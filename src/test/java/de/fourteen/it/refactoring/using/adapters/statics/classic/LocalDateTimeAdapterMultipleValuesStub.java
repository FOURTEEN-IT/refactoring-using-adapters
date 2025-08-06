package de.fourteen.it.refactoring.using.adapters.statics.classic;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Iterator;

final class LocalDateTimeAdapterMultipleValuesStub
    implements LocalDateTimeAdapter {

  private final Iterator<LocalDateTime> stubbedValues;

  LocalDateTimeAdapterMultipleValuesStub(LocalDateTime... stubbedValues) {
    this.stubbedValues = Arrays.asList(stubbedValues).iterator();
  }

  @Override
  public LocalDateTime now() {
    return stubbedValues.next();
  }
}
