package app.beatsmith.entity.form.user;

import app.beatsmith.utils.Sanitizer;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CheckUsernameForm {
    @NotNull
    @Size(min = 2, max = 30)
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = Sanitizer.cleanIt(username);
    }
}
