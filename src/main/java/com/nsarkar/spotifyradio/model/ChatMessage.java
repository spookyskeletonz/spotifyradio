package com.nsarkar.spotifyradio.model;

public class ChatMessage {
  private final String message;
  private final String author;

  public ChatMessage(String message, String author) {
    this.message = message;
    this.author = author;
  }

  public String getMessage() {
    return message;
  }

  public String getAuthor() {
    return author;
  }
}
