package client;

import javax.websocket.ClientEndpoint;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;



/**
 * @author jsjchai
 */
@ClientEndpoint
public class WebSocketClient {

    private String message;

    @OnOpen
    public void onOpen(Session session) {
        System.out.printf("client open id:%s,status:%s",session.getId(),session.isOpen());
        System.out.println();
    }

    @OnMessage
    public void onMessage(String message) {

        this.message = message;

        System.out.printf("client onMessage mes:%s",message);
        System.out.println();

    }

    @OnClose
    public void onClose(Session session) {
        System.out.printf("client close id:%s,status:%s",session.getId(),session.isOpen());
        System.out.println();
    }

    @OnError
    public void onError(Throwable e){
       e.printStackTrace();
    }

    public String getMessage() {
        return message;
    }

}
