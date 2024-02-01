package Core.Stats;

import Core.Character;

public class PartyPoints extends Stat {
    private int magneticPersonality;
    private int goodNatured;

    public PartyPoints(String name) {
        super(name);
        magneticPersonality = 0;
        goodNatured = 0;
    }

    @Override
    void calculateValue(Character character) {
        int speech = character.getSkills().getSkillByName("Speech").getSkillValue();
        int speechPP = (int)(speech / 3);
        int chDrugs = character.getSpecials().getSpecialByName("Charisma").getFinalValue();
        magneticPersonality = character.getSupportPerks().getPerkByName("Magnetic Personality").isTaken()? 1 : 0;
        goodNatured = character.getTraits().getTraitByName("Good Natured").isTaken()? 1 : 0;

        int finalValue = speechPP + 10 * chDrugs + 50 * magneticPersonality + 50 * goodNatured;
        setValue(finalValue);
    }

    @Override
    public String toString() {
        return Integer.toString(getValue());
    }
}
