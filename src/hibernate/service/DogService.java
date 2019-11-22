package hibernate.service;

import hibernate.entity.Dogs;

import java.util.List;

public interface DogService {

    List<Dogs> listAllDogs();

    void createDog(Dogs myDog);
}
