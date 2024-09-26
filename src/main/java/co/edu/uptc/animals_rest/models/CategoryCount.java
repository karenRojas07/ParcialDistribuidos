package co.edu.uptc.animals_rest.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CategoryCount {
    private String category;
    private int number;

}
