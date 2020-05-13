/**
 * This class extend RuntimeException to be used as a response from API when some request is wrong or mal formed.
 * */

package ie.cct.ca2019206.utils;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException{

    /**
     * Constructor
     * @param msg String*/
    public BadRequestException(String msg) {
        super(msg);
    }
}
