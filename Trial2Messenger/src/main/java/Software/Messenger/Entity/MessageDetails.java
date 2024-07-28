package Software.Messenger.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Data
@NoArgsConstructor
public class MessageDetails {
    private String content;
}
