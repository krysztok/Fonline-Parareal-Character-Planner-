package Core.Stats;

import Core.Character;

public class MovementSpeed extends Stat {
    private int heaveHo;
    private int dodger;
    private int closeCombatMaster;
    private int bonusMove;
    private int smallFrame;
    private int heavyHanded;
    private int rightKnee;

    public MovementSpeed(String name) {
        super(name);
        heaveHo = 0;
        dodger = 0;
        closeCombatMaster = 0;
        bonusMove = 0;
        smallFrame = 0;
        heavyHanded = 0;
        rightKnee = 0;
    }

    @Override
    void calculateValue(Character character) {
        heaveHo = 0;
        if (character.getPerks().getPerkByName("Heave Ho!").isTaken()){
            heaveHo = 1;
            if (character.getPerks().getPerkByName("Heave Ho!!").isTaken()){
                heaveHo = 2;
            }
        }

        dodger = character.getPerks().getPerkByName("Dodger(1)").isTaken()? 1 : 0;
        closeCombatMaster = character.getPerks().getPerkByName("Close Combat Master").isTaken()? 1 : 0;
        bonusMove = character.getPerks().getPerkByName("Bonus Move").isTaken()? 1 : 0;

        smallFrame = character.getTraits().getTraitByName("Small Frame").isTaken()? 1 : 0;
        heavyHanded = character.getTraits().getTraitByName("Heavy Handed").isTaken()? 1 : 0;

        rightKnee = character.getImplants().getImplantByName("Right Knee").isTaken()? 1 : 0;

        int finalValue = 5 * heaveHo + 5 * dodger + 5 * closeCombatMaster + 10 * bonusMove + 5 * smallFrame - 10 * heavyHanded + 5 * rightKnee;
        setValue(finalValue);
    }

    @Override
    public String toString() {
        String valueStr = Integer.toString(getValue());
        return getValue() > 0 ? "+" + valueStr : valueStr;
    }
}
