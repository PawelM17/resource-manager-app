package pl.gispartner.ResourceManagerApp.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ErrorObject {

    private Integer statusCode;
    private String message;
    private Long timeStamp;

}
