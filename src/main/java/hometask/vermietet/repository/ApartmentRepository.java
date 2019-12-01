package hometask.vermietet.repository;

import hometask.vermietet.domain.Apartment;
import hometask.vermietet.domain.Device;
import hometask.vermietet.inmemory.Memory;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class ApartmentRepository {

  private final Memory memory;

  public ApartmentRepository(Memory memory) {
    this.memory = memory;
  }

  public void addNewApartment(Apartment newApartment) {
    memory.getApartments().add(newApartment);
  }

  public Optional<Apartment> getApartmentById(Integer apartmentId) {
    return memory
        .getApartments()
        .stream()
        .filter(apartment -> apartment.getId().equals(apartmentId))
        .findFirst();
  }

  public void addNewDeviceToApartment(Apartment apartment, Device device) {
    memory.getDeviceIdToApartmentIdMap().put(device.getId(), apartment.getId());
  }

  public Optional<Apartment> getApartmentByDeviceId(Device device) {
    Integer apartmentId = memory.getDeviceIdToApartmentIdMap().get(device.getId());
    return getApartmentById(apartmentId);
  }

  public List<Apartment> getApartments() {
    return memory.getApartments();
  }
}
