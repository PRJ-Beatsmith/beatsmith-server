package app.beatsmith.entity.response.error;

import app.beatsmith.entity.CONSTANTS_TEXTS;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.List;

public class FormErrorResponse extends ErrorResponse {
    private List<String> errorTags;

    public FormErrorResponse(BindingResult bindingResult) {
        setMessage(CONSTANTS_TEXTS.BAD_FORMDATA_REQUEST_TEXT);
        parseBindingResult(bindingResult);
    }

    public List<String> getErrorTags() {
        return errorTags;
    }

    public void setErrorTags(List<String> errorTags) {
        this.errorTags = errorTags;
    }

    private void parseBindingResult(BindingResult bindingResult) {
        List<ObjectError> objectErrorList = bindingResult.getAllErrors();
        for (ObjectError objectError : objectErrorList) {
            errorTags.add(objectError.getObjectName());
        }
    }
}
