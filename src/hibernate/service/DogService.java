package hibernate.service;

import hibernate.entity.Breed;
import hibernate.entity.Declawed;
import hibernate.entity.Dogs;
import hibernate.entity.Gender;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface DogService {

    List<Dogs> listAllDogs();
    List<Breed> listAllBreeds();
    List<Gender> listAllGenders();
    List<Declawed> listAllDeclawed();

    List<Dogs> getDogsByName(String theSearchTerm);

    void createDog(Dogs myDog, MultipartFile file, String applicationPath);

    Dogs getDog(int theId);

    void deleteDog(int theId);
}
