package hometask.vermietet;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import com.fasterxml.jackson.databind.ObjectMapper;
import hometask.vermietet.domain.Apartment;
import hometask.vermietet.domain.Device;
import hometask.vermietet.inmemory.Memory;
import hometask.vermietet.repository.ApartmentRepository;
import hometask.vermietet.repository.DeviceRepository;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
@WebAppConfiguration
public class DeviceManagerControllerTest {

  private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
      MediaType.APPLICATION_JSON.getSubtype(),
      StandardCharsets.UTF_8);

  private MockMvc mockMvc;

  @Autowired
  private WebApplicationContext webApplicationContext;
  @Autowired
  private ObjectMapper objectMapper;
  @Autowired
  private Memory memory;
  @Autowired
  private DeviceRepository deviceRepository;
  @Autowired
  private ApartmentRepository apartmentRepository;

  @Autowired
  void setConverters(HttpMessageConverter<?>[] converters) {

    HttpMessageConverter mappingJackson2HttpMessageConverter = Arrays.asList(converters).stream()
        .filter(hmc -> hmc instanceof MappingJackson2HttpMessageConverter)
        .findAny()
        .orElse(null);

    assertNotNull("the JSON message converter must not be null",
        mappingJackson2HttpMessageConverter);
  }

  @Before
  public void setup() throws Exception {
    this.mockMvc = webAppContextSetup(webApplicationContext).build();
    memory = new Memory();
    Device newDevice = new Device(1, 10000.123, LocalDateTime.now().minusHours(24));
    Apartment apartment = new Apartment(1, "Villarriba");
    apartment.getDeviceList().add(newDevice);
    memory.getApartments().add(apartment);
    memory.getDevices().add(newDevice);
    memory.getDeviceIdToApartmentIdMap().put(1, 1);
    deviceRepository.addNewDevice(newDevice);
    apartmentRepository.addNewApartment(apartment);
    apartmentRepository.addNewDeviceToApartment(apartment, newDevice);
  }

  @Test
  public void durationTest() throws Exception {
    mockMvc.perform(get("/consumption_report?duration=" + TestUtils.getDuration())
        .contentType(contentType))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.villages[0].village_name", is("Villarriba")))
        .andExpect(jsonPath("$.villages[0].consumption", is(10000.123)));

  }

  @Test
  public void counterCallBackTest() throws Exception {
    mockMvc.perform(post("/counter_callback")
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(TestUtils.getDeviceCounterCreateRequest())))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.counter_id", is(1)))
        .andExpect(jsonPath("$.amount", is(10.0)));
  }


  @Test
  public void counterTest() throws Exception {
    mockMvc.perform(get("/counter?id=" + 1))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id", is(1)))
        .andExpect(jsonPath("$.village", is("Villarriba")));
  }

}
