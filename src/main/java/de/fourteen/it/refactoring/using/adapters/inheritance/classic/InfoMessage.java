package de.fourteen.it.refactoring.using.adapters.inheritance.classic;

final class InfoMessage extends Message {

  private final MessageAdapter messageAdapter;
  private final String content;

  InfoMessage(final String content) {
    this(new MessageAdapterImpl(), content);
  }

  InfoMessage(final MessageAdapter messageAdapter, final String content) {
    this.messageAdapter = messageAdapter;
    this.content = content;
  }

  @Override
  public String toString() {
    return messageAdapter.formatted("INFO", content);
  }
}
