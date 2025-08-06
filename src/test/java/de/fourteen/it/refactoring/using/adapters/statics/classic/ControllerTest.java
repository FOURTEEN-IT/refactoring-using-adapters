package de.fourteen.it.refactoring.using.adapters.statics.classic;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ControllerTest {

  @Test
  void theControllerCachesTheResponseForAtLeast29Seconds() {
    var now = LocalDateTime.of(2024, Month.FEBRUARY, 22, 0, 0);
    var in29seconds = now.plusSeconds(29);
    var localDateTimeAdapterSub =
        new LocalDateTimeAdapterMultipleValuesStub(now,
                                                   in29seconds,
                                                   in29seconds
        );
    var anExpensiveServiceSpy = new AnExpensiveServiceSpy();
    var sut = new Controller(anExpensiveServiceSpy, localDateTimeAdapterSub);

    var response1 = sut.anExpensiveRequest(null);
    var response2 = sut.anExpensiveRequest(null);

    assertThat(anExpensiveServiceSpy.timesCalled()).isEqualTo(1);
    assertThat(response1).isEqualTo(response2);
  }

  @Test
  void theControllerDoesNotCacheTheResponseForMoreThan31Seconds() {
    var now = LocalDateTime.of(2024, Month.FEBRUARY, 22, 0, 0);
    var localDateTimeAdapterStub = new LocalDateTimeAdapterSingleValueStub(now);
    var anExpensiveServiceSpy = new AnExpensiveServiceSpy();
    var sut = new Controller(anExpensiveServiceSpy, localDateTimeAdapterStub);

    sut.anExpensiveRequest(null);
    localDateTimeAdapterStub.stubNow(now.plusSeconds(31));
    sut.anExpensiveRequest(null);

    assertThat(anExpensiveServiceSpy.timesCalled()).isEqualTo(2);
  }
}