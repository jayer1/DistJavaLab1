package hibernate.dao;

import hibernate.entity.Declawed;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DeclawedDAOImpl implements DeclawedDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Declawed> getDeclawed() {
        Session session = sessionFactory.getCurrentSession();

        List<Declawed> declawedList = session.createQuery("from Declawed ", Declawed.class).getResultList();

        return declawedList;
    }

    @Override
    public Declawed getDeclawed(int id) {
        Session session = sessionFactory.getCurrentSession();

        // Get donut shop by primary key
        Declawed aDeclawed = session.get(Declawed.class, id);

        // Return results
        return aDeclawed;
    }
}
