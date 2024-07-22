package Software.Messenger.Configuration;

import Software.Messenger.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static org.springframework.security.core.userdetails.User.withUsername;
@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
    @Autowired
    User user;
    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        org.springframework.security.core.userdetails.User.UserBuilder builder=withUsername(username);
        builder.password(user.getPassword());
        builder.roles("USER");
        return builder.build();
    }
}
