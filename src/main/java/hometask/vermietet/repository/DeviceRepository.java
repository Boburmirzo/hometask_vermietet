package hometask.vermietet.repository;

import hometask.vermietet.domain.Device;
import hometask.vermietet.inmemory.Memory;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class DeviceRepository {

  private final Memory memory;

  public DeviceRepository(Memory memory) {
    this.memory = memory;
  }

  public void addNewDevice(Device device) {
    memory.getDevices().add(device);
  }

  public Optional<Device> findDeviceById(Integer id) {
    return memory
        .getDevices()
        .stream()
        .filter(device -> device.getId().equals(id))
        .findFirst();
  }

  public List<Device> getAllDevices() {
    return memory.getDevices();
  }

}
