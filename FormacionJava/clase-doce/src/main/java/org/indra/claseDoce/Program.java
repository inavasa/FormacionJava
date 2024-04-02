package org.indra.claseDoce;

import org.indra.claseDoce.models.Personaje;
import org.indra.claseDoce.services.PersonajeServiceInterface;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Program {

    public static void main(String[] args) {
        // SpringApplication.run(ClaseDiezApplication.class, args);
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        /*
        Repository repository = (Repository) applicationContext.getBean("repositoryPersonaje");

        Personaje personaje = new Personaje("Magneto");
        repository.save(personaje);

        Personaje personaje2 = (Personaje) repository.findById(1);
        System.out.println(personaje2.getNombre());
         */

        PersonajeServiceInterface personajeService = (PersonajeServiceInterface) applicationContext.getBean("service");
        personajeService.registrarPersonaje("Xavier");

        Personaje p = personajeService.recuperar(1);
        System.out.println(p.getNombre());
    }
}
