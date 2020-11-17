package pl.project.clusteringspringboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.util.Workspace;
import pl.util.ClusteringSettingsU;

@Configuration
public class BeansConfig {

    @Bean
    Workspace workspace() {
        return new Workspace();
    }

    @Bean
    ClusteringSettingsU utilClusteringSettings() {
        return new ClusteringSettingsU();
    }
}
