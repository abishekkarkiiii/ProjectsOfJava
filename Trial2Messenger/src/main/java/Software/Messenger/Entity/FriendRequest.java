package Software.Messenger.Entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.List;

@Data
public class FriendRequest {
   private String userprofileId;//paune(receiver)
   private String userId;//pathaune(sender)


}
