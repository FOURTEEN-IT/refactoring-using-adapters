package de.fourteen.it.refactoring.using.adapters.statics.classic;

import java.time.LocalDateTime;

final class LocalDateTimeAdapterImpl implements LocalDateTimeAdapter {

  @Override
  public LocalDateTime now() {
    return LocalDateTime.now();
  }
}
