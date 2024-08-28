package Core.Stats;

import Core.Character;

public class MovementSpeed extends Stat {
    private int heaveHo;
    private int dodger;
    private int closeCombatMaster;
    //private int bonusHthAttacks;
    //private int bonusHthDamage;
    private int bonusMove;
    private int smallFrame;
    private int heavyHanded;
    //private int rightKnee;
    private int actionBoy;
    private int bubblegum;

    public MovementSpeed(String name) {
        super(name);
        heaveHo = 0;
        dodger = 0;
        closeCombatMaster = 0;
        //bonusHthAttacks = 0;
        //bonusHthDamage = 0;
        bonusMove = 0;
        smallFrame = 0;
        heavyHanded = 0;
        //rightKnee = 0;
        actionBoy = 0;
        bubblegum = 0;
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

        actionBoy = 0;
        if (character.getPerks().getPerkByName("Action Boy(1)").isTaken()){
            actionBoy = 1;
            if (character.getPerks().getPerkByName("Action Boy(2)").isTaken()){
                actionBoy = 2;
            }
        }

        dodger = 0;
        if (character.getPerks().getPerkByName("Dodger(1)").isTaken()){
            dodger = 1;
            if (character.getPerks().getPerkByName("Dodger(2)").isTaken()){
                dodger = 2;
            }
        }

        //dodger = character.getPerks().getPerkByName("Dodger").isTaken()? 1 : 0;
        closeCombatMaster = character.getPerks().getPerkByName("Close Combat Master").isTaken()? 1 : 0;
        //bonusHthAttacks = character.getPerks().getPerkByName("Bonus HtH Attacks").isTaken()? 1 : 0;
        //bonusHthDamage = character.getPerks().getPerkByName("Bonus HtH Damage").isTaken()? 1 : 0;
        bonusMove = character.getPerks().getPerkByName("Bonus Move").isTaken()? 1 : 0;

        smallFrame = character.getTraits().getTraitByName("Small Frame").isTaken()? 1 : 0;
        heavyHanded = character.getTraits().getTraitByName("Heavy Handed").isTaken()? 1 : 0;
        bubblegum = character.getDrugs().getDrugByName("Bubblegum").isTaken()? 1 : 0;

        //rightKnee = character.getImplants().getImplantByName("Right Knee").isTaken()? 1 : 0;

        int finalValue = 5 * heaveHo + 5 * dodger + 5 * actionBoy + 5 * /*bonusHthDamage*/closeCombatMaster + /*5 * bonusHthAttacks */+ 10 * bonusMove + 5 * smallFrame - 10 * heavyHanded /* + 5 * rightKnee*/ + 5 * bubblegum;

        /*cap*/
        if (finalValue > 40 ){
            finalValue = 40;
        }

        setValue(finalValue);
    }

    @Override
    public String toString() {
        String valueStr = Integer.toString(getValue());
        return getValue() > 0 ? "+" + valueStr : valueStr;
    }
}
