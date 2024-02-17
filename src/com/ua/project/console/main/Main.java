package com.ua.project.console.main;

import com.ua.project.console.interfaces.implementes.GameConsole;

public class Main {
    public static void main(String[] args) {
        GameConsole gameConsole = new GameConsole("XBOX", GameConsole.randomizeSerialNumber(12), "Series X");

        System.out.println(gameConsole);
    }
}
