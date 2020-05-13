/**
 * Class responsible for showing a message after an animal is created though a Post to the end-point /animal
 * @since   2020-05-12
 * */
package ie.cct.ca2019206.Helpers;

public class RespSuccess {
    private String message;

    /**
     * Constructor
     * @param message String*/
    public RespSuccess(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
