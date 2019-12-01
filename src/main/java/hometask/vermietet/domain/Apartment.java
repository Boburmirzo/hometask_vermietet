package hometask.vermietet.domain;

import java.util.ArrayList;
import java.util.List;

public class Apartment {
  private Integer id;
  private String name;
  private List<Device> deviceList;

  public Apartment(Integer id,
                   String name) {
    this.id = id;
    this.name = name;
    this.deviceList = new ArrayList<>();
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Device> getDeviceList() {
    return deviceList;
  }

  public void setDeviceList(List<Device> deviceList) {
    this.deviceList = deviceList;
  }
}
