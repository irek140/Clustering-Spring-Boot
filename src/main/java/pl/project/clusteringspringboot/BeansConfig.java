package pl.project.clusteringspringboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.project.clusteringspringboot.datamining.resource.CDMFileConnectionFactory;
import pl.util.Workspace;
import pl.util.ClusteringSettingsPL;


@Configuration
public class BeansConfig {

    @Bean
    Workspace workspace() {
        return new Workspace();
    }

    @Bean
    ClusteringSettingsPL utilClusteringSettings() {
        return new ClusteringSettingsPL();
    }

}
