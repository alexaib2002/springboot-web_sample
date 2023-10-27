package org.alexaib.springlearn.springweblearn.model;

import org.springframework.lang.NonNull;

public record User(@NonNull String name,
                   @NonNull  String surname,
                   @NonNull String email) {
}
