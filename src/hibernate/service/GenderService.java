package hibernate.service;

import hibernate.entity.Gender;

import java.util.List;

public interface GenderService {
    List<Gender> getGenders();

    Gender getGenders(int id);
}
