package pe.edu.i202221574.cl1_jpa_data_Lima_Luis.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CountryLanguageId implements Serializable {

    @Column(name = "CountryCode")
    private String countryCode;

    @Column(name = "Language")
    private String language;


    public CountryLanguageId() {}


    public CountryLanguageId(String countryCode, String language) {
        this.countryCode = countryCode;
        this.language = language;
    }

    // Getters y Setters
    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    // Métodos equals() y hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountryLanguageId that = (CountryLanguageId) o;
        return Objects.equals(countryCode, that.countryCode) && Objects.equals(language, that.language);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryCode, language);
    }
}
