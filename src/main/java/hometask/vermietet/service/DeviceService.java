package hometask.vermietet.service;

import hometask.vermietet.domain.Apartment;
import hometask.vermietet.domain.Device;
import hometask.vermietet.dto.VillageDto;
import hometask.vermietet.repository.ApartmentRepository;
import hometask.vermietet.repository.DeviceRepository;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class DeviceService {

  private final DeviceRepository deviceRepository;
  private final ApartmentRepository apartmentRepository;

  public DeviceService(DeviceRepository deviceRepository,
                       ApartmentRepository apartmentRepository) {
    this.deviceRepository = deviceRepository;
    this.apartmentRepository = apartmentRepository;
  }

  public Device findDeviceById(Integer id) throws Exception {
    Optional<Device> deviceOptional = deviceRepository.findDeviceById(id);
    if (deviceOptional.isEmpty()) {
      throw new Exception("Device not found by given id: " + id);
    }
    return deviceOptional.get();
  }

  public void addNewDevice(Device device) {
    deviceRepository.addNewDevice(device);
  }

  public Apartment findApartmentByDeviceId(Integer deviceId) throws Exception {
    Device device = findDeviceById(deviceId);
    Optional<Apartment> apartmentOptional = apartmentRepository.getApartmentByDeviceId(device);
    if (apartmentOptional.isEmpty()) {
      throw new Exception("Apartment is not found by given id: " + deviceId);
    }
    return apartmentOptional.get();
  }

  public List<VillageDto> totalConsumption(Integer duration) {
    List<VillageDto> villageDtos = new ArrayList<>();
    apartmentRepository.getApartments().forEach(apartment -> {
      VillageDto villageDto = new VillageDto(apartment.getName());
      Double totalConsumption = apartment.getDeviceList().stream()
          .filter(device -> device.getRegisteredTime()
              .isBefore(LocalDateTime.now().minusHours(duration)))
          .mapToDouble(Device::getAmount).sum();
      villageDto.setConsumption(totalConsumption);
      villageDtos.add(villageDto);
    });
    return villageDtos;
  }
}
