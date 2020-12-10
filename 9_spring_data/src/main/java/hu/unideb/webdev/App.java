package hu.unideb.webdev;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Run -> Configuration -> Environment Variables
 *  - DB_HOST localhost /127.0.0.1
 *  - DB_PORT 3306
 *  - DB_NAME AustralianFotball
 *  - DB_USER root
 *  - DB_PASS password
 *
 *  Example configuration
 * @see {project.basedir}/src/main/resources/sql/football.sh
 */
@Slf4j
@SpringBootApplication
public class App {

    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }

}
