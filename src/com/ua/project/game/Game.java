package com.ua.project.game;

import com.ua.project.game.enums.Rate;
import com.ua.project.game.enums.Genre;
import com.ua.project.game.enums.Type;

import java.util.Comparator;

public class Game {
    private final String name;
    private final Genre genre;
    private final Type type;

    public static class GameDisk {
        private final String description;
        private final Game data;

        private GameDisk(String name, Genre genre, String description) {
            this.data = new Game(name, genre, Type.PHYSICAL);
            this.description = description;
        }

        public String getDescription() {
            return description;
        }

        public Game getData() {
            return data;
        }

        @Override
        public String toString() {
            return data + "\n" +
                    " Description: " + this.description;
        }
    }

    public static class DigitalGame {
        private Rate rating;
        private final Game data;

        private DigitalGame(String name, Genre genre, Rate rating) {
            this.data = new Game(name, genre, Type.DIGITAL);
            this.rating = rating;
        }

        public Rate getRating() {
            return rating;
        }

        public void setRating(Rate rating) {
            this.rating = rating;
        }

        public Game getData() {
            return data;
        }

        @Override
        public String toString() {
            return data + "\n" +
                    " Rating: " + rating.getRate() + " stars";
        }
    }

    private Game(String name, Genre genre, Type type) {
        this.name = name;
        this.genre = genre;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public Genre getGenre() {
        return genre;
    }

    public Type getType() {
        return type;
    }

    public static GameDisk getDisk(String name, Genre genre, String description) {
        return new GameDisk(name, genre, description);
    }

    public static DigitalGame getDigital(String name, Genre genre, Rate rating) {
        return new DigitalGame(name, genre, rating);
    }

    @Override
    public String toString() {
        return " Game title: " + this.name + "\n" +
                " Genre: " + this.genre.name().toLowerCase() + "\n" +
                " Type: " + this.type.name().toLowerCase();
    }
}
