package Core.Stats;

import Core.Character;

public class HealingRate extends Stat {
    private int fasterHealing;
    private int livingAnatomy;
    private int adrenalEnhancement;
    private int mutant;
    private int wonderlandHr;
    private int roentgen;
    private int cookie;
    private int bruiser;
    private int mutie;

    public HealingRate(String name) {
        super(name);
        fasterHealing = 0;
        livingAnatomy = 0;
        mutant = 0;
        adrenalEnhancement = 0;
        cookie = 0;
        wonderlandHr = 0;
        roentgen = 0;
        bruiser = 0;
        mutie = 0;
    }

    @Override
    void calculateValue(Character character) {
        int enImpsAndPerks = character.getSpecials().getSpecialByName("Endurance").getValueWithPerksAndImplants();
        int base = (int)(7 + enImpsAndPerks / 2);
        fasterHealing = character.getSupportPerks().getPerkByName("Faster Healing").isTaken()? 1 : 0;
        livingAnatomy = character.getPerks().getPerkByName("Living Anatomy").isTaken()? 1 : 0;
        adrenalEnhancement = character.getImplants().getImplantByName("Adrenal Enhancer").isTaken()? 1 : 0;
        mutant = character.getMasteries().getMasteryByName("Mutant").isTaken()? 1 : 0;
        wonderlandHr = character.getSupportPerks().getPerkByName("Basic Field Medicine").isTaken()? 1 : 0;
        roentgen = character.getDrugs().getDrugByName("Roentgen Rum").isTaken()? 1 : 0;
        cookie = character.getDrugs().getDrugByName("Cookie").isTaken()? 1 : 0;
        bruiser = character.getTraits().getTraitByName("Bruiser").isTaken()? 1 : 0;
        mutie = character.getDrugs().getDrugByName("Mutie").isTaken()? 1 : 0;

        int finalValue = base + 20 * fasterHealing + 30 * livingAnatomy + 10 * adrenalEnhancement + 10 * mutant + 20 * wonderlandHr + 20 * roentgen + 20 * cookie - 10 * bruiser - 20 * mutie;

        finalValue = finalValue<0? 0 : finalValue;
        setValue(finalValue);
    }

    @Override
    public String toString() {
        return Integer.toString(getValue());
    }
}
