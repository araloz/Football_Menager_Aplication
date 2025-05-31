package football_menager_aplication;
public class Contract {

    private double value;
    private String type;
    private Player player;
    private Team team;

    Contract(double value, String type, Player player, Team team) {
        this.value = value;
        this.type = type;
        this.player = player;
        this.team = team;

    }

    public Player getPlayer() {
        return player;
    }

    public Team getTeam() {
        return team;
    }

    public String getType() {
        return type;
    }

    public double getValue() {
        return value;

    }

    public void setType(String type) {
        this.type = type;
    }

    public void setValue(double value) {
        this.value = value;

    }

}
