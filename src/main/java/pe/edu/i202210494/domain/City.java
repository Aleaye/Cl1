package pe.edu.i202210494.domain;

import jakarta.persistence.*;

@Entity
@Table (name = "city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    private String Name;
    //
    @ManyToOne
    @JoinColumn(name = "CountryCode", nullable = false)
    private Country country;
    private String  District;
    private int Population;

    @Override
    public String toString() {
        return "City[ID=" + ID + ", Name='" + Name + "'," +
                " District='" + District + "', Population=" + Population + "," +
                " country=" + country + "]";
    }

    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public String getDistrict() {
        return District;
    }
    public void setDistrict(String district) {
        District = district;
    }
    public int getPopulation() {
        return Population;
    }
    public void setPopulation(int population) {
        Population = population;
    }
    public Country getCountry() {
        return country;
    }
    public void setCountry(Country country) {
        this.country = country;
    }


    public City() {
    }

    public City(int ID, String name, String district, int population, Country country) {
        this.ID = ID;
        Name = name;
        District = district;
        Population = population;
        this.country = country;
    }
}
