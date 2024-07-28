package Software.Messenger.Controller;

import Software.Messenger.Entity.Profile;
import Software.Messenger.Entity.FriendRequest;
import Software.Messenger.Entity.UserAccount;
import Software.Messenger.Model.ProfileModel;
import Software.Messenger.Model.UserModel;
import Software.Messenger.Repositry.UserAccountRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("profile")
public class ProfileController {
    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;
    @Autowired
    ProfileModel profileModel;
    @Autowired
    UserAccountRepo userAccountRepo;
     @PostMapping
     public List< Profile> Attacher( @RequestBody FriendRequest friendRequest){
     return profileModel.getAllProfile(userAccountRepo.findByobjectId(new ObjectId(friendRequest.getUserId())));
    }

@PostMapping("getcurrentprofile")
public String profile(@RequestBody FriendRequest currentuserId){
         return userAccountRepo.findByobjectId(new ObjectId(currentuserId.getUserId())).getProfile().getUserId();
}

    @MessageMapping("/profile/add_friend")
    public void request(FriendRequest request){
        System.out.println(request);
        Profile userProfile=profileModel.profileFinder(new ObjectId(request.getUserId()));
        profileModel.requestadd(request.getUserId(), request.getUserprofileId());
        simpMessagingTemplate.convertAndSend("/chat/"+request.getUserprofileId(),userProfile);
    }
}
