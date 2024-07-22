package Software.Messenger.Controller;

import Software.Messenger.Entity.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("app")
public class MainController {
    @MessageMapping("/app")//response
    @SendTo("/chat/chat")
    Message message(Message message){
        System.out.println(message);
        return message;
    }

}
