package Software.Messenger.Model;

import Software.Messenger.Entity.Message;
import Software.Messenger.Entity.Profile;
import Software.Messenger.Entity.UserAccount;
import Software.Messenger.Repositry.MessageRepo;
import Software.Messenger.Repositry.UserAccountRepo;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@Component
@NoArgsConstructor
public class ChatModel {
private String username;
@Autowired
UserAccountRepo userrepo;
@Autowired
    MessageRepo messageRepo;

     private UserAccount user(){
         System.out.println("hello");
        return userrepo.findByusername(username);
    }

    public ObjectId Idgiver(){
         return user().getObjectId();
    }


    public String usernamefinder(ObjectId id){
         return userrepo.findByobjectId(id).getUsername();
     }

     public Message messagesSave(Message message){
         return messageRepo.save(message);
     }

     public List<Message> getMessage(){
         return messageRepo.findAll();
     }


}
