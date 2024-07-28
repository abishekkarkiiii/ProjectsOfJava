package Software.Messenger.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAccount {
    @Indexed(unique = true)
    @NonNull
    private String username;
    @NonNull
    private String password;
    @Id
    private ObjectId objectId;
    @DBRef
    Profile profile;

}
