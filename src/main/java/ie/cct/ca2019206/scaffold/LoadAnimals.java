/**
 * This class is responsible for creating default animals in memory when the application start.
 * @since   2020-05-12*/

package ie.cct.ca2019206.scaffold;

import ie.cct.ca2019206.enums.AnimalType;
import ie.cct.ca2019206.model.Animal;

import java.util.ArrayList;

public class LoadAnimals {

    /** ArrayList to add Animal objects */
    private static ArrayList<Animal> animals = new ArrayList<>();

    /** Method add animals default to the ArrayList
     * @return ArrayList ArrayList of Animal */
    public static ArrayList<Animal> create(){
        animals.add(new Animal(AnimalType.COW, 290F));
        animals.add(new Animal(AnimalType.COW, 300F));
        animals.add(new Animal(AnimalType.COW, 321F));
        animals.add(new Animal(AnimalType.COW, 232F));
        animals.add(new Animal(AnimalType.PIG, 120F));
        animals.add(new Animal(AnimalType.PIG, 92F));
        animals.add(new Animal(AnimalType.PIG, 60F));
        animals.add(new Animal(AnimalType.PIG, 113F));
        animals.add(new Animal(AnimalType.CHICKEN, 0.2F));
        animals.add(new Animal(AnimalType.CHICKEN, 0.5F));
        animals.add(new Animal(AnimalType.CHICKEN, 0.3F));
        animals.add(new Animal(AnimalType.CHICKEN, 0.8F));
        animals.add(new Animal(AnimalType.CHICKEN, 0.6F));
        animals.add(new Animal(AnimalType.CHICKEN, 0.72F));

        return animals;
    }
}
