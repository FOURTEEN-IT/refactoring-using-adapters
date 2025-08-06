package de.fourteen.it.refactoring.using.adapters.statics.modern;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.function.Supplier;

@RestController
public class Controller {

  private final AnExpensiveService anExpensiveService;
  private final Supplier<LocalDateTime> now;

  private Response cachedResponse;
  private LocalDateTime cachedAt;

  public Controller(AnExpensiveService anExpensiveService) {
    this(anExpensiveService, LocalDateTime::now);
  }

  Controller(AnExpensiveService anExpensiveService,
             Supplier<LocalDateTime> now) {
    this.anExpensiveService = anExpensiveService;
    this.now = now;
  }

  @GetMapping("/an-expensive-request")
  public Response anExpensiveRequest(@RequestParam String aParameter) {
    if (cachedAt != null && cachedAt.isAfter(now.get().minusSeconds(30))) {
      return cachedResponse;
    }
    cachedAt = now.get();
    return cachedResponse =
        anExpensiveService.doSomethingAndGiveSomeResponse(aParameter);
  }
}
