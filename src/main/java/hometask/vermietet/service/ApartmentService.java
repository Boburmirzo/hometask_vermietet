package hometask.vermietet.service;

import hometask.vermietet.repository.ApartmentRepository;
import org.springframework.stereotype.Service;

@Service
public class ApartmentService {

  private final ApartmentRepository apartmentRepository;

  public ApartmentService(ApartmentRepository apartmentRepository) {
    this.apartmentRepository = apartmentRepository;
  }


}
