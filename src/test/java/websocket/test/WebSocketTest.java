package websocket.test;

import client.WebSocketClient;
import javafx.beans.binding.StringBinding;
import org.junit.Test;
import util.ZipUtil;

import javax.websocket.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author jsjchai.
 */
public class WebSocketTest {

    private static WebSocketContainer container = ContainerProvider.getWebSocketContainer();

    @Test
    public void testWebSocket() throws URISyntaxException, IOException, DeploymentException {

        WebSocketClient client = new WebSocketClient();

        Session session = container.connectToServer(client, new URI("ws://127.0.0.1:18888/demo/"+System.currentTimeMillis()));
        session.setMaxIdleTimeout(30000);


        //session.addMessageHandler(MessageHandler);

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < 200000 ; i++) {
            builder.append("hello");
        }

        session.setMaxTextMessageBufferSize(builder.toString().length()+100);
        System.out.println(builder.toString().length());
        session.getBasicRemote().sendText(ZipUtil.compress(builder.toString()));



        while(true){
            if( !session.isOpen() || "ok".equals(client.getMessage())){
                System.out.println("break");
                break;
            }
        }

        session.close();

    }
}
