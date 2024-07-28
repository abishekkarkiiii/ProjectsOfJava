package Software.Messenger.Controller;

import Software.Messenger.Entity.Message;
import Software.Messenger.Entity.MessageDetails;
import Software.Messenger.Entity.Profile;
import Software.Messenger.Entity.UserAccount;
import Software.Messenger.Model.ChatModel;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Component
@RestController
@RequestMapping("app")
public class MainController {

    @Autowired
    ChatModel chatModel;
    private String username;
    @MessageMapping("/app")
    @SendTo("/chat/chat")
    public Message message(Message message) {
        if(message.getSender()==null){
            message.setSender(chatModel.usernamefinder(new ObjectId(message.getMessageId())));
        }
        chatModel.messagesSave(message);
        return message;
    }

    @GetMapping
    public Message idsetter() {
        Message message = new Message();
        message.setMessageId(chatModel.Idgiver().toString());
        return message;
    }

    @MessageMapping("/file")
    @SendTo("/chat/chat")
    public MessageDetails file(MessageDetails file){
        String imgdata=file.getContent();
        Message message=new Message();
        message.setContent(imgdata);
        chatModel.messagesSave(message);
        return file;
    }

    @GetMapping("allmessage")
    public List <Message> getall(){
       return chatModel.getMessage();
    }


}
