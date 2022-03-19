package com.univpm.progetto.Exceptions;

public class MyFileNotFoundException extends Exception {
    public MyFileNotFoundException() {
        super();
    }
    public MyFileNotFoundException(String msg) {
        super(msg);
    }
}
