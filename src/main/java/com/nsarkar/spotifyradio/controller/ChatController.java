package com.nsarkar.spotifyradio.controller;

import com.nsarkar.spotifyradio.model.ChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

  @Autowired
  SimpMessagingTemplate messagingTemplate;

  @MessageMapping("chat/{channelId}/sendMessage")
  public void sendMessage(@DestinationVariable String channelId, @Payload ChatMessage chatMessage) {
    // send the incoming message to all clients connected to this channel
    messagingTemplate.convertAndSend(String.format("/channel/%s", channelId), chatMessage);
  }
}
