package Software.Messenger.Repositry;

import Software.Messenger.Entity.Message;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface MessageRepo extends MongoRepository <Message, ObjectId>{
    List<Message> findByfriendcode(String friendcode);

}
