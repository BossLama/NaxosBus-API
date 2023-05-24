package de.riemerjonas.other;

import de.riemerjonas.BootLoader;

public class SystemMessage {


    public static void sendError(String error){
        System.out.println(SystemColor.ANSI_RESET + "[" + SystemColor.ANSI_RED + "ERROR" + SystemColor.ANSI_RESET + "] " + SystemColor.ANSI_RED + error + SystemColor.ANSI_RESET);
    }

    public static void sendSuccess(String message){
        System.out.println(SystemColor.ANSI_RESET + "[" + SystemColor.ANSI_GREEN + "SUCCESS" + SystemColor.ANSI_RESET + "] " + message);
    }

    public static void sendWarning(String message){
        System.out.println(SystemColor.ANSI_RESET + "[" + SystemColor.ANSI_YELLOW + "WARNING" + SystemColor.ANSI_RESET + "] " + SystemColor.ANSI_YELLOW + "" + message + SystemColor.ANSI_RESET);
    }

    public static void sendInformation(String message){
        System.out.println(SystemColor.ANSI_RESET + "[" + SystemColor.ANSI_BLUE + "INFO" + SystemColor.ANSI_RESET + "] " + message);
    }

    public static void sendCommandInfo(String message){
        System.out.println(SystemColor.ANSI_RESET + "[" + SystemColor.ANSI_CYAN + "CMD" + SystemColor.ANSI_RESET + "] " + message);
    }
}
