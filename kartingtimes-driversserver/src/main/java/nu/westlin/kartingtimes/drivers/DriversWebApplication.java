package nu.westlin.kartingtimes.drivers;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@SpringBootApplication
@EntityScan("nu.westlin.kartingtimes.drivers")
@EnableJpaRepositories("nu.westlin.kartingtimes.drivers")
@PropertySource("classpath:db-config.properties")
public class DriversWebApplication {

    protected Logger logger = Logger.getLogger(DriversWebApplication.class
        .getName());

    /**
     * Run the application using Spring Boot and an embedded servlet engine.
     *
     * @param args Program arguments - ignored.
     */
/*
    public static void main(String[] args) {
        SpringApplication.run(DriversWebApplication.class, args);
    }
*/

    /**
     * Creates an in-memory "rewards" database populated with test data for fast
     * testing
     */
    @Bean
    public DataSource dataSource() {
        logger.info("dataSource() invoked");

        // Create an in-memory H2 relational database containing some demo
        // drivers.
        DataSource dataSource = (new EmbeddedDatabaseBuilder())
            .addScript("classpath:testdb/schema.sql")
            .addScript("classpath:testdb/data.sql").build();

        logger.info("dataSource = " + dataSource);

        // Sanity check
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<Map<String, Object>> drivers = jdbcTemplate
            .queryForList("SELECT ID FROM T_DRIVER");
        logger.info("System has " + drivers.size() + " drivers");

        return dataSource;
    }
}
