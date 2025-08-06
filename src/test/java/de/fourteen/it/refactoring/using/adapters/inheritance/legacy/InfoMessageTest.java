package de.fourteen.it.refactoring.using.adapters.inheritance.legacy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

final class InfoMessageTest {

  @Test
  void messageIsWellFormatted() {
    var sut = new InfoMessage("test content");

    var actual = sut.toString();

    assertThat(actual).isEqualTo("[INFO]: test content");
  }
}
