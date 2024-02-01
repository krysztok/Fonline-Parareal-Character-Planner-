package Core.Traits;

import Core.Character;

public class Trait {
    private String name;
    private Boolean taken;

    public Trait(String name) {
        this.name = name;
        taken = false;
    }

    public String getName() {
        return name;
    }

    public void setTaken(Boolean taken) {
        this.taken = taken;
    }

    public void takeTrait(Character character){
        setTaken(true);
    }

    public void takeOffTrait(Character character){
        setTaken(false);
    }

    public Boolean isTaken() {
        return taken;
    }
}