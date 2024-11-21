package pe.edu.i202221574.cl1_jpa_data_Lima_Luis.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int population;

    @ManyToOne
    @JoinColumn(name = "CountryCode", referencedColumnName = "Code", insertable = false, updatable = false)
    private Country country;
}



