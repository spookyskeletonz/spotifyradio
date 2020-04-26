package com.nsarkar.spotifyradio.controller;

import com.nsarkar.spotifyradio.data.ChannelQueue;
import com.nsarkar.spotifyradio.data.ChannelQueueRepository;
import com.nsarkar.spotifyradio.model.AddTrackMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class TrackController {
  Logger logger = LoggerFactory.getLogger(TrackController.class);

  @Autowired
  private SimpMessagingTemplate messagingTemplate;

  @Autowired
  private ChannelQueueRepository repo;

  @MessageMapping("/track/{channelId}/addTrack")
  public void addTrack(@DestinationVariable String channelId, @Payload AddTrackMessage addTrackMessage) {
    if (addTrackMessage == null || addTrackMessage.getTrack() == null) {
      logger.warn("received empty add track message for channel {}", channelId);
      return;
    }
    logger.info("Received message for channel {}: {}", channelId, addTrackMessage.toString());
    var rec = repo.findByChannel(channelId);
    if (rec != null) {
      // add to existing queue
      rec.queue.add(addTrackMessage.getTrack());
      repo.save(rec);
    } else {
      // need to create a new channel queue for this channel
      var channelQueue = new ChannelQueue(channelId, List.of(addTrackMessage.getTrack()));
      repo.insert(channelQueue);
    }
  }
}
