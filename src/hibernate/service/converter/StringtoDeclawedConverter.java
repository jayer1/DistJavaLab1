package hibernate.service.converter;

import hibernate.entity.Declawed;
import hibernate.service.DeclawedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class StringtoDeclawedConverter implements Converter<String, Declawed> {

    @Autowired
    private DeclawedService declawedService;
    @Override
    public Declawed convert(String source) {
        int declawedId = Integer.parseInt(source);
        return declawedService.getDeclaweds(declawedId);
    }
}
