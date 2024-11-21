package pe.edu.i202221574.cl1_jpa_data_Lima_Luis.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "countrylanguage")
public class CountryLanguage {

    @EmbeddedId
    private CountryLanguageId id;

    private String isOfficial;
    private Double percentage;

    @ManyToOne
    @JoinColumn(name = "CountryCode", referencedColumnName = "Code", insertable = false, updatable = false)
    private Country country;


    public String getLanguage() {
        return id != null ? id.getLanguage() : null;
    }
}















