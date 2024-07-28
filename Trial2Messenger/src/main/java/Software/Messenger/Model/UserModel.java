package Software.Messenger.Model;

import Software.Messenger.Entity.UserAccount;
import Software.Messenger.Repositry.UserAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserModel {
    @Autowired
    UserAccount userAccount;
    @Autowired
    UserAccountRepo AccountRepo;

    private String passwordconverter(String password){
        return new BCryptPasswordEncoder().encode(password);
    }
    public UserAccount create(UserAccount user)
    {
        user.setPassword(passwordconverter(user.getPassword()));
        return AccountRepo.save(user);
    }

       public UserAccount checker(String user){
       return  AccountRepo.findByusername(user);
    }


    public void delete(UserAccount user){
        AccountRepo.delete(user);
    }


}
