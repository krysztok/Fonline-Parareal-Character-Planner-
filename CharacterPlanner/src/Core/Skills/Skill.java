package Core.Skills;

import Core.Character;

public abstract class Skill {
    private String name;
    private int skillAdded;
    private int skillBase;
    private int skillAddedTmp;
    private boolean isSkillTagged;
    private int skillCap;
    private int skillPointsUsed;

    public Skill (String skillName, int skillCap){
        this.name = skillName;
        this.skillAdded = 0;
        this.skillAddedTmp = 0;
        this.isSkillTagged = false;
        this.skillCap = skillCap;
        this.skillPointsUsed = 0;
    }

    public int getCost(){
        int cost = 1;
        int skillValue = getSkillValue();

        if(skillValue < 101){
            cost = 1;
        } else if(skillValue < 126){
            cost = 2;
        } else if(skillValue < 151){
            cost = 3;
        } else if(skillValue < 176){
            cost = 4;
        }else if(skillValue < 201){
            cost = 5;
        } else {
            cost = 6;
        }

        return cost;
    }

    //for books
    public void putSkillPoints(int value){
        int sp = 1;
        if(isSkillTagged){
            sp = 2;
        }

        if(isMax()){
            return;
        }

        int tmp = value;

        while(tmp > 0){
            tmp -= getCost();
            if(tmp >= 0){
                skillAdded+=sp;
            }
        }
    }

    public void confirmSkill(){
        skillAdded += skillAddedTmp;
        skillAddedTmp = 0;
    }

    public void addPointToTmp(){
        int sp = 1;
        if(isSkillTagged){
            sp = 2;
        }
        skillPointsUsed += getCost();
        skillAddedTmp += sp;
    }

    public void removePointFromTmp(){
        int sp = 1;
        if(isSkillTagged){
            sp = 2;
        }
        skillAddedTmp -= sp;
        skillPointsUsed -= getCost();
    }

    public String getName() {
        return name;
    }

    abstract void calculateBaseValue(Character character);

    public boolean isMax(){
        return getSkillValue() >= skillCap;
    }

    public int getSkillAddedTmp() {
        return skillAddedTmp;
    }

    public void setSkillTagged(boolean skillTagged) {
        isSkillTagged = skillTagged;
    }

    public boolean isSkillTagged() {
        return isSkillTagged;
    }

    public void addSkillAdded(int value) {
        this.skillAdded = skillAdded + value;
    }

    public void setSkillBase(int skillBase) {
        this.skillBase = skillBase;
    }

    public int getSkillAdded() {
        return skillAdded;
    }

    public int getSkillValue(){
        int value = skillBase + skillAdded + skillAddedTmp;
        return value > skillCap? skillCap : value;
    }

    public int getSkillPointsUsed() {
        return skillPointsUsed;
    }

    public String getSkillValueString(){
        return Integer.toString(getSkillValue());
    }
}
