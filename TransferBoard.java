
package football_menager_aplication;
import java.util.ArrayList;
public class TransferBoard {
    private  ArrayList<Team> teams = new ArrayList<Team>();
    public  ArrayList<Player>teamPlayers=new ArrayList<Player>();
    private ArrayList<Contract> contracts= new ArrayList<Contract>();
    
    public TransferBoard(ArrayList<Contract> contracts,ArrayList<Team> teams,ArrayList<Player> players){
        this.contracts=contracts;
        this.teams=teams;
        this.teamPlayers=players;
        
        
        
    }
    
    public TransferBoard(){
        
    }
    public void populatePlayers(){
        String[] playerData = {
            "Muslera", "1", "Goalkeeper", "1800000", 
            "Kaan", "22", "Defence", "5000000", 
            "Toreira", "34", "Midfield", "15000000", 
            "Icardi", "9", "Forward", "18000000", 
            "Kerem", "7", "Midfield", "17000000", 
            "Abdulkerim", "17", "Defence", "9500000",
            "Oliveira", "20", "Midfield", "3500000", 
            "Mertens", "10", "Midfield", "1800000",
            "Bakambu", "99", "Forward", "2800000", 
            "Nellson", "25", "Defence", "15000000", 
            "Boey", "2", "Defence", "22000000" 
        };
        int i = 0;
        while(i <= playerData.length){
            String name = playerData[i];
            i++;
            int backNumber = Integer.valueOf(playerData[i ]);
            i++;
            String position = playerData[i];
            i++;
            double marketValue = Double.valueOf(playerData[i]); 
            i++;
            
            Player player = new Player(backNumber,name,position);
            player.setMarketValue(marketValue);
            teamPlayers.add(player);
        }
            
    }
    
    public void populateTeams(){
        String[] teamData = {
            "Galatasaray", "GS",
            "Fenerbahce", "FB",
            "Besiktas", "BJK",
            "Trabzonspor", "TS",
            "Ankaragucu", "ANK",
            "Basaksehir", "BSK",
            "Karagumruk", "KGM"
        };  
        int i = 0;
        while(i <= teamData.length){
            String fullName = teamData[i];
            i++;
            String shortName = teamData[i];
            i++;
            Team team = new Team(shortName,fullName);
            teams.add(team);
        }
            
    }
    
    
    
    public String makeContract(String playerName, String teamName,String contractType, double contractValue){
        Player p = null;
        for (int i = 0; i < teamPlayers.size(); i++) {
            if(teamPlayers.get(i).getName().equalsIgnoreCase(playerName)){
                p = teamPlayers.get(i);
            }
        }
        
        Team t = null;
        for (int i = 0; i < teams.size(); i++) {
            if(teams.get(i).getFullName().equalsIgnoreCase(teamName) && teams.get(i).getShortName().equalsIgnoreCase(teamName)){
                t = teams.get(i);
            }
        }
        
        if(p == null){
            return "UnknownPlayer";
        }
        
        if(t == null){
            return "UnknownTeam";
        }
        
        if(t.getSize() == t.getMaxTeamSize()){
            return "ExceedingMaxNumPlayers";
        }
        
        for (int i = 0; i < contracts.size(); i++) {
            Contract c = contracts.get(i);
            if(c.getPlayer() == p && c.getTeam() == t){
                return "ExistingContract";
            }
        }
        
        for (int i = 0; i < contracts.size(); i++) {
            Contract c = contracts.get(i);
            if (c.getPlayer() == p && c.getType().equalsIgnoreCase("rented")) {
            return "ContractNotPossible";
            }
        }
        
        if (p.getCurrentTeam() == null && contractType.equals("Permanent")) {
            return "InvalidContractType";
        }
        
        for (int i = 0; i < contracts.size(); i++) {
            Contract c = contracts.get(i);
            if (c.getPlayer().equals(p)) {
                contracts.remove(i);
                p.setPreviousTeam(p.getCurrentTeam());
                p.setCurrentTeam(null);
                p.setMarketValue(contractValue);
            }
        }
        
        Contract newContract = new Contract(contractValue, contractType, p, t);
        contracts.add(newContract);
        terminateContract(p,t,contractValue);
        return "SuccessfullyContracted";  
    }

    public void getTeams() {
        for (int i = 0; i < teams.size(); i++) {
            System.out.println(teams.get(i));
        }
    }

    public void getTeamPlayers() {
        for (int i = 0; i < teamPlayers.size(); i++) {
            System.out.println(teamPlayers.get(i));
        }
    }

    public void getContracts() {
        for (int i = 0; i < contracts.size(); i++) {
            System.out.println(contracts.get(i));
        }
    }
    
    public void terminateContract(Player p, Team t, double contractValue){
        p.setCurrentTeam(t.getFullName());
        p.setMarketValue(contractValue);
        t.setSize(t.getSize() + 1);
        t.setTotalValue(t.getTotalValue() + contractValue);
    }
    
}
