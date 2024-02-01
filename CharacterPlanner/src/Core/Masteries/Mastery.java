package Core.Masteries;

import Core.Requirements.LevelRequirement;
import Core.Requirements.Requirement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Mastery {
    private String name;
    private Boolean taken;
    private LevelRequirement levelRequirement;

    public Mastery(String name, LevelRequirement levelRequirement) {
        this.name = name;
        taken = false;
        this.levelRequirement = levelRequirement;
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
        List<Requirement> requirements = new ArrayList<>();
        requirements.add(levelRequirement);
        return requirements;
    }

    public Boolean meetsRequirements(){
        return levelRequirement.isAvailable;
    }

    public boolean takeMastery(){
        if(meetsRequirements()){
            taken = true;
            return true;
        }

        return false;
    }
}
