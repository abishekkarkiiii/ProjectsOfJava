package Software.Messenger.Repositry;

import Software.Messenger.Entity.Profile;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProfileRepo extends MongoRepository<Profile, ObjectId> {

}
