package hometask.vermietet.dto;

public class DeviceCounterCreateResponse {

  private Integer counter_id;
  private Double amount;

  public Integer getCounter_id() {
    return counter_id;
  }

  public void setCounter_id(Integer counter_id) {
    this.counter_id = counter_id;
  }

  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }
}
