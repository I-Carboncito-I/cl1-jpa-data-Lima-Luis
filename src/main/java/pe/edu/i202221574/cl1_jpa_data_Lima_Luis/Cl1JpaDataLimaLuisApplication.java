package pe.edu.i202221574.cl1_jpa_data_Lima_Luis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pe.edu.i202221574.cl1_jpa_data_Lima_Luis.entity.Country;
import pe.edu.i202221574.cl1_jpa_data_Lima_Luis.repository.CountryRepository;


import java.util.Optional;

@SpringBootApplication
public class Cl1JpaDataLimaLuisApplication implements CommandLineRunner {

	@Autowired
	private CountryRepository countryRepository;

	public static void main(String[] args) {
		SpringApplication.run(Cl1JpaDataLimaLuisApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// 1. Lenguajes de Argentina o Perú
		System.out.println("Consulta 1: Lenguajes de Argentina o Perú");

		// Obtener el país por código
		Optional<Country> country = countryRepository.findById("ARG");

		// Si existe, obtener y mostrar los lenguajes, de lo contrario mostrar lenguas de Perú
		country.ifPresentOrElse(
				c -> {
					System.out.println("Lenguas de Argentina:");
					c.getLanguages().forEach(language -> {
						System.out.println(language.getLanguage());
					});
				},
				() -> {
					System.out.println("No se encontraron lenguas para Argentina. Consultando lenguas de Perú.");
					Optional<Country> peru = countryRepository.findById("PER");
					peru.ifPresentOrElse(
							p -> {
								System.out.println("Lenguas de Perú:");
								p.getLanguages().forEach(language -> {
									System.out.println(language.getLanguage());
								});
							},
							() -> System.out.println("No se encontraron lenguas para Perú.")
					);
				}
		);

		// 2. Eliminar países "COL" y "ARG"
		System.out.println("Eliminando los países 'COL' y 'ARG'...");
		countryRepository.deleteById("COL");
		countryRepository.deleteById("ARG");
		System.out.println("Países eliminados.");

		// 3. Volver a ejecutar la consulta después de eliminar "ARG"
		System.out.println("Volviendo a ejecutar la consulta después de eliminar 'ARG'...");
		Optional<Country> restoredCountry = countryRepository.findById("ARG");
		if (restoredCountry.isPresent()) {
			System.out.println("Lenguas de Argentina:");
			restoredCountry.get().getLanguages().forEach(language -> {
				System.out.println(language.getLanguage());
			});
		} else {
			System.out.println("No se encontraron lenguas para Argentina después de la eliminación.");
		}
	}
}






