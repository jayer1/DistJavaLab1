package hibernate.service;

import hibernate.dao.DogsDAO;
import hibernate.entity.Breed;
import hibernate.entity.Declawed;
import hibernate.entity.Dogs;
import hibernate.entity.Gender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;
import java.util.List;

@Service
public class DogServiceImpl implements DogService{

    @Autowired
    private DogsDAO dogsDAO;

    @Autowired
    private ImageFileService imageFileService;

    @Override
    @Transactional
    public List<Dogs> listAllDogs() {
        return dogsDAO.listAllDogs();
    }

    @Override
    @Transactional
    public List<Breed> listAllBreeds() {
        return dogsDAO.listAllBreeds();
    }

    @Override
    @Transactional
    public List<Gender> listAllGenders() {
        return dogsDAO.listAllGenders();
    }

    @Override
    @Transactional
    public List<Declawed> listAllDeclawed() {
        return dogsDAO.listAllDeclawed();
    }

    @Override
    @Transactional
    public List<Dogs> getDogsByName(String theSearchTerm) {
        return dogsDAO.getDogsByName(theSearchTerm);
    }

    @Override
    @Transactional
    public void createDog(Dogs myDog, MultipartFile file, String applicationPath) {
        String fileName = imageFileService.saveFile(file, applicationPath, myDog.getImagePath());
        if(fileName != null)
        {
            myDog.setImgFile(fileName);
        }
        dogsDAO.createDog(myDog);
    }

    @Override
    @Transactional
    public Dogs getDog(int theId) {
        return dogsDAO.getDog(theId);
    }


    @Override
    @Transactional
    public void deleteDog(int theId) {
        dogsDAO.deleteDog(theId);
    }


}
