package Core.Implants;
import Core.Requirements.Requirement;

import java.util.ArrayList;
import java.util.List;

public class Implant {
    private String name;
    private Boolean taken;
    private List<Requirement> requirements;

    public Implant(String name,  List<Requirement> requirements){
        this.name = name;
        this.requirements = requirements;
        taken = false;
    }

    public Implant(String name,  Requirement requirement){
        this.name = name;
        this.requirements = new ArrayList<>();
        requirements.add(requirement);
        taken = false;
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

    public void takeImplant(boolean cheatsOn) {
        if(meetsRequirements() || cheatsOn){
            taken = true;
        }
    }
}
