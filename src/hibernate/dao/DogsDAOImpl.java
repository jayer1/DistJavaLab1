package hibernate.dao;

import hibernate.entity.Breed;
import hibernate.entity.Declawed;
import hibernate.entity.Dogs;
import hibernate.entity.Gender;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DogsDAOImpl implements DogsDAO {

    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Dogs> listAllDogs() {
        Session session = sessionFactory.getCurrentSession();
        List<Dogs> dogList = session.createQuery("from Dogs", Dogs.class).getResultList();

        return dogList;
    }

    @Override
    public void createDog(Dogs myDog) {
        Session session = sessionFactory.getCurrentSession();

        session.save(myDog);

    }
}
