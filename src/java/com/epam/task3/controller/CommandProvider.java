package com.epam.task3.controller;

import com.epam.task3.command.Command;
import com.epam.task3.command.CommandName;
import com.epam.task3.command.exception.CommandNotFoundException;
import com.epam.task3.command.impl.general.CollectGiftCommand;
import com.epam.task3.command.impl.general.DefineGiftWeightCommand;
import com.epam.task3.command.impl.general.FindBySugarAmountCommand;
import com.epam.task3.command.impl.general.SortByParameterCommand;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by serge on 01.04.2017.
 */
public class CommandProvider {
    private static final CommandProvider INSTANCE = new CommandProvider();
    private final Map<String, Command> commandMap = new HashMap<>();

    private CommandProvider() {
        commandMap.put(CommandName.COLLECT_GIFT,
                new CollectGiftCommand());
        commandMap.put(CommandName.DEFINE_GIFTS_WEIGHT,
                new DefineGiftWeightCommand());
        commandMap.put(CommandName.FIND_CANDY_BY_AMOUNT_OF_SUGAR,
                new FindBySugarAmountCommand());
        commandMap.put(CommandName.SORT_BY_PARAMETER,
                new SortByParameterCommand());
    }

    public static CommandProvider getInstance(){
        return INSTANCE;
    }

    public Command getCommand(String commandName)
            throws CommandNotFoundException {
        Command command = commandMap.get(commandName);
        if (command != null) {
            return command;
        } else {
            throw new CommandNotFoundException("Null/Wrong Command name");
        }
    }
}
