package Core.Requirements;

import Core.Character;
import Core.Perks.Perk;

import java.util.ArrayList;
import java.util.List;

public class PerkRequirement extends Requirement {
    private List<String> names;
    private Boolean hasPerk;

    public PerkRequirement (String name, Boolean hasPerk) {
        names = new ArrayList<>();
        names.add(name);
        this.hasPerk = hasPerk;
        isAvailable = false;
    }

    public PerkRequirement (List<String> names, Boolean hasPerk) {
        this.names = names;
        this.hasPerk = hasPerk;
    }

    @Override
    public void check(Character character) {
        if(wasChecked){
            return;
        }

        for(int i = 0; i < names.size(); i++){
            Perk perk = character.getPerks().getPerkByName(names.get(i));
            if (perk == null) {
                perk = character.getSupportPerks().getPerkByName(names.get(i));
            }
            Boolean characterHasPerk = perk.isTaken();

            if(hasPerk){ //returns false if doesnt have all perks
                if(!characterHasPerk) {
                    isAvailable = false;
                    return;
                }
            } else { //returns false if has any of perk
                if(characterHasPerk){
                    isAvailable = false;
                    return;
                }
            }
        }

        isAvailable = true;
        wasChecked = true;
    }

    @Override
    public String getInfo() {
        String info = "";
        if(!hasPerk){
            info += "Not having ";
        }
        for(int i = 0; i < names.size()-1;i++){
            info += names.get(i) + " and ";
        }


        info += names.get(names.size()-1) + " perk";

        if(names.size() > 1){
            info +="s";
        }


        return info;
    }
}
