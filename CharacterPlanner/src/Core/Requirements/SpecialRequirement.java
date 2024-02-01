package Core.Requirements;

import Core.Character;

public class SpecialRequirement extends Requirement{
    private String specialName;
    private int requiredValue;
    private Boolean moreOrEqual;

    public SpecialRequirement(String specialName, int requiredValue, Boolean moreOrEqual) {
        this.specialName = specialName;
        this.requiredValue = requiredValue;
        this.moreOrEqual = moreOrEqual;
        isAvailable = false;
    }

    @Override
    public void check(Character character) {
        if(wasChecked){
            return;
        }

        int specialValue = character.getSpecials().getSpecialByName(specialName).getValueWithPerksAndImplants();

        if((specialValue >= requiredValue && moreOrEqual) || (specialValue <= requiredValue && !moreOrEqual)){
            isAvailable = true;
        } else {
            isAvailable = false;
        }

        wasChecked = true;
    }

    @Override
    public String getInfo() {
        if(moreOrEqual){
            return specialName + " >= " + requiredValue;
        } else {
            return specialName + " &lt= " + requiredValue;
        }
    }
}
