package hometask.vermietet.domain;

import java.time.LocalDateTime;

public class Device {
  private Integer id;
  private Double amount;
  private LocalDateTime registeredTime;

  public Device(Integer id,
                Double amount,
                LocalDateTime registeredTime) {
    this.id = id;
    this.amount = amount;
    this.registeredTime = registeredTime;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  public LocalDateTime getRegisteredTime() {
    return registeredTime;
  }

  public void setRegisteredTime(LocalDateTime registeredTime) {
    this.registeredTime = registeredTime;
  }
}
