package hibernate.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Breeds")
public class Breed {


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="breed_id")
    private int breedId;

    @Column(name="breed_name")
    private String breed;

    // OneToMany - Each breed can be attached to many dogs
    // Default is Lazy Load - it's the preferred method and only gets entities when needed.
    @OneToMany(mappedBy = "breed",
            cascade = {CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH})
    private List<Dogs> doggie;

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getBreedId() {
        return breedId;
    }

    public void setBreedId(int breedId) {
        this.breedId = breedId;
    }

    public List<Dogs> getDoggie() {
        return doggie;
    }

    public void setDoggie(List<Dogs> doggie) {
        this.doggie = doggie;
    }

    public Breed() {
    }

    public Breed(String breed) {
        this.breed = breed;
    }

    public void add(Dogs tempDog){
        if(doggie == null){
            doggie = new ArrayList<>();

        }
        doggie.add(tempDog);
    }

    @Override
    public String toString() {
        return "Breed{" +
                "breedId=" + breedId +
                ", breed='" + breed + '\'' +
                ", doggie=" + doggie +
                '}';
    }
}
