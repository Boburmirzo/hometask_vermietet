package hometask.vermietet.dto;

import java.util.List;

public class ConsumptionResponse {
  private List<VillageDto> villages;

  public ConsumptionResponse(List<VillageDto> villages) {
    this.villages = villages;
  }

  public List<VillageDto> getVillages() {
    return villages;
  }

  public void setVillages(List<VillageDto> villages) {
    this.villages = villages;
  }
}
