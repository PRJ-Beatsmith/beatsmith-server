package app.beatsmith.servicer;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import app.beatsmith.entity.auth.Permission;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserManagementService {

    private final FirebaseAuth firebaseAuth;

    public void setUserClaims(String uid, List<Permission> requestedPermissions) throws FirebaseAuthException, FirebaseAuthException {
        List<String> permissions = new ArrayList<>();
        for (Permission permission : requestedPermissions) {
            permissions.add(permission.toString());
        }

        Map<String, Object> claims = Map.of("custom_claims", permissions);

        firebaseAuth.setCustomUserClaims(uid, claims);
    }
}