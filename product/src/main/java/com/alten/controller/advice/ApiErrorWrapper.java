package com.alten.controller.advice;

import lombok.Builder;

@Builder
public record ApiErrorWrapper(int code , String message) {
}
