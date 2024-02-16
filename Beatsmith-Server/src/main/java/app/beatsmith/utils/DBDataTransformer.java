package app.beatsmith.utils;

import app.beatsmith.entity.db.UserEntity;
import app.beatsmith.entity.form.user.SignUpForm;

public class DBDataTransformer {
    public static UserEntity signUpFormToUserEntity(SignUpForm signUpForm) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(signUpForm.getUsername());
        userEntity.setEmail(signUpForm.getEmail());
        userEntity.setName(signUpForm.getName());
        userEntity.setLastname(signUpForm.getLastname());
        userEntity.setBirthdate(signUpForm.getBirthDate());
        userEntity.setEulaAccepted(signUpForm.isEulaAccepted());
        userEntity.setImageUrl(signUpForm.getImageUrl());
        return userEntity;
    }
}
