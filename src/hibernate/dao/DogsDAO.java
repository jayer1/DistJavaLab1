package hibernate.dao;

import hibernate.entity.Breed;
import hibernate.entity.Declawed;
import hibernate.entity.Dogs;
import hibernate.entity.Gender;

import java.util.List;

public interface DogsDAO {
    List<Dogs> listAllDogs();

    List<Breed> listAllBreeds();
    List<Gender> listAllGenders();
    List<Declawed> listAllDeclawed();

    List<Dogs> getDogsByName(String theSearchTerm);

    Dogs getDog(int theId);

    void deleteDog(int theId);

    void createDog(Dogs myDog);


}
