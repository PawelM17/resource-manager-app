package pl.gispartner.app.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class ErrorMessage {

    private Integer statusCode;
    private String message;
    private Long timeStamp;
}
