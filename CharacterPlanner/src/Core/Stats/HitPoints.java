package Core.Stats;

import Core.Character;

public class HitPoints extends Stat {
    private int hpFromLevels;
    private int lifegivers;
    private int nemeans;
    private int noiception;
    private int mutant;
    private int nightkin;
    private int tank;
    private int wonderlandHp;
    private int bakedFish;
    private int buffout;
    private int rotgut;
    private int cookie;
    private int smittysMeal;
    private int enduranceImp;
    private Boolean isOdd;
    private int brutishHulk;
    private int bruiser;

    public HitPoints(String name) {
        super(name);
        hpFromLevels = 0;
        lifegivers = 0;
        nemeans = 0;
        noiception = 0;
        mutant = 0;
        nightkin = 0;
        tank = 0;
        wonderlandHp = 0;
        bakedFish = 0;
        buffout = 0;
        rotgut = 0;
        cookie = 0;
        smittysMeal = 0;
        enduranceImp = 0;
        isOdd = false;
        brutishHulk = 0;
        bruiser = 0;
    }

    @Override
    void calculateValue(Character character) {
        int stImpsAndPerks = character.getSpecials().getSpecialByName("Strength").getValueWithPerksAndImplants();
        int baseEnd = character.getSpecials().getSpecialByName("Endurance").getValueWithPerksAndImplants();
        int base = 55 + stImpsAndPerks + 2 * baseEnd;

        /*hp from levels*/
        int level = character.getLevel() < 25? character.getLevel() : 24;
        int hpPerLevel = character.getStats().getStatByName("HP/Level").getValue();
        isOdd = baseEnd%2 != 0? true : false;
        hpFromLevels = (level-1) * hpPerLevel; //-1 because no added hp on 1st level
        if(isOdd){
            hpFromLevels += (int)(level/2);
        }

        /*hp from traits*/
        bruiser = character.getTraits().getTraitByName("Bruiser").isTaken()? 1 : 0;
        brutishHulk = character.getTraits().getTraitByName("Brutish Hulk").isTaken()? 1 : 0;
        int hpFromTraits = (int)((level-1)/2) * brutishHulk;

        if(bruiser == 1){
            hpFromTraits*=2;
        }

        /*hp from implants, perks, masteries and drugs*/
        nemeans = 0;
        if(character.getImplants().getImplantByName("Nemean Armor(1)").isTaken()){
            nemeans = 1;
            if(character.getImplants().getImplantByName("Nemean Armor(2)").isTaken()){
                nemeans = 2;
            }
        }

        noiception = character.getImplants().getImplantByName("Nociception clamp").isTaken()? 1 : 0;
        enduranceImp = character.getImplants().getImplantByName("SPECIAL +1 EN").isTaken()? 1 : 0;

        lifegivers = 0;
        if (character.getPerks().getPerkByName("Lifegiver(1)").isTaken()){
            lifegivers = 1;
            if (character.getPerks().getPerkByName("Lifegiver(2)").isTaken()){
                lifegivers = 2;
                if (character.getPerks().getPerkByName("Lifegiver(3)").isTaken()){
                    lifegivers = 3;
                }
            }
        }

        wonderlandHp = character.getSupportPerks().getPerkByName("Surviving in the wild").isTaken()? 1 : 0;
        smittysMeal = character.getSupportPerks().getPerkByName("Smitty's Meal").isTaken()? 1 : 0;

        mutant = character.getMasteries().getMasteryByName("Mutant").isTaken()? 1 : 0;
        nightkin = character.getMasteries().getMasteryByName("Nightkin").isTaken()? 1 : 0;
        tank = character.getMasteries().getMasteryByName("Tank").isTaken()? 1 : 0;

        buffout = character.getDrugs().getDrugByName("Buffout").isTaken()? 1 : 0;
        rotgut = character.getDrugs().getDrugByName("Rot Gut").isTaken()? 1 : 0;
        cookie = character.getDrugs().getDrugByName("Cookie").isTaken()? 1 : 0;
        bakedFish = character.getDrugs().getDrugByName("Baked Fish").isTaken()? 1 : 0;


        int finalValue = base + hpFromLevels + hpFromTraits + 20 * nemeans + 50 * noiception + 40 * lifegivers + 100 * mutant +
                50 * nightkin + 20 * tank + 15 * buffout + 15 * bakedFish - 10 * rotgut + 10 * cookie + 10 * wonderlandHp +
                5 * smittysMeal + 2 * enduranceImp;

        setValue(finalValue);
    }

    @Override
    public String toString() {
        return Integer.toString(getValue());
    }
}
