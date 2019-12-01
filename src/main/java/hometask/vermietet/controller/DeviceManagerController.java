package hometask.vermietet.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import hometask.vermietet.domain.Apartment;
import hometask.vermietet.domain.Device;
import hometask.vermietet.dto.ConsumptionResponse;
import hometask.vermietet.dto.DeviceCounterCreateRequest;
import hometask.vermietet.dto.DeviceCounterCreateResponse;
import hometask.vermietet.dto.VillageDto;
import hometask.vermietet.service.DeviceService;
import java.time.LocalDateTime;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping
public class DeviceManagerController {

  private final DeviceService deviceService;

  public DeviceManagerController(DeviceService deviceService) {
    this.deviceService = deviceService;
  }

  @RequestMapping(value = "/counter_callback", method = RequestMethod.POST,
      produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<DeviceCounterCreateResponse>
  registerElectricCounter(@RequestBody @Valid DeviceCounterCreateRequest request) {
    try {
      Device device = new Device(request.getCounterId(), request.getAmount(), LocalDateTime.now());
      deviceService.addNewDevice(device);
      DeviceCounterCreateResponse response = new DeviceCounterCreateResponse();
      response.setCounter_id(device.getId());
      response.setAmount(device.getAmount());
      return new ResponseEntity<>(response, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @RequestMapping(value = "/counter", method = RequestMethod.GET)
  public ResponseEntity getDevice(@RequestParam(value = "id") Integer id) throws Exception {
    Apartment apartment;
    apartment = deviceService.findApartmentByDeviceId(id);
    ObjectMapper mapper = new ObjectMapper();
    ObjectNode response = mapper.createObjectNode();
    try {

      response.put("id", id);
      response.put("village", apartment.getName());
    } catch (Exception e) {
      return new ResponseEntity<>("Apartment or device does not exist", HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @RequestMapping(value = "/consumption_report", method = RequestMethod.GET)
  public ResponseEntity<ConsumptionResponse> getConsumptionReport(@RequestParam(value = "duration") Integer duration) {
    try {
      List<VillageDto> villageDtos = deviceService.totalConsumption(duration);
      return new ResponseEntity<>(new ConsumptionResponse(villageDtos), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
