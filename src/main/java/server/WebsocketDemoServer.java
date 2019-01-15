package server;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 * @author jsjchai
 */
@ServerEndpoint(value = "/demo/{requestId}")
public class WebsocketDemoServer {



    @OnMessage
    public void onMessage(String message,Session session) {
        System.out.println(message.length());

        try {
            session.getBasicRemote().sendText("ok");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @OnOpen
    public void open(@PathParam(value="requestId") String requestId,Session session) {
        System.out.println(requestId);
        System.out.println("On Open---" + session.getId());
    }

    @OnClose
    public void close() {
        System.out.println("Close.");
    }




}
