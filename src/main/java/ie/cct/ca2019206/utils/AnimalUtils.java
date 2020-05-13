/**
 * This class has some methods to be utilised by the class AnimalController in order to reduce the amount of code in the
 * methods of the controller classes, helping to perform some operations and keeping these methods more organized and
 * readable
 * @since   2020-05-12*/
package ie.cct.ca2019206.utils;

import ie.cct.ca2019206.enums.AnimalMinWeight;
import ie.cct.ca2019206.enums.AnimalType;
import ie.cct.ca2019206.model.Animal;
import java.util.ArrayList;
import java.util.HashMap;

import static ie.cct.ca2019206.enums.AnimalType.*;

public class AnimalUtils {
    /**
     * This method calc how many animals are ready to sell based on the minimum weight needed for each animal and based
     * on the type of the animal.
     * @param animals is an ArrayList of animal. This ArrayList must have all the animals we want to verify.
     * @param animalType is an AnimalType we want to search within the ArrayList.
     * @param animalMinWeight is an AnimalMinWeight with the value of the minimum weight we should consider.
     * @return HashMap is a pair value list with the result.
     * */
    public static HashMap<String, Integer> qtyAnimalToSell(ArrayList<Animal> animals, AnimalType animalType, AnimalMinWeight animalMinWeight){
        int qtyToSell = 0;
        HashMap<String, Integer> result = new HashMap<>();
        for ( Animal animal : animals ) {
            if( animal.getType().equals(animalType) ){
                if( Float.compare(animal.getWeight(), animalMinWeight.get()) >= 0){
                    qtyToSell++;
                }
            }
        }
        result.put(animalType.toString().toLowerCase(), qtyToSell);
        return result;
    }

    /**
     * This method calc how many animals are ready to sell based on the minimum weight needed for each animal and based
     * on the type of the animal. Different from the method above, this method count all the animals ready to sell
     * whereas the first method make the calc based on only one type of animal.
     * @param animals is an ArrayList of animal. This ArrayList must have all the animals we want to verify.
     * @return HashMap is a pair value list with the result.
     * */
    public static HashMap<String, Integer> qtyAllAnimalsToSell(ArrayList<Animal> animals){
        HashMap<String, Integer> animalsToSell = new HashMap<>();
        animalsToSell.put("cow", qtyAnimalToSell(animals, COW, AnimalMinWeight.COW).get("cow"));
        animalsToSell.put("pig", qtyAnimalToSell(animals, PIG, AnimalMinWeight.PIG).get("pig"));
        animalsToSell.put("chicken", qtyAnimalToSell(animals, CHICKEN, AnimalMinWeight.CHICKEN).get("chicken"));
        return animalsToSell;
    }

    /**
     * This method try to parse the parameter from String to Double, if it fail then it is not a valid Double and trows an exception
     * If the parameter is null or is empty, the defaultValue is taken
     * @param parameter String
     * @param defaultValue default value of type Double.
     * @return Double.
     * */
    public static Double validParametersDouble(String parameter, Double defaultValue){
        if(parameter.equals(null) || parameter.equals("")){
            return defaultValue;
        } else {
            try {
                return Double.parseDouble(parameter);
            } catch (NumberFormatException e){
                throw new BadRequestException("Parameters must be numbers. "+e.getMessage());
            }
        }
    }
}
