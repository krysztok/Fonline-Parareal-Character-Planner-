package Core.Stats;

import Core.Character;

public class MeleeDamage extends Stat {
    //private int closeCombatMaster;
    private int bonusHthDamage;
    private int heavyHanded;
    private int rightHand;
    private int sweetScience;
    private int bruiser;

    public MeleeDamage(String name) {
        super(name);
        //closeCombatMaster = 0;
        bonusHthDamage = 0;
        heavyHanded = 0;
        rightHand = 0;
        sweetScience = 0;
        bruiser = 0;
    }

    @Override
    void calculateValue(Character character) {
        int stImpsAndPerks = character.getSpecials().getSpecialByName("Strength").getValueWithPerksAndImplants();
        int bruiser = character.getTraits().getTraitByName("Bruiser").isTaken()? 1 : 0;
        int base = stImpsAndPerks > 6 ? (1 + stImpsAndPerks - 6) : 1;
        base = bruiser == 1? (base * 2) : base;

        heavyHanded = character.getTraits().getTraitByName("Heavy Handed").isTaken()? 1 : 0;
        //closeCombatMaster = character.getPerks().getPerkByName("Close Combat Master").isTaken()? 1 : 0;
        bonusHthDamage = character.getPerks().getPerkByName("Bonus HtH Damage").isTaken()? 1 : 0;
        rightHand = character.getImplants().getImplantByName("Right Hand").isTaken()? 1 : 0;
        sweetScience = character.getMasteries().getMasteryByName("Sweet Science").isTaken()? 1 : 0;

        int finalValue = base + 7 * bonusHthDamage /*10 * closeCombatMaster */+ 5 * heavyHanded + 6 * rightHand + 10 * sweetScience;
        setValue(finalValue);
    }

    @Override
    public String toString() {
        return Integer.toString(getValue());
    }
}
