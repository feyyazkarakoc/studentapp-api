package com.tpe.exception;

import org.aspectj.bridge.Message;

public class ResourceNotFoundException extends  RuntimeException{

    public ResourceNotFoundException(String message){
        super(message);
    }
}
