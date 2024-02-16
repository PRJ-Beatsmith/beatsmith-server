package app.beatsmith.entity.form.user;

import app.beatsmith.annotations.ValidPassword;
import app.beatsmith.utils.Sanitizer;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class SignUpForm {
    @NotNull
    @Size(min = 2, max = 30)
    private String username;

    @NotNull
    @Email
    private String email;
    @NotNull
    @Size(min = 2, max = 30)
    private String name;

    @NotNull
    @Size(min = 2, max = 30)
    private String lastname;

    @NotNull
    @DateTimeFormat(pattern="dd.MM.yyyy")
    private Date birthDate;
    private String imageUrl;

    @NotNull
    @ValidPassword
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEulaAccepted() {
        return eulaAccepted;
    }

    public void setEulaAccepted(boolean eulaAccepted) {
        this.eulaAccepted = eulaAccepted;
    }

    @NotNull
    private boolean eulaAccepted;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = Sanitizer.cleanIt(email);;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
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
