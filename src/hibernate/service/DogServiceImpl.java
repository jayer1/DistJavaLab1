package hibernate.service;

import hibernate.dao.DogsDAO;
import hibernate.entity.Dogs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
public class DogServiceImpl implements DogService{

    @Autowired
    private DogsDAO dogsDAO;

    @Override
    @Transactional
    public List<Dogs> listAllDogs() {
        return dogsDAO.listAllDogs();
    }

    @Override
    @Transactional
    public void createDog(Dogs myDog) {

        dogsDAO.createDog(myDog);


    }
}
