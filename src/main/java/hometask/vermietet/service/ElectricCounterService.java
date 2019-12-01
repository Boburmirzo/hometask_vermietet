package hometask.vermietet.service;

import hometask.vermietet.domain.Device;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.TreeMap;
import org.springframework.stereotype.Service;

@Service
public class ElectricCounterService {

  private Map<LocalDateTime, Device> deviceTreeMap = new TreeMap<>();


  public void registerNewDevice(Device device) {
    deviceTreeMap.put(LocalDateTime.now(), device);
  }
}
