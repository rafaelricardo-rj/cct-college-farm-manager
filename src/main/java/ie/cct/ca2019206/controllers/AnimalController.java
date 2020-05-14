/**
 * This controller receives requests for the endpoint /animals.
 * Available resources:
 * 1 List all the animals.
 * 2 Add a new animal
 * 3 Calculate the average weight of each type of animal
 * 4 How many animals of each type can be sold right now.
 * 5 What is the current value of the full farm stock (the price of all animals that can be sold right now)
 * 6 What is the current value of the farm assuming the price of each animal is set by a parameter in the HTTP request.
 *
 * @author  Rafael Ricardo - Student number: 2019206
 * @since   2020-05-12
 * */
package ie.cct.ca2019206.controllers;

import ie.cct.ca2019206.Helpers.RespRequest;
import ie.cct.ca2019206.Helpers.RespSuccess;
import ie.cct.ca2019206.enums.AnimalMinWeight;
import ie.cct.ca2019206.enums.AnimalType;
import ie.cct.ca2019206.enums.AnimalValue;
import ie.cct.ca2019206.model.Animal;
import ie.cct.ca2019206.scaffold.LoadAnimals;
import ie.cct.ca2019206.utils.AnimalUtils;
import ie.cct.ca2019206.utils.BadRequestException;
import org.springframework.web.bind.annotation.*;

import java.text.DecimalFormat;
import java.util.*;

import static ie.cct.ca2019206.enums.AnimalType.*;

@RestController
public class AnimalController {

    /**
     * It holds a list of animal objects instances when the application run. */
    private ArrayList<Animal> animals = new ArrayList<>();

    /**
     * Constructor of the class call the class responsible for creating all of the animals and add it to the
     * ArrayList animals
     * @see ie.cct.ca2019206.scaffold.LoadAnimals LoadAnimals */
    public AnimalController(){ this.animals = LoadAnimals.create(); }

    /**
     * Adds a new animal to the farm.
     * @param animal This expect an Object animal but actually the end-point get a json object from the client then
     *               Spring transform this json in Animal object.
     *               The json object received must be like this: { "type": "cow", "weight":"200" }.
     *               Types accepted: cow | pig | chicken
     * @return RespSuccess This is an Object with the message of success.
     * @see ie.cct.ca2019206.model.Animal Animal
     * @see ie.cct.ca2019206.enums.AnimalValue AnimalValue
     * @see ie.cct.ca2019206.Helpers.RespSuccess RespSuccess
     * */
    @PostMapping("/api/animals")
    public RespSuccess storeAnimal(@RequestBody Animal animal) {
        /** Set the value of this animal according with the type. */
        animal.setValue(AnimalValue.valueOf(animal.getType().toString()).get());
        animals.add(animal);
        System.out.println(animal.getType());
        return new RespSuccess("Animal added");
    }

    /**
     * List all the animals.
     * @return ArrayList This is a list of Animal Objects
     * */
    @GetMapping("/api/animals")
    public ArrayList<Animal> listAnimals(){
        return animals;
    }

