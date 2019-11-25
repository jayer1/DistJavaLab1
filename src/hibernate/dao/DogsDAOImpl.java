package hibernate.dao;

import hibernate.entity.Breed;
import hibernate.entity.Declawed;
import hibernate.entity.Dogs;
import hibernate.entity.Gender;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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
    public List<Breed> listAllBreeds() {
        Session session = sessionFactory.getCurrentSession();
        List<Breed> breedList = session.createQuery("from Breed", Breed.class).getResultList();

        return breedList;
    }

    @Override
    public List<Gender> listAllGenders() {
        Session session = sessionFactory.getCurrentSession();
        List<Gender> genderList = session.createQuery("from Gender", Gender.class).getResultList();

        return genderList;
    }

    @Override
    public List<Declawed> listAllDeclawed() {
        Session session = sessionFactory.getCurrentSession();
        List<Declawed> declawedList = session.createQuery("from Declawed ", Declawed.class).getResultList();

        return declawedList;
    }

    @Override
    public List<Dogs> getDogsByName(String theSearchTerm) {
        Session session = sessionFactory.getCurrentSession();

        theSearchTerm = "%" + theSearchTerm.toLowerCase() + "%";

        Query<Dogs> query = session.createQuery("from Dogs where lower(name) like :nameToSearch");
        query.setParameter("nameToSearch", theSearchTerm);

        return query.getResultList();
    }

    @Override
    public Dogs getDog(int theId) {
        Session session = sessionFactory.getCurrentSession();

        return session.get(Dogs.class, theId);
    }

    @Override
    public void deleteDog(int theId) {
        Session session = sessionFactory.getCurrentSession();

        // Delete object using primary key
        Query query = session.createQuery("delete from Dogs where dog_id = :doomedDogId");
        // Set parameter value
        query.setParameter("doomedDogId", theId);

        // Perform the delete
        query.executeUpdate();
    }

    @Override
    public void createDog(Dogs myDog) {
        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(myDog);

    }
}
