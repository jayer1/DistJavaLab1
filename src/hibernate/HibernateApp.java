package hibernate;

import hibernate.entity.Breed;
import hibernate.entity.Declawed;
import hibernate.entity.Dogs;
import hibernate.entity.Gender;
import hibernate.entity.Registration;
import hibernate.entity.State;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HibernateApp {

    private SessionFactory factory;

    public HibernateApp(){
        factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Breed.class)
                .addAnnotatedClass(Declawed.class)
                .addAnnotatedClass(Dogs.class)
                .addAnnotatedClass(Gender.class)
                .addAnnotatedClass(Registration.class)
                .addAnnotatedClass(State.class)
                .buildSessionFactory();
    }

    private void close(){
        factory.close();
    }

    public static void main(String[] args) {

        HibernateApp hibby = new HibernateApp();

        try{

            // Tables related to the DOG object:

            // BREED
            //int myBreed = hibby.createBreed();
            //hibby.readBreed(myBreed);
            //hibby.updateBreed();
            //hibby.listAllBreeds();
            //hibby.deleteBreed(301);
            //hibby.listAllBreeds();

            // DECLAWED
            //int myDeclawed = hibby.createDeclawed();
            //hibby.readDeclawed(myDeclawed);
            //hibby.updateDeclawed();
            //hibby.deleteDeclawed(601);
            //hibby.listAllDeclawed();

            // GENDER
            //int myGender = hibby.createGender();
            //hibby.readGender(myGender);
            //hibby.updateGender();
            //hibby.deleteGender(801);
            //hibby.listAllGenders();

            // Table related to the REGISTRATION object:

            // STATE
            //int myState = hibby.createState();
            //hibby.readState(myState);
            //hibby.listAllStates();
            //hibby.updateState();
            //hibby.deleteState(1701);

            // REGISTRATION
            //int myReg = hibby.createRegistration();
            //hibby.readRegistration(myReg);
            //hibby.updateRegistration();
            //hibby.listAllRegistrations();
            //hibby.deleteRegistration(401);

            // DOGS
            //int myDog = hibby.createDog();
            //hibby.readDog(myDog);
            //hibby.updateDog();
            hibby.listAllDogs();


        }finally{

            hibby.close();
        }

    }

    private int createGender(){
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        Gender gender = new Gender("Cisgender");

        session.save(gender);

        session.getTransaction().commit();

        return gender.getGenderId();
    }

    private void readGender(int genderId){
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        Gender aGender = session.get(Gender.class, genderId);
        if(aGender == null){
            System.out.println("No genders found for ID " + genderId);
        } else{
            System.out.println(aGender);
        }

        session.getTransaction().commit();
    }


    private int createBreed(){
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        Breed breed = new Breed("Beagle");
        //Breed breed1 = new Breed("Bulldog");
        //Breed breed2 = new Breed("Boxer");

        session.save(breed);
        //session.save(breed1);
        //session.save(breed2);

        session.getTransaction().commit();

        return breed.getBreedId();
    }

    private void readBreed(int breedId){
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        Breed aBreed = session.get(Breed.class, breedId);
        if(aBreed == null){
            System.out.println("No breeds found for ID " + breedId);
        } else{
            System.out.println(aBreed);
        }

        session.getTransaction().commit();
    }

    private void deleteBreed(int breedId){
        Session session = factory.getCurrentSession();

        session.beginTransaction();
        Breed badBreed = session.get(Breed.class, breedId);
        if(badBreed != null){
            session.delete(badBreed);
        }

        session.getTransaction().commit();
    }

    private void listAllBreeds(){
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        List<Breed> list = session.createQuery("from hibernate.entity.Breed").getResultList();

        printBreedList(list);
        session.getTransaction().commit();
    }

    private void printBreedList(List<Breed> list){
        if(list.isEmpty()){
            System.out.println("No breeds in list.");
        } else {
            for(Breed breed: list){
                System.out.println(breed.getBreed());
            }
        }
    }

    private void listAllGenders(){
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        List<Gender> list = session.createQuery("from hibernate.entity.Gender").getResultList();

        printGenderList(list);
        session.getTransaction().commit();
    }

    private void printGenderList(List<Gender> list){
        if(list.isEmpty()){
            System.out.println("No genders in list.");
        } else {
            for(Gender gender: list){
                System.out.println(gender.getGender());
            }
        }
    }

    private int createDeclawed(){
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        Declawed declawed = new Declawed("Unknown");

        session.save(declawed);

        session.getTransaction().commit();

        return declawed.getDeclawedId();
    }

    private void readDeclawed(int declawed ){
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        Declawed aDeclawed = session.get(Declawed.class, declawed);
        if(aDeclawed == null){
            System.out.println("No declaws found for ID " + declawed);
        } else{
            System.out.println(aDeclawed);
        }

        session.getTransaction().commit();
    }

    private void listAllDeclawed(){
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        List<Declawed> list = session.createQuery("from hibernate.entity.Declawed").getResultList();

        printDeclawedList(list);
        session.getTransaction().commit();
    }

    private void printDeclawedList(List<Declawed> list){
        if(list.isEmpty()){
            System.out.println("No declaweds in list.");
        } else {
            for(Declawed declawed: list){
                System.out.println(declawed.getDeclawed());
            }
        }
    }

    private int createState(){
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        State state = new State("Alabama");

        session.save(state);

        session.getTransaction().commit();

        return state.getStateId();
    }

    private void readState(int stateId){
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        State aState = session.get(State.class, stateId);
        if(aState == null){
            System.out.println("No states found for ID " + stateId);
        } else{
            System.out.println(aState);
        }

        session.getTransaction().commit();
    }

    private void listAllStates(){
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        List<State> list = session.createQuery("from hibernate.entity.State").getResultList();

        printStateList(list);
        session.getTransaction().commit();
    }

    private void printStateList(List<State> list){
        if(list.isEmpty()){
            System.out.println("No declaweds in list.");
        } else {
            for(State state: list){
                System.out.println(state.getStateName());
            }
        }
    }

    private void deleteState(int stateId){
        Session session = factory.getCurrentSession();

        session.beginTransaction();
        State badState = session.get(State.class, stateId);
        if(badState != null){
            session.delete(badState);
        }

        session.getTransaction().commit();
    }

    private void deleteGender(int genderId){
        Session session = factory.getCurrentSession();

        session.beginTransaction();
        Gender badGender = session.get(Gender.class, genderId);
        if(badGender != null){
            session.delete(badGender);
        }



        session.getTransaction().commit();
    }

    private void deleteDeclawed(int declawedId){
        Session session = factory.getCurrentSession();

        session.beginTransaction();
        Declawed baddeclawed = session.get(Declawed.class, declawedId);
        if(baddeclawed != null){
            session.delete(baddeclawed);
        }

        session.getTransaction().commit();
    }

    private void updateState(){
        Session session = factory.getCurrentSession();

        session.beginTransaction();
        State aState = session.get(State.class, 1701);
        aState.setStateName("Hawaii");

        session.getTransaction().commit();
    }

    private void updateGender(){
        Session session = factory.getCurrentSession();

        session.beginTransaction();
        Gender aGender = session.get(Gender.class, 1);
        aGender.setGender("Unknown");

        session.getTransaction().commit();
    }

    private void updateDeclawed(){
        Session session = factory.getCurrentSession();

        session.beginTransaction();
        Declawed aDeclawed = session.get(Declawed.class, 701);
        aDeclawed.setDeclawed("Partially");

        session.getTransaction().commit();
    }

    private void updateBreed(){
        Session session = factory.getCurrentSession();

        session.beginTransaction();
        Breed aBreed = session.get(Breed.class, 201);
        aBreed.setBreed("Shetland Sheep Dog");

        session.getTransaction().commit();
    }




    private int createRegistration(){
        Session session = factory.getCurrentSession();

        session.beginTransaction();
        List<State> list = session.createQuery("from hibernate.entity.State where stateName='California'").getResultList();
        Registration registration = new Registration("Sally", "Ride", "1420 Mollie Avenue","San Diego", "22434", "srider@gmail.com", "riders100");
        registration.setState(list.get(0));
        session.save(registration);

        session.getTransaction().commit();
        return registration.getRegistrationId();
    }


    private void readRegistration(int registrationId){
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        Registration aRegistration = session.get(Registration.class, registrationId);
        if(aRegistration == null){
            System.out.println("No registrations found for ID " + registrationId);
        } else{
            System.out.println(aRegistration);
        }

        State aState = session.get(State.class, aRegistration.getState().getStateId());

        if(aState == null){
            System.out.println("No states found for ID " + registrationId);
        } else{
            System.out.println(aState);
        }

        session.getTransaction().commit();
    }


    private void updateRegistration(){
        Session session = factory.getCurrentSession();

        session.beginTransaction();
        Registration aRegistration = session.get(Registration.class, 501);
        List<State> listState = session.createQuery("from hibernate.entity.State where stateName='Alaska'").getResultList();
        aRegistration.setState(listState.get(0));
        aRegistration.setFirstName("Charlie");
        aRegistration.setLastName("Browning");

        session.getTransaction().commit();
    }

    private void deleteRegistration(int registrationId){
        Session session = factory.getCurrentSession();

        session.beginTransaction();
        Registration badReggie = session.get(Registration.class, registrationId);
        if(badReggie != null){
            session.delete(badReggie);
        }

        session.getTransaction().commit();
    }

    private void listAllRegistrations(){
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        List<Registration> list = session.createQuery("from hibernate.entity.Registration").getResultList();
        List<State> listStates = session.createQuery("from hibernate.entity.State").getResultList();
        printRegistrationList(list, listStates);
        session.getTransaction().commit();
    }

    private void printRegistrationList(List<Registration> list, List<State> listStates){

        if(list.isEmpty()){
            System.out.println("No registrations in list.");
        } else {
            for(Registration registration: list){
                System.out.print(registration);
                System.out.println(" State is " + registration.getState().getStateName());

            }
        }

    }

    private int createDog(){
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        List<Breed> listBreed = session.createQuery("from hibernate.entity.Breed where breed='Shetland Sheep Dog'").getResultList();
        List<Declawed> listDeclawed = session.createQuery("from hibernate.entity.Declawed where declawed='Partially'").getResultList();
        List<Gender> listGender = session.createQuery("from hibernate.entity.Gender where gender='Female'").getResultList();
        Dogs dog = new Dogs("Byron", 1, 279.00,"byron.png");
        dog.setBreed(listBreed.get(0));
        dog.setDeclawed(listDeclawed.get(0));
        dog.setGender(listGender.get(0));
        session.save(dog);

        session.getTransaction().commit();
        return dog.getDog_id();
    }

    private void readDog(int dogId){
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        Dogs aDog = session.get(Dogs.class, dogId);
        if(aDog == null){
            System.out.println("No dogs found for ID " + dogId);
        } else{
            System.out.println(aDog);
        }

        Breed aBreed = session.get(Breed.class, aDog.getBreed().getBreedId());
        Declawed aDeclawed = session.get(Declawed.class, aDog.getDeclawed().getDeclawedId());
        Gender aGender = session.get(Gender.class, aDog.getGender().getGenderId());
        if(aBreed == null){
            System.out.println("No breeds found for ID " + dogId);
        } else{
            System.out.println(aBreed);
        }
        if(aDeclawed == null){
            System.out.println("No declaweds found for ID " + dogId);
        } else{
            System.out.println(aDeclawed);
        }
        if(aGender == null){
            System.out.println("No genders found for ID " + dogId);
        } else{
            System.out.println(aGender);
        }

        session.getTransaction().commit();
    }

    private void updateDog(){
        Session session = factory.getCurrentSession();

        session.beginTransaction();
        Dogs aDog = session.get(Dogs.class, 201);
        List<Breed> listBreed = session.createQuery("from hibernate.entity.Breed where breed='Boxer'").getResultList();
        List<Gender> listGender = session.createQuery("from hibernate.entity.Gender where gender='Female'").getResultList();
        aDog.setBreed(listBreed.get(0));
        aDog.setGender(listGender.get(0));
        aDog.setName("Penny");
        aDog.setPrice(275.89);
        aDog.setImgFile("penny.jpg");

        session.getTransaction().commit();
    }

    private void listAllDogs(){
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        List<Dogs> list = session.createQuery("from hibernate.entity.Dogs").getResultList();
        List<Breed> listBreeds = session.createQuery("from hibernate.entity.Breed").getResultList();
        List<Declawed> listDeclaweds = session.createQuery("from hibernate.entity.Declawed").getResultList();
        List<Gender> listGenders = session.createQuery("from hibernate.entity.Gender").getResultList();
        printRegistrationList(list, listBreeds, listDeclaweds, listGenders);
        session.getTransaction().commit();
    }

    private void printRegistrationList(List<Dogs> list, List<Breed> listBreeds, List<Declawed> listDeclaweds, List<Gender> listGenders){

        if(list.isEmpty()){
            System.out.println("No registrations in list.");
        } else {
            for(Dogs dog: list){
                System.out.print(dog);
                System.out.print(", Breed is " + dog.getBreed().getBreed());
                System.out.print(", Claw status is " + dog.getDeclawed().getDeclawed());
                System.out.print(", Gender is " + dog.getGender().getGender());
                System.out.println();
            }
        }

    }



}
