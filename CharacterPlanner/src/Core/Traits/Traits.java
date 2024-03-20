package Core.Traits;
import Core.Character;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Traits {
    private int traitsLimit;
    private int traitsTaken;
    private Map<String, Trait> traitsMap;

    public Traits(){
        traitsLimit = 2;
        traitsTaken = 0;
        traitsMap = new LinkedHashMap<>();

        Trait bloodyMess = new Trait("Bloody Mess");

        Trait bonehead = new Trait("Bonehead") {
            @Override
            public void takeTrait(Character character){
                setTaken(true);
                character.getSpecials().changeSpecialWithTrait("Intelligence", -1, false);
            }

            @Override
            public void takeOffTrait(Character character){
                setTaken(false);
                character.getSpecials().changeSpecialWithTrait("Intelligence", 1, false);
            }
        };

        Trait bruiser = new Trait("Bruiser"){
            @Override
            public void takeTrait(Character character){
                setTaken(true);
                character.getSpecials().changeSpecialWithTrait("Strength", 4, true);

                if(getTraitByName("Brutish Hulk").isTaken()){
                    character.getSpecials().changeSpecialWithTrait("Charisma", -1, false);
                }
            }

            @Override
            public void takeOffTrait(Character character){
                setTaken(false);
                character.getSpecials().changeSpecialWithTrait("Strength", -4, true);

                if(getTraitByName("Brutish Hulk").isTaken()){
                    character.getSpecials().changeSpecialWithTrait("Charisma", 1, false);
                }
            }
        };

        Trait brutishHulk = new Trait("Brutish Hulk"){
            @Override
            public void takeTrait(Character character){
                setTaken(true);
                int value = getTraitByName("Bruiser").isTaken()? -2 : -1;
                character.getSpecials().changeSpecialWithTrait("Charisma", value, false);
            }

            @Override
            public void takeOffTrait(Character character){
                setTaken(false);
                int value = getTraitByName("Bruiser").isTaken()? 2 : 1;
                character.getSpecials().changeSpecialWithTrait("Charisma", value, false);
            }
        };

        Trait chemReliant = new Trait("Chem Reliant");

        Trait fastMetabolism = new Trait("Fast Metabolism");

        Trait fastShot = new Trait("Fast Shot");

        Trait finesse = new Trait("Finesse");

        Trait gifted = new Trait("Gifted"){
            @Override
            public void takeTrait(Character character){
                setTaken(true);

                character.getSpecials().changeSpecialWithTrait("Strength", 1, true);
                character.getSpecials().changeSpecialWithTrait("Perception", 1, true);
                character.getSpecials().changeSpecialWithTrait("Endurance", 1, true);
                character.getSpecials().changeSpecialWithTrait("Charisma", 1, true);
                character.getSpecials().changeSpecialWithTrait("Intelligence", 1, true);
                character.getSpecials().changeSpecialWithTrait("Agility", 1, true);
                character.getSpecials().changeSpecialWithTrait("Luck", 1, true);

                //character.getSpecials().changeSpecialPointsByValue(5);
            }

            @Override
            public void takeOffTrait(Character character){
                setTaken(false);

                character.getSpecials().changeSpecialWithTrait("Strength", -1, true);
                character.getSpecials().changeSpecialWithTrait("Perception", -1, true);
                character.getSpecials().changeSpecialWithTrait("Endurance", -1, true);
                character.getSpecials().changeSpecialWithTrait("Charisma", -1, true);
                character.getSpecials().changeSpecialWithTrait("Intelligence", -1, true);
                character.getSpecials().changeSpecialWithTrait("Agility", -1, true);
                character.getSpecials().changeSpecialWithTrait("Luck", -1, true);

                //character.getSpecials().changeSpecialPointsByValue(-5);
            }
        };

        Trait goodNatured = new Trait("Good Natured");

        Trait heavyHanded = new Trait("Heavy Handed");

        Trait jinxed = new Trait("Jinxed");

        Trait kamikaze = new Trait("Kamikaze");

        Trait loner = new Trait("Loner");

        Trait oneHander = new Trait("One Hander");

        Trait smallFrame = new Trait("Small Frame"){
            @Override
            public void takeTrait(Character character){
                setTaken(true);
                character.getSpecials().changeSpecialWithTrait("Agility", 1, true);
            }

            @Override
            public void takeOffTrait(Character character){
                setTaken(false);
                character.getSpecials().changeSpecialWithTrait("Agility", -1, true);
            }
        };

        traitsMap.put(fastMetabolism.getName(), fastMetabolism);
        traitsMap.put(bruiser.getName(), bruiser);
        traitsMap.put(smallFrame.getName(), smallFrame);
        traitsMap.put(oneHander.getName(), oneHander);
        traitsMap.put(finesse.getName(), finesse);
        traitsMap.put(kamikaze.getName(), kamikaze);
        traitsMap.put(heavyHanded.getName(), heavyHanded);
        traitsMap.put(fastShot.getName(), fastShot);
        traitsMap.put(bloodyMess.getName(), bloodyMess);
        traitsMap.put(jinxed.getName(), jinxed);
        traitsMap.put(goodNatured.getName(), goodNatured);
        traitsMap.put(chemReliant.getName(), chemReliant);
        traitsMap.put(brutishHulk.getName(), brutishHulk);
        traitsMap.put(bonehead.getName(), bonehead);
        traitsMap.put(gifted.getName(), gifted);
        traitsMap.put(loner.getName(), loner);
    }

    public Trait getTraitByName(String name) {
        return traitsMap.get(name);
    }

    public List<String> getTraitsNames() {
        List<String> traitsNames = new ArrayList<String>();

        traitsMap.forEach((name, stat) -> {
            traitsNames.add(name);
        });

        return traitsNames;
    }

    public void takeTrait(Character character, String name) {
        Trait trait = getTraitByName(name);

        if(trait.isTaken()){
            traitsTaken--;
            trait.takeOffTrait(character);
        } else {
            if(traitsTaken < traitsLimit){
                traitsTaken++;
                trait.takeTrait(character);
            }
        }
    }

    public List<String> getTakenTraitsNames(){
        List<String> takenTraits = new ArrayList<>();
        traitsMap.forEach((name, trait) -> {
            if(trait.isTaken()){
                takenTraits.add(trait.getName());
            }
        });

        return takenTraits;
    }

    public int getTraitsLeft() {
        return traitsLimit - traitsTaken;
    }
}
