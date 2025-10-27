package AdventureTimeGame;

import java.util.Scanner;

public class Toolstore extends NormalLocation{
    
    Toolstore(Player player) {
        super(player,"Blacksmith");
        
    }
    public boolean getLocation(){
        System.out.println("Gold:"+player.getGold());
        System.out.println("1.Swords");
        System.out.println("2.Armors");
        System.out.println("3.Exit");
        System.out.print("Your Choose:");
        int selTool=scan.nextInt();
        int selItemID;
        switch(selTool){
        case 1:
        selItemID=weaponMenu();
        buyWeapon(selItemID);
        break;
        case 2:
        selItemID=armorMenu();
        buyArmor(selItemID);
        break;
        case 3:
        break;
        default:
        break;
        }
        return true;
    }

    public int weaponMenu(){
        System.out.println("1.Holy Knight Sword\t <Gold:15 - Damage:7>");
        System.out.println("2.Demonic Sword\t <Gold:35 - Damage:13>");
        System.out.println("3.Dragon Slayer SWord\t <Gold:57 - Damage:20>");
        System.out.println("4.Exit");
        System.out.print("Choose your Sword:");
        int selWeaponID=scan.nextInt();
        return selWeaponID;
    }
    public void buyWeapon(int itemID){
        int damage=0,price=0;
        String wName=null;
        switch(itemID){
            case 1:
            damage=7;
            wName="Holy Knight Sword";
            price=15;
            break;
            case 2:
            damage=13;
            wName="Demonic Sword";
            price=35;
            break;
            case 3:
            damage=20;
            wName="Dragon Slayer";
            price=57;
            break;
            case 4:
            System.out.println("Checking out");
            break;
            default:
            System.out.println("Please select a valid action!");
            break;
        }
        if(price>0){
            if(player.getGold()>=price){
            player.getInventory().setDamage(damage);
            player.getInventory().setwName(wName);
            player.setGold(player.getGold()-price);
            System.out.println(wName+" you bought  weapon,Previous Damage:"+player.getDamage()+",New Damage:"+player.getTotalDamage());
            System.out.println("Remaining Gold:"+player.getGold());
        }
        else{
            System.out.println("Not enough gold!");
        }
        }
        
        
    }
    public int armorMenu(){
        System.out.println("1.Holy Knight Armor\t <Gold:10 - Armor:5>");
        System.out.println("2.Demonic Armor\t <Gold:21 - Armor:9>");
        System.out.println("3.Dragon Slayer Armor\t <Gold:36 - Armor:17>");
        System.out.println("4.Exit");
        System.out.print("Choose your Armor:");
        int selWeaponID=scan.nextInt();
        return selWeaponID;
    }
    public void buyArmor(int itemID){
        int armor=0,price=0;
        String aName=null;
        switch(itemID){
            case 1:
            armor=5;
            aName="Holy Knight Armor";
            price=10;
            break;
            case 2:
            armor=9;
            aName="Demonic Armor";
            price=21;
            break;
            case 3:
            armor=17;
            aName="Dragon Slayer Armor";
            price=36;
            break;
            case 4:
            System.out.println("Checking out");
            break;
            default:
            System.out.println("Please select a valid action!");
            break;
        }
        if(price>0){
            if(player.getGold()>=price){
            player.getInventory().setArmor(armor);
            player.getInventory().setaName(aName);
            player.setGold(player.getGold()-price);
            System.out.println(aName+" you bought , Prevented Damage:"+player.getInventory().getArmor());
            System.out.println("Remaining Gold:"+player.getGold());
        }
        else{
            System.out.println("Not enough gold!");
        }
        }
        
    }
}
