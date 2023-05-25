package de.riemerjonas.input.commands;

import de.riemerjonas.input.InputHandler;

public abstract class Command {

    public abstract void execute(String[] args);

    public abstract String getDescription();

    public Command setAlias(String alias){
        InputHandler.registerCommand(this, alias);
        return this;
    }


}
