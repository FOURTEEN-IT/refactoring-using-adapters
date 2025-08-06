package de.fourteen.it.refactoring.using.adapters.inheritance.classic;

final class MessageAdapterFake implements MessageAdapter {
  @Override
  public String formatted(final String prefix, final String content) {
    return "[" + prefix + "]: " + content;
  }
}
