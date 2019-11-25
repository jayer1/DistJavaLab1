package hibernate.service;

import hibernate.dao.DeclawedDAO;
import hibernate.entity.Declawed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DeclawedServiceImpl implements DeclawedService {
    @Autowired
    private DeclawedDAO declawedDAO;

    @Override
    @Transactional
    public List<Declawed> getDeclaweds() {
        return declawedDAO.getDeclawed();
    }

    @Override
    @Transactional
    public Declawed getDeclaweds(int id) {
        return declawedDAO.getDeclawed(id);
    }
}
