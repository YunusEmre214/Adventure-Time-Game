package AdventureTimeGame;

import java.util.Scanner;

public class Game {
    Player player;
    Location location;
    Scanner scan=new Scanner(System.in);
    
    public void login(){
        Scanner scan=new Scanner(System.in);
        System.out.println("Welcome too Adventure Time Game !!!");
        System.out.print("Before the start game choose your name:");
        //String playerName=scan.nextLine();
        player=new Player("Victor Elderblood");
        player.selectCha();
        start();
    }

    public void start(){
        while(true){
            System.out.println();
        System.out.println("------------------");
        System.out.println();
        System.out.println("Choose a Location:");
        System.out.println("1-)The Castle of Elderblood-->Your castle This is the safe place");
        System.out.println("2-)Dark forest-->There are so many zombies have");
        System.out.println("3-)The demon castle-->There are so many demons have");
        System.out.println("4-)Tower of Nightmare-->There are so many Eldritch Monsters have");
        System.out.println("5-)Blacksmith Shop-->You can created equipment and buy");
        System.out.print("Location you want to go:");
        int selloc=scan.nextInt();
        while(selloc<0||selloc>5){
            System.out.println("Please select a valid class:");
            selloc=scan.nextInt();
        }

        switch(selloc){
            case 1:
            location=new SafeHouse(player);
            break;
            case 2:
            location=new DarkForest(player);
            break;
            case 3:
            location=new TheDemonCastle(player);
            break;
            case 4:
            location=new TowerOfNightmare(player);
            break;
            case 5:
            location=new Toolstore(player);
            break;
            default:
            location=new SafeHouse(player);
            break;
        }
        if(location.getClass().getName().equals("Safe House")){
            if(player.getInventory().isFirewood()&&player.getInventory().isFood()&&player.getInventory().isWater()){
                System.out.println("Congrulations You won the game!!!");
                break;
            }
        }
        if(!location.getLocation()){
            System.out.println("Game Over!");
            break;
        }
        }
        
    }
}
