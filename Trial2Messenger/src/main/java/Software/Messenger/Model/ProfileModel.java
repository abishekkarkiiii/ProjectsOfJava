package Software.Messenger.Model;

import Software.Messenger.Entity.Profile;
import Software.Messenger.Entity.UserAccount;
import Software.Messenger.Repositry.ProfileRepo;
import Software.Messenger.Repositry.UserAccountRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ProfileModel {
    @Autowired
    ProfileRepo profileRepo;
    @Autowired
    UserAccountRepo userAccountRepo;

    @Autowired
    SimpMessagingTemplate messagingTemplate;
    private  Profile saveprofile(Profile profile){
       return profileRepo.save(profile);
    }

    public void createProfile(String username){
        Profile profile=new Profile();
        profile.setUsername(username);
         Profile VirtualProfile= saveprofile(profile);
         deleteProfile(VirtualProfile);
         VirtualProfile.setUserId(VirtualProfile.getId().toString());
        VirtualProfile.setUserId(profile.getId().toString());
        profileRepo.save(VirtualProfile);
        UserAccount VirtualUser= userAccountRepo.findByusername(profile.getUsername());
        userAccountRepo.delete(VirtualUser);
        VirtualUser.setProfile(profile);
        userAccountRepo.save(VirtualUser);


    }

    public List<Profile> getAllProfile(UserAccount userAccount){
        List< Profile> profiles=profileRepo.findAll();
        return profiles;
    }
    public void deleteProfile(Profile profile){
        profileRepo.delete(profile);

    }

    public Profile profileFinder(ObjectId objectId) {
        Optional<Profile> optionalProfile = profileRepo.findById(objectId);
        return optionalProfile.orElse(null);
    }

    public void requestadd(String sender,String receiver){
        Profile receiverprofile=profileFinder(new ObjectId(receiver));
        receiverprofile.getRequestList().add(sender);
        profileRepo.save(receiverprofile);
    }


}
