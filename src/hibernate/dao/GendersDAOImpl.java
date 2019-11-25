package hibernate.dao;

import hibernate.entity.Gender;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GendersDAOImpl implements GendersDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Gender> getGender() {
        Session session = sessionFactory.getCurrentSession();

        // Get list of donut shops from query
        List<Gender> genderList = session.createQuery("from Gender", Gender.class).getResultList();

        // Return results
        return genderList;
    }

    @Override
    public Gender getGender(int id) {
        Session session = sessionFactory.getCurrentSession();

        // Get donut shop by primary key
        Gender aGender = session.get(Gender.class, id);

        // Return results
        return aGender;
    }
}
