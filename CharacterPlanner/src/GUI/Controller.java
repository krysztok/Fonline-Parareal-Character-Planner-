package GUI;

import Core.Character;

import java.io.IOException;

public class Controller {
    private Character character;
    private GUI gui;
    private int skillPointsPerClick;
    private ToolTipsGenerator toolTipsGenerator;

    public Controller(Character character, GUI gui) {
        this.character = character;
        this.gui = gui;
        this.skillPointsPerClick = 1;
        toolTipsGenerator = new ToolTipsGenerator();
        toolTipsGenerator.generateNotChangingTips();
    }

    public void start() {
        refresh();
    }

    public void levelUpButtonOnClick(){
        if(character.getCreated()){
            character.levelUp();
        } else {
            if(!character.createCharacter()) {
                gui.setFirstLineRed(true);
                return;
            }
        }

        refresh();
    }


    public void resetButtonOnClick() {
        character = new Character();
        refresh();
    }

    public void printScreen() throws IOException {
        gui.printScreen();
    }

    public void refresh() {
        gui.showSpecialsValues(character.getSpecialsBaseValues(), character.getSpecialsFinalValues());
        gui.showCharPoints(character.getSpecialPointsToUse());
        gui.showSkillsValues(character.getSkillsValues(), character.getSkillPointsValues(), character.getBooksAmountValues());
        gui.showStatsValues(character.getStatsValues());

        int points = 0;
        if(!character.getCreated()){
            points = character.getSkillTagsLeft();
            gui.setCharBuildingMessage(character.getSpecialPointsToUse(), character.getTraitsLeft(), character.getSkillTagsLeft());
        } else {
            points = character.getSkillPoints();
            gui.showLevelAndExpValues(character.getLevel(), character.getExp(), character.hasNewPerk());
        }
        gui.showSkillPoints(points);

        gui.setPerksColors(character.getTakenPerksNames(), character.getAvailablePerksNames(), character.getUnAvailablePerksNames());
        gui.setSupportPerksColors(character.getTakenSupportPerksNames(), character.getAvailableSupportPerksNames(), character.getUnAvailableSupportPerksNames());
        gui.setImplantsColors(character.getTakenImplantsNames(), character.getAvailableImplantsNames(), character.getUnAvailableImplantsNames());
        gui.setMasteriesColors(character.getTakenMasteriesNames(), character.getAvailableMasteriesNames(), character.getUnAvailableMasteriesNames());
        gui.setDrugsColors(character.getCreated(), character.getTakenDrugsNames(), character.getAvailableDrugsNames(), character.getUnAvailableDrugsNames());
        gui.setTraitsColors(character.getCreated(), character.getTakenTraitsNames());
        gui.setSkillsColors(character.getTaggedSkills());

        if(character.perkAlert()){
            gui.setFirstLineRed(true);
        }


        toolTipsGenerator.generateChangingTips(character);
        refreshTips();
    }

    public void plusSpecialButtonOnClick(String specialName){
        character.changeSpecialWithButton(specialName, true);
        refresh();
    }

    public void minusSpecialButtonOnClick(String specialName){
        character.changeSpecialWithButton(specialName, false);
        refresh();
    }

    public void takeTraitButtonOnClick(String traitName){
        character.takeTrait(traitName);
        refresh();
    }

    public void takeDrugButtonOnClick(String drugName) {
        character.takeDrug(drugName);
        refresh();
    }

    public void takePerkButtonOnClick(String perkName) {
        character.takePerk(perkName);
        refresh();
    }

    public void takeMasteryButtonOnClick(String masteryName) {
        character.takeMastery(masteryName);
        refresh();
    }

    public void takeImplantButtonOnClick(String implantName) {
        character.takeImplant(implantName);
        refresh();
    }

    public void takeSupportPerkButtonOnClick(String perkName) {
        character.takeSupportPerk(perkName);
        refresh();
    }

    public void setTagSkillButtonOnClick(String skillName) {
        character.setTagSkill(skillName);
        refresh();
    }

    public void plusSkillPointButtonOnClick(String skillName) {
        for(int i = 0; i < skillPointsPerClick; i++){
            character.putSkillPointByButton(skillName, true);
        }
        refresh();
    }

    public void minusSkillPointButtonOnClick(String skillName) {
        for(int i = 0; i < skillPointsPerClick; i++) {
            character.putSkillPointByButton(skillName, false);
        }
        refresh();
    }

    public void readBookButtonOnClick(String skillName) {
        character.readBook(skillName);
        refresh();
    }

    public void readAllBooksButtonOnClick(){
        character.readAllBooks();
        refresh();
    }

    public void setSkillPointsPerClickAmount(int amount) {
        if(skillPointsPerClick == 1){
            skillPointsPerClick = 5;
        } else{
            skillPointsPerClick = 1;
        }
        gui.changeSkillPointsPerClickIcons(skillPointsPerClick);
    }

    public void refreshTips() {
        gui.refreshTraitsTips(toolTipsGenerator.getTraitsTipsMap());
        gui.refreshDrugsTips(toolTipsGenerator.getDrugsTipsMap());
        gui.refreshPerksTips(toolTipsGenerator.getPerksTipsMap());
        gui.refreshMasteriesTips(toolTipsGenerator.getMasteriesTipsMap());
        gui.refreshImplantsTips(toolTipsGenerator.getImplantsTipsMap());
        gui.refreshSupportsTips(toolTipsGenerator.getSupportsTipsMap());
    }
}
