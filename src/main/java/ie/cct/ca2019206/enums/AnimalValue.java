package ie.cct.ca2019206.enums;

public enum AnimalValue {
    /**
     * After learning about Enum in classroom I have decided to study in depth the subject and apply this to the project.
     * This Enum hold some constants about the market value for each animal.
     * @see <a href="https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html">Enum - Oracle Documentation</a>
     * @since   2020-05-12
     * */
    COW(500.0),
    PIG(250.0),
    CHICKEN(5);

    private final double value;

    AnimalValue(double value) {
        this.value = value;
    }

    /** Method to get the constant value by the type. Eg. AnimalValue.valueOf("COW").get()
     * @return AnimalValue */
    public double get() {
        return this.value;
    }
}
