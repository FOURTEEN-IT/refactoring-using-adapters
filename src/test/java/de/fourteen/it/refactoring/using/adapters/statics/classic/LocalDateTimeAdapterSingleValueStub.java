package de.fourteen.it.refactoring.using.adapters.statics.classic;

import java.time.LocalDateTime;

final class LocalDateTimeAdapterSingleValueStub implements LocalDateTimeAdapter {

  private LocalDateTime now;

  LocalDateTimeAdapterSingleValueStub(LocalDateTime stubbedValue) {
    now = stubbedValue;
  }

  @Override
  public LocalDateTime now() {
    return now;
  }

  void stubNow(LocalDateTime stubbedValue) {
    now = stubbedValue;
  }
}
