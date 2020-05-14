package ie.cct.ca2019206.enums;

public enum AnimalType {
    /**
     * After learning about Enum in classroom I have decided to study in depth the subject and apply this to the project.
     * This Enum hold the types of animal available.
     * @see <a href="https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html">Enum - Oracle Documentation</a>
     * @since   2020-05-12
     * */
    COW,
    PIG,
    CHICKEN;

    /**
     * This method test if there is some animal in the enum. Return false if not exist.
     * @param animal String
     * @return Boolean */
    public static boolean has(String animal) {
        try {
            return AnimalType.valueOf(animal) != null;
        } catch (Exception e) {
            return false;
        }
    }

}