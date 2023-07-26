package com.shadabshamsi.catalogservice.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

public record Book(
    @NotBlank(message = "The Book ISBN must be defined")
    @Pattern(regexp = "^([0-9]{10}|[0-9]{13})$", message = "The Book ISBN must be valid")
    String isbn,
    @NotBlank(message = "The Book title must be defined")
    String title,
    @NotBlank(message = "The Book author must be defined")
    String author,
    @NotNull(message = "The Book price must be defined")
    @Positive(message = "The Book price must be a positive number")
    Double price
) {}
