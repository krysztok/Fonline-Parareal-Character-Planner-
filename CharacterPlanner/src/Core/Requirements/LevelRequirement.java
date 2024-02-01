package Core.Requirements;


import Core.Character;

public class LevelRequirement extends Requirement{
    private int requiredLevel;
    private boolean moreOrEqual;

    public LevelRequirement(int requiredLevel, boolean moreOrEqual){
        this.requiredLevel = requiredLevel;
        this.moreOrEqual = moreOrEqual;
        isAvailable = false;
    }

    @Override
    public void check(Character character) {
        if(wasChecked){
            return;
        }

        int level = character.getLevel();

        if((level >= requiredLevel && moreOrEqual) || (level <= requiredLevel && !moreOrEqual)){
            isAvailable = true;
        } else {
            isAvailable = false;
        }

        wasChecked = true;
    }

    @Override
    public String getInfo() {
        if(moreOrEqual){
            return ("Level >= " + requiredLevel);
        } else {
          return ("Level &lt= " + requiredLevel);
        }
    }
}
