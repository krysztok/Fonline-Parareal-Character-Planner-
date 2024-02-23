package Core.Specials;

import Core.Character;

import java.util.*;

public class Specials {
    private int specialPointsToUse;
    private int baseValue;
    private Map<String, Special> specialMap;

    public Specials(){
        specialPointsToUse = 5;
        baseValue = 5;

        specialMap = new LinkedHashMap<>();

        Special strength = new Special("Strength", baseValue) {
            @Override
            void calculateFinalValue(Character character) {
                int jet = character.getDrugs().getDrugByName("Jet").isTaken()? 1 : 0;
                int buffout = character.getDrugs().getDrugByName("Buffout").isTaken()? 1 : 0;
                int psycho = character.getDrugs().getDrugByName("Psycho").isTaken()? 1 : 0;
                int roentgen = character.getDrugs().getDrugByName("Roentgen Rum").isTaken()? 1 : 0;

                int finalValue = getValueWithPerksAndImplants() - 2 * jet + 2 * buffout + psycho - roentgen;
                finalValue = finalValue > 10? 10 : finalValue;
                finalValue = finalValue < 1? 1 : finalValue;
                setFinalValue(finalValue);
            }

            @Override
            void calculateWithPerksAndImplantsValue(Character character) {
                int gainSpecial = character.getPerks().getPerkByName("Gain Strength").isTaken()? 1 : 0;
                int specialImplant = character.getImplants().getImplantByName("SPECIAL +1 ST").isTaken()? 1 : 0;
                int value = getBase() + gainSpecial + specialImplant;
                setWithPerksAndImplants(value > 10? 10 : value);
            }
        };

        Special perception = new Special("Perception", baseValue) {
            @Override
            void calculateFinalValue(Character character) {
                int beer = character.getDrugs().getDrugByName("Beer").isTaken()? 1 : 0;
                int cigs = character.getDrugs().getDrugByName("Cigarettes").isTaken()? 1 : 0;
                int psycho = character.getDrugs().getDrugByName("Psycho").isTaken()? 1 : 0;
                int mentats = character.getDrugs().getDrugByName("Mentats").isTaken()? 1 : 0;
                int booze = character.getDrugs().getDrugByName("Booze").isTaken()? 1 : 0;
                int roentgen = character.getDrugs().getDrugByName("Roentgen Rum").isTaken()? 1 : 0;
                int rotgut = character.getDrugs().getDrugByName("Rot Gut").isTaken()? 1 : 0;
                int fruit = character.getDrugs().getDrugByName("Fruit").isTaken()? 1 : 0;

                int mutie = character.getDrugs().getDrugByName("Mutie").isTaken()? 1 : 0;
                int mutant = character.getMasteries().getMasteryByName("Mutant").isTaken()? 1 : 0;
                int nightkin = character.getMasteries().getMasteryByName("Nightkin").isTaken()? 1 : 0;

                int finalValue = getValueWithPerksAndImplants() - 2 * beer + cigs - 2 * psycho + 2 * mentats - booze - 2 * roentgen - rotgut;
                if(character.getPerks().getPerkByName("Way of the Fruit").isTaken()) {
                    finalValue += 2 * fruit;
                }

                if(mutant == 1 || nightkin == 1) {
                    finalValue -= 2 * mutie;
                }

                finalValue = finalValue > 10? 10 : finalValue;
                finalValue = finalValue < 1? 1 : finalValue;
                setFinalValue(finalValue);
            }

            @Override
            void calculateWithPerksAndImplantsValue(Character character) {
                int gainSpecial = character.getPerks().getPerkByName("Gain Perception").isTaken()? 1 : 0;
                int specialImplant = character.getImplants().getImplantByName("SPECIAL +1 PE").isTaken()? 1 : 0;
                int value = getBase() + gainSpecial + specialImplant;
                setWithPerksAndImplants(value > 10? 10 : value);
            }
        };

        Special endurance = new Special("Endurance", baseValue) {
            @Override
            void calculateFinalValue(Character character) {
                int beer = character.getDrugs().getDrugByName("Beer").isTaken()? 1 : 0;
                int buffout = character.getDrugs().getDrugByName("Buffout").isTaken()? 1 : 0;
                int psycho = character.getDrugs().getDrugByName("Psycho").isTaken()? 1 : 0;
                int mentats = character.getDrugs().getDrugByName("Mentats").isTaken()? 1 : 0;
                int nuka = character.getDrugs().getDrugByName("Nuka-Cola").isTaken()? 1 : 0;
                int booze = character.getDrugs().getDrugByName("Booze").isTaken()? 1 : 0;
                int gamma = character.getDrugs().getDrugByName("Gamma Gulp Beer").isTaken()? 1 : 0;

                int finalValue = getValueWithPerksAndImplants() + beer + buffout + psycho - 2 * mentats - nuka - booze - 3 * gamma;
                finalValue = finalValue > 10? 10 : finalValue;
                finalValue = finalValue < 1? 1 : finalValue;
                setFinalValue(finalValue);
            }

            @Override
            void calculateWithPerksAndImplantsValue(Character character) {
                int gainSpecial = character.getPerks().getPerkByName("Gain Endurance").isTaken()? 1 : 0;
                int specialImplant = character.getImplants().getImplantByName("SPECIAL +1 EN").isTaken()? 1 : 0;
                int value = getBase() + gainSpecial + specialImplant;
                setWithPerksAndImplants(value > 10? 10 : value);
            }
        };

        Special charisma = new Special("Charisma", baseValue) {
            @Override
            void calculateFinalValue(Character character) {
                int beer = character.getDrugs().getDrugByName("Beer").isTaken()? 1 : 0;
                int gamma = character.getDrugs().getDrugByName("Gamma Gulp Beer").isTaken()? 1 : 0;
                int booze = character.getDrugs().getDrugByName("Booze").isTaken()? 1 : 0;
                int roentgen = character.getDrugs().getDrugByName("Roentgen Rum").isTaken()? 1 : 0;
                int cigs = character.getDrugs().getDrugByName("Cigarettes").isTaken()? 1 : 0;
                int jet = character.getDrugs().getDrugByName("Jet").isTaken()? 1 : 0;

                int finalValue = getValueWithPerksAndImplants() + beer + gamma + booze + roentgen - cigs - jet;

                finalValue = finalValue > 10? 10 : finalValue;
                finalValue = finalValue < 1? 1 : finalValue;
                setFinalValue(finalValue);
            }

            @Override
            void calculateWithPerksAndImplantsValue(Character character) {
                int gainSpecial = character.getPerks().getPerkByName("Gain Charisma").isTaken()? 1 : 0;
                int specialImplant = character.getImplants().getImplantByName("SPECIAL +1 CH").isTaken()? 1 : 0;
                int theGoodDoctor = character.getSupportPerks().getPerkByName("The Good Doctor").isTaken()? 1 : 0;
                int value = getBase() + gainSpecial + specialImplant + theGoodDoctor;
                setWithPerksAndImplants(value > 10? 10 : value);
            }
        };

        Special intelligence = new Special("Intelligence", baseValue) {
            @Override
            void calculateFinalValue(Character character) {
                int mentats = character.getDrugs().getDrugByName("Mentats").isTaken()? 1 : 0;
                int finalValue = getValueWithPerksAndImplants() + 2 * mentats;

                finalValue = finalValue > 10? 10 : finalValue;
                finalValue = finalValue < 1? 1 : finalValue;
                setFinalValue(finalValue);
            }

            @Override
            void calculateWithPerksAndImplantsValue(Character character) {
                int gainSpecial = character.getPerks().getPerkByName("Gain Intelligence").isTaken()? 1 : 0;
                int specialImplant = character.getImplants().getImplantByName("SPECIAL +1 IN").isTaken()? 1 : 0;
                int value = getBase() + gainSpecial + specialImplant;
                setWithPerksAndImplants(value > 10? 10 : value);
            }
        };

        Special agility = new Special("Agility", baseValue) {
            @Override
            void calculateFinalValue(Character character) {
                int buffout = character.getDrugs().getDrugByName("Buffout").isTaken()? 1 : 0;
                int gamma = character.getDrugs().getDrugByName("Gamma Gulp Beer").isTaken()? 1 : 0;

                int mutie = character.getDrugs().getDrugByName("Mutie").isTaken()? 1 : 0;
                int mutant = character.getMasteries().getMasteryByName("Mutant").isTaken()? 1 : 0;
                int nightkin = character.getMasteries().getMasteryByName("Nightkin").isTaken()? 1 : 0;

                int finalValue = getValueWithPerksAndImplants() + 2 * gamma - buffout;

                if(mutant == 1 || nightkin == 1) {
                    finalValue += 3 * mutie;
                }

                finalValue = finalValue > 10? 10 : finalValue;
                finalValue = finalValue < 1? 1 : finalValue;
                setFinalValue(finalValue);
            }

            @Override
            void calculateWithPerksAndImplantsValue(Character character) {
                int gainSpecial = character.getPerks().getPerkByName("Gain Agility").isTaken()? 1 : 0;
                int specialImplant = character.getImplants().getImplantByName("SPECIAL +1 AG").isTaken()? 1 : 0;
                int value = getBase() + gainSpecial + specialImplant;
                setWithPerksAndImplants(value > 10? 10 : value);
            }
        };

        Special luck = new Special("Luck", baseValue) {
            @Override
            void calculateFinalValue(Character character) {
                int booze = character.getDrugs().getDrugByName("Booze").isTaken()? 1 : 0;

                int finalValue = getValueWithPerksAndImplants() + 2 * booze;
                finalValue = finalValue > 10? 10 : finalValue;
                finalValue = finalValue < 1? 1 : finalValue;
                setFinalValue(finalValue);
            }

            @Override
            void calculateWithPerksAndImplantsValue(Character character) {
                int gainSpecial = character.getPerks().getPerkByName("Gain Luck").isTaken()? 1 : 0;
                int specialImplant = character.getImplants().getImplantByName("SPECIAL +1 LK").isTaken()? 1 : 0;
                int value = getBase() + gainSpecial + specialImplant;
                setWithPerksAndImplants(value > 10? 10 : value);
            }
        };

        specialMap.put(strength.getName(), strength);
        specialMap.put(perception.getName(), perception);
        specialMap.put(endurance.getName(), endurance);
        specialMap.put(charisma.getName(), charisma);
        specialMap.put(intelligence.getName(), intelligence);
        specialMap.put(agility.getName(), agility);
        specialMap.put(luck.getName(), luck);
    }

