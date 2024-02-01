package Core.Stats;

import Core.Character;

public class HitPointsPerLevel extends Stat{
    private boolean odd;
    private int brutishHulk;
    private int bruiser;

    public HitPointsPerLevel(String name) {
        super(name);
        odd = false;
        brutishHulk = 0;
        bruiser = 0;
    }

    @Override
    void calculateValue(Character character) {
        int endImpsAndPerks = character.getSpecials().getSpecialByName("Endurance").getValueWithPerksAndImplants();
        bruiser = character.getTraits().getTraitByName("Bruiser").isTaken()? 1 : 0;
        brutishHulk = character.getTraits().getTraitByName("Brutish Hulk").isTaken()? 1 : 0;

        odd = endImpsAndPerks%2 != 0? true : false;

        int finalValue = (int)(0.5 * endImpsAndPerks);

        if(brutishHulk > 0){
            finalValue = bruiser > 0 ? finalValue + 2 : finalValue + 1;
        }

        setValue(finalValue);
    }

    @Override
    public String toString() {
        String string = "" + getValue();
        if(odd){
            string += " - " +  (getValue() + 1);
        }

        return string;
    }
}
