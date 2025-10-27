package AdventureTimeGame;

public class SafeHouse extends NormalLocation{

    SafeHouse(Player player) {
        super(player,"Safe House");
        
    }
    public boolean getLocation(){
        player.setHealthy(player.getrHealthy());
        System.out.println("Your health has improved...");
        System.out.println("Now You are in your castle.");
        return true;
    }
    
}
