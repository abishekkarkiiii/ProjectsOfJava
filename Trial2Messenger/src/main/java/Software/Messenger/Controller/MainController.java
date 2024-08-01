package Software.Messenger.Controller;

import Software.Messenger.Entity.*;
import Software.Messenger.Model.ChatModel;
import Software.Messenger.Model.ProfileModel;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@RestController
@RequestMapping("app")
public class MainController {

    @Autowired
    ProfileModel profileModel;
    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;
    @Autowired
    ChatModel chatModel;
    private String username;
    @MessageMapping("/app")
    public Message message(Message message) {
        Profile profile=profileModel.profileFinder(new ObjectId(message.getMessageId())) ;
        System.out.println();
        if(message.getSender()==null){
           message.setSender(profile.getUsername());//1
        }
        chatModel.messagesSave(message);
        System.out.println(message);
        simpMessagingTemplate.convertAndSend("/chat/"+chatModel.usercode(profile,profileModel.profileFinder(new ObjectId(message.getAddress()))).get(),message);
        simpMessagingTemplate.convertAndSend("/chat/"+profile.getUserId(),message);
        return message;
    }

    @GetMapping
    public Message idsetter() {
        Message message = new Message();//2
        message.setMessageId(chatModel.Idgiver().toString());
        return message;
    }

    @MessageMapping("/file")// for image
    @SendTo("/chat/chat")
    public MessageDetails file(MessageDetails file){
        String imgdata=file.getContent();
        Message message=new Message();
        message.setContent(imgdata);
        chatModel.messagesSave(message);
        return file;
    }

    @PostMapping("allmessage")
    public List <Message> getall(@RequestBody ResponseRequest request){

       return chatModel.getMessage(chatModel.usercode(profileModel.profileFinder(new ObjectId(request.getUserId())),profileModel.profileFinder(new ObjectId(request.getReceiverUserId()))).get());
    }


    @PostMapping("/getChatendPoint")
    public String getEndpointForMesage(@RequestBody ResponseRequest request){
        System.out.println(request);
       return chatModel.usercode(profileModel.profileFinder(new ObjectId(request.getUserId())),profileModel.profileFinder(new ObjectId(request.getReceiverUserId()))).get();
    }






}
