package cm.skysoft.Care_Health.Config;


import cm.skysoft.Care_Health.Entity.Medecin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class config {

    @Bean
    public Medecin medecin() {

        return new Medecin();
    }
}
