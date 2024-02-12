package app.beatsmith.entity.response;

import org.springframework.http.HttpStatus;

public abstract class BaseResponse {

    private final HttpStatus httpStatus;
    private String message;

    public BaseResponse(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public int getHttpStatusCode() {
        return this.httpStatus.value();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
