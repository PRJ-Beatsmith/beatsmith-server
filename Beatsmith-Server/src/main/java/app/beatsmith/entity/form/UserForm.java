package app.beatsmith.entity.form;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserForm {
    @NotNull
    @Size(min=2, max=30)
    private String username;

    public void setUsername(String username) {
        this.username = username;
    }
}
