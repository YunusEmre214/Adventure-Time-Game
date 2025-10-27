package AdventureTimeGame;

public abstract class BattleLocation extends Location{
    private Obstacle obstacle;
    protected String award;
    BattleLocation(Player player,String name,Obstacle obstacle,String award) {
        super(player);
        this.obstacle=obstacle;
        this.name=name;
        this.award=award;
    }
    public boolean getLocation(){
        int obstacleCount=obstacle.count();
        System.out.println("Now You are in:"+this.getName());
        System.out.println("Be careful ! "+obstacleCount+" "+obstacle.getName()+" have!");
        System.out.println("<F>ight or <R>un");
        String selCase=scan.nextLine();
        selCase=selCase.toUpperCase();
        if(selCase.equals("F")){
            if(combat(obstacleCount)){
                System.out.println("In "+this.getName()+" you killed all enemys !");
                if(this.award.equals("Black Leaf") && player.getInventory().isFood()==false){
                    System.out.println(this.award+" you won !");
                    player.getInventory().setFood(true);
                }else if(this.award.equals("Demon King Blood") && player.getInventory().isWater()==false){
                    System.out.println(this.award+" you won !");
                    player.getInventory().setWater(true);
                }else if(this.award.equals("The wand of Madness") && player.getInventory().isFirewood()==false){
                    System.out.println(this.award+" you won !");
                    player.getInventory().setFirewood(true);
                }
                return true;
            }
            if(player.getHealthy()<=0){
                System.out.println("You are dead!");
                return false;
            }
            
        }
        return true;
    }

    public boolean combat(int obstacleCount){
        for(int i=0;i<obstacleCount;i++){
            int defObsHealthy=obstacle.getHealthy();
            playerStats();
            enemyStats();
            while(player.getHealthy()>0 && obstacle.getHealthy()>0){
                System.out.println("<A>ttack or <R>un");
                String selCase=scan.nextLine();
                selCase=selCase.toUpperCase();
                if(selCase.equals("A")){
                    System.out.println("First you attacked !");
                    obstacle.setHealthy(obstacle.getHealthy()-player.getTotalDamage());
                    afterHeat();
                    if(obstacle.getHealthy()>0){
                    System.out.println(("Monster attacked you now !"));
                    player.setHealthy(player.getHealthy()-(obstacle.getDamage()-player.getInventory().getArmor()));
                    afterHeat();
                    }
                    
                }
                else{
                    return false;
                }
            }
            if(obstacle.getHealthy()< player.getHealthy()){
                System.out.println("You killed an enemy !");
                player.setGold(player.getGold()+obstacle.getAward());
                System.out.println("Your new Gold Count:"+player.getGold());
                obstacle.setHealthy((defObsHealthy));
                
            }
            else{
                return false;
            }
            System.out.println("---------------------");
        }
        return true;
    }
    public void playerStats(){
        System.out.println("Player Information\n-------------");
        System.out.println("Damage:"+player.getDamage());
        System.out.println("Healthy:"+player.getHealthy());
        System.out.println("Gold:"+player.getGold());
        if(player.getInventory().getDamage()>0){
            System.out.println("Weapon:"+player.getInventory().getwName());
        }
        if(player.getInventory().getArmor()>0){
            System.out.println("Armor:"+player.getInventory().getaName());
        }
        
    }
    public void enemyStats(){
        System.out.println("\n"+obstacle.getName()+" enemy Information\n-------------");
        System.out.println("Damage:"+obstacle.getDamage());
        System.out.println("Healthy:"+obstacle.getHealthy());
        System.out.println("Award:"+obstacle.getAward());
    }
    public void afterHeat(){
    System.out.println("Player Healthy:"+player.getHealthy());
    System.out.println(obstacle.getName()+" Healthy:"+obstacle.getHealthy());
    System.out.println("-----------");
    }
    
}
