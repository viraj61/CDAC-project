package com.example.demo;

//import org.modelmapper.Conditions;
//import org.modelmapper.ModelMapper;
//import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
public class CdacProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(CdacProjectApplication.class, args);
    }

   @Bean
   public ModelMapper mapper() {
       ModelMapper modelMapper = new ModelMapper();
       modelMapper.getConfiguration()
               .setMatchingStrategy(MatchingStrategies.STRICT)
               .setPropertyCondition(Conditions.isNotNull());
       return modelMapper;
   }
}
