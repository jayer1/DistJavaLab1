package springxml.beans;

import springxml.iface.LoggingService;

import java.util.List;

public class Registration {

    private int Registration_ID;
    private String FirstName;
    private String LastName;
    private String StreetAddress;
    private String City;
    private String State;
    private String Zip;
    private String Email;
    private String Password;
    private LoggingService ls;

    List<State> RegistrationState;

    public Registration() {
    }

    public int getRegistration_ID() {
        return Registration_ID;
    }

    public void setRegistration_ID(int registration_ID) {
        Registration_ID = registration_ID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getStreetAddress() {
        return StreetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        StreetAddress = streetAddress;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getZip() {
        return Zip;
    }

    public void setZip(String zip) {
        Zip = zip;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public List<springxml.beans.State> getRegistrationState() {
        return RegistrationState;
    }

    public void setRegistrationState(List<springxml.beans.State> registrationState) {
        RegistrationState = registrationState;
    }

    public void setLs(LoggingService ls) {
        this.ls = ls;
    }

    public String getLog() {
        return "Registration just logged something!!";
    }

}
