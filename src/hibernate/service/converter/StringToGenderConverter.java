package hibernate.service.converter;

import hibernate.entity.Gender;
import hibernate.service.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class StringToGenderConverter implements Converter<String, Gender> {

    @Autowired
    private GenderService genderService;

    @Override
    public Gender convert(String source) {
        int genderId = Integer.parseInt(source);
        Gender aGender = genderService.getGenders(genderId);

        return aGender;
    }


}
