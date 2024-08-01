package Software.Messenger.Controller;

import Software.Messenger.Entity.Profile;
import Software.Messenger.Entity.FriendRequest;
import Software.Messenger.Entity.ResponseRequest;
import Software.Messenger.Model.ProfileModel;
import Software.Messenger.Model.RequestModel;
import Software.Messenger.Model.UserModel;

import Software.Messenger.Repositry.ProfileRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("profile")
public class ProfileController {
    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;
    @Autowired
    ProfileModel profileModel;
    @Autowired
    UserModel userModel;

     @PostMapping
     public List< Profile> Attacher( @RequestBody FriendRequest friendRequest){

     return profileModel.getAllProfile(userModel.finduserAccount(new ObjectId(friendRequest.getUserId())));
    }

    @Autowired
    RequestModel requestModel;

@PostMapping("getcurrentprofile")
public String profile(@RequestBody FriendRequest currentuserId){
    System.out.println(currentuserId.getUserId());
         return userModel.finduserAccount(new ObjectId(currentuserId.getUserId())).getProfile().getUserId();
}

    @MessageMapping("/profile/add_friend")
    public void request(FriendRequest request){
        Profile userProfile=profileModel.profileFinder(new ObjectId(request.getUserId()));
        if(profileModel.requestadd(request.getUserId(),request.getUserprofileId()))
        simpMessagingTemplate.convertAndSend("/chat/"+request.getUserprofileId(),userProfile);
    }


    @PostMapping("/getFriendRequest")
    public List<Profile> requessearcher(@RequestBody List<String> requestList) {
        System.out.println(requestList);
        List<Profile> virtualprofile = new ArrayList<>();
        // Simulate fetching profiles based on requestList (user IDs)
        for (String userId : requestList) {
            Profile profile = profileModel.profileFinder(new ObjectId(userId));
            profile.setUsername(profile.getUsername());
           profile.setRequestList(profile.getRequestList().stream().map(x->{
              return  x="";
            }).collect(Collectors.toList()));
            virtualprofile.add(profile);
        }

        return virtualprofile;
    }


    @PostMapping("/accept")
    public void  requestAccept(@RequestBody FriendRequest request) {
        Profile requestSender = profileModel.profileFinder(new ObjectId(request.getUserId()));
        Profile requestReceiver = profileModel.profileFinder(new ObjectId(request.getUserprofileId()));
        requestModel.friendRequest(requestReceiver, requestSender);
    }


    @PostMapping("friendlist")
    public List<ResponseRequest>friendlistsearcher(@RequestBody FriendRequest request)
    {
        List<ResponseRequest>responseRequests=new ArrayList<>();
        System.out.println("debug1");
      List<String>friendlist= profileModel.profileFinder(new ObjectId(request.getUserId())).getFriendList();
        System.out.println("debug2");
        for (String s : friendlist) {
            ResponseRequest virtualResponse=new ResponseRequest();
            virtualResponse.setUsername( profileModel.profileFinder(new ObjectId(s)).getUsername());
            virtualResponse.setUserId( profileModel.profileFinder(new ObjectId(s)).getUserId());
            responseRequests.add(virtualResponse);
        }
        return  responseRequests;
    }




}
