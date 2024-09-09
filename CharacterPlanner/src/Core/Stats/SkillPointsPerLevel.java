package Core.Stats;

import Core.Character;

public class SkillPointsPerLevel extends Stat{
    //private int educated;
    //private int skilled;
    private int gifted;

    public SkillPointsPerLevel(String name) {
        super(name);
        //educated = 0;
        //skilled = 0;
        gifted = 0;
    }

    @Override
    void calculateValue(Character character) {
        //int inImpsAndPerks = character.getSpecials().getSpecialByName("Intelligence").getValueWithPerksAndImplants();
        //int base = 5 + 2 * inImpsAndPerks;
        int base = character.getLevel() < 30? 17 : 9;


        //educated = character.getSupportPerks().getPerkByName("Educated").isTaken()? 1 : 0;
        //skilled = character.getSupportPerks().getPerkByName("Skilled").isTaken()? 1 : 0;
        gifted = character.getTraits().getTraitByName("Gifted").isTaken()? 1 : 0;

        int finalValue = base /*+ 5 * skilled +*/ /*2 * educated*/;
        setValue(finalValue);
    }

    @Override
    public String toString() {
        return Integer.toString(getValue());
    }
}
