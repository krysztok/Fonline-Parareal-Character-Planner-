package Core.Stats;

import Core.Character;

public class Sequence extends Stat{
    private int earlierSequence;

    public Sequence(String name) {
        super(name);
        earlierSequence = 0;
    }

    @Override
    void calculateValue(Character character) {
        int peDrugs = character.getSpecials().getSpecialByName("Perception").getFinalValue();
        earlierSequence = character.getPerks().getPerkByName("Earlier Sequence").isTaken()? 1 : 0;

        int finalValue = 2 * peDrugs + 2 * earlierSequence;
        setValue(finalValue);
    }

    @Override
    public String toString() {
        return Integer.toString(getValue());
    }
}
