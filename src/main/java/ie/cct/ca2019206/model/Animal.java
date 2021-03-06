/** This class represent an animal that can be 'cow', 'pig' or 'chicken'
 * @author  Rafael Ricardo - Student number: 2019206
 * @since   2020-05-12
 * */
package ie.cct.ca2019206.model;

import ie.cct.ca2019206.enums.AnimalType;
import ie.cct.ca2019206.enums.AnimalValue;
import ie.cct.ca2019206.utils.BadRequestException;
import ie.cct.ca2019206.utils.SingletonIdAnimalCounter;

final public class Animal {
    private int id = 0;
    private AnimalType type = null;
    private float weight = 0f;
    private double value = 0;

    /**
     * Constructor without parameters. This constructor is called when a new animal is created through http Post method.
     * An Id is generated by the singleton replacing the database column with id increment function as the application
     * does not work with a database
     * @see ie.cct.ca2019206.utils.SingletonIdAnimalCounter Singleton to generate Id.*/
    public Animal() {
        super();
        this.id = SingletonIdAnimalCounter.getInstance().incrementIdAnimal();
    }

    /**
     * Second constructor with three parameters. This constructor is used when this class is instanced by methods in the system.
     * For example, the method ie.cct.ca2019206.scaffold.LoadAnimals#create() invoke this constructor.
     * @param type Receive AnimalType
     * @param weight Get a float value about the weight of the animal
     * @param value  Get a double value about the price of the animal
     * @deprecated This constructor will be removed due 'this.value' attribute is now filled automatically. */
    public Animal(AnimalType type, float weight, double value) {
        super();

        this.id = SingletonIdAnimalCounter.getInstance().incrementIdAnimal();
        this.type = type;
        this.weight = weight;
        this.value = value;
    }

    /**
     * Third constructor with two parameters. This constructor is used when this class is instanced by methods in the system.
     * For example, the method ie.cct.ca2019206.scaffold.LoadAnimals#create() invoke this constructor.
     * An Id is generated by the singleton and the value is generated automatically depending on the type of the animal.
     * @param type Receive AnimalType
     * @param weight Get a float value about the weight of the animal
     * */
    public Animal(AnimalType type, float weight) {
        super();

        this.id = SingletonIdAnimalCounter.getInstance().incrementIdAnimal();
        this.type = type;
        this.weight = weight;
        this.value = AnimalValue.valueOf(type.toString().toUpperCase()).get();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AnimalType getType() {
        return type;
    }

    /**
     * I created this validation because I don't know yet how to validate the AnimalType in the end-point
     * \@PostMapping("/api/animals") before Spring convert the json object into Animal object, then I could throw an
     * BadRequestReception in the controller if someone try to post "COw instead of COW or other word that
     * is not in the Enum AnimalType. This is a workaround. */
    public void setType(String type)  {
        if(AnimalType.has(type.toUpperCase())){
            this.type = AnimalType.valueOf(type.toUpperCase());
        } else {
            throw new BadRequestException("Wrong animal type. Types accepted: COW | PIG | CHICKEN");
        }
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
