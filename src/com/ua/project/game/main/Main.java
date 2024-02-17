package com.ua.project.game.main;

import com.ua.project.game.Game;
import com.ua.project.game.enums.Genre;
import com.ua.project.game.enums.Rate;

public class Main {
    public static void main(String[] args) {
        Game.GameDisk disk = Game.getDisk("Forza Horizon 5", Genre.RACE, "Very good racing game!");
        Game.DigitalGame digitalGame = Game.getDigital("HITMAN 3", Genre.STEALTH, Rate.FIVE);

        System.out.println(disk);
        System.out.println("-".repeat(50));
        System.out.println(digitalGame);
    }
}
