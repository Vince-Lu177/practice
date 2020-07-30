package Vince.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Result {

    private boolean success;

    private String massage;

    private String stackTrace;

    private Object data;

}
