package Software.Messenger.Configuration;

import Software.Messenger.Entity.UserAccount;
import Software.Messenger.Model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static org.springframework.security.core.userdetails.User.withUsername;
@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
    @Autowired
    UserModel model;
    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAccount userAccount=model.checker(username);
        if(userAccount!=null){
            org.springframework.security.core.userdetails.User.UserBuilder builder=withUsername(username);
            builder.password(userAccount.getPassword());
            builder.roles("USER");
            return builder.build();
        }else{
            return null;
        }

    }
}
