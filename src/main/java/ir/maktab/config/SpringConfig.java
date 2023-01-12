package ir.maktab.config;

import ir.maktab.service.DoctorService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {"ir.maktab"})
@Import(value={DatabaseConfig.class})
public class SpringConfig {

/*    @Bean
    public DoctorService doctorService() {
        return new DoctorService();
    }*/
}
