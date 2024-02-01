package Core.Skills;

import Core.Character;

import java.util.*;

public class Skills {
    private int skillPoints;
    private int skillTagsLeft;
    private Map<String, Skill> skillsMap;

    public Skills(){
        skillPoints = 0;
        skillTagsLeft = 3;

        skillsMap = new LinkedHashMap<>();

        Skill smallGuns = new Skill("Small Guns", 300) {
            @Override
            void calculateBaseValue(Character character) {
                int boneyardGuard = character.getSupportPerks().getPerkByName("Boneyard Guard sg").isTaken()? 1 : 0;
                int tagged = isSkillTagged()? 20:0;
                //int gifted = character.getTraits().getTraitByName("Gifted").isTaken()? 10 : 0;

                int agility = character.getSpecials().getSpecialByName("Agility").getBase();
                setSkillBase(5 + 4 * agility + 10 * boneyardGuard + tagged /*- gifted*/);
            }
        };

        Skill bigGuns = new Skill("Big Guns",300) {
            @Override
            void calculateBaseValue(Character character) {
                int boneyardGuard = character.getSupportPerks().getPerkByName("Boneyard Guard bg").isTaken()? 1 : 0;
                int tagged = isSkillTagged()? 20:0;
                //int gifted = character.getTraits().getTraitByName("Gifted").isTaken()? 10 : 0;

                int agility = character.getSpecials().getSpecialByName("Agility").getBase();
                setSkillBase(2 * agility + 10 * boneyardGuard + tagged /*- gifted*/);
            }
        };

        Skill energyWeapons = new Skill("Energy Weapons",300) {
            @Override
            void calculateBaseValue(Character character) {
                int boneyardGuard = character.getSupportPerks().getPerkByName("Boneyard Guard ew").isTaken()? 1 : 0;
                int tagged = isSkillTagged()? 20:0;
                //int gifted = character.getTraits().getTraitByName("Gifted").isTaken()? 10 : 0;

                int agility = character.getSpecials().getSpecialByName("Agility").getBase();
                setSkillBase(2 * agility + 10 * boneyardGuard + tagged /*- gifted*/);
            }
        };

        Skill closeCombat = new Skill("Close Combat", 300) {
            @Override
            void calculateBaseValue(Character character) {
                int boneyardGuard = character.getSupportPerks().getPerkByName("Boneyard Guard cc").isTaken()? 1 : 0;
                int tagged = isSkillTagged()? 20:0;
               // int gifted = character.getTraits().getTraitByName("Gifted").isTaken()? 10 : 0;

                int strength = character.getSpecials().getSpecialByName("Strength").getBase();
                int agility = character.getSpecials().getSpecialByName("Agility").getBase();
                setSkillBase(30 + 2 * (strength + agility) + 10 * boneyardGuard + tagged /*- gifted*/);
            }
        };

        Skill scavenger = new Skill("Scavenger", 300) {
            @Override
            void calculateBaseValue(Character character) {
                //int tagged = isSkillTagged()? 20:0;
                //int gifted = character.getTraits().getTraitByName("Gifted").isTaken()? 10 : 0;
                //setSkillBase(1 + tagged - gifted);
                setSkillBase(0);
            }
        };

        Skill throwing = new Skill("Throwing", 300) {
            @Override
            void calculateBaseValue(Character character) {
                int boneyardGuard = character.getSupportPerks().getPerkByName("Boneyard Guard th").isTaken()? 1 : 0;
                int tagged = isSkillTagged()? 20:0;
               // int gifted = character.getTraits().getTraitByName("Gifted").isTaken()? 10 : 0;

                int agility = character.getSpecials().getSpecialByName("Agility").getBase();
                setSkillBase(4 * agility + 10 * boneyardGuard + tagged /*- gifted*/);
            }
        };

        Skill firstAid = new Skill("First Aid",200) {
            @Override
            void calculateBaseValue(Character character) {
                int perception = character.getSpecials().getSpecialByName("Perception").getBase();
                int intelligence = character.getSpecials().getSpecialByName("Intelligence").getBase();
                int tagged = isSkillTagged()? 20:0;
               // int gifted = character.getTraits().getTraitByName("Gifted").isTaken()? 10 : 0;

                setSkillBase(4 * (perception + intelligence) + tagged /*- gifted*/);
            }
        };

        Skill doctor = new Skill("Doctor",200) {
            @Override
            void calculateBaseValue(Character character) {
                int perception = character.getSpecials().getSpecialByName("Perception").getBase();
                int intelligence = character.getSpecials().getSpecialByName("Intelligence").getBase();
                int tagged = isSkillTagged()? 20:0;
               // int gifted = character.getTraits().getTraitByName("Gifted").isTaken()? 10 : 0;

                setSkillBase(5 + perception + intelligence + tagged /*- gifted*/);
            }
        };

        Skill sneak = new Skill("Sneak",300) {
            @Override
            void calculateBaseValue(Character character) {
                int agility = character.getSpecials().getSpecialByName("Agility").getBase();
                int tagged = isSkillTagged()? 20:0;
               // int gifted = character.getTraits().getTraitByName("Gifted").isTaken()? 10 : 0;

                setSkillBase(5 + 3 * agility + tagged /*- gifted*/);
            }
        };

        Skill lockpick = new Skill("Lockpick",150) {
            @Override
            void calculateBaseValue(Character character) {
                int perception = character.getSpecials().getSpecialByName("Perception").getBase();
                int agility = character.getSpecials().getSpecialByName("Agility").getBase();
                int tagged = isSkillTagged()? 20:0;
               // int gifted = character.getTraits().getTraitByName("Gifted").isTaken()? 10 : 0;

                setSkillBase(10 + perception + agility + tagged /*- gifted*/);
            }
        };

        Skill steal = new Skill("Steal",150) {
            @Override
            void calculateBaseValue(Character character) {
                int agility = character.getSpecials().getSpecialByName("Agility").getBase();
                int tagged = isSkillTagged()? 20:0;
                //int gifted = character.getTraits().getTraitByName("Gifted").isTaken()? 10 : 0;

                setSkillBase(3 * agility + tagged /*- gifted*/);
            }
        };

        Skill traps = new Skill("Traps",150) {
            @Override
            void calculateBaseValue(Character character) {
                int perception = character.getSpecials().getSpecialByName("Perception").getBase();
                int agility = character.getSpecials().getSpecialByName("Agility").getBase();
                int tagged = isSkillTagged()? 20:0;
             //   int gifted = character.getTraits().getTraitByName("Gifted").isTaken()? 10 : 0;

                setSkillBase(10 + perception + agility + tagged /*- gifted*/);
            }
        };

        Skill science = new Skill("Science",125) {
            @Override
            void calculateBaseValue(Character character) {
                int intelligence = character.getSpecials().getSpecialByName("Intelligence").getBase();
                int tagged = isSkillTagged()? 20:0;
               // int gifted = character.getTraits().getTraitByName("Gifted").isTaken()? 10 : 0;

                setSkillBase(4 * intelligence + tagged /*- gifted*/);
            }
        };

        Skill repair = new Skill("Repair",125) {
            @Override
            void calculateBaseValue(Character character) {
                int intelligence = character.getSpecials().getSpecialByName("Intelligence").getBase();
                int tagged = isSkillTagged()? 20:0;
               // int gifted = character.getTraits().getTraitByName("Gifted").isTaken()? 10 : 0;

                setSkillBase(3 * intelligence + tagged /*- gifted*/);
            }
        };

        Skill speech = new Skill("Speech",300) {
            @Override
            void calculateBaseValue(Character character) {
                int charisma = character.getSpecials().getSpecialByName("Charisma").getBase();
                int tagged = isSkillTagged()? 20:0;
              //  int gifted = character.getTraits().getTraitByName("Gifted").isTaken()? 10 : 0;

                setSkillBase(5 * charisma + tagged /*- gifted*/);
            }
        };

        Skill barter = new Skill("Barter",150) {
            @Override
            void calculateBaseValue(Character character) {
                int charisma = character.getSpecials().getSpecialByName("Charisma").getBase();
                int tagged = isSkillTagged()? 20:0;
              //  int gifted = character.getTraits().getTraitByName("Gifted").isTaken()? 10 : 0;

                setSkillBase(4 * charisma + tagged /*- gifted*/);
            }
        };

        Skill gambling = new Skill("Gambling",300) {
            @Override
            void calculateBaseValue(Character character) {
                int luck = character.getSpecials().getSpecialByName("Luck").getBase();
                int tagged = isSkillTagged()? 20:0;
              //  int gifted = character.getTraits().getTraitByName("Gifted").isTaken()? 10 : 0;

                setSkillBase(5 * luck + tagged /*- gifted*/);
            }
        };

        Skill outdoorsman = new Skill("Outdoorsman",175) {
            @Override
            void calculateBaseValue(Character character) {
                int intelligence = character.getSpecials().getSpecialByName("Intelligence").getBase();
                int endurance = character.getSpecials().getSpecialByName("Endurance").getBase();
                int tagged = isSkillTagged()? 20:0;
              //  int gifted = character.getTraits().getTraitByName("Gifted").isTaken()? 10 : 0;

                setSkillBase(2 * (intelligence + endurance) + tagged /*- gifted*/);
            }
        };

        skillsMap.put(smallGuns.getName(), smallGuns);
        skillsMap.put(bigGuns.getName(), bigGuns);
        skillsMap.put(energyWeapons.getName(), energyWeapons);
        skillsMap.put(closeCombat.getName(), closeCombat);
        skillsMap.put(scavenger.getName(), scavenger);
        skillsMap.put(throwing.getName(), throwing);
        skillsMap.put(firstAid.getName(), firstAid);
        skillsMap.put(doctor.getName(), doctor);
        skillsMap.put(sneak.getName(), sneak);
        skillsMap.put(lockpick.getName(), lockpick);
        skillsMap.put(steal.getName(), steal);
        skillsMap.put(traps.getName(), traps);
        skillsMap.put(science.getName(), science);
        skillsMap.put(repair.getName(), repair);
        skillsMap.put(speech.getName(), speech);
        skillsMap.put(barter.getName(), barter);
        skillsMap.put(gambling.getName(), gambling);
        skillsMap.put(outdoorsman.getName(), outdoorsman);
    }

