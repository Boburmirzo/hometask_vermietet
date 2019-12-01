package hometask.vermietet.dto;

public class VillageDto {
  private String village_name;
  private Double consumption;

  public VillageDto(String village_name,
                    Double consumption) {
    this.village_name = village_name;
    this.consumption = consumption;
  }

  public VillageDto(String village_name) {
    this.village_name = village_name;
  }

  public String getVillage_name() {
    return village_name;
  }

  public void setVillage_name(String village_name) {
    this.village_name = village_name;
  }

  public Double getConsumption() {
    return consumption;
  }

  public void setConsumption(Double consumption) {
    this.consumption = consumption;
  }
}
