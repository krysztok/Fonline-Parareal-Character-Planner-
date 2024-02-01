package Core.Stats;

import Core.Character;

public class ViewRange extends Stat{
    private int sharpshooter;

    public ViewRange(String name) {
        super(name);
        sharpshooter = 0;
    }

    @Override
    void calculateValue(Character character) {
        int peDrugs = character.getSpecials().getSpecialByName("Perception").getFinalValue();
        sharpshooter = character.getPerks().getPerkByName("Sharpshooter").isTaken()? 1 : 0;

        int finalValue = 20 + 3 * peDrugs + 6 * sharpshooter;
        setValue(finalValue);
    }

    @Override
    public String toString() {
        return Integer.toString(getValue());
    }
}
