package football_menager_aplication;
import java.util.ArrayList;
public class Team {
    
    private String shortName;
    private String fullName;
    private double totalValue;
    private int size;
    private static final int MAXTEAMSIZE = 22;
    private ArrayList<Player> teamPlayers = new ArrayList<Player>();
    
    public Team(String shortName,String fullName){
        this.shortName = shortName;
        this.fullName = fullName;
    }
    
    private double calculateTotalValue(){
        for (Player Players : teamPlayers) {
            totalValue += Players.getMarketValue();
        }
        return totalValue;
    }
    
    public String getShortName(){
        return shortName;
    }
    
    public String getFullName(){
        return fullName;
    }
    
    public double getTotalValue(){
        return totalValue;
    }
    
    public int getSize(){
        return size;
    }
    
    @Override
    public String toString(){
        return "short name: " + shortName + " full name: " + fullName + 
                " total value: " + totalValue + " size: " + size;
    }
    
    public int getMaxTeamSize(){
        return MAXTEAMSIZE;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    
    
    
}
