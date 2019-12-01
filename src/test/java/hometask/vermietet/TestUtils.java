package hometask.vermietet;

import hometask.vermietet.dto.DeviceCounterCreateRequest;

public class TestUtils {

  public static DeviceCounterCreateRequest getDeviceCounterCreateRequest() {
    DeviceCounterCreateRequest request = new DeviceCounterCreateRequest();
    request.setAmount(10.0);
    request.setCounterId(1);
    return request;
  }

  public static Integer getDuration() {
    return 1;
  }
}
