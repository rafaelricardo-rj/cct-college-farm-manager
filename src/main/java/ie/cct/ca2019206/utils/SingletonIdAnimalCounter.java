/**
 * This singleton class ensure that when new animals are created they get one unique ID regardless of where they were
 * created in the application. Animals are created when the application start and when the user make a Http Post request,
 * then this singleton is called in these two process to ensure the continuity of the ID, otherwise the application
 * could not know the next id should be used when a new animal is created.
 * This task is usually done by the database but it is not present on this project.
 * @author  Rafael Ricardo - Student number: 2019206
 * @since   2020-05-12
 * */
package ie.cct.ca2019206.utils;

public class SingletonIdAnimalCounter {

    private int idAnimal = 0;

    private static SingletonIdAnimalCounter instance = null;

    /**
     * This method check if already exist an instance of the class, if yes, return it, if not, created a new one.
     * @return SingletonAnimalCounter
     * */
    public static SingletonIdAnimalCounter getInstance(){

        if (instance == null) {

            instance = new SingletonIdAnimalCounter();
        }

        return (instance);
    }

    /**
     * Method responsible for increment the ID attribute and return it.
     * @return int
     * */
    public int incrementIdAnimal(){
        this.idAnimal++;
        return this.idAnimal;
    }
}
