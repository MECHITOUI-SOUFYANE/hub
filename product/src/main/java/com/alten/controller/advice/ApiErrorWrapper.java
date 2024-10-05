package com.alten.controller.advice;

import lombok.Builder;

import java.util.List;

@Builder
public record ApiErrorWrapper(int code , List<String> messages) {
}
