package com.epam.task3.controller;

import com.epam.task3.command.Command;
import com.epam.task3.command.exception.CommandNotFoundException;

/**
 * Created by serge on 01.04.2017.
 */
public final class Controller {
    private final CommandProvider commandProvider = CommandProvider.getInstance();

    public <T> T executeCommand(String request) {
        T response = null;
        try {
            String[] fullReqString = request.split(" ");
            String cmdName = fullReqString[0];
            request = request.substring(cmdName.length()).trim();
            Command command = commandProvider.getCommand(cmdName);
            response = command.execute(request);
        } catch (CommandNotFoundException e) {
            e.printStackTrace();
        }
        return response;
    }
}
