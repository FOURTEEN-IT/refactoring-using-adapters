package de.fourteen.it.refactoring.using.adapters.statics.legacy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ControllerTest {

  @Test
  void theControllerCachesTheResponseForAtLeast29Seconds()
      throws InterruptedException {
    var anExpensiveServiceSpy = new AnExpensiveServiceSpy();
    var sut = new Controller(anExpensiveServiceSpy);

    var response1 = sut.anExpensiveRequest(null);
    Thread.sleep(29_000);
    var response2 = sut.anExpensiveRequest(null);

    assertThat(anExpensiveServiceSpy.timesCalled()).isEqualTo(1);
    assertThat(response1).isEqualTo(response2);
  }

  @Test
  void theControllerDoesNotCacheTheResponseForMoreThan31Seconds()
      throws InterruptedException {
    var anExpensiveServiceSpy = new AnExpensiveServiceSpy();
    var sut = new Controller(anExpensiveServiceSpy);

    sut.anExpensiveRequest(null);
    Thread.sleep(31_000);
    sut.anExpensiveRequest(null);

    assertThat(anExpensiveServiceSpy.timesCalled()).isEqualTo(2);
  }
}