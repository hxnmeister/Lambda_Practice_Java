package com.ua.project.console.exceptions;

public class GamepadNotConnectedException extends RuntimeException {
    public GamepadNotConnectedException(String message){
        super(message);
    }
    public GamepadNotConnectedException() {
        this("Gamepad not connected!");
    }
}
