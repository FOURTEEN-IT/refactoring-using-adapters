package de.fourteen.it.refactoring.using.adapters.inheritance.classic;

final class ErrorMessage extends Message {

  private final MessageAdapter messageAdapter;
  private final String content;

  ErrorMessage(final String content) {
    this(new MessageAdapterImpl(), content);
  }

  ErrorMessage(final MessageAdapter messageAdapter, final String content) {
    this.messageAdapter = messageAdapter;
    this.content = content;
  }

  @Override
  public String toString() {
    return messageAdapter.formatted("ERROR", content);
  }
}
