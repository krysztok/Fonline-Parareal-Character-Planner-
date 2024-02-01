package GUI;

import Core.Character;
import Core.Requirements.Requirement;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ToolTipsGenerator {

    Map<String, String> traitsTipsMap;
    Map<String, String> drugsTipsMap;
    Map<String, String> perksTipsMap;
    Map<String, String> masteriesTipsMap;
    Map<String, String> implantsTipsMap;
    Map<String, String> supportsTipsMap;

   public ToolTipsGenerator(){
       traitsTipsMap = new LinkedHashMap<>();
       drugsTipsMap = new LinkedHashMap<>();
       perksTipsMap = new LinkedHashMap<>();
       masteriesTipsMap = new LinkedHashMap<>();
       implantsTipsMap = new LinkedHashMap<>();
       supportsTipsMap = new LinkedHashMap<>();
   }



   public void generateNotChangingTips() {
        traitsTipsMap.put("Bloody Mess", "<html>Bloody Mess <br> (+) Violent death animations <br> (+) +5% to your Critical Chance <br> <font color=\"red\">(-) -3 penalty to all Damage Resistance values</font></html>");
        traitsTipsMap.put("Bonehead", "<html>Bonehead <br> (+) -10 to critical roll of attacks aimed to your head/eyes <br> <font color=\"red\">(-) -1 Intelligence</font></html>");
        traitsTipsMap.put("Bruiser", "<html>Bruiser <br> (+) +4 Strength<br> (+) Doubled base melee damage  <br> <font color=\"red\">(-) -10 Radiation and Poison resistance <br> (-) -10 Healing Rate <br> (-) -1 to maximum Action Points</font></html>");
        traitsTipsMap.put("Brutish Hulk", "<html>Brutish Hulk <br> (+) +1 hp for each level gained up to soft cap (24)<br>Both the bonus and penalty are doubled when taken with Bruiser Trait <br> <font color=\"red\">(-) -1 Charisma</font></html>");
        traitsTipsMap.put("Chem Reliant", "<html>Chem Reliant <br> (+) doubled durration of drugs effects <br> <font color=\"red\">(-) -1/3 to current Hit Points healed with medicines</font></html>");
        traitsTipsMap.put("Fast Metabolism", "<html>Fast Metabolism <br> (+) healing rate every 10s instead of every 60s <br> <font color=\"red\">(-) halved duration of drug effects</font></html>");
        traitsTipsMap.put("Fast Shot", "<html>Fast Shot <br> (+) -1 AP cost for single shots (Single-handed weapons with aim mode) <br> (+) -2 AP cost for single shots (Two-handed weapons with aim mode) <br> (+)  +5 flat damage <br> <font color=\"red\">(-) Not possible to make aimed shots</font></html>");
        traitsTipsMap.put("Finesse", "<html>Finesse <br> (+) +10% to critical chance <br> (+) reduces enemy's base armor critical chance mod by 25% <br> <font color=\"red\">(-) +30 to your target's DR</font></html>");
        traitsTipsMap.put("Gifted", "<html>Gifted <br> (+) +1 to all SPECIAL stats <br> <font color=\"red\">(-) -5 skill points per level </font></html>");
        traitsTipsMap.put("Good Natured", "<html>Good Natured <br> (+) +50 party points <br> <font color=\"red\">(-) can't own slaves </font></html>");
        traitsTipsMap.put("Heavy Handed", "<html>Heavy Handed <br> (+) +5 melee damage and chance to knock opponents down <br> <font color=\"red\">(-) -10 penalty to Movement Speed </font></html>");
        traitsTipsMap.put("Jinxed", "<html>Jinxed <br> (+) 50% chance for critical failure when enemy misses <br> <font color=\"red\">(-) 50% chance for critical failure when you miss </font></html>");
        traitsTipsMap.put("Kamikaze", "<html>Kamikaze <br> (+) +1 to maximum Action Points <br> <font color=\"red\">(-) all enemies gain +10 to all critical power rolls made against you </font></html>");
        traitsTipsMap.put("Loner", "<html>Loner <br> (+) +10% to any experience points gained <br> <font color=\"red\">(-) Can't have followers </font></html>");
        traitsTipsMap.put("One Hander", "<html>One Hander <br> (+) +20% to chance to hit when using Single-handed weapons <br> (+) +10% Overall Damage with Single-Handed weapons <br> <font color=\"red\">(-) -100 hit chance penalty when using Two-handed weapons </font></html>");
        traitsTipsMap.put("Small Frame", "<html>Small Frame <br> (+) +1 to Agility <br> (+) +5 to Movement Speed <br> <font color=\"red\">(-) significantly reduced Carry Weight capacity <br> (-) using Weapons requiring a Strength of eight or more will injure you! </font></html>");

        drugsTipsMap.put("Beer", "<html>Beer <br> (+) +1 Endurance <br>(+) +1 Charisma <br> <font color=\"red\">(-) -2 Perception </font></html>");
        drugsTipsMap.put("Buffout", "<html>Buffout <br> (+) +2 Strength <br> (+) +1 Endurance <br> (+) +20 Max Hit Points <br><font color=\"red\">(-) -1 Agility </font></html>");
        drugsTipsMap.put("Cigarettes", "<html>Cigarettes <br> (+) +1 Perception <br><font color=\"red\">(-) -1 Charisma </font></html>");
        drugsTipsMap.put("Jet", "<html>Jet <br> (+) +2 Action Points <br><font color=\"red\">(-) -15% Normal DR <br>(-) -1 Charisma <br>(-) -2 Strength</font></html>");
        drugsTipsMap.put("Mentats", "<html>Mentats <br> (+) +2 Intelligence <br> (+) +2 Perception <br><font color=\"red\"> (-) -2 Endurance</font></html>");
        drugsTipsMap.put("Nuka-Cola", "<html>Nuka-Cola <br> (+) +1 Action Point<br><font color=\"red\"> (-) -1 Endurance</font></html>");
        drugsTipsMap.put("Psycho", "<html>Psycho <br> (+) +15% Normal DR<br> (+) +1 Strength <br> (+) +1 Endurance <br><font color=\"red\"> (-) -2 Perception</font></html>");
        drugsTipsMap.put("Rad-X", "<html>Rad-X <br> (+) +20% Rad Resistance</html>");
        drugsTipsMap.put("Booze", "<html>Booze <br> (+) +2 Luck<br> (+) +1 Charisma <br> <font color=\"red\"> (-) -1 Endurance <br> (-) -1 Perception</font></html>");
        drugsTipsMap.put("Gamma Gulp Beer", "<html>Gamma Gulp Beer <br> (+) +2 Agility<br> (+) +1 Charisma <br> <font color=\"red\"> (-) -3 Endurance </font></html>");
        drugsTipsMap.put("Roentgen Rum", "<html>Roentgen Rum <br> (+) +20 Healing Rate<br> (+) +1 Charisma <br> <font color=\"red\"> (-) -1 Strength <br> (-) -2 Perception </font></html>");
        drugsTipsMap.put("Rot Gut", "<html>Rot Gut <br> (+) +10 Fire DR<br><font color=\"red\"> (-) -1 Perception <br> (-) -10 Max Hit Points </font></html>");
        drugsTipsMap.put("Cookie", "<html>Cookie <br> (+) +1 Action Point <br> (+) +10 Max Hit Points<br> (+) +20 Healing Rate</html>");
        drugsTipsMap.put("Baked Fish", "<html>Baked Fish <br> (+) +20 Max Hit Points</html>");
   }

    public void generateChangingTips(Character character) {
       /*********DRUGS*********/
       String fruit = "<html>Fruit <br> (+) +10 Plasma DR <br> (+) +10 Laser DR <br> (+) +2 Perception <br> Requirements: <br>";


       boolean hasWayOfTheFruit = character.getPerks().getPerkByName("Way of the Fruit").isTaken();
       if(!hasWayOfTheFruit){
           fruit += "<font color=\"red\">";
       }
       fruit += "Way of the Fruit perk";
       if(!hasWayOfTheFruit){
           fruit += "</font>";
       }
       fruit += "</html>";
       drugsTipsMap.put("Fruit", fruit);

       String mutie = "<html>Mutie <br> (+) +4 Fire DT <br> (+) +4 Explode DT<br><font color=\"red\"> (-) -2 Charisma <br> (-) -2 Intelligence</font> <br> Requirements: <br>";
       boolean hasMutant = character.getMasteries().getMasteryByName("Mutant").isTaken() || character.getMasteries().getMasteryByName("Nightkin").isTaken();
       if(!hasMutant){
           mutie += "<font color=\"red\">";
       }
       mutie += "Mutant or Nightkin mastery";
       if(!hasMutant){
           mutie += "</font>";
       }
       mutie += "</html>";

       drugsTipsMap.put("Mutie", mutie);

       /*********Perks*********/
        perksTipsMap.put("Action Boy(1)", "<html>Action Boy(1) <br> (+) +1 Action Point <br> Requirements: <br>");
        perksTipsMap.put("Action Boy(2)", "<html>Action Boy(2) <br> (+) +1 Action Point <br> Requirements: <br>");
        perksTipsMap.put("Adrenaline Rush", "<html>Adrenaline Rush <br> (+) HP loss effects DT's and DR's incremental increase at certain thresholds <br> Requirements: <br>");
        perksTipsMap.put("Better Criticals", "<html>Better Criticals <br> (+) Much more devastating critical hits <br> Requirements: <br>");
        perksTipsMap.put("Bonus Move", "<html>Bonus Move <br> (+) +2 APs that can only be expended for movement in turn-base combat <br>(+) +10 Movement Speed <br> Requirements: <br>");
        perksTipsMap.put("Bonus Ranged Damage(1)", "<html>Bonus Ranged Damage(1) <br> (+) +2 to the weapon's damage range when using small, big or energy guns <br> Requirements: <br>");
        perksTipsMap.put("Bonus Ranged Damage(2)", "<html>Bonus Ranged Damage(2) <br> (+) +2 to the weapon's damage range when using small, big or energy guns <br> Requirements: <br>");
        perksTipsMap.put("Bonus Rate of Attack", "<html>Bonus Rate of Attack <br> (+) -1 AP cost of performing an attack (ranged or melee) <br> Requirements: <br>");
        perksTipsMap.put("Close Combat Master", "<html>Close Combat Master <br> (+) +10 to melee damage <br> (+) +15% to critical hit chance for HtH/melee attacks<br>(+) +5 Movement Speed <br> Requirements: <br>");
        perksTipsMap.put("Dodger(1)", "<html>Dodger(1)<br>(+) -5% to final Hit Chance (works only with melee/unarmed/throwing weapons in both hands) <br> (+) +5 Movement Speed <br> Requirements: <br>");
        perksTipsMap.put("Dodger(2)", "<html>Dodger(2)<br>(+) -5% to final Hit Chance (works only with melee/unarmed/throwing weapons in both hands) <br> Requirements: <br>");
        perksTipsMap.put("Earlier Sequence", "<html>Earlier Sequence<br> (+) +2 to Sequence<br> Requirements: <br>");
        perksTipsMap.put("Even More Criticals", "<html>Even More Criticals<br> (+) +10% to critical hit chance<br> Requirements: <br>");
        perksTipsMap.put("Gain Agility", "<html>Gain Agility<br> (+) +1 Agility<br> Requirements: <br>");
        perksTipsMap.put("Gain Charisma", "<html>Gain Charisma<br> (+) +1 Charisma<br> Requirements: <br>");
        perksTipsMap.put("Gain Endurance", "<html>Gain Endurance<br> (+) +1 Endurance<br> Requirements: <br>");
        perksTipsMap.put("Gain Intelligence", "<html>Gain Intelligence<br> (+) +1 Intelligence<br> Requirements: <br>");
        perksTipsMap.put("Gain Luck", "<html>Gain Luck<br> (+) +1 Luck<br> Requirements: <br>");
        perksTipsMap.put("Gain Perception", "<html>Gain Perception<br> (+) +1 Perception    <br> Requirements: <br>");
        perksTipsMap.put("Gain Strength", "<html>Gain Strength<br> (+) +1 Strength<br> Requirements: <br>");
        perksTipsMap.put("Ghost", "<html>Ghost<br> (+) +30 bonus to Sneak when within 5 hexes from a wall<br> Requirements: <br>");
        perksTipsMap.put("Heave Ho!", "<html>Heave Ho!<br> (+) +3 to throw range <br> (+) +5 Movement Speed <br> Requirements: <br>");
        perksTipsMap.put("Heave Ho!!", "<html>Heave Ho!!<br> (+) +3 to throw range <br> (+) +5 Movement Speed <br> Requirements: <br>");
        perksTipsMap.put("Hit the Gaps", "<html>Hit the Gaps<br> (+) -50% to your target's armor's critical modifiers<br> Requirements: <br>");
        perksTipsMap.put("In Your Face!", "<html>In Your Face!<br> (+) Anti-hth perk. All single attacks (Not bursts) at one hex range will have a 50% chance to miss no matter what weapon the player that has it is holding.<br> Requirements: <br>");
        perksTipsMap.put("Lifegiver(1)", "<html>Lifegiver(1)<br> (+) +40 to Hit Points<br> Requirements: <br>");
        perksTipsMap.put("Lifegiver(2)", "<html>Lifegiver(2)<br> (+) +40 to Hit Points<br> Requirements: <br>");
        perksTipsMap.put("Lifegiver(3)", "<html>Lifegiver(3)<br> (+) +40 to Hit Points<br> Requirements: <br>");
        perksTipsMap.put("Livewire", "<html>Livewire<br> (+) Doubled AC derived from Agility<br> Requirements: <br>");
        perksTipsMap.put("Living Anatomy", "<html>Living Anatomy<br> (+) +5 to damage when attacking living organisms <br> (+) better luck when using First Aid <br> (+) +30 healing rate<br> Requirements: <br>");
        perksTipsMap.put("Man of Steel", "<html>Man of Steel<br> (+) Increased resistance to critical hits <br> (+) -20 to enemy crit power rolls<br> Requirements: <br>");
        perksTipsMap.put("Medic", "<html>Medic<br> (+) Healing First Aid and Doctor cooldowns reduced by 50% <br> (+) Guarantee bonus of random +20-55 HP on every use of First Aid <br> (+) allows removal of KO on others with doctor skill<br> Requirements: <br>");
        perksTipsMap.put("More Critical", "<html>More Critical<br> (+) +5% Critical Chance<br> Requirements: <br>");
        perksTipsMap.put("More Ranged Damage", "<html>More Ranged Damage<br> (+) +3 to a weapon's damage range when using small or big guns<br> Requirements: <br>");
        perksTipsMap.put("Pyromaniac(1)", "<html>Pyromaniac(1)<br> (+) +20 to damage when using fire-based weaponry<br> Requirements: <br>");
        perksTipsMap.put("Pyromaniac(2)", "<html>Pyromaniac(2)<br> (+) +20 to damage when using fire-based weaponry<br> Requirements: <br>");
        perksTipsMap.put("Quick Pockets", "<html>Quick Pockets<br> (+) (Un)equipping/picking up items is done at half its normal AP cost <br> (+) Reloading cost reduced to 1 AP <br> Requirements: <br>");
        perksTipsMap.put("Quick Recovery", "<html>Quick Recovery<br> (+) Recovering from knock downs/knock outs costs significantly fewer APs than it normally would<br> Requirements: <br>");
        perksTipsMap.put("Right Between the Eyes", "<html>Right Between the Eyes<br> (+) -50% to your target's helmet's critical modifiers<br> Requirements: <br>");
        perksTipsMap.put("Sharpshooter", "<html>Sharpshooter<br> (+) +6 Field of View <br> (+) +8% to your chance to hit<br> Requirements: <br>");
        perksTipsMap.put("Silent Death", "<html>Silent Death<br> (+) Attacking a critter from behind always causes a critical hit when unarmed, using melee weapons or firing one-handed guns.<br> Requirements: <br>");
        perksTipsMap.put("Silent Running", "<html>Silent Running<br> (+) No penalty for running while in sneak mode<br> Requirements: <br>");
        perksTipsMap.put("Spray and Pray", "<html>Spray and Pray<br> (+) -10 from the targets armor Crit Chance modifier when using unaimed attacks<br> Requirements: <br>");
        perksTipsMap.put("Stonewall", "<html>Stonewall<br> (+) Better chance of avoiding knock-downs and knock-outs<br> Requirements: <br>");
        perksTipsMap.put("Toughness", "<html>Toughness<br> (+) +2 Normal DT <br> (+) +5 Normal DR<br> Requirements: <br>");
        perksTipsMap.put("Even Tougher", "<html>Even Tougher<br> (+) +3 Normal DT <br> (+) +10 Normal DR<br> Requirements: <br>");
        perksTipsMap.put("Way of the Fruit", "<html>Way of the Fruit<br> (+) +2 Perception, +10% plasma DR, +10% laser DR - when eat apple<br> Requirements: <br>");
        perksTipsMap.put("Weapon Handling", "<html>Weapon Handling<br> (+) +2 to Strength when calculating chance to hit <br> +10 flat damage to big guns also energy big guns only<br> Requirements: <br>");

        perksTipsMap.forEach((name, text) -> {
            String reqs = "";
            List<Requirement> requirementList =  character.getPerks().getPerkByName(name).getRequirements();

            for(int i = 0; i < requirementList.size(); i++){
                if(!requirementList.get(i).isAvailable){
                    reqs += "<font color=\"red\">";
                }

                reqs += requirementList.get(i).getInfo();
                if(!requirementList.get(i).isAvailable){
                    reqs += "</font>";
                }

                reqs += "<br>";

            }

            reqs += "</html>";
            perksTipsMap.put(name,text + reqs);
        });

        /*********Masteries*********/
        masteriesTipsMap.put("Tank", "<html>Tank <br> (+) +20 max Hit Points <br> (+) +5 Normal DR <br> +2 Normal DT<br> Requirements: <br>");
        masteriesTipsMap.put("Sweet Science", "<html>Sweet Science <br> (+) +10 Melee Damage <br> (+) +10 Normal DR <br> +5% to melee critical power rolls <br> Requirements: <br>");
        masteriesTipsMap.put("Sniper", "<html>Sniper<br> (+) Changes the critical chance calculation to a random roll of 1-13 against the attackers Luck <br> Requirements: <br>");
        masteriesTipsMap.put("Rambo", "<html>Rambo<br> (+) +1 damage to each bullet <br> (+) +5% Critical Chance <br> (+) +5% final dmg<br> Requirements: <br>");
        masteriesTipsMap.put("Nightkin", "<html>Nightkin<br> (+) +50 max Hit Points <br> (+) +5 Normal DR <br> +3 Normal DT <br> (+) while in sneak, all successful rear attacks have Silent Death effect <br> (+) radiation immunity <br> (+) you can wear Mutants Armors<br> Requirements: <br>");
        masteriesTipsMap.put("Mutant", "<html>Mutant<br> (+) +100 max Hit Points <br> (+) +10 Healing rate <br> (+) +10 Normal DR <br> +3 Normal DT <br> (+) radiation immunity <br> (+) you can wear Mutants Armors<br> Requirements: <br>");

        masteriesTipsMap.forEach((name, text) -> {
            String reqs = "";
            List<Requirement> requirementList =  character.getMasteries().getMasteryByName(name).getRequirements();

            for(int i = 0; i < requirementList.size(); i++){
                if(!requirementList.get(i).isAvailable){
                    reqs += "<font color=\"red\">";
                }

                reqs += requirementList.get(i).getInfo();
                if(!requirementList.get(i).isAvailable){
                    reqs += "</font>";
                }

                reqs += "<br>";

            }

            reqs += "</html>";
            masteriesTipsMap.put(name,text + reqs);
        });

       /*********Implants*********/
       implantsTipsMap.put("SPECIAL +1 ST", "<html>SPECIAL +1 ST <br> (+) +1 Strength<br> Requirements: <br>");
       implantsTipsMap.put("SPECIAL +1 PE", "<html>SPECIAL +1 PE <br> (+) +1 Perception<br> Requirements: <br>");
       implantsTipsMap.put("SPECIAL +1 EN", "<html>SPECIAL +1 EN <br> (+) +1 Endurance<br> Requirements: <br>");
       implantsTipsMap.put("SPECIAL +1 CH", "<html>SPECIAL +1 CH <br> (+) +1 Charisma<br> Requirements: <br>");
       implantsTipsMap.put("SPECIAL +1 IN", "<html>SPECIAL +1 IN <br> (+) +1 Intelligence<br> Requirements: <br>");
       implantsTipsMap.put("SPECIAL +1 AG", "<html>SPECIAL +1 AG <br> (+) +1 Agility<br> Requirements: <br>");
       implantsTipsMap.put("SPECIAL +1 LK", "<html>SPECIAL +1 LK <br> (+) +1 Luck<br> Requirements: <br>");
       implantsTipsMap.put("Dermal Impact Armor", "<html>Dermal Impact Armor <br> (+) +4 Normal / Explode DR<br> Requirements: <br>");
       implantsTipsMap.put("Phoenix Armor", "<html>Phoenix Armor <br> (+) +4 Fire / Laser / Plasma DR<br> Requirements: <br>");
       implantsTipsMap.put("Nemean Armor(1)", "<html>Nemean Armor(1) <br> (+) +20 Max Hit Points<br> Requirements: <br>");
       implantsTipsMap.put("Dermal Impact Assault", "<html>Dermal Impact Assault <br> (+) +4 Normal / Explode DR<br> (+) +1 Normal / Explode DT <br>Requirements: <br>");
       implantsTipsMap.put("Phoenix Assault", "<html>Phoenix Assault <br> (+) +4 Fire / Laser / Plasma DR<br> (+) +1 Fire / Laser / Plasma DT<br>Requirements: <br>");
       implantsTipsMap.put("Nemean Armor(2)", "<html>Nemean Armor(2) <br> (+) +20 Max Hit Points<br> Requirements: <br>");
       implantsTipsMap.put("Right Knee", "<html>Right Knee <br> (+) Your powerful thighs enable you to withstand leg shots that would floor others <br> (+) +5 Movement Speed<br> Requirements: <br>");
       implantsTipsMap.put("Left Knee", "<html>Left Knee <br> (+) +50 carry weight<br> Requirements: <br>");
       implantsTipsMap.put("Right Hand", "<html>Right Hand <br> (+) +6 melee damage<br> Requirements: <br>");
       implantsTipsMap.put("Left Hand", "<html>Left Hand <br> (+) ou suffer fewer weapon drops and arm cripples<br> Requirements: <br>");
       implantsTipsMap.put("Nociception clamp", "<html>Nociception clamp <br> (+) +50 max Hit Points <br> Requirements: <br>");
       implantsTipsMap.put("Eye", "<html>Eye <br> (+) +10% Critical Chance <br> Requirements: <br>");
       implantsTipsMap.put("Adrenal Enhancer", "<html>Adrenal Enhancer <br> (+) (+)  +10 Healing Rate <br> Requirements: <br>");
       implantsTipsMap.put("Liver Box", "<html>Liver Box <br> (+) +15% Radiation and Poison Resistanc <br> Requirements: <br>");
       implantsTipsMap.put("Cerebral Modem", "<html>Cerebral Modem <br> (+) +10% Electric DR <br> Requirements: <br>");

        implantsTipsMap.forEach((name, text) -> {
            String reqs = "";
            List<Requirement> requirementList =  character.getImplants().getImplantByName(name).getRequirements();

            for(int i = 0; i < requirementList.size(); i++){
                if(!requirementList.get(i).isAvailable){
                    reqs += "<font color=\"red\">";
                }

                reqs += requirementList.get(i).getInfo();
                if(!requirementList.get(i).isAvailable){
                    reqs += "</font>";
                }

                reqs += "<br>";

            }

            reqs += "</html>";
            implantsTipsMap.put(name,text + reqs);
        });

        /*********Support Perks*********/
        supportsTipsMap.put("Boneyard Guard sg", "<html>Boneyard Guard sg <br> (+) +10% Small Guns skill<br> Requirements: <br>");
        supportsTipsMap.put("Boneyard Guard bg", "<html>Boneyard Guard bg <br> (+) +10% Big Guns skill<br> Requirements: <br>");
        supportsTipsMap.put("Boneyard Guard ew", "<html>Boneyard Guard ew <br> (+) +10% Energy Weapons skill<br> Requirements: <br>");
        supportsTipsMap.put("Boneyard Guard cc", "<html>Boneyard Guard cc <br> (+) +10% Close Combat skill<br> Requirements: <br>");
        supportsTipsMap.put("Boneyard Guard th", "<html>Boneyard Guard th <br> (+) +10% Throwing skill<br> Requirements: <br>");
        supportsTipsMap.put("Cautious Nature", "<html>Cautious Nature<br> (+) +3 to Perception when determining placement in random encounters<br> Requirements: <br>");
        supportsTipsMap.put("Dead Man Walking", "<html>Dead Man Walking<br> (+) Doubled negative HP capacity<br> Requirements: <br>");
        supportsTipsMap.put("Demolition Expert", "<html>Demolition Expert<br> (+) No unwanted explosions and extra damage for the wanted ones<br> Requirements: <br>");
        supportsTipsMap.put("Dismantler", "<html>Dismantler<br> (+) Doubled amount of resources received from dismantling items<br> Requirements: <br>");
        supportsTipsMap.put("Educated", "<html>Educated<br> (+) +2 to Skill Points per level <br> Requirements: <br>");
        supportsTipsMap.put("Explorer", "<html>Explorer<br> (+) Faster world map travelling<br> Requirements: <br>");
        supportsTipsMap.put("Faster Healing", "<html>Faster Healing<br> (+) +20 Healing Rate<br> Requirements: <br>");
        supportsTipsMap.put("Fortune Finder", "<html>Fortune Finder<br> (+) Find additional caps during random encounters or from backpacks<br> Requirements: <br>");
        supportsTipsMap.put("Harmless", "<html>Harmless<br> (+) Halved reputation loss when stealing<br> Requirements: <br>");
        supportsTipsMap.put("Light Step", "<html>Light Step<br> (+) Chance to set off a trap reduced by 50%<br> Requirements: <br>");
        supportsTipsMap.put("Locksmith", "<html>Locksmith<br> (+) Reduces Lockpick cooldown to 5 seconds<br> Requirements: <br>");
        supportsTipsMap.put("Lumberjack", "<html>Lumberjack<br> (+) Harvesting wood twice faster <br> (+) Chop 2 wood at a time (provided the tree has capacity of more than one) <br> Requirements: <br>");
        supportsTipsMap.put("Magnetic Personality", "<html>Magnetic Personality<br> (+) +50 to party points <br> (+) +1 to maximum party size<br> Requirements: <br>");
        supportsTipsMap.put("Master Thief", "<html>Master Thief<br> (+) Stealing cooldown reduced by 50%<br> Requirements: <br>");
        supportsTipsMap.put("Monster Skinning", "<html>Monster Skinning<br> (+) Ability to skin or resources from animals<br> Requirements: <br>");
        supportsTipsMap.put("Mr. Fixit", "<html>Mr. Fixit<br> (+) Repairing items is easier<br> Requirements: <br>");
        supportsTipsMap.put("Negotiator", "<html>Negotiator<br> (+) Reputation lower than neutral is upgraded to neutral when talking to NPCs<br> Requirements: <br>");
        supportsTipsMap.put("Nerd Rage", "<html>Nerd Rage<br> (+) +10% damage when 1/2 hp or less<br> Requirements: <br>");
        supportsTipsMap.put("Pack Rat", "<html>Pack Rat<br> (+) You can carry more<br> Requirements: <br>");
        supportsTipsMap.put("Pathfinder", "<html>Pathfinder<br> (+) 25% faster world map travelling<br> Requirements: <br>");
        supportsTipsMap.put("Pickpocket", "<html>Pickpocket<br> (+) Easier stealing<br> Requirements: <br>");
        supportsTipsMap.put("Rad Resistance", "<html>Rad Resistance<br> (+) +10% to Radiation Resistance <br> (+) +10% to Poison Resistance <br>Requirements: <br>");
        supportsTipsMap.put("Ranger", "<html>Ranger<br> (+) Ability to craft several new items, a safe house instead of a military tent<br> Requirements: <br>");
        supportsTipsMap.put("Scout", "<html>Scout<br> (+) Faster revealing of the covered areas of the world map<br> (+) More chance of find a special encounter<br>Requirements: <br>");
        supportsTipsMap.put("Scrounger", "<html>Scrounger<br> (+) more ammo from lockers or backpacks in random encounters<br> Requirements: <br>");
        supportsTipsMap.put("Sex Appeal", "<html>Sex Appeal<br> (+) +250 to reputation when interacting with the opposite sex<br> Requirements: <br>");
        supportsTipsMap.put("Smitty's Meal", "<html>Smitty's Meal<br> (+) +5 max Hit Points<br> Requirements: <br>");
        supportsTipsMap.put("Snakeater", "<html>Snakeater<br> (+) +20% to Radiation Resistance <br> (+) +30% to Poison Resistance<br> Requirements: <br>");
        supportsTipsMap.put("Speaker", "<html>Speaker<br> (+) Your followers' loyalty decreases at half the normal rate<br> Requirements: <br>");
        supportsTipsMap.put("Stealth Girl", "<html>Stealth Girl<br> (+) Doubled stealth boy's battery life<br> Requirements: <br>");
        supportsTipsMap.put("Straight Shooter", "<html>Straight Shooter<br> (+) +1 damage with ranged weapons<br> Requirements: <br>");
        supportsTipsMap.put("Strong Back", "<html>Strong Back<br> (+) +22 to carry weight capacity<br> Requirements: <br>");
        supportsTipsMap.put("Swift Learner", "<html>Swift Learner<br> (+) +10% to all your experience point gains<br> Requirements: <br>");
        supportsTipsMap.put("The Good Doctor", "<html>The Good Doctor<br> (+) +1 Charisma<br> Requirements: <br>");
        supportsTipsMap.put("Thief", "<html>Thief<br> (+) Luck/50 chance of no cooldown if a stealing attempt has failed<br> Requirements: <br>");
        supportsTipsMap.put("Treasure Hunter", "<html>Treasure Hunter<br> (+) Additional items spawn in lockers in random encounters<br> Requirements: <br>");
        supportsTipsMap.put("Surviving in the wild", "<html>Surviving in the wild <br> (+) +10 max Hit Points<br> Requirements: <br>");
        supportsTipsMap.put("The art of the hunt", "<html>The art of the hunt <br> (+) +3% Critical Chance<br> Requirements: <br>");
        supportsTipsMap.put("Basic Field Medicine", "<html>Basic Field Medicine <br> (+) +20 Healing Rate<br> Requirements: <br>");

        supportsTipsMap.forEach((name, text) -> {
            String reqs = "";
            List<Requirement> requirementList =  character.getSupportPerks().getPerkByName(name).getRequirements();

            for(int i = 0; i < requirementList.size(); i++){
                if(!requirementList.get(i).isAvailable){
                    reqs += "<font color=\"red\">";
                }

                reqs += requirementList.get(i).getInfo();
                if(!requirementList.get(i).isAvailable){
                    reqs += "</font>";
                }

                reqs += "<br>";

            }

            reqs += "</html>";
            supportsTipsMap.put(name,text + reqs);
        });
    }

    public Map<String, String> getTraitsTipsMap() {
        return traitsTipsMap;
    }

    public Map<String, String> getDrugsTipsMap() {
        return drugsTipsMap;
    }

    public Map<String, String> getPerksTipsMap() {
        return perksTipsMap;
    }

    public Map<String, String> getMasteriesTipsMap() {
        return masteriesTipsMap;
    }

    public Map<String, String> getImplantsTipsMap() {
        return implantsTipsMap;
    }

    public Map<String, String> getSupportsTipsMap() {
        return supportsTipsMap;
    }
}
