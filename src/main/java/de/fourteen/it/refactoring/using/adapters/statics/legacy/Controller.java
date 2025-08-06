package de.fourteen.it.refactoring.using.adapters.statics.legacy;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class Controller {

  private final AnExpensiveService anExpensiveService;

  private Response cachedResponse;
  private LocalDateTime cachedAt;

  public Controller(AnExpensiveService anExpensiveService) {
    this.anExpensiveService = anExpensiveService;
  }

  @GetMapping("/an-expensive-request")
  public Response anExpensiveRequest(@RequestParam String aParameter) {
    if (cachedAt != null &&
        cachedAt.isAfter(LocalDateTime.now().minusSeconds(30))) {
      return cachedResponse;
    }
    cachedAt = LocalDateTime.now();
    return cachedResponse =
        anExpensiveService.doSomethingAndGiveSomeResponse(aParameter);
  }
}
