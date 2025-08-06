package de.fourteen.it.refactoring.using.adapters.inheritance.legacy;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

abstract class Message {
  String formatted(final String prefix, final String content) {
    Objects.requireNonNull(content);
    String formattedPrefix = Optional
        .ofNullable(prefix)
        .map(p -> "[" + p + "]")
        .orElseThrow(IllegalArgumentException::new);
    Function<List<String>, String> joinWithColon =
        strings -> String.join(": ", strings);
    return joinWithColon.apply(List.of(formattedPrefix, content));
  }
}
