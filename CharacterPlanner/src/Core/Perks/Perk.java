package Core.Perks;

import Core.Requirements.*;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;
import java.util.List;

public class Perk {
    private String name;
    private Boolean taken;
    List<Requirement> requirements;

    public Perk (String name) {
        this.name = name;
        this.taken = false;
        requirements = new ArrayList<>();
    }

    public Perk (String name, Requirement requirement) {
        this.name = name;
        this.taken = false;
        this.requirements = new ArrayList<>();
        requirements.add(requirement);
    }

    public Perk (String name, LevelRequirement levelRequirement, Requirement otherRequirement) {
        this.name = name;
        this.taken = false;
        this.requirements = new ArrayList<>();
        requirements.add(levelRequirement);
        requirements.add(otherRequirement);
    }

    public Perk (String name, List<Requirement> requirements) {
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

    public boolean takePerk(){
        if(meetsRequirements()){
            taken = true;
            return true;
        }

        return false;
    }
}
