package hibernate.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "STATES")
public class State {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="STATE_ID")
    private int stateId;
    @Column(name="STATE_NAME")
    private String stateName;

    // OneToMany - Each state can be attached to many registrations
    // Default is Lazy Load - it's the preferred method and only gets entities when needed.
    @OneToMany(mappedBy = "state",
        cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH})
    private List<Registration> reggie;

    public int getStateId() {
        return stateId;
    }

    public void setStateId(int stateId) {
        this.stateId = stateId;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public List<Registration> getReggie() {
        return reggie;
    }

    public void setReggie(List<Registration> reggie) {
        this.reggie = reggie;
    }

    public State() {
    }

    public State(String stateName) {
        this.stateName = stateName;
    }

    public void add(Registration tempRegistration){
        if(reggie == null){
            reggie = new ArrayList<>();

        }
        reggie.add(tempRegistration);
    }

    @Override
    public String toString() {
        return "State{" +
                "stateId=" + stateId +
                ", stateName='" + stateName + '\'' +
                '}';
    }
}
