package pe.edu.i202221574.cl1_jpa_data_Lima_Luis.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConexionesConfig {

    @Bean
    public HikariDataSource hikariDataSource() {
        HikariConfig config = new HikariConfig();

        // Configuración de la conexión
        config.setJdbcUrl(System.getenv("DB_WORLD_URL"));
        config.setUsername(System.getenv("DB_WORLD_USER"));
        config.setPassword(System.getenv("DB_WORLD_PASS"));
        config.setDriverClassName(System.getenv("DB_WORLD_DRIVER"));

        // Configuración del pool de conexiones
        config.setMaximumPoolSize(30);
        config.setMinimumIdle(4);
        config.setIdleTimeout(240000); // 4 minutos
        config.setConnectionTimeout(45000); // 45 segundos

        return new HikariDataSource(config);
    }
}
