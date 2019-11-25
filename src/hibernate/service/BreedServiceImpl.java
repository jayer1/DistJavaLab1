package hibernate.service;

import hibernate.dao.BreedsDAO;
import hibernate.entity.Breed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BreedServiceImpl implements BreedService {

    @Autowired
    private BreedsDAO breedsDAO;

    @Override
    @Transactional
    public List<Breed> getBreeds() {

        return breedsDAO.getBreed();
    }

    @Override
    @Transactional
    public Breed getBreeds(int id) {

        return breedsDAO.getBreed(id);
    }
}
