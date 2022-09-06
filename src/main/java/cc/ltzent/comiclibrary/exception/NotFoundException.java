package cc.ltzent.comiclibrary.exception;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class NotFoundException extends RuntimeException {

    public NotFoundException(String message) {
        super(message);
    }
}
