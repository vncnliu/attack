package me.vncnliu.web.websocket;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

/**
 * 该注解用来指定一个URI，客户端可以通过这个URI来连接到WebSocket。类似Servlet的注解mapping。无需在web.xml中配置。
 * Copyright (c) 2008 by vncnliu.
 * All right reserved.
 * Created by vncnliu@gmail.com on 2016/5/11.
 */

@ServerEndpoint("/websocket")
public class WebsocketConnection {

    /**
     * 连接建立成功调用的方法
     * @param session  可选的参数。session为与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    @OnOpen
    public void onOpen(Session session){
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose(){
    }

    @OnMessage
    public void onMessage(String message, Session session) {
    }

    /**
     * 发生错误时调用
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error){
        System.out.println("发生错误");
        error.printStackTrace();
    }

}
