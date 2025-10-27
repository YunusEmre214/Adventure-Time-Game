package AdventureTimeGame;

import java.util.Scanner;

public class Player {
    private int damage,healthy,gold,rHealthy;
    private String name,cName;
    private Inventory inventory;
    Scanner scan=new Scanner(System.in);
    public Player(String name) {
        this.name = name;
        this.inventory=new Inventory();
    }

    public void selectCha(){
        switch(chaMenu()){
            case 1:
            initPlayer("Knight", 18, 87, 12);
            break;
            case 2:
            initPlayer("Archer", 21, 62, 15);
            break;
            case 3:
            initPlayer("Mage", 25, 68, 20);
            break;
            default:
            initPlayer("Knight", 18, 87, 12);
            break;
            
        }
        System.out.println("The Character is created ! Class:"+getcName()+"\tDamage:"+getDamage()+"\tHealthy:"+getHealthy()+"\tGold:"+getGold());
    }
    public int chaMenu(){
        System.out.println("Please choose your character class:");
        System.out.println("1-Class:Knight\tDamage:18\tHealthy:87\tGold:12");
        System.out.println("2-Class:Archer\tDamage:21\tHealthy:62\tGold:15");
        System.out.println("3-Class:Mage\tDamage:25\tHealthy:68\tGold:20");
        System.out.print("Your choose is:");
        int chaID=scan.nextInt();
        while(chaID<1||chaID>3){
            System.out.println("Please select a valid class:");
            chaID=scan.nextInt();
        }
        return chaID;
    }
    public int getTotalDamage(){
        return this.getDamage()+this.getInventory().getDamage();
    }

    public void initPlayer(String cName,int dmg,int hlthy,int gld){
            setcName(cName);
            setDamage(dmg);
            setHealthy(hlthy);
            setGold(gld);
            setrHealthy(hlthy);
    }


    public int getDamage() {
        return damage;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }
    public int getHealthy() {
        return healthy;
    }
    public void setHealthy(int healthy) {
        this.healthy = healthy;
    }
    public int getGold() {
        return gold;
    }
    public void setGold(int gold) {
        this.gold = gold;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getcName() {
        return cName;
    }
    public void setcName(String cName) {
        this.cName = cName;
    }
    public Inventory getInventory() {
        return inventory;
    }
    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getrHealthy() {
        return rHealthy;
    }

    public void setrHealthy(int rHealthy) {
        this.rHealthy = rHealthy;
    }
    
    

}
