/**
 * @author Simon Lissack
 * Chat.java
 * Endpoint for the chat server using Websockets as the means of communication.
 * Messages are passed as Json strings using the Message class and the associated
 * encoder and decoder classes.
 */

package org.teng.websocket.example.two.server;

import org.teng.websocket.example.two.domain.Message;
import org.teng.websocket.example.two.util.MessageDecoder;
import org.teng.websocket.example.two.util.MessageEncoder;

import javax.json.Json;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@ServerEndpoint(value = "/chat", encoders = {MessageEncoder.class}, decoders = {MessageDecoder.class})
public class Chat {
    // Set of all the connected sessions
    private static final Set<Session> sessions = Collections.synchronizedSet(new HashSet<Session>());

    /**
     * @OnOpen allows us to intercept the creation of a new session.
     * The session class allows us to send data to the user.
     * In the method onOpen, we'll let the user know that the handshake was
     * successful.
     */
    @OnOpen
    public void onOpen(Session session) {
        sessions.add(session);

        Message message = new Message(Json.createObjectBuilder()
                .add("type", "text")
                .add("data", "User has connected")
                .build());

        for (Session s : sessions) {
            try {
                s.getBasicRemote().sendObject(message);
            } catch (IOException | EncodeException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println(session.getId() + " has connected");
    }

    /**
     * When a user sends a message to the server, this method will intercept the message
     * and allow us to react to it. For now the message is read as a String.
     */
    @OnMessage
    public void onMessage(Message message, Session session) {
        System.out.println(message);
        for (Session s : sessions) {
            try {
                s.getBasicRemote().sendObject(message);
            } catch (IOException | EncodeException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println(message);
    }

    /**
     * The user closes the connection.
     * <p/>
     * Note: you can't send messages to the client from this method
     */
    @OnClose
    public void onClose(Session session) {
        sessions.remove(session);

        Message message = new Message(Json.createObjectBuilder()
                .add("type", "text")
                .add("data", "User has disconnected")
                .build());

        for (Session s : sessions) {
            try {
                s.getBasicRemote().sendObject(message);
            } catch (IOException | EncodeException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println("User disconnected");
    }
}
