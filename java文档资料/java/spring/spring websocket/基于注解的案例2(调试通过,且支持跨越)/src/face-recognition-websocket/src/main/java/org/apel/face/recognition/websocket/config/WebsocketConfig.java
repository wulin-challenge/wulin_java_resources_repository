package org.apel.face.recognition.websocket.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration  
@EnableWebMvc  
@EnableWebSocket  
public class WebsocketConfig extends WebMvcConfigurerAdapter implements WebSocketConfigurer{

	@Autowired
	private WebSocketHandler reallyWebSocketHander;
	
	@Autowired
	private HandshakeInterceptor handshakeInterceptor;
	
	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(reallyWebSocketHander, "/echo")
		.addInterceptors(handshakeInterceptor)
		.setAllowedOrigins("*");
	}

}
