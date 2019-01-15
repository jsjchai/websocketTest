package server;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 * @author jsjchai
 */
@ServerEndpoint(value = "/hello")
public class WebsocketServer {

    @OnMessage
    public String sayHello(String incomingMessage) {
        return "I got this(" + incomingMessage + ") so I am sending it back to you!";
    }

    @OnOpen
    public void open(Session session) {
        System.out.println("On Open---" + session.getId());
    }

    @OnClose
    public void close() {
        System.out.println("Close.");
    }
}
