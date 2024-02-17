package com.ua.project.console.interfaces.implementes;

import com.ua.project.console.enums.Color;
import com.ua.project.console.interfaces.Powered;
import com.ua.project.game.Game;
import org.w3c.dom.ls.LSOutput;

import java.util.Random;

public class GameConsole implements Powered {
    private int waitingCounter;
    private boolean isOn;
    private final String brand;
    private final String model;
    private final String serial;
    private Game activeGame;
    private Gamepad firstGamepad;
    private Gamepad secondGamepad;

    public class Gamepad implements Powered {
        private short connectedNumber;
        private boolean isOn;
        private double chargeLevel;
        private final String brand;
        private final String consoleSerial;
        private final Color color;

        public Gamepad(String brand, short connectedNumber, Color color) {
            this.brand = brand;
            this.connectedNumber = connectedNumber;
            this.consoleSerial = serial;
            this.color = color;

            this.chargeLevel = 100.0;
        }

        public short getConnectedNumber() {
            return connectedNumber;
        }

        public void setConnectedNumber(short connectedNumber) {
            this.connectedNumber = connectedNumber;
        }

        public boolean isOn() {
            return isOn;
        }

        @Override
        public void powerOn() {
            this.isOn = true;
            GameConsole.this.powerOn();
        }

        @Override
        public void powerOff() {
            this.isOn = false;
            if(this.connectedNumber == 1){
                GameConsole.this.changeGamepadOrder();
            }
        }

        public double getChargeLevel() {
            return chargeLevel;
        }

        public void setChargeLevel(double chargeLevel) {
            this.chargeLevel = chargeLevel;
        }

        public String getBrand() {
            return brand;
        }

        public String getConsoleSerial() {
            return consoleSerial;
        }

        public Color getColor() {
            return color;
        }

        public double reduceChargeLevel(int reducePercentIndex) {
            return this.chargeLevel -= (this.chargeLevel * ((double)reducePercentIndex / 100));
        }

        private void checkStatus() {
            if(this.chargeLevel <= 0){
                this.powerOff();
                System.out.println(" Gamepad \"" + this.brand + "\" charged out!");
            }
        }

        public void loadGame(Game game) {
            GameConsole.this.setActiveGame(game);
            System.out.println(" Game \"" + game.getName() + "\" loading...");
        }

        public void playGame() {
            System.out.println(" Current playing \"" + GameConsole.this.activeGame.getName() + "\"");
            System.out.println((GameConsole.this.firstGamepad.isOn() ? GameConsole.this.firstGamepad : ""));
            System.out.println((GameConsole.this.secondGamepad.isOn() ? GameConsole.this.secondGamepad : ""));

            this.reduceChargeLevel(10);
            checkStatus();
        }

        @Override
        public String toString() {
            return " Gamepad: \"" + this.brand +
                    "\"\n Color: " + this.color.name().toLowerCase().replace("_", " ") + "\n" +
                    " Charge level: " + this.chargeLevel +
                    " Power: " + (this.isOn ? "on" : "off");
        }
    }

    public GameConsole(String brand, String model, String serial, Gamepad firstGamepad, Gamepad secondGamepad) {
        this.brand = brand;
        this.model = model;
        this.serial = serial;
        this.firstGamepad = firstGamepad;
        this.secondGamepad = secondGamepad;
    }

    public GameConsole(String brand, String serial, String model) {
        this.brand = brand;
        this.model = model;
        this.serial = serial;

        this.firstGamepad = new Gamepad("XBOX", (short)1, Color.GREEN);
        this.secondGamepad = new Gamepad("MSI", (short)2, Color.RED_BLACK);
    }
    public GameConsole(){
        this("ConsoleBRAND", randomizeSerialNumber(12), "ConsoleMODEL");
    }

    public Game getActiveGame() {
        return activeGame;
    }

    public void setActiveGame(Game activeGame) {
        this.activeGame = activeGame;
    }

    public boolean isOn() {
        return isOn;
    }

    @Override
    public void powerOn() {
        this.isOn = true;
    }

    @Override
    public void powerOff() {
        this.isOn = false;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getSerial() {
        return serial;
    }

    public Gamepad getFirstGamepad() {
        return firstGamepad;
    }

    public void setFirstGamepad(Gamepad firstGamepad) {
        this.firstGamepad = firstGamepad;
    }

    public Gamepad getSecondGamepad() {
        return secondGamepad;
    }

    public void setSecondGamepad(Gamepad secondGamepad) {
        this.secondGamepad = secondGamepad;
    }

    public static String randomizeSerialNumber(final int serialNumberLength) {
        char currentChar;
        Random random = new Random();
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < serialNumberLength; i++) {
            do {
                currentChar = (char)random.nextInt(48, 122);
            }while(!Character.isLetterOrDigit(currentChar));

            builder.append(currentChar);
        }

        return builder.toString();
    }

    private void changeGamepadOrder() {
        this.secondGamepad.setConnectedNumber((short)1);
        this.firstGamepad.setConnectedNumber((short)2);
    }

    public void noConnectedGamepads(final int maxCheckCycles) {
        while(this.waitingCounter <= maxCheckCycles){
            System.out.println(" Please connect gamepad!");
            ++this.waitingCounter;

            if(this.waitingCounter == maxCheckCycles){
                System.out.println(" Console shutting down...");
                this.powerOff();
            }
        }
    }

    @Override
    public String toString() {
        return " Console: \"" + this.brand + " " + this.model + "\"\n" +
                " Power: " + (this.isOn ? "on" : "off") + "\n" + "-".repeat(25) + "\n" +
                firstGamepad + "\n" + "-".repeat(25) + "\n" +
                secondGamepad;
    }
}
