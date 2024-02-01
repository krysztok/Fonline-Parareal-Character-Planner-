package Core.Requirements;

import Core.Character;

public class ImplantRequirement extends Requirement{
    private String implantName;
    private boolean hasImplant;

    public ImplantRequirement(String name, boolean hasImplant) {
        this.implantName = name;
        this. hasImplant = hasImplant;
        isAvailable = false;
    }


    @Override
    public void check(Character character) {
        if(wasChecked){
            return;
        }

        if(character.getImplants().getImplantByName(implantName).isTaken() && hasImplant){
            isAvailable = true;
        } else if (!character.getImplants().getImplantByName(implantName).isTaken() && !hasImplant){
            isAvailable = true;
        } else {
            isAvailable = false;
        }

        wasChecked = true;
    }

    @Override
    public String getInfo() {
        if(hasImplant){
            return implantName +" implant";
        } else {
            return "Not having " + implantName + " implant";
        }
    }
}
