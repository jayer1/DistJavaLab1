package hibernate.service;

import hibernate.entity.Declawed;
import java.util.List;


public interface DeclawedService {

    List<Declawed> getDeclaweds();

    Declawed getDeclaweds(int id);
}
