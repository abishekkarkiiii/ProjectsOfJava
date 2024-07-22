package Software.Messenger.Controller;

import Software.Messenger.Entity.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("messenger")
public class UserController {
    @Autowired
    UserAccount account;

    @PostMapping("create")
    public UserAccount createAccount(@RequestBody UserAccount userAccount){
        System.out.println(userAccount.getUsername());
         return userAccount;
    }
}
