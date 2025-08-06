package de.fourteen.it.refactoring.using.adapters.statics.classic;

final class AnExpensiveServiceSpy implements AnExpensiveService {

  private int timesCalled = 0;

  @Override
  public Response doSomethingAndGiveSomeResponse(final String aParameter) {
    timesCalled++;
    return new Response();
  }

  int timesCalled() {
    return timesCalled;
  }
}
