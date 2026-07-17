package game;

import entity.Player;

import java.util.Scanner;

public abstract class Event {

    public abstract void trigger(Player player, Scanner scanner);
}