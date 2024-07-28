package Software.Messenger.Repositry;

import Software.Messenger.Entity.UserAccount;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserAccountRepo extends MongoRepository<UserAccount, ObjectId> {
    UserAccount findByusername(String username);
    UserAccount findByobjectId(ObjectId id);
}
