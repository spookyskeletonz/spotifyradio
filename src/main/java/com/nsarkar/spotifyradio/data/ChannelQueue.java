package com.nsarkar.spotifyradio.data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class ChannelQueue {
  @Id
  public String id;
  @Indexed(unique = true)
  private final String channel;
  public List<Track> queue;

  public ChannelQueue(String channel, List<Track> queue) {
    this.channel = channel;
    this.queue = queue;
  }

  public String getChannel() {
    return channel;
  }

  @Override
  public String toString() {
    return "ChannelQueue{" +
        "id='" + id + '\'' +
        ", channel='" + channel + '\'' +
        ", queue=" + queue +
        '}';
  }
}
