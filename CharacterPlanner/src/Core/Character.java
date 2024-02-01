package Core;

import Core.Books.Books;
import Core.Drugs.Drugs;
import Core.Implants.Implants;
import Core.Masteries.Masteries;
import Core.Perks.Perks;
import Core.Perks.SupportPerks;
import Core.Requirements.Requirement;
import Core.Skills.Skills;
import Core.Specials.Specials;
import Core.Stats.Stats;
import Core.Traits.Traits;

import java.util.ArrayList;
import java.util.List;

public class Character {
    private int level;
    private int exp;

    private Specials specials;
    private Traits traits;
    private Skills skills;
    private Books books;
    private Drugs drugs;
    private Implants implants;
    private Masteries masteries;
    private Perks perks;
    private SupportPerks supportPerks;
    private Stats stats;
    private Boolean isCreated;

    public Character(){
        level = 1;
        exp = 0;
        isCreated = false;

        specials = new Specials();
        traits = new Traits();
        skills = new Skills();
        drugs = new Drugs();
        implants = new Implants();
        masteries = new Masteries();
        perks = new Perks();
        supportPerks = new SupportPerks();
        stats = new Stats();
        books = new Books(skills);

        calculate();
    }

    public int getLevel(){
        return level;
    }

    public Specials getSpecials(){
        return specials;
    }

    public Traits getTraits() {
        return traits;
    }

    public Skills getSkills() {
        return skills;
    }

    public Implants getImplants() {
        return implants;
    }

    public Masteries getMasteries() {
        return masteries;
    }

    public Perks getPerks() {
        return perks;
    }

    public SupportPerks getSupportPerks() {
        return supportPerks;
    }

    public Drugs getDrugs() {
        return drugs;
    }

    public Stats getStats() {
        return stats;
    }

    public Books getBooks() {
        return books;
    }

    public Boolean getCreated() {
        return isCreated;
    }

    public void setCreated(Boolean created) {
        isCreated = created;
    }

    public void checkRequirements() {
        if(isCreated){
            List<Requirement> requirementList = new ArrayList<>();
            requirementList.addAll(perks.getRequirements());
            requirementList.addAll(supportPerks.getRequirements());
            requirementList.addAll(implants.getRequirements());
            requirementList.addAll(masteries.getRequirements());

            requirementList.forEach((requirement) -> {
                requirement.unChecked();
            });

            requirementList.forEach((requirement) -> {
                requirement.check(this);
            });
        }
    }

    public int getExp() {
        return exp;
    }

    public void calculate() {
        getSpecials().calculateSpecialValues(this);
        getSkills().calculateSkillsValues(this);
        getStats().calculateStats(this);
        checkRequirements();
    }

    public void levelUp(){
        if(isCreated){
            level++;
            exp = level * ((level - 1) * 1000) / 2;

            skills.addSkillPoints(stats.getStatByName("SP/Level").getValue());
            perks.checkIfHasAvailablePerk(level);
        }

        skills.confirmSkills();
        calculate();
    }

    public boolean createCharacter() {
        if(!isCreated){
            if(skills.getSkillTagsLeft() == 0 && specials.getSpecialPointsToUse() == 0){
                isCreated = true;
                calculate();
                return true;
            }
        }

        return false;
    }

    public int getSkillTagsLeft() {
        return skills.getSkillTagsLeft();
    }

    public int getSkillPoints() {
        return skills.getSkillPoints();
    }

    public List<Integer> getSpecialsBaseValues() {
        return specials.getSpecialsBaseValues();
    }

    public List<Integer> getSpecialsFinalValues() {
        return specials.getSpecialsFinalValues();
    }

    public int getSpecialPointsToUse() {
        return specials.getSpecialPointsToUse();
    }

    public List<Integer> getSkillsValues() {
        return skills.getSkillsValues();
    }

    public List<Integer> getSkillPointsValues() {
        return skills.getSkillPointsValues();
    }

    public List<Integer> getBooksAmountValues() {
        return books.getBooksAmountValues();
    }

    public List<String> getStatsValues() {
        return stats.getStatsValues();
    }

    public int getTraitsLeft() {
        return traits.getTraitsLeft();
    }

    public List<String> getTakenPerksNames() {
        return perks.getTakenPerksNames();
    }

    public List<String> getAvailablePerksNames() {
        return perks.getAvailablePerksNames();
    }

    public List<String> getUnAvailablePerksNames() {
        return perks.getUnAvailablePerksNames();
    }

    public List<String> getTakenSupportPerksNames() {
        return supportPerks.getTakenPerksNames();
    }

    public List<String> getAvailableSupportPerksNames() {
        return supportPerks.getAvailablePerksNames(isCreated);
    }

    public List<String> getUnAvailableSupportPerksNames() {
        return supportPerks.getUnAvailablePerksNames(isCreated);
    }

    public List<String> getTakenImplantsNames() {
        return implants.getTakenImplantsNames();
    }

    public List<String> getAvailableImplantsNames() {
        return implants.getAvailableImplantsNames();
    }

    public List<String> getUnAvailableImplantsNames() {
        return implants.getUnAvailableImplantsNames();
    }

    public List<String> getTakenMasteriesNames() {
        return masteries.getTakenMasteriesNames();
    }

    public List<String> getAvailableMasteriesNames() {
        return masteries.getAvailableMasteriesNames();
    }

    public List<String> getUnAvailableMasteriesNames() {
        return masteries.getUnAvailableMasteriesNames();
    }

    public List<String> getTakenDrugsNames() {
        return drugs.getTakenDrugsNames();
    }

    public List<String> getTakenTraitsNames() {
        return traits.getTakenTraitsNames();
    }

    public List<String> getTaggedSkills() {
        return skills.getTaggedSkills();
    }

    public void changeSpecialWithButton(String specialName, boolean add) {
        if(!isCreated){
            specials.changeSpecialWithButton(specialName, add);
            calculate();
        }
    }

    public void takeTrait(String traitName) {
        if(!isCreated){
            traits.takeTrait(this, traitName);
            calculate();
        }
    }

    public void takeDrug(String drugName) {
        if(isCreated){
            drugs.takeDrug(drugName);
            skills.confirmSkills();
            calculate();
        }
    }

    public void takePerk(String perkName) {
        perks.takePerk(perkName);
        skills.confirmSkills();
        calculate();
    }

    public void takeMastery(String masteryName) {
        masteries.takeMastery(masteryName);
        skills.confirmSkills();
        calculate();
    }

    public void takeImplant(String implantName) {
        implants.takeImplant(implantName);
        skills.confirmSkills();
        calculate();
    }

    public void takeSupportPerk(String perkName) {
        supportPerks.takeSupportPerk(perkName);
        skills.confirmSkills();
        calculate();
    }

    public void setTagSkill(String skillName) {
        if(!isCreated){
            skills.setTagSkill(skillName);
            calculate();
        }
    }

    public void putSkillPointByButton(String skillName, boolean addPoint) {
        skills.putSkillPointByButton(skillName, addPoint);
        calculate();
    }

    public void readBook(String skillName) {
        if(isCreated){
            books.readBook(skillName);
            skills.confirmSkills();
            calculate();
        }
    }


    public void readAllBooks() {
        if(isCreated){
            books.readAllBooks();
            skills.confirmSkills();
            calculate();
        }
    }

    public boolean hasNewPerk() {
        return perks.hasAvailablePerk();
    }

    public boolean perkAlert() {
        return perks.perkAlert(level);
    }
}