    public Skill getSkillByName(String name){
        return skillsMap.get(name);
    }

    public List<String> getSkillsNames() {
        List<String> skillsNames = new ArrayList<String>();

        skillsMap.forEach((name, stat) -> {
            skillsNames.add(name);
        });

        return skillsNames;
    }

    public void calculateSkillsValues(Character character) {
        skillsMap.forEach((name, skill) -> skill.calculateBaseValue(character));
    }

    public List<Integer> getSkillsValues(){
        List<Integer> values = new ArrayList<>();
        skillsMap.forEach((name, skill) -> values.add(skill.getSkillValue()));
        return  values;
    }

    public List<Integer> getSkillPointsValues() {
        List<Integer> values = new ArrayList<>();
        skillsMap.forEach((name, skill) -> values.add(skill.getSkillPointsUsed()));
        return  values;
    }

    public int getSkillPoints() {
        return skillPoints;
    }

    public int getSkillTagsLeft() {
        return skillTagsLeft;
    }

    public void setTagSkill(String skillName) {
        if(skillName.equals("Scavenger")) {
            return;
        }

        Skill skill = getSkillByName(skillName);


        if(skill.isSkillTagged()){
            skillTagsLeft++;
            skill.setSkillTagged(false);
        } else if(skillTagsLeft > 0) {
            skillTagsLeft--;
            skill.setSkillTagged(true);
        }
    }

    public List<String> getTaggedSkills() {
        List<String> taggedSkills = new ArrayList<>();

        skillsMap.forEach((name, skill) -> {
            if(skill.isSkillTagged()){
                taggedSkills.add(skill.getName());
            }
        });

        return taggedSkills;
    }

    public void addSkillPoints(int points) {
        skillPoints += points;
    }

    public void putSkillPointByButton(String skillName, boolean addPoint) {
        if(skillName.equals("Scavenger")) {
            return;
        }

        Skill skill = getSkillByName(skillName);

        if(addPoint){
            int cost = skill.getCost();
            if(cost > skillPoints || skill.isMax()) {
                return;
            }

            skillPoints -= cost;
            skill.addPointToTmp();
        } else {
            if(skill.getSkillAddedTmp() <= 0) {
                return;
            }

            skill.removePointFromTmp();
            skillPoints += skill.getCost();
        }
    }

    public void confirmSkills(){
        skillsMap.forEach((name, skill) -> {
            skill.confirmSkill();
        });
    }
}
