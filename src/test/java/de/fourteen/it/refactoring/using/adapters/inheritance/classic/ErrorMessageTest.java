package de.fourteen.it.refactoring.using.adapters.inheritance.classic;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

final class ErrorMessageTest {

  @Test
  void messageIsWellFormatted() {
    var sut = new ErrorMessage(new MessageAdapterFake(), "test content");

    var actual = sut.toString();

    assertThat(actual).isEqualTo("[ERROR]: test content");
  }
}
