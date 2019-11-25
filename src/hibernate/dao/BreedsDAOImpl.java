package hibernate.dao;

import hibernate.entity.Breed;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BreedsDAOImpl implements BreedsDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Breed> getBreed() {
        Session session = sessionFactory.getCurrentSession();

        // Get list of donut shops from query
        List<Breed> breedList = session.createQuery("from Breed", Breed.class).getResultList();

        // Return results
        return breedList;

    }

    @Override
    public Breed getBreed(int id) {
        Session session = sessionFactory.getCurrentSession();

        // Get donut shop by primary key
        Breed aBreed = session.get(Breed.class, id);

        // Return results
        return aBreed;
    }
}
