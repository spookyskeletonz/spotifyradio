package com.nsarkar.spotifyradio.controller;

import com.nsarkar.spotifyradio.model.ChatMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {
  Logger logger = LoggerFactory.getLogger(ChatController.class);

  @Autowired
  SimpMessagingTemplate messagingTemplate;

  @MessageMapping("/chat/{channelId}/sendMessage")
  public void sendMessage(@DestinationVariable String channelId, @Payload ChatMessage chatMessage) {
    // send the incoming message to all clients connected to this channel
    if (chatMessage == null) {
      logger.warn("Received empty message for channel {}", channelId);
      return;
    }
    logger.info("Received message for channel {}: {}", channelId, chatMessage.getMessage());
    messagingTemplate.convertAndSend(String.format("/channel/%s", channelId), chatMessage);
  }
}
