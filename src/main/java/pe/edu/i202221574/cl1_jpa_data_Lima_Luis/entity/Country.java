package pe.edu.i202221574.cl1_jpa_data_Lima_Luis.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Country {

    @Id
    private String code;

    private String name;
    private String continent;
    private String region;
    private Double surfaceArea;
    private Integer indepYear;
    private int population;
    private Double lifeExpectancy;
    private Double gnp;
    private Double gnpOld;
    private String localName;
    private String governmentForm;
    private String headOfState;
    private Integer capital;
    private String code2;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<City> cities;


    @OneToMany(mappedBy = "country", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CountryLanguage> languages;



}








