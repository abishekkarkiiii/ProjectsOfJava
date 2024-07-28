package Software.Messenger.Controller;

import Software.Messenger.Entity.UserAccount;
import Software.Messenger.Model.ProfileModel;
import Software.Messenger.Model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("messenger")
public class UserController {

@Autowired
UserModel user;

@Autowired
    ProfileModel profileModel;
    @PostMapping("create")
    public UserAccount createAccount(@RequestBody UserAccount userAccount){
        System.out.println(userAccount.getUsername());
       user.create(userAccount);
        profileModel.createProfile(userAccount.getUsername());
         return userAccount;
    }


}
