package cm.skysoft.Care_Health.Exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;


@NoArgsConstructor
public class NonValidEntity extends Exception {
    private Integer code;
    private List<String> errorMessageList;

    public NonValidEntity(String message, Integer code, List<String> errorMessageList) {
        super(message);
        this.code = code;
        this.errorMessageList = errorMessageList;
    }
}
