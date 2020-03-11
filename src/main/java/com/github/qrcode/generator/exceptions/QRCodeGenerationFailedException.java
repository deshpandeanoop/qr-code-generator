package com.github.qrcode.generator.exceptions;

import javax.ws.rs.WebApplicationException;

public class QRCodeGenerationFailedException extends WebApplicationException {

    public QRCodeGenerationFailedException(Throwable cause, int status) {
        super(cause, status);
    }
}
