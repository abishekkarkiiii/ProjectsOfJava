package Software.Messenger.Entity;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "profile")
@Data
public class Profile {
    private  String username;
    private String bio;
    @Id
    private ObjectId id;
    private String  userId;
    private List<String> RequestList=new ArrayList<>();

}
