package hibernate.dao;

import hibernate.entity.Declawed;

import java.util.List;

public interface DeclawedDAO {
    List<Declawed> getDeclawed();

    Declawed getDeclawed(int id);
}
