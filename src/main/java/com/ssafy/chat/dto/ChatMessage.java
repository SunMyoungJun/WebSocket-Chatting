package com.ssafy.chat.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatMessage {
    public enum MessageType { // 메세지 타입 : 입장, 채팅
        ENTER, TALK
    }

    private MessageType type; // 메세지 타입
    private String roomId; //방번호
    private String sender; //메세지 보낸사람
    private String message; //메세지


//    public MessageType getType() {
//        return type;
//    }
//
//    public String getRoomId() {
//        return roomId;
//    }
//    public String getSender() {
//        return sender;
//    }
//    public String getMessage(){
//        return message;
//    }
//
//    public void setType(MessageType type) {
//        this.type = type;
//    }
//    public void setMessage(String message) {
//        this.message = message;
//    }
//    public void setRoomId(String roomId){
//        this.roomId = roomId;
//    }
//    public void setSender(String sender){
//        this.sender = sender;
//    }
}
