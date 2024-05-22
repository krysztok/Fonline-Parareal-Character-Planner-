package Core.Drugs;

import Core.Requirements.Requirement;

import java.util.ArrayList;
import java.util.List;

public class Drug {
    private String name;
    private Boolean taken;
    List<Requirement> requirements;

    public Drug(String name){
        this.name = name;
        taken = false;
        requirements = new ArrayList<>();
    }

    public Drug (String name, Requirement requirement) {
        this.name = name;
        taken = false;
        requirements = new ArrayList<>();
        requirements.add(requirement);
    }

    public Drug (String name, List<Requirement> requirements) {
        this.name = name;
        taken = false;
        this.requirements = requirements;
    }

    public String getName() {
        return name;
    }

    public void takeDrug(Boolean take) {
        if(take == false){
            this.taken = false;
            return;
        }

        if(meetsRequirements()){
            taken = true;
        }
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

    public Boolean isTaken() {
        return taken;
    }
}
