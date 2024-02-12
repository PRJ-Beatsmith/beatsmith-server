package app.beatsmith.entity.form.user;

import app.beatsmith.utils.Sanitizer;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class SignUpForm {
    @NotNull
    @Size(min = 2, max = 30)
    private String username;

    @NotNull
    @Email
    private String email;
    @NotNull
    @Size(min = 2, max = 30)
    private String fullname;
    private String imageUrl;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = Sanitizer.cleanIt(email);;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = Sanitizer.cleanIt(fullname);
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = Sanitizer.cleanIt(imageUrl);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = Sanitizer.cleanIt(username);
    }
}
