package springxml.beans;

import springxml.iface.LoggingService;

public class Dogs {

    private int Dog_ID;
    private String Name;
    private String Breed;
    private int Age;
    private Double Price;
    private String Gender;
    private String Declawed;
    private String ImageFile;
    private LoggingService ls;

    public void setLs(LoggingService ls) {
        this.ls = ls;
    }


    public Dogs(){

    }

    public int getDog_ID() {
        return Dog_ID;
    }

    public void setDog_ID(int dog_ID) {
        Dog_ID = dog_ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getBreed() {
        return Breed;
    }

    public void setBreed(String breed) {
        Breed = breed;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
        Price = price;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getDeclawed() {
        return Declawed;
    }

    public void setDeclawed(String declawed) {
        Declawed = declawed;
    }

    public String getImageFile() {
        return ImageFile;
    }

    public void setImageFile(String imageFile) {
        ImageFile = imageFile;
    }

    public String getLog() {
        return "The dog is out of the house!!";
    }


}
