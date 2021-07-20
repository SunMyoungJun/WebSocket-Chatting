package com.ssafy.chat.websocket;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.*;

@RequiredArgsConstructor
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    private final WebSocketHandler webSocketHandler;

    @Override
    //요청이 오면 그에 해당하는 통신 채널로 전송, 응답 또한 같은 경로로 가서 응답한다.
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/sub"); //메세지 응답 prefix
        registry.setApplicationDestinationPrefixes("/pub"); // 클라이언트에서 메세지 송신 시 붙여줄 prefix
    }


    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) { //최초 소켓 연결 시 endpoint 설정
        registry.addEndpoint("/ws-stomp").setAllowedOrigins("*") // javascript에서 SockJS생성자를 통해 연결
                .withSockJS();
    }
}
