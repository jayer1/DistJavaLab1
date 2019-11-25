package hibernate.dao;

import hibernate.entity.Breed;

import java.util.List;

public interface BreedsDAO {

    List<Breed> getBreed();

    Breed getBreed(int id);
}
