package hibernate.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Dogs")
public class Dogs {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="Dog_Id")
    private int dog_id;

    @NotNull(message = "required")
    @Column(name="Name")
    private String name;

    @NotNull(message = "required")
    @Min(value = 1, message = "must be greater than 0")
    @Column(name="Age")
    private Integer age;

    @NotNull(message = "required")
    @Min(value = 100, message = "must be greater than 100")
    @Column(name="Price")
    private Double price;

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
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

    public Dogs(String name, Integer age, Double price, String imgFile) {
        this.name = name;
        this.age = age;
        this.price = price;
        this.imgFile = imgFile;

    }

    public String getImagePath() {
        if (imgFile == null)
            return "none.jpg";
        return "/" + imgFile;
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
