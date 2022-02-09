package com.basis.sgcproject.config;

public class RegraNegocioException extends RuntimeException {
    public RegraNegocioException(final String message) {
        this(message, null);
    }

    public RegraNegocioException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
