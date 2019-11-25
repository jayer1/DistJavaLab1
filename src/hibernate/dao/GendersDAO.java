package hibernate.dao;

import hibernate.entity.Gender;

import java.util.List;

public interface GendersDAO {
    List<Gender> getGender();

    Gender getGender(int id);
}
