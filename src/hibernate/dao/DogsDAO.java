package hibernate.dao;

import hibernate.entity.Dogs;

import java.util.List;

public interface DogsDAO {
    List<Dogs> listAllDogs();

    void createDog(Dogs myDog);


}
