package app.beatsmith.dao.service;


import app.beatsmith.entity.db.UserEntity;
import app.beatsmith.entity.form.user.CheckUsernameForm;

public interface UserDAOService {

    /**
     * Diese Methode überprüft, ob der übergebene Benutzername in der {@link CheckUsernameForm} bereits in der Datenbank vergeben wurde.
     * <code>true</code> wenn der Benutzername noch nicht vergeben wurde.
     *
     * @param checkUsernameForm {@link CheckUsernameForm}
     * @return {@link Boolean}
     */
    public boolean isUsernameAvailable(CheckUsernameForm checkUsernameForm);

    /**
     * Validiert und speichert eine {@link UserEntity} in die Datenbank ab.
     *
     * @param userEntity {@link UserEntity}
     */
    public void saveUser(UserEntity userEntity);


}
