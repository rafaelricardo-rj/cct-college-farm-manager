/**
 * This class receive a HasMap in the constructor and allow access to the HasMap through the get method.
 * Actually this class was created only for tests as I wanted only one type of return for the endpoints.
 * Using this class as return I could add HashMaps<String, Float>,HashMaps<String, Double>, HashMaps<String, String> and
 * keeping the same return of the method. Eg: public RespRequest calcTotalStock() or public RespRequest calcAverageWeight().
 * It was not necessary but I wanted to test it.
 * @since   2020-05-12
 * */

package ie.cct.ca2019206.Helpers;

import java.util.HashMap;

final public class RespRequest {

    private HashMap response;

    /**
     * Constructor
     * @param list HashMap*/
    public RespRequest(HashMap list) {
        this.response = list;
    }

    public HashMap getResponse() { return response;    }

    public void setResponse(HashMap response) {
        this.response = response;
    }
}
