package de.riemerjonas.input.commands;

public class ClearCommand extends Command{
    @Override
    public void execute(String[] args) {
        for(int i = 0; i < 40; i++){
            System.out.println("");
        }
    }
}
