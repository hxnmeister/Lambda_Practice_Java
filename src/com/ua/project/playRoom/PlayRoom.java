package com.ua.project.playRoom;

import com.ua.project.console.enums.Color;
import com.ua.project.console.interfaces.implementes.GameConsole;
import com.ua.project.game.Game;
import com.ua.project.game.enums.Genre;
import com.ua.project.game.enums.Rate;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PlayRoom {
    public static void main(String[] args) {
        GameConsole console = new GameConsole("Nintendo", GameConsole.randomizeSerialNumber(12), "Switch 2");
        List<Game.GameDisk> diskList = new ArrayList<Game.GameDisk>(List.of(new Game.GameDisk[] {
                Game.getDisk("Civilization VI", Genre.STRATEGY, "Good for relax and chill"),
                Game.getDisk("Helldivers 2", Genre.ACTION, "Bring democracy everywhere!!!"),
                Game.getDisk("World of Warcraft III", Genre.MMORPG, "Need more resources"),
                Game.getDisk("Forza Horion 4", Genre.RACE, "very unique race experience =)"),
        }));
        List<Game.DigitalGame> digitalGameList = new ArrayList<Game.DigitalGame>(List.of(new Game.DigitalGame[]{
                Game.getDigital("HITMAN World of Assassination", Genre.STEALTH, Rate.FIVE),
                Game.getDigital("Mad Max", Genre.ACTION, Rate.FOUR),
                Game.getDigital("Lord of the Ring: Gollum", Genre.STEALTH, Rate.ZERO),
                Game.getDigital("The Elder Scrolls: Online", Genre.RPG, Rate.THREE),
        }));

        System.out.println("  BEFORE CHANGES:\n");
        System.out.println(console);
        System.out.println("-".repeat(50));
        System.out.println("  DISKS:");
        displayGames(diskList);
        System.out.println("  DIGITALS:");
        displayGames(digitalGameList);

        System.out.println("\n  AFTER SORTING DISKS BY GENRE:\n");
        diskList.sort(Comparator.comparing((disk) -> disk.getData().getGenre()));
        displayGames(diskList);

        System.out.println("\n  AFTER SORTING DIGITALS BY RATING:\n");
        digitalGameList.sort(Comparator.comparing(Game.DigitalGame::getRating));
        displayGames(digitalGameList);
    }

    private static void displayGames(List<?> gamesList) {
        gamesList.forEach((value) -> {
            System.out.println(value);
            System.out.println("-".repeat(25));
        });
    }
}