    /**
     * This end-point calculate the average weight of each animal on the farm.
     * This iterate the animal list, check the type of animal in the current loop and summarize their weight, increment the
     * counter then in the of the loop divide weight total by the quantity of the animal.
     * After that, an instance of DecimalFormat class is created to limit the number of digits in the result.
     * In the end, the values are added to the HashMap.
     * @return RespRequest This returns an Object with a HashMap.
     * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/text/DecimalFormat.html">Docs Oracle</a>
     * @see <a href="https://mkyong.com/java/java-display-double-in-2-decimal-points/">Example</a>
     * */
    @GetMapping("/api/animals/average-weight")
    public RespRequest averageWeightAnimals(){

        int   qtyCow = 0, qtyPig = 0, qtyChicken = 0;
        float subTotalCow = 0F, subTotalPig = 0F, subTotalChicken = 0F;
        float avgWeightCow = 0F, avgWeightPig = 0F, avgWeightChicken = 0F;

        for ( Animal animal: this.animals ) {
            switch (animal.getType()){
                case COW: subTotalCow += animal.getWeight(); qtyCow++;
                    break;
                case PIG: subTotalPig += animal.getWeight(); qtyPig++;
                    break;
                case CHICKEN: subTotalChicken += animal.getWeight(); qtyChicken++;
                    break;
                default: System.out.println("Unknown animal type");
                    break;
            }
        }
        /** DecimalFormat is a concrete subclass of NumberFormat that formats decimal numbers. It has a variety of
         * features designed to make it possible to parse and format numbers in any locale.
         * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/text/DecimalFormat.html">Docs Oracle</a>
         * @see <a href="https://mkyong.com/java/java-display-double-in-2-decimal-points/">Example</a>*/
        DecimalFormat df2 = new DecimalFormat("#.##");
        avgWeightCow     = Float.parseFloat( df2.format( (subTotalCow / qtyCow) ) );
        avgWeightPig     = Float.parseFloat( df2.format( (subTotalPig / qtyPig) ) );
        avgWeightChicken = Float.parseFloat( df2.format( (subTotalChicken / qtyChicken) ) );

        HashMap<String, Float> avg = new HashMap<>();
        avg.put("Cow", avgWeightCow);
        avg.put("Pig", avgWeightPig);
        avg.put("Chicken", avgWeightChicken);
        return new RespRequest(avg);
    }

    /**
     * Returns the quantity of animals available for sale. Omitting the "type" parameter, all the types of animals are
     * returned. To return only one type of animal, the following parameter must be added at the end of the
     * end-point: "?type=cow" or "?type=pig" or "?type=chicken".
     * @param type cow | pig | chicken This parameter select what animal should be searched.
     * @return RespRequest This returns an Object with a HashMap.
     * @exception BadRequestException On parameter not acceptable
     * @see ie.cct.ca2019206.utils.AnimalUtils AnimalUtils
     * @see ie.cct.ca2019206.enums.AnimalType AnimalType
     * @see ie.cct.ca2019206.enums.AnimalMinWeight AnimalMinWeight
     */
    @GetMapping("/api/animals/for-sale")
    public RespRequest animalsReadyToSell(@RequestParam(required = false, defaultValue = "all") String type){
        type = type.toUpperCase();
        System.out.println(type);

        if(type.equals("ALL")){
            return new RespRequest(AnimalUtils.qtyAllAnimalsToSell(this.animals));
        } else if( COW.toString().equals(type) || PIG.toString().equals(type) || CHICKEN.toString().equals(type) ){
            return new RespRequest(AnimalUtils.qtyAnimalToSell(this.animals, AnimalType.valueOf(type), AnimalMinWeight.valueOf(AnimalType.valueOf(type).toString())));
        } else {
            throw new BadRequestException("Parameters: 'cow', 'pig' and 'chicken'");
        }
    }

    /**
     * This end-point returns two values, "totalValue" and "totalValueToSell". "totalValue" tell us the total value of animals
     * on the farm, the second shows the stock value considering only the animals that have already reached the minimum
     * weight for sale.
     * @return RespRequest This returns an Object with a HashMap.
     * @see ie.cct.ca2019206.enums.AnimalValue AnimalValue
     * @see ie.cct.ca2019206.enums.AnimalMinWeight AnimalMinWeight
     * */
    @GetMapping("/api/animals/total-stock")
    public RespRequest totalValueStock(){
        double animalMarketValue;
        float minWeightToSell;
        double totalToSell = 0.0;
        double total = 0.0;
        for ( Animal animal: this.animals ) {

            animalMarketValue = AnimalValue.valueOf(animal.getType().toString()).get();
            minWeightToSell = AnimalMinWeight.valueOf(animal.getType().toString()). get();

            total += animalMarketValue;

            totalToSell += Float.compare(animal.getWeight(), minWeightToSell) >= 0 ? animalMarketValue : 0;
        }

        HashMap<String, Double> result = new HashMap<>();
        result.put("totalValueToSell", totalToSell);
        result.put("totalValue", total);

        return new RespRequest(result);
    }

