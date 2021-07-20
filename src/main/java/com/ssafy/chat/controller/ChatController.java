package com.ssafy.chat.controller;

import com.ssafy.chat.dto.ChatMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
public class ChatController {
    private final SimpMessageSendingOperations messagingTemplate;
    //SimpMessageSendingOperations -> 메세지를 도착지 까지 보내는것(스프링 프레임워크에 맞게)

    @MessageMapping("/chat/message")
    public void message(ChatMessage message) {
        if(ChatMessage.MessageType.ENTER.equals(message.getType())) {
            message.setMessage(message.getSender()+"님이 입장하셨습니다.");
        }
        messagingTemplate.convertAndSend("/sub/chat/room/"+message.getRoomId(),message);
        //convertAndSend -> 컨트롤러에서 Cassandra에서 정해진 시간마다 쿼리를 해 구독자들이 데이터를 가지고 갈 수 있도록
        //해당 토픽에 전송할 것.
    }
}
