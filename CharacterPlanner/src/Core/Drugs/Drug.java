package Core.Drugs;

public class Drug {
    private String name;
    private Boolean taken;

    public Drug(String name){
        this.name = name;
        taken = false;
    }

    public String getName() {
        return name;
    }

    public void setTaken(Boolean taken) {
        this.taken = taken;
    }

    public Boolean isTaken() {
        return taken;
    }
}
