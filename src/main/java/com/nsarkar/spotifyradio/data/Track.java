package com.nsarkar.spotifyradio.data;

import java.util.Objects;

public class Track {
  private final String trackName;
  private final String trackURI;
  private final String artistName;
  private final String albumName;

  public Track(String trackName, String trackURI, String artistName, String albumName) {
    this.trackName = trackName;
    this.trackURI = trackURI;
    this.artistName = artistName;
    this.albumName = albumName;
  }

  public String getTrackName() {
    return trackName;
  }

  public String getTrackURI() {
    return trackURI;
  }

  public String getArtistName() {
    return artistName;
  }

  public String getAlbumName() {
    return albumName;
  }

  @Override
  public String toString() {
    return "Track{" +
        "trackName='" + trackName + '\'' +
        ", trackURI='" + trackURI + '\'' +
        ", artistName='" + artistName + '\'' +
        ", albumName='" + albumName + '\'' +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Track track = (Track) o;
    return trackName.equals(track.trackName) &&
        trackURI.equals(track.trackURI) &&
        artistName.equals(track.artistName) &&
        Objects.equals(albumName, track.albumName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(trackName, trackURI, artistName, albumName);
  }
}
