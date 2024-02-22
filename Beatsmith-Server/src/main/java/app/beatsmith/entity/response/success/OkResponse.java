package app.beatsmith.entity.response.success;

import app.beatsmith.entity.response.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.OK)
public class OkResponse extends BaseResponse {

    public static final String OK = "OK";

    public OkResponse() {
        super(HttpStatus.OK);
        setMessage(OK);
    }
}
