package hibernate.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CLAWS")
public class Declawed {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="DECLAWED_ID")
    private int declawedId;

    @Column(name="DECLAWED_NAME")
    private String declawed;

    // OneToMany - Each declawed type can be attached to many dogs
    // Default is Lazy Load - it's the preferred method and only gets entities when needed.
    @OneToMany(mappedBy = "declawed",
            cascade = {CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH})
    private List<Dogs> doggie;

    public int getDeclawedId() {
        return declawedId;
    }

    public void setDeclawedId(int declawedId) {
        this.declawedId = declawedId;
    }

    public String getDeclawed() {
        return declawed;
    }

    public void setDeclawed(String declawed) {
        this.declawed = declawed;
    }

    public List<Dogs> getDoggie() {
        return doggie;
    }

    public void setDoggie(List<Dogs> doggie) {
        this.doggie = doggie;
    }

    public Declawed(String declawed) {
        this.declawed = declawed;
    }

    public Declawed() {
    }

    public void add(Dogs tempDog){
        if(doggie == null){
            doggie = new ArrayList<>();

        }
        doggie.add(tempDog);
    }

    @Override
    public String toString() {
        return "Declawed{" +
                "declawedId=" + declawedId +
                ", declawed='" + declawed + '\'' +
                '}';
    }
}
