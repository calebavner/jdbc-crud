package org.midasvision.exceptions;

public class DbIntegrityException extends RuntimeException{

    public DbIntegrityException(String msg) {
        super(msg);
    }
}
