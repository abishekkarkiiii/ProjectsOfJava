package Software.Messenger.Model;

import Software.Messenger.Entity.Profile;
import Software.Messenger.Repositry.ProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class RequestModel {
    @Autowired
    ProfileRepo profileRepo;
    public void friendRequest(Profile user, Profile sender) {
        if(!user.getFriendList().contains(sender.getUserId())){
          String friendcode=  new BCryptPasswordEncoder().encode(user.getUserId()+sender.getUserId());
            user.getFriendcode().add(friendcode);
            sender.getFriendcode().add(friendcode);
            user.getFriendList().add(sender.getUserId());
            sender.getFriendList().add(user.getUserId());
            user.getRequestList().removeIf(id -> id.equals(sender.getUserId()));
            sender.getRequestList().removeIf(id -> id.equals(user.getUserId()));
            profileRepo.save(user);
            profileRepo.save(sender);
        }else{
            System.out.println("sorry already exist");
        }

    }



}
