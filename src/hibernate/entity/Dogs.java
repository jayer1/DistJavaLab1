package hibernate.entity;

import javax.persistence.*;

@Entity
@Table(name = "Dogs")
public class Dogs {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="Dog_Id")
    private int dog_id;

    @Column(name="Name")
    private String name;

    @Column(name="Age")
    private int age;

    @Column(name="Price")
    private double price;

    @Column(name="Imagefile")
    private String imgFile;

    // OneToMany - Each Declawed record can be attached to many dogs
    // Default is Eager Load - and gets related entities right away.
    @ManyToOne(
            cascade = {CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH})
    @JoinColumn(name = "Declawed_ID")
    private Declawed declawed;

    // OneToMany - Each Breed record can be attached to many dogs
    // Default is Eager Load - and gets related entities right away.
    @ManyToOne(
            cascade = {CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH})
    @JoinColumn(name = "Breed_ID")
    private Breed breed;

    // OneToMany - Each Gender record can be attached to many dogs
    // Default is Eager Load - and gets related entities right away.
    @ManyToOne(
            cascade = {CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH})
    @JoinColumn(name = "Gender_ID")
    private Gender gender;

    public int getDog_id() {
        return dog_id;
    }

    public void setDog_id(int dog_id) {
        this.dog_id = dog_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImgFile() {
        return imgFile;
    }

    public void setImgFile(String imgFile) {
        this.imgFile = imgFile;
    }

    public Declawed getDeclawed() {
        return declawed;
    }

    public void setDeclawed(Declawed declawed) {
        this.declawed = declawed;
    }

    public Breed getBreed() {
        return breed;
    }

    public void setBreed(Breed breed) {
        this.breed = breed;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Dogs() {
    }

    public Dogs(String name, int age, double price, String imgFile) {
        this.name = name;
        this.age = age;
        this.price = price;
        this.imgFile = imgFile;

    }

    @Override
    public String toString() {
        return "Dogs{" +
                "dog_id=" + dog_id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", price=" + price +
                ", imgFile='" + imgFile + '\'' +
                '}';
    }
}
