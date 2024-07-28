package Software.Messenger.Configuration;

import Software.Messenger.Controller.MainController;
import Software.Messenger.Controller.UserController;
import Software.Messenger.Entity.Message;
import Software.Messenger.Entity.UserAccount;
import Software.Messenger.Model.ChatModel;
import Software.Messenger.Model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


public class Authentication implements AuthenticationProvider {
    @Autowired
    UserDetailsService userDetails;
    @Autowired
    ChatModel message;
    PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
    @Override
    public org.springframework.security.core.Authentication authenticate(org.springframework.security.core.Authentication authentication) throws AuthenticationException {
        UserDetails user=userDetails.loadUserByUsername(authentication.getName());
        if(passwordEncoder.matches((String)authentication.getCredentials(),user.getPassword())){
            message.setUsername(user.getUsername());
            return new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword(),user.getAuthorities());
        }else{
            throw new BadCredentialsException("username or password wrong");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
         return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