    /**
     * Similar to the previous end-point, this feature accepts HTTP parameters request by changing the values ​​of each
     * animal to reflect a new stock value based on these parameters.
     * For example: "/animals/total-stock-simulation?cow=520" will return the stock value considering that cow has a value of 520.
     * It is possible to use up to 3 parameters.
     * Example: "/animals/total-stock-simulation?cow=520&pig=200&chicken=4". In this example the return will be the total
     * value of the stock considering the values ​​of each animal passed by the parameters "cow", "pig" and "chicken".
     * If one of the parameters is omitted or if no parameters are passed, the calculation will be based on the standard
     * market values ​​of each animal declared in the Enum class within the system. If a parameter is used correctly but
     * the value is not a valid double, a Bad Request code 400 error message will be returned from the API.
     * Parameters with wrong name are ignored, then the default market value is taken.
     * @param cowPrice A Double value to cow. Not required. Default value = "".
     * @param pigPrice A Double value to pig. Not required. Default value = "".
     * @param chickenPrice A double value to chicken. Not required. Default value = "".
     * @return RespRequest This returns an Object with a HashMap.
     * @see ie.cct.ca2019206.enums.AnimalValue AnimalValue
     * @see ie.cct.ca2019206.enums.AnimalMinWeight AnimalMinWeight
     * @see ie.cct.ca2019206.utils.AnimalUtils#validParametersDouble(String, Double) Check valid double numbers
     * */
    @GetMapping("/api/animals/total-stock-simulation")
    public RespRequest totalValueStockSimulation(
            @RequestParam(required = false, defaultValue = "", name = "cow") String cowPrice,
            @RequestParam(required = false, defaultValue = "", name = "pig") String pigPrice,
            @RequestParam(required = false, defaultValue = "", name = "chicken") String chickenPrice
    ){
        Double cowValue = 0.0, pigValue = 0.0, chickenValue = 0.0;

        float minWeightToSell;
        double totalToSell = 0.0;
        double total = 0.0;
        HashMap<String, Double> result = new HashMap<>();

        /** The method AnimalUtils.validParameterDouble(String parameter, Double defaultValue) is called.
         * This try to parse String to Double, if fail then it is not a valid Double and trows an exception
         * If the parameter is null, the DefaulValue is taken. */
        cowValue = AnimalUtils.validParametersDouble(cowPrice, AnimalValue.COW.get());
        pigValue = AnimalUtils.validParametersDouble(pigPrice, AnimalValue.PIG.get());
        chickenValue = AnimalUtils.validParametersDouble(chickenPrice, AnimalValue.CHICKEN.get());

        System.out.println(cowValue+" - "+pigValue+" - "+chickenValue);

        for ( Animal animal: this.animals ) {
            minWeightToSell = AnimalMinWeight.valueOf(animal.getType().toString()).get();
            if(animal.getType().equals(COW)){
                total += cowValue;
                totalToSell += Float.compare(animal.getWeight(), minWeightToSell) >= 0 ? cowValue : 0;
            } else if(animal.getType().equals(PIG)){
                total += pigValue;
                totalToSell += Float.compare(animal.getWeight(), minWeightToSell) >= 0 ? pigValue : 0;
            } else {
                total += chickenValue;
                totalToSell += Float.compare(animal.getWeight(), minWeightToSell) >= 0 ? chickenValue : 0;
            }

        }

        DecimalFormat df2 = new DecimalFormat("#.##");

        result.put("totalValueToSell", Double.parseDouble(df2.format(totalToSell)));
        result.put("totalValue", Double.parseDouble(df2.format(total)));

        return new RespRequest(result);
    }
}
