package pe.edu.i202210494.Crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import pe.edu.i202210494.domain.Country;
import pe.edu.i202210494.domain.City;
import pe.edu.i202210494.domain.CountryLanguage;
import jakarta.persistence.Persistence;

import java.util.Arrays;

public class JPAPersiste {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try {
            emf = Persistence.createEntityManagerFactory("world");
            em = emf.createEntityManager();

            Country country = createCountry();
            City city1 = createCity("city new", " centro", 989234, country);
            City city2 = createCity("ciudad got", "este", 4535324, country);
            City city3 = createCity("ciudad negra", "sur", 345453, country);
            CountryLanguage language1 = createLanguage("GL", "ingle", true, 60.0, country);
            CountryLanguage language2 = createLanguage("GL", "españo", false, 10.0, country);
            country.setCities(Arrays.asList(city1, city2, city3));
            country.setLanguages(Arrays.asList(language1, language2));

            em.getTransaction().begin();
            em.persist(country);
            em.getTransaction().commit();


            System.out.println("------ País ---");
            System.out.println(country);
            System.out.println("País creado con éxito.");

        } catch (Exception e) {
            System.err.println("Ocurrió un error : " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (em != null) em.close();
            if (emf != null) emf.close();
        }
    }

    private static Country createCountry() {
        Country country = new Country();
        country.setName("GOTAN");
        country.setCode("GL");
        country.setContinent(Country.Continent.NORTH_AMERICA);
        country.setRegion("sur");
        country.setSurfaceArea(12345.67);
        country.setPopulation(3200932);
        country.setIndepYear(2025);
        country.setLocalName("ciudad de batman");
        country.setGovernmentForm("Sin");
        country.setCode2("GL");
        return country;
    }

    private static City createCity(String name, String district, int population, Country country) {
        City city = new City();
        city.setName(name);
        city.setDistrict(district);
        city.setPopulation(population);
        city.setCountry(country);
        return city;
    }

    private static CountryLanguage createLanguage(String countryCode, String language, boolean isOfficial, double percentage, Country country) {
        CountryLanguage lang = new CountryLanguage();
        lang.setCountryCode(countryCode);
        lang.setLanguage(language);
        lang.setIsOfficial(isOfficial ? "T" : "F");
        lang.setPercentage(percentage);
        lang.setCountry(country);
        return lang;
    }
}


