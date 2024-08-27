package Core.Requirements;

import Core.Character;
import Core.Perks.Perk;

import java.util.ArrayList;
import java.util.List;

public class PerkRequirement extends Requirement {
    private List<String> names;
    private Boolean hasPerk;
    private Boolean allPerks;

    public PerkRequirement (String name, Boolean hasPerk) {
        names = new ArrayList<>();
        names.add(name);
        this.hasPerk = hasPerk;
        isAvailable = false;
        allPerks = true;
    }

    public PerkRequirement (List<String> names, Boolean hasPerk, Boolean allPerks) {
        this.names = names;
        this.hasPerk = hasPerk;
        this.allPerks = allPerks;
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

            if(hasPerk){
                //returns false if doesnt have all perks nd allperks is true
                if (allPerks) {
                    if(!characterHasPerk) {
                        isAvailable = false;
                        return;
                    }
                } else {
                    //returns true if has any of perk and allperks is false
                    if(characterHasPerk){
                        isAvailable = true;
                        return;
                    }
                }
            } else { //returns false if has any of perk
                if(characterHasPerk){
                    isAvailable = false;
                    return;
                }
            }
        }

        isAvailable = allPerks? true : false;
        wasChecked = true;
    }

    @Override
    public String getInfo() {
        String info = "";
        if(!hasPerk){
            info += "Not having ";
        }

        String conjunction = allPerks? "and" : "or";

        for(int i = 0; i < names.size()-1;i++){
            info += names.get(i) + " " + conjunction + " ";
        }


        info += names.get(names.size()-1) + " perk";

        if(names.size() > 1){
            info +="s";
        }


        return info;
    }
}
