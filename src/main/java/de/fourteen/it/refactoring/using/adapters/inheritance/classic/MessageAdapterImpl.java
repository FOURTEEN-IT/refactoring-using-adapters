package de.fourteen.it.refactoring.using.adapters.inheritance.classic;

final class MessageAdapterImpl extends Message implements MessageAdapter {
  @Override
  public String formatted(final String prefix, final String content) {
    return super.formatted(prefix, content);
  }
}
