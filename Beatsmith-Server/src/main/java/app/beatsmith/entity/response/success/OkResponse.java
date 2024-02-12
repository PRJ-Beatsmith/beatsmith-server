package app.beatsmith.entity.response.success;

import app.beatsmith.entity.response.BaseResponse;
import org.springframework.http.HttpStatus;

public class OkResponse extends BaseResponse {

    public static final String OK = "OK";

    public OkResponse() {
        super(HttpStatus.OK);
        setMessage(OK);
    }
}
