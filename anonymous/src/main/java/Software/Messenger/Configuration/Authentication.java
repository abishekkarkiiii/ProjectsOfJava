package Software.Messenger.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;



public class Authentication implements AuthenticationProvider {
    @Autowired
    UserDetailsService userDetails;


    @Override
    public org.springframework.security.core.Authentication authenticate(org.springframework.security.core.Authentication authentication) throws AuthenticationException {
        UserDetails user=userDetails.loadUserByUsername(authentication.getName());
        System.out.println(user.getUsername());
        if(user.getUsername().equals(authentication.getName())&&authentication.getCredentials().equals(user.getPassword())){
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
