package de.fourteen.it.refactoring.using.adapters.statics.classic;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class Controller {

  private final AnExpensiveService anExpensiveService;
  private final LocalDateTimeAdapter localDateTimeAdapter;

  private Response cachedResponse;
  private LocalDateTime cachedAt;

  public Controller(AnExpensiveService anExpensiveService) {
    this(anExpensiveService, new LocalDateTimeAdapterImpl());
  }

  Controller(AnExpensiveService anExpensiveService,
             LocalDateTimeAdapter localDateTimeAdapter) {
    this.anExpensiveService = anExpensiveService;
    this.localDateTimeAdapter = localDateTimeAdapter;
  }

  @GetMapping("/an-expensive-request")
  public Response anExpensiveRequest(@RequestParam String aParameter) {
    if (cachedAt != null &&
        cachedAt.isAfter(localDateTimeAdapter.now().minusSeconds(30))) {
      return cachedResponse;
    }
    cachedAt = localDateTimeAdapter.now();
    return cachedResponse =
        anExpensiveService.doSomethingAndGiveSomeResponse(aParameter);
  }
}
