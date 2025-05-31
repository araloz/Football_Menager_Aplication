package football_menager_aplication;
import java.util.ArrayList;
public class Player {
        
    private int backNumber;
    private String name;
    private String position;
    private double marketValue;
    private String currentTeam;
    private String previousTeam;
    private int count;
    
    
    public Player(int backNumber, String name, String position){
        this.backNumber = backNumber;
        this.name = name;
        this.position = position;
    }
   
    
    public int getBackNumber(){
        return backNumber;
    }
    
    public String getName(){
        return name;
    }
    
    @Override
    public String toString(){
        return "Name: " + name +" back number: " + backNumber + " position: " +
                position + " market value: " + marketValue + " current team: "
                + currentTeam + " previous team: " + previousTeam;
    }

    public void setPreviousTeam(String previousTeam) {
        this.previousTeam = previousTeam;
    }
    
    public double getMarketValue(){
        return marketValue;
    }
    
    public void setMarketValue(double marketValue){
        this.marketValue = marketValue;
    }

    public void setCurrentTeam(String currentTeam) {
        this.currentTeam = currentTeam;
    }

    public String getCurrentTeam() {
        return currentTeam;
    }

    public String getPosition() {
        return position;
    }

    public String getPreviousTeam() {
        return previousTeam;
    }

    
    
    
    
    
}
