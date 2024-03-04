package app.beatsmith.server.routes.admin;

import app.beatsmith.entity.auth.Permission;
import app.beatsmith.servicer.UserManagementService;
import com.google.firebase.auth.FirebaseAuthException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final UserManagementService userManagementService;

    @PostMapping(path = "/user-claims/{uid}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void setUserClaims(
            @PathVariable String uid,
            @RequestBody List<Permission> requestedClaims
    ) throws FirebaseAuthException {
        userManagementService.setUserClaims(uid, requestedClaims);
    }

}
