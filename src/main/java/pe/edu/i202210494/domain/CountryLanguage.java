package pe.edu.i202210494.domain;

import jakarta.persistence.*;

@Entity
@IdClass(CLid.class)
public class CountryLanguage {
   @Id
   private String CountryCode;
   @Id
   private String Language;
   private String  IsOfficial;
   private double Percentage;
   @ManyToOne
   @JoinColumn(name = "CountryCode", insertable = false, updatable = false)
   private Country country;

   @Override
   public String toString() {
      return "{\n" +
              "  \"CountryCode\": \"" + CountryCode + "\",\n" +
              "  \"Language\": \"" + Language + "\",\n" +
              "  \"IsOfficial\": \"" + IsOfficial + "\",\n" +
              "  \"Percentage\": " + Percentage + ",\n" +
              "  \"Country\": " + country + "\n" +
              "}";
   }
   public String getCountryCode() {
      return CountryCode;
   }
   public void setCountryCode(String countryCode) {
      CountryCode = countryCode;
   }
   public String getLanguage() {
      return Language;
   }
   public void setLanguage(String language) {
      Language = language;
   }
   public String getIsOfficial() {
      return IsOfficial;
   }
   public void setIsOfficial(String isOfficial) {
      IsOfficial = isOfficial;
   }
   public double getPercentage() {
      return Percentage;
   }
   public void setPercentage(double percentage) {
      Percentage = percentage;
   }
   public Country getCountry() {
      return country;
   }
   public void setCountry(Country country) {
      this.country = country;
   }
   public CountryLanguage() {
   }

   public CountryLanguage(String countryCode) {
      CountryCode = countryCode;
   }

   public CountryLanguage(String countryCode, String language, String isOfficial, double percentage, Country country) {
      CountryCode = countryCode;
      Language = language;
      IsOfficial = isOfficial;
      Percentage = percentage;
      this.country = country;
   }

}
