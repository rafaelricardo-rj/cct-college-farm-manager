package ie.cct.ca2019206.enums;

public enum AnimalMinWeight {
    /**
     * After learning about Enum in classroom I have decided to study in depth the subject and apply this to the project.
     * This Enum hold some constants about weight value for each animal.
     * @see <a href="https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html">Enum - Oracle Documentation</a>
     * @since   2020-05-12
     * */
    COW(300.0f),
    PIG(100.0f),
    CHICKEN(0.5f);

    private final float value;

    /**
     * Constructor
     * */
    AnimalMinWeight(float value) {
        this.value = value;
    }

    /** Method to get the constant value by the type. Eg. AnimalMinWeight.valueOf("COW").get()
     * @return AnimalMinWeight */
    public float get() {
        return this.value;
    }
}
