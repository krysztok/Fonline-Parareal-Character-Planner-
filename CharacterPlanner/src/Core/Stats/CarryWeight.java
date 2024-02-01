package Core.Stats;

import Core.Character;

public class CarryWeight extends Stat {
    private int smallFrame;
    private int strongBack;
    private int packRat;
    private int leftKnee;

    public CarryWeight(String name) {
        super(name);
        smallFrame = 0;
        strongBack = 0;
        packRat = 0;
        leftKnee = 0;
    }

    @Override
    void calculateValue(Character character) {
        int stDrugs = character.getSpecials().getSpecialByName("Strength").getFinalValue();
        smallFrame = character.getTraits().getTraitByName("Small Frame").isTaken()? 1 : 0;

        int baseStMultiplier = smallFrame == 0? 25 : 15;
        int base = (int)((( 25 + (stDrugs * baseStMultiplier)) / 2.2) + 20);

        strongBack = character.getSupportPerks().getPerkByName("Strong Back").isTaken()? 1 : 0;
        packRat = character.getSupportPerks().getPerkByName("Pack Rat").isTaken()? 1 : 0;

        leftKnee = character.getImplants().getImplantByName("Left Knee").isTaken()? 1 : 0;

        int finalValue =  (int)((base * (3 + packRat) / 3) + 22 * strongBack + 50 * leftKnee);
        setValue(finalValue);
    }

    @Override
    public String toString() {
        return Integer.toString(getValue());
    }
}
