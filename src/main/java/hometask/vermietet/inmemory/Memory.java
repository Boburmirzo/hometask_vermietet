package hometask.vermietet.inmemory;

import hometask.vermietet.domain.Apartment;
import hometask.vermietet.domain.Device;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class Memory {
  private List<Device> devices = new ArrayList<>();
  private List<Apartment> apartments = new ArrayList<>();
  private Map<Integer, Integer> deviceIdToApartmentIdMap = new HashMap<>();

  public List<Device> getDevices() {
    return devices;
  }

  public List<Apartment> getApartments() {
    return apartments;
  }

  public void setApartments(List<Apartment> apartments) {
    this.apartments = apartments;
  }

  public Map<Integer, Integer> getDeviceIdToApartmentIdMap() {
    return deviceIdToApartmentIdMap;
  }

  public void setDeviceIdToApartmentIdMap(Map<Integer, Integer> deviceIdToApartmentIdMap) {
    this.deviceIdToApartmentIdMap = deviceIdToApartmentIdMap;
  }
}
