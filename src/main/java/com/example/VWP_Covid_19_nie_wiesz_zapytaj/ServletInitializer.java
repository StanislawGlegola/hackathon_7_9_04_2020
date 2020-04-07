package com.example.VWP_Covid_19_nie_wiesz_zapytaj;


import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(VwpCovid19NieWieszZapytajApplication.class);
    }

}
