package Core.Stats;

import Core.Character;

import java.util.*;

public class Stats {
    private Map<String, Stat> statsMap;

    public Stats(){
        statsMap = new LinkedHashMap<>();

        Stat hitPoints = new HitPoints("Hit Points");
        Stat hitPointsPerLevel = new HitPointsPerLevel("HP/Level");
        Stat skillPointsPerLevel = new SkillPointsPerLevel("SP/Level");
        Stat partPoints = new PartyPoints("Party Points");
        Stat viewRange = new ViewRange("View Range");
        Stat sequence = new Sequence("Sequence");
        Stat flatDamage = new FlatDamage("Flat Damage");
        Stat armorClass = new ArmorClass("Armor Class");
        Stat actionPoints =  new ActionPoints("Action Points");
        Stat carryWeight = new CarryWeight("Carry Weight");
        Stat meleeDamage = new MeleeDamage("Melee Damage");
        Stat poisonResistance = new PoisonResistance("Poison Res.");
        Stat radiationResistance = new RadiationResistance("Radiation Res.");
        Stat healingRate = new HealingRate("Healing Rate");
        Stat criticalChance = new CriticalChance("Critical Chance");
        Stat movementSpeed = new MovementSpeed("Movement Speed");
        Stat normalDTDR = new NormalDTDR("Normal DT/DR");
        Stat laserDTDR = new LaserDTDR("Laser DT/DR");
        Stat fireDTDR = new FireDTDR("Fire DT/DR");
        Stat plasmaDTDR = new PlasmaDTDR("Plasma DT/DR");
        Stat electroDTDR = new ElectroDTDR("Electro DT/DR");
        Stat explodeDTDR = new ExplodeDTDR("Explode DT/DR");

        statsMap.put(hitPoints.getName(), hitPoints);
        statsMap.put(hitPointsPerLevel.getName(), hitPointsPerLevel);
        statsMap.put(skillPointsPerLevel.getName(), skillPointsPerLevel);
        statsMap.put(partPoints.getName(), partPoints);
        statsMap.put(viewRange.getName(), viewRange);
        statsMap.put(sequence.getName(), sequence);
        statsMap.put(flatDamage.getName(), flatDamage);
        statsMap.put(armorClass.getName(), armorClass);
        statsMap.put(actionPoints.getName(), actionPoints);
        statsMap.put(carryWeight.getName(), carryWeight);
        statsMap.put(meleeDamage.getName(), meleeDamage);
        statsMap.put(poisonResistance.getName(), poisonResistance);
        statsMap.put(radiationResistance.getName(), radiationResistance);
        statsMap.put(healingRate.getName(), healingRate);
        statsMap.put(criticalChance.getName(), criticalChance);
        statsMap.put(movementSpeed.getName(), movementSpeed);
        statsMap.put(normalDTDR.getName(), normalDTDR);
        statsMap.put(laserDTDR.getName(), laserDTDR);
        statsMap.put(fireDTDR.getName(), fireDTDR);
        statsMap.put(plasmaDTDR.getName(), plasmaDTDR);
        statsMap.put(electroDTDR.getName(), electroDTDR);
        statsMap.put(explodeDTDR.getName(), explodeDTDR);
    }

    public Stat getStatByName(String name) {
        return statsMap.get(name);
    }

    public List getStatsNames() {
        List<String> statsNames = new ArrayList<String>();

        statsMap.forEach((name, stat) -> {
            statsNames.add(name);
        });

        return statsNames;
    }

    public void calculateStats(Character character) {
        statsMap.forEach((name, stat) -> stat.calculateValue(character));
    }

    public List<String> getStatsValues(){
        List<String> values = new ArrayList<>();
        statsMap.forEach((name, stat) -> values.add(stat.toString()));
        return  values;
    }

}
