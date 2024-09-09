package Core.Masteries;

import Core.Requirements.LevelRequirement;
import Core.Requirements.Requirement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Mastery {
    private String name;
    private Boolean taken;
    List<Requirement> requirements;

    public Mastery(String name, LevelRequirement levelRequirement) {
        this.name = name;
        taken = false;
        this.requirements = new ArrayList<>();
        requirements.add(levelRequirement);
    }

    public Mastery (String name, List<Requirement> requirements) {
        this.name = name;
        this.taken = false;
        this.requirements = requirements;
    }

    public String getName() {
        return name;
    }

    public Boolean isTaken() {
        return taken;
    }

    public void setTaken(Boolean taken) {
        this.taken = taken;
    }

    public List<Requirement> getRequirements() {
        return requirements;
    }

    public Boolean meetsRequirements(){
        for(int i = 0; i < requirements.size(); i++){
            if(!requirements.get(i).isAvailable) {
                return false;
            }
        }

        return true;
    }

    public boolean takeMastery(){
        if(meetsRequirements()){
            taken = true;
            return true;
        }

        return false;
    }
}
