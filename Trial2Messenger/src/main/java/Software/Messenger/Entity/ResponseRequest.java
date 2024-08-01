package Software.Messenger.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseRequest {
    private String username;
    private String userId;
    private String ReceiverUserId;

}
