package com.epam.task3.command.exception;

/**
 * Created by serge on 01.04.2017.
 */
public class CommandNotFoundException extends Exception {

    public CommandNotFoundException(){
        super();
    }

    public CommandNotFoundException(String message){
        super(message);
    }

    public CommandNotFoundException(Exception e){
        super(e);
    }

    public CommandNotFoundException(String message, Exception e){
        super(message, e);
    }
}
