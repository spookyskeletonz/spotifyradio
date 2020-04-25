package com.nsarkar.spotifyradio.data;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChannelQueueRepository extends MongoRepository<ChannelQueue, String> {
  // auto implemented by spring
  public ChannelQueue findByChannel(String channel);
}
