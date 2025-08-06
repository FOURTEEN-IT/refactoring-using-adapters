package de.fourteen.it.refactoring.using.adapters.inheritance.legacy;

final class InfoMessage extends Message {

  private final String content;

  InfoMessage(final String content) {
    this.content = content;
  }

  @Override
  public String toString() {
    return formatted("INFO", content);
  }
}
