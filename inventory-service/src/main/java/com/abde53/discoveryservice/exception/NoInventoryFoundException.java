package com.abde53.discoveryservice.exception;

public class NoInventoryFoundException extends RuntimeException {
    public NoInventoryFoundException(String msg) {
        super(msg);
    }
}
