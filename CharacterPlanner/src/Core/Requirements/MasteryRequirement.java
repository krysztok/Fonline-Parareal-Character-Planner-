package Core.Requirements;

import Core.Character;
import Core.Masteries.Mastery;
import Core.Perks.Perk;

import java.util.ArrayList;
import java.util.List;

public class MasteryRequirement extends Requirement {
    private List<String> names;
    private Boolean hasMastery;

    public MasteryRequirement (String name, Boolean hasMastery) {
        names = new ArrayList<>();
        names.add(name);
        this.hasMastery = hasMastery;
        isAvailable = false;
    }

    public MasteryRequirement (List<String> names, Boolean hasMastery) {
        this.names = names;
        this.hasMastery = hasMastery;
    }

    @Override
    public void check(Character character) {
        if(wasChecked){
            return;
        }

        if(hasMastery){ //checking if has any mastery
            for(int i = 0; i < names.size(); i++){
                Mastery mastery = character.getMasteries().getMasteryByName(names.get(i));
                if(mastery.isTaken()){
                    isAvailable = true;
                    return;
                }
            }
            isAvailable = false;
        } else {
            for(int i = 0; i < names.size(); i++){
                Mastery mastery = character.getMasteries().getMasteryByName(names.get(i));
                if(mastery.isTaken()){
                    isAvailable = false;
                    return;
                }
            }
            isAvailable = true;
        }

        wasChecked = true;
    }

    @Override
    public String getInfo() {

        String info = "";
        if(!hasMastery){
            info += "Not having ";
        }
        for(int i = 0; i < names.size()-1;i++){
            info += names.get(i) + " or ";
        }

        info += names.get(names.size()-1) + " mastery";

        return info;
    }
}
