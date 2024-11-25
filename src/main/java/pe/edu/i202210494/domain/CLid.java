package pe.edu.i202210494.domain;

import java.io.Serializable;

public class CLid implements Serializable {
    private String CountryCode;
    private String Language;

    public CLid(String countryCode, String language) {
        CountryCode = countryCode;
        Language = language;
    }
    public CLid() {
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

    @Override
    public String toString() {
        return "CountryLanguageId {" +
                "CountryCode='" + (CountryCode != null ? CountryCode : "N/A") + '\'' +
                ", Language='" + (Language != null ? Language : "N/A") + '\'' +
                '}';
    }

}
