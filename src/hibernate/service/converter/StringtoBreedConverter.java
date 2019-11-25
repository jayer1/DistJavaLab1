package hibernate.service.converter;

import hibernate.entity.Breed;
import hibernate.service.BreedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class StringtoBreedConverter implements Converter<String, Breed> {

    @Autowired
    private BreedService breedService;

    @Override
    public Breed convert(String source) {
        int breedId = Integer.parseInt(source);
        Breed aBreed = breedService.getBreeds(breedId);

        return aBreed;
    }


}
