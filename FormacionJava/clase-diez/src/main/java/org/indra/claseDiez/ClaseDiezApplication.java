package org.indra.claseDiez;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class ClaseDiezApplication {

    public static void main(String[] args) {
        // SpringApplication.run(ClaseDiezApplication.class, args);
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Repository repository = (Repository) applicationContext.getBean("repository");
        repository.save();
    }

}
