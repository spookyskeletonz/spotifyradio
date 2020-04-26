package com.nsarkar.spotifyradio.model;

import com.nsarkar.spotifyradio.data.Track;

public class AddTrackMessage {
  private final Track track;

  public AddTrackMessage(Track track) {
    this.track = track;
  }

  public Track getTrack() {
    return track;
  }

  @Override
  public String toString() {
    return "AddTrackMessage{" +
        "track=" + track.toString() +
        '}';
  }
}
