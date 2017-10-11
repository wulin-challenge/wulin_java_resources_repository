package cn.wulin.spring.websocket.chat;

import org.springframework.http.server.ServerHttpRequest;  
import org.springframework.http.server.ServerHttpResponse;  
import org.springframework.http.server.ServletServerHttpRequest;  
import org.springframework.web.socket.WebSocketHandler;  
  
import javax.servlet.http.HttpServletRequest;  
import java.util.Map;  
  
public class HandshakeInterceptor implements org.springframework.web.socket.server.HandshakeInterceptor{  
    // 初次握手访问前  
    @Override  
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse serverHttpResponse,  
            WebSocketHandler webSocketHandler, Map<String, Object> map) throws Exception {  
        if (request instanceof ServletServerHttpRequest) {  
            HttpServletRequest servletRequest = ((ServletServerHttpRequest) request).getServletRequest();  
            String userName = "xq";  
            // 使用userName区分WebSocketHandler，以便定向发送消息  
            // String userName = (String)  
            // session.getAttribute("WEBSOCKET_USERNAME");  
            map.put("WEBSOCKET_USERNAME", userName);  
            servletRequest.getSession().setAttribute("WEBSOCKET_USERNAME", userName);  
        }  
        return true;  
    }  
  
    // 初次握手访问后  
    @Override  
    public void afterHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse,  
            WebSocketHandler webSocketHandler, Exception e) {  
  
    }  
}  
