package hibernate.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Genders")
public class Gender {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="gender_id")
    private int genderId;

    @Column(name="gender_name")
    private String gender;

    // OneToMany - Each gender can be attached to many dogs
    // Default is Lazy Load - it's the preferred method and only gets entities when needed.
    @OneToMany(mappedBy = "gender",
            cascade = {CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH})
    private List<Dogs> doggie;

    public int getGenderId() {
        return genderId;
    }

    public void setGenderId(int genderId) {
        this.genderId = genderId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Gender() {
    }

    public Gender(String gender) {
        this.gender = gender;
    }

    public List<Dogs> getDoggie() {
        return doggie;
    }

    public void setDoggie(List<Dogs> doggie) {
        this.doggie = doggie;
    }

    public void add(Dogs tempDog){
        if(doggie == null){
            doggie = new ArrayList<>();

        }
        doggie.add(tempDog);
    }

    @Override
    public String toString() {
        return "Gender{" +
                "genderId=" + genderId +
                ", gender='" + gender + '\'' +
     //           ", doggie=" + doggie +
                '}';
    }
}
