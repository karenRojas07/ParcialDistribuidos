package co.edu.uptc.animals_rest.controllers;

import java.io.IOException;
import java.util.List;

import co.edu.uptc.animals_rest.models.CategoryCount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uptc.animals_rest.models.Animal;
import co.edu.uptc.animals_rest.services.AnimalService;


@RestController
@RequestMapping("/animal")
public class AnimalController {

    private static final Logger logger = LoggerFactory.getLogger(AnimalController.class);

    @Autowired
    private AnimalService animalService;


    @GetMapping("/all")
    public List<Animal> getAnimalAll() throws IOException {
        logger.info("getAnimalAll called");
        return animalService.getAnimalAll();
    }

    @GetMapping("/range")
    public List<Animal> getAnimal(@RequestParam int from, @RequestParam int to) throws IOException {
        logger.info("getAnimal called with parameters: from = {}, to = {}", from, to);
        return animalService.getAnimalInRange(from, to);
    }

    @GetMapping("/numberByCategory")
    public List<CategoryCount> getNumberByCategory() throws IOException {
        try {
            logger.info("getNumberByCategory called");
            return animalService.getNumberByCategory();
        } catch (IOException e) {
            // Manejar el error imprimiendo el mensaje en consola
            System.out.println(":( Error al acceder a uno de los archivos. Por favor verifica la ruta.");
            System.out.println("Ruta de archivo incorrecta: " + e.getMessage());
            return null; // O puedes devolver un error 500 u otro mensaje personalizado
        }
    }


}
