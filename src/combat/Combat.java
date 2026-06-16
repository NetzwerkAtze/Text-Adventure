package combat;

import entity.Entity;

import java.util.Scanner;

public class Combat {
    public static void fightHelper(Entity player, Entity enemy, int action){
            player.useAbility(action-1, enemy);
            enemy.useAbility(0, player);
    }
    public static void fight(Entity player, Entity enemy){
        Scanner scanner = new Scanner(System.in);
        while (player.isAlive() && enemy.isAlive()) {
            System.out.println(player.getCharacterClass().getName() + " " + player.getName() + ": " + player.getHp() + " HP       " + enemy.getName()+ ": " + enemy.getHp() + " HP");
            System.out.println("Choose your next action: ");
            for (int i = 0; i < player.fleeIndex()-1; i ++) {
                int index = i + 1;
                System.out.println("    ("+index+") "+ player.getAbility(i).getName());
            }
            System.out.println("    ("+player.fleeIndex()+") Flee");
            int input = scanner.nextInt();;
            if (input == player.fleeIndex()) {
                System.out.println("You have fled the fight!");
                return;
            }
            fightHelper(player, enemy, input);
            if (player.isAlive())
                player.processEndOfTurn();
            if (enemy.isAlive())
                enemy.processEndOfTurn();
        }
        if (!enemy.isAlive())
            System.out.println("You have slain " + enemy.getName() + "!");
        else
            System.out.println("You died!");
    }
}
