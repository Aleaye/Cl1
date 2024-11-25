package pe.edu.i202210494.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "country")
public class Country {
    public enum Continent {
        ASIA("Asia"),
        OCEANIA("Oceania"),
        NORTH_AMERICA("North America"),
        SOUTH_AMERICA("South America"),
        AFRICA("Africa"),
        EUROPE("Europe"),
        ANTARCTICA("Antarctica");
        private final String value;

        Continent(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
    @Id
    private String Code;
    private String Name;
    @Convert(converter = ConConverter.class)
    private Continent Continent;
    private String  Region;
    private double SurfaceArea;
    private int IndepYear;
    private int Population;
    private double LifeExpectancy;
    private double GNP;
    private double GNPOld;
    private String LocalName;
    private String GovernmentForm;
    private String HeadOfState;
    private int Capital;
    private String Code2;

    @OneToMany(mappedBy = "country", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
    private List<City> cities;

    @OneToMany(mappedBy = "country", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
    private List<CountryLanguage> languages;

    @Override
    public String toString() {
        return "{\n" +
                "  \"Code\": \"" + Code + "\",\n" +
                "  \"Name\": \"" + Name + "\",\n" +
                "  \"Continent\": \"" + Continent + "\",\n" +
                "  \"Region\": \"" + Region + "\",\n" +
                "  \"SurfaceArea\": " + SurfaceArea + ",\n" +
                "  \"IndepYear\": " + IndepYear + ",\n" +
                "  \"Population\": " + Population + ",\n" +
                "  \"LifeExpectancy\": " + LifeExpectancy + ",\n" +
                "  \"GNP\": " + GNP + ",\n" +
                "  \"GNPOld\": " + GNPOld + ",\n" +
                "  \"LocalName\": \"" + LocalName + "\",\n" +
                "  \"GovernmentForm\": \"" + GovernmentForm + "\",\n" +
                "  \"HeadOfState\": \"" + HeadOfState + "\",\n" +
                "  \"Capital\": " + Capital + ",\n" +
                "  \"Code2\": \"" + Code2 + "\",\n" +
                "  \"Cities\": " + cities + ",\n" +
                "  \"Languages\": " + languages + "\n" +
                "}";
    }


    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Country.Continent getContinent() {
        return Continent;
    }

    public void setContinent(Country.Continent continent) {
        Continent = continent;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String region) {
        Region = region;
    }

    public double getSurfaceArea() {
        return SurfaceArea;
    }

    public void setSurfaceArea(double surfaceArea) {
        SurfaceArea = surfaceArea;
    }

    public int getIndepYear() {
        return IndepYear;
    }

    public void setIndepYear(int indepYear) {
        IndepYear = indepYear;
    }

    public int getPopulation() {
        return Population;
    }

    public void setPopulation(int population) {
        Population = population;
    }

    public double getLifeExpectancy() {
        return LifeExpectancy;
    }

    public void setLifeExpectancy(double lifeExpectancy) {
        LifeExpectancy = lifeExpectancy;
    }

    public double getGNP() {
        return GNP;
    }

    public void setGNP(double GNP) {
        this.GNP = GNP;
    }

    public double getGNPOld() {
        return GNPOld;
    }

    public void setGNPOld(double GNPOld) {
        this.GNPOld = GNPOld;
    }

    public String getLocalName() {
        return LocalName;
    }

    public void setLocalName(String localName) {
        LocalName = localName;
    }

    public String getGovernmentForm() {
        return GovernmentForm;
    }

    public void setGovernmentForm(String governmentForm) {
        GovernmentForm = governmentForm;
    }

    public String getHeadOfState() {
        return HeadOfState;
    }

    public void setHeadOfState(String headOfState) {
        HeadOfState = headOfState;
    }

    public int getCapital() {
        return Capital;
    }

    public void setCapital(int capital) {
        Capital = capital;
    }

    public String getCode2() {
        return Code2;
    }

    public void setCode2(String code2) {
        Code2 = code2;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public List<CountryLanguage> getLanguages() {
        return languages;
    }

    public void setLanguages(List<CountryLanguage> languages) {
        this.languages = languages;
    }

    public Country() {
    }
    public Country(String code, String name, Country.Continent continent, String region, double surfaceArea, int indepYear, int population, double lifeExpectancy, double GNP, double GNPOld, String localName, String governmentForm, String headOfState, int capital, String code2, List<City> cities, List<CountryLanguage> languages) {
        Code = code;
        Name = name;
        Continent = continent;
        Region = region;
        SurfaceArea = surfaceArea;
        IndepYear = indepYear;
        Population = population;
        LifeExpectancy = lifeExpectancy;
        this.GNP = GNP;
        this.GNPOld = GNPOld;
        LocalName = localName;
        GovernmentForm = governmentForm;
        HeadOfState = headOfState;
        Capital = capital;
        Code2 = code2;
        this.cities = cities;
        this.languages = languages;
    }
}
