package app.beatsmith.entity.response.error;

import app.beatsmith.entity.response.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ErrorResponse extends BaseResponse {
    private Integer errorCode;

    public ErrorResponse() {
        super(HttpStatus.BAD_REQUEST);
    }

    public ErrorResponse(Exception exception) {
        super(HttpStatus.INTERNAL_SERVER_ERROR);
        setMessage(exception.getMessage());
        setErrorCode(exception.hashCode());
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
}