    public void changeSpecialWithTrait(String name, int value, boolean changeMinimum){
        specialPointsToUse += specialMap.get(name).changeSpecialWithTrait(value, changeMinimum);
    }

    public void changeSpecialWithButton(String name, boolean add){
        Special special = getSpecialByName(name);

        if(add && specialPointsToUse <= 0){
            return;
        }

        if(add  && special.getBase() == special.getMaximum() || !add && special.getBase() == special.getMinimum()){
            return;
        }

        if(add){
            special.changeBaseByPoints(1);
            specialPointsToUse--;
        } else {
            special.changeBaseByPoints(-1);
            specialPointsToUse++;
        }
    }

    public int getSpecialPointsToUse() {
        return specialPointsToUse;
    }

    public Special getSpecialByName(String name){
        return specialMap.get(name);
    }

    public List<String> getSpecialsNames() {
        List<String> specialsNames = new ArrayList<String>();

        specialMap.forEach((name, stat) -> {
            specialsNames.add(name);
        });

        return specialsNames;
    }

    public void calculateSpecialValues(Character character){
        specialMap.forEach((name, special) -> {
            special.calculateWithPerksAndImplantsValue(character);
            special.calculateFinalValue(character);});
    }

    public List<Integer> getSpecialsBaseValues(){
        List<Integer> values = new ArrayList<>();
        specialMap.forEach((name, special) -> values.add(special.getBase()));
        return  values;
    }

    public List<Integer> getSpecialsFinalValues(){
        List<Integer> values = new ArrayList<>();
        specialMap.forEach((name, special) -> values.add(special.getFinalValue()));
        return  values;
    }

    public void changeSpecialPointsByValue(int value) {
        specialPointsToUse += value;
    }

}
