package app.beatsmith.entity.db;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "user_tbl")
public class UserEntity {
    @Id
    @GeneratedValue
    @Column(name = "uuid", updatable = false, nullable = false, unique = true)
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Column(name = "email", unique = true, nullable = false)

    private String email;

    @Column(name = "name", nullable = false)

    private String name;

    @Column(name = "lastname", nullable = false)

    private String lastname;

    @Column(name = "birthdate", nullable = false)

    private Date birthdate;

    @Column(name = "eula", nullable = false)

    private boolean eulaAccepted;

    @Column(name = "password", nullable = false)

    private String password;

    @Column(name = "imageUrl")

    private String imageUrl;

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

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public boolean isEulaAccepted() {
        return eulaAccepted;
    }

    public void setEulaAccepted(boolean eulaAccepted) {
        this.eulaAccepted = eulaAccepted;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
