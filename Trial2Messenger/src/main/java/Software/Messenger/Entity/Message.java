package Software.Messenger.Entity;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Component
@Data
@Document(collection = "messages")
public class Message {
    private String content;
    private String sender;
    private String messageId;
}
