package de.fourteen.it.refactoring.using.adapters.inheritance.legacy;

final class ErrorMessage extends Message {

  private final String content;

  ErrorMessage(final String content) {
    this.content = content;
  }

  @Override
  public String toString() {
    return formatted("ERROR", content);
  }
}