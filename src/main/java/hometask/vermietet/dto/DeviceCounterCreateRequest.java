package hometask.vermietet.dto;

import javax.validation.constraints.NotNull;

public class DeviceCounterCreateRequest {
  @NotNull(message = "Counter id cannot be null")
  private Integer counterId;
  @NotNull(message = "Amount cannot be null")
  private Double amount;

  public Integer getCounterId() {
    return counterId;
  }

  public void setCounterId(Integer counterId) {
    this.counterId = counterId;
  }

  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }
}
