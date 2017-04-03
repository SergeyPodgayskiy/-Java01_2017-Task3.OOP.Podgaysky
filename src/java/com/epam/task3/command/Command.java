package com.epam.task3.command;

/**
 * Created by serge on 31.03.2017.
 */
public interface Command {
    <T> T execute(String name);
}
