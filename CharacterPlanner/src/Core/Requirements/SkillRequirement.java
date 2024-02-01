package Core.Requirements;

import Core.Character;

import java.util.ArrayList;
import java.util.List;

public class SkillRequirement extends Requirement{
    private List<String> names;
    private int requiredValue;
    private Boolean moreOrEqual;

    public SkillRequirement (String name, int requiredValue, Boolean moreOrEqual) {
        this.requiredValue = requiredValue;
        this.moreOrEqual = moreOrEqual;
        names = new ArrayList<String>();
        names.add(name);
        isAvailable = false;
    }

    public SkillRequirement (List<String> names, int requiredValue, Boolean moreOrEqual) {
        this.names = names;
        this.requiredValue = requiredValue;
        this.moreOrEqual = moreOrEqual;
    }

    @Override
    public void check(Character character) {
        if(wasChecked){
            return;
        }

        if(moreOrEqual){ //checking if any of skills is higher or equal
            for(int i = 0; i < names.size(); i++){
                int skillValue = character.getSkills().getSkillByName(names.get(i)).getSkillValue();
                if(skillValue >= requiredValue){
                    isAvailable = true;
                    return;
                }
            }
            isAvailable = false;
        } else { //checking if all skills are lower or equal
            for(int i = 0; i < names.size(); i++){
                int skillValue = character.getSkills().getSkillByName(names.get(i)).getSkillValue();
                if(skillValue > requiredValue){
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

        for(int i = 0; i < names.size()-1; i++ ){
            info += names.get(i);
            if(moreOrEqual){
                info += " or ";
            } else {
                info += " and ";
            }
        }

        info += names.get(names.size()-1);

        if(moreOrEqual){
            info += " >= ";
        } else {
            info += " &lt= ";
        }

        info += requiredValue;

        return info;
    }
}
