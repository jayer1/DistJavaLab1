package hibernate.service;

import hibernate.entity.Breed;

import java.util.List;

public interface BreedService {

    List<Breed> getBreeds();

    Breed getBreeds(int id);
}
