package de.fourteen.it.refactoring.using.adapters.statics.modern;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ControllerTest {

  @Test
  void theControllerCachesTheResponseForAtLeast29Seconds() {
    var now = LocalDateTime.of(2024, Month.FEBRUARY, 22, 0, 0);
    var in29seconds = now.plusSeconds(29);
    var stubbedValues = List.of(now, in29seconds, in29seconds).iterator();
    var anExpensiveServiceSpy = new AnExpensiveServiceSpy();
    var sut = new Controller(anExpensiveServiceSpy, stubbedValues::next);

    var response1 = sut.anExpensiveRequest(null);
    var response2 = sut.anExpensiveRequest(null);

    assertThat(anExpensiveServiceSpy.timesCalled()).isEqualTo(1);
    assertThat(response1).isEqualTo(response2);
  }

  @Test
  void theControllerDoesNotCacheTheResponseForMoreThan31Seconds() {
    var now =
        new AtomicReference<>(LocalDateTime.of(2024, Month.FEBRUARY, 22, 0, 0));
    var anExpensiveServiceSpy = new AnExpensiveServiceSpy();
    var sut = new Controller(anExpensiveServiceSpy, now::get);

    sut.anExpensiveRequest(null);
    now.set(now.get().plusSeconds(31));
    sut.anExpensiveRequest(null);

    assertThat(anExpensiveServiceSpy.timesCalled()).isEqualTo(2);
  }
}