package pe.edu.i202210494.domain;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class ConConverter implements AttributeConverter<Country.Continent, String> {

    @Override
    public String convertToDatabaseColumn(Country.Continent attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.name();
    }

    @Override
    public Country.Continent convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.isEmpty()) {
            return null;
        }
        try {
            return Country.Continent.valueOf(dbData.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Valor desconocido Continent: '" + dbData + "'", e);
        }
    }
}
