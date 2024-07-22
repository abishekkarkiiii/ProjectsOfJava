package Software.Messenger.Entity;

import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class UserAccount {
    private String username;
    private String password;
}
