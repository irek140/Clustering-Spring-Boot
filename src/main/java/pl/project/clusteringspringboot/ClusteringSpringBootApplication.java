package pl.project.clusteringspringboot;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.util.Workspace;

/**
 * Author of implementation and concept in java: Piotr Lasek
 * Authors of refactoring to Spring Boot application: Ireneusz Kiełtyka, Kamil Kłósek, Łukasz Janowski
 */
@SpringBootApplication
public class ClusteringSpringBootApplication {

    private final static Logger log = LogManager.getLogger(ClusteringSpringBootApplication.class);


    public static void main(String[] args) {

        SpringApplication.run(ClusteringSpringBootApplication.class, args);


    }

}
