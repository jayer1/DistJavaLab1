package hibernate.service;

import hibernate.dao.GendersDAO;
import hibernate.entity.Gender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GenderServiceImpl implements GenderService {
    @Autowired
    private GendersDAO gendersDAO;

    @Override
    @Transactional
    public List<Gender> getGenders() {
        return gendersDAO.getGender();
    }

    @Override
    @Transactional
    public Gender getGenders(int id) {
        return gendersDAO.getGender(id);
    }
}
