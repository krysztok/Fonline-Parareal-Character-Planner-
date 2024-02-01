package GUI;

import Core.Character;
import GUI.Panels.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class GUI extends JPanel {
    boolean debug;
    JFrame frame;
    int width, height;
    Controller controller;
    SpecialsPanel specialsPanel;
    StatsPanel statsPanel;
    PerksPanel perksPanel;
    TraitsPanel traitsPanel;
    MasteriesPanel masteriesPanel;
    ImplantsPanel implantsPanel;
    SupportsPanel supportsPanel;
    DrugsPanel drugsPanel;
    SkillsPanel skillsPanel;
    SkillPointsPanel skillPointsPanel;
    DisplayTextPanel displayTextPanel;
    MainButtonsPanel mainButtonsPanel;
    Font font;
    ImageIcon[] numbers;
    ImageIcon[] negativeNumbers;
    Color transparentColor, debug1Color, debug2Color, greenColor, redColor, notAvailableColor, takenColor;
    Map<String, Color> colorsMap;
    Icon bigButtonIcon, bigButtonPushedIcon, smallButtonIcon, smallButtonPushedIcon, minusIcon, minusPushedIcon,
            plusIcon, plusPushedIcon, plus1Icon, plus1PushedIcon, plus5Icon, plus5PushedIcon, allIcon, allPushedIcon;
    Map<String, Icon> iconsMap;

    public GUI(JFrame frame, Character character) throws IOException, FontFormatException {
        this.frame = frame;
        controller = new Controller(character, this);
        debug = false;
        setLayout(null);
        setOpaque(false);
        width = 1129;
        height = 851;
        setSize(width,height);
        setPreferredSize(new Dimension(width, height));
        //setBounds(0, 0, width, height);

        colorsMap = new LinkedHashMap<>();
        transparentColor = new Color(0,0,0,0);
        debug1Color = new Color(200,0,0,100);
        debug2Color = new Color(0,200,0,100);
        greenColor = Color.GREEN;
        redColor = Color.RED;
        //notAvailableColor = new Color(48,48,48,85);
        notAvailableColor = new Color(0,250,0,55);
        takenColor = new Color(171,171,171, 250);
        colorsMap.put("Transparent", transparentColor);
        colorsMap.put("Debug1", debug1Color);
        colorsMap.put("Debug2", debug2Color);
        colorsMap.put("Green", greenColor);
        colorsMap.put("Red", redColor);
        colorsMap.put("NotAvailable", notAvailableColor);
        colorsMap.put("Taken", takenColor);

        InputStream iss = getClass().getResourceAsStream("/resources/fonts/font.ttf");
        font = Font.createFont(Font.TRUETYPE_FONT, iss);
        font = font.deriveFont(Font.PLAIN, 12f);

        numbers = new ImageIcon[10];
        negativeNumbers = new ImageIcon[10];

        try {
            String path = "/resources/graphics/number";
            for(int i = 0; i < 10; i++){
                numbers[i] = new ImageIcon(ImageIO.read(getClass().getResource(path + i + ".png")));
                negativeNumbers[i] = new ImageIcon(ImageIO.read(getClass().getResource(path + i + "r.png")));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        iconsMap = new LinkedHashMap<>();
        bigButtonIcon = new ImageIcon(getClass().getResource("/resources/graphics/bigButton.png"));
        bigButtonPushedIcon = new ImageIcon(getClass().getResource("/resources/graphics/bigButtonPushed.png"));
        smallButtonIcon = new ImageIcon(getClass().getResource("/resources/graphics/smallButton.png"));
        smallButtonPushedIcon = new ImageIcon(getClass().getResource("/resources/graphics/smallButtonPushed.png"));
        minusIcon = new ImageIcon(getClass().getResource("/resources/graphics/minusButton.png"));
        minusPushedIcon = new ImageIcon(getClass().getResource("/resources/graphics/minusButtonPushed.png"));
        plusIcon = new ImageIcon(getClass().getResource("/resources/graphics/plusButton.png"));
        plusPushedIcon = new ImageIcon(getClass().getResource("/resources/graphics/plusButtonPushed.png"));
        plus1Icon = new ImageIcon(getClass().getResource("/resources/graphics/plus1.png"));
        plus1PushedIcon = new ImageIcon(getClass().getResource("/resources/graphics/plus1Pushed.png"));
        plus5Icon= new ImageIcon(getClass().getResource("/resources/graphics/plus5.png"));
        plus5PushedIcon = new ImageIcon(getClass().getResource("/resources/graphics/plus5Pushed.png"));
        allIcon = new ImageIcon(getClass().getResource("/resources/graphics/allbutt.png"));
        allPushedIcon = new ImageIcon(getClass().getResource("/resources/graphics/allbuttPushed.png"));
        iconsMap.put("bigButton", bigButtonIcon);
        iconsMap.put("bigButtonPushed", bigButtonPushedIcon);
        iconsMap.put("smallButton", smallButtonIcon);
        iconsMap.put("smallButtonPushed", smallButtonPushedIcon);
        iconsMap.put("minus", minusIcon);
        iconsMap.put("minusPushed", minusPushedIcon);
        iconsMap.put("plus", plusIcon);
        iconsMap.put("plusPushed", plusPushedIcon);
        iconsMap.put("plus1", plus1Icon);
        iconsMap.put("plus1Pushed", plus1PushedIcon);
        iconsMap.put("plus5", plus5Icon);
        iconsMap.put("plus5Pushed", plus5PushedIcon);
        iconsMap.put("all", allIcon);
        iconsMap.put("allPushed", allPushedIcon);

        List<String> statsNames = new ArrayList<>(character.getStats().getStatsNames());
        List<String> perksNames = new ArrayList<>(character.getPerks().getPerksNames());
        List<String> traitsNames = new ArrayList<>(character.getTraits().getTraitsNames());
        List<String> drugsNames = new ArrayList<>(character.getDrugs().getDrugsNames());
        List<String> masteriesNames = new ArrayList<>(character.getMasteries().getMasteriesNames());
        List<String> supportPerksNames = new ArrayList<>(character.getSupportPerks().getSupportPerksNames());
        List<String> implantsNames = new ArrayList<>(character.getImplants().getImplantsNames());
        List<String> skillsNames = new ArrayList<>(character.getSkills().getSkillsNames());
        List<String> specialsNames = new ArrayList<>(character.getSpecials().getSpecialsNames());

        specialsPanel = new SpecialsPanel(controller, numbers, negativeNumbers, specialsNames, iconsMap, colorsMap, debug);
        statsPanel = new StatsPanel(controller, font, statsNames, colorsMap, debug);
        perksPanel = new PerksPanel(controller, font, perksNames, iconsMap, colorsMap, debug);
        traitsPanel = new TraitsPanel(controller, font, traitsNames, iconsMap, colorsMap, debug);
        masteriesPanel = new MasteriesPanel(controller, font, masteriesNames, iconsMap, colorsMap, debug);
        implantsPanel = new ImplantsPanel(controller, font, implantsNames, iconsMap, colorsMap, debug);
        supportsPanel = new SupportsPanel(controller, font, supportPerksNames, iconsMap, colorsMap, debug);
        drugsPanel = new DrugsPanel(controller, font, drugsNames, iconsMap, colorsMap, debug);
        skillsPanel = new SkillsPanel(controller, font, skillsNames, iconsMap, colorsMap, debug);
        skillPointsPanel = new SkillPointsPanel(controller, numbers, negativeNumbers, colorsMap, iconsMap, debug);
        displayTextPanel = new DisplayTextPanel(controller, font, colorsMap, debug);
        mainButtonsPanel = new MainButtonsPanel(controller, iconsMap, colorsMap,  debug);

        add(specialsPanel);
        add(statsPanel);
        add(perksPanel);
        add(traitsPanel);
        add(masteriesPanel);
        add(implantsPanel);
        add(supportsPanel);
        add(drugsPanel);
        add(skillsPanel);
        add(skillPointsPanel);
        add(displayTextPanel);
        add(mainButtonsPanel);

        setVisible(true);

        controller.start();
    }

    public SkillPointsPanel getSkillPointsPanel() {
        return skillPointsPanel;
    }

    public SpecialsPanel getSpecialsPanel() {
        return specialsPanel;
    }

    public StatsPanel getStatsPanel() {
        return statsPanel;
    }

    public SkillsPanel getSkillsPanel() {
        return skillsPanel;
    }

    public PerksPanel getPerksPanel() {
        return perksPanel;
    }

    public SupportsPanel getSupportsPanel() {
        return supportsPanel;
    }

    public ImplantsPanel getImplantsPanel() {
        return implantsPanel;
    }

    public MasteriesPanel getMasteriesPanel() {
        return masteriesPanel;
    }

    public DrugsPanel getDrugsPanel() {
        return drugsPanel;
    }

    public TraitsPanel getTraitsPanel() {
        return traitsPanel;
    }

    public DisplayTextPanel getDisplayTextPanel() {
        return displayTextPanel;
    }

    public void printScreen() throws IOException {
        BufferedImage img = ImageIO.read(getClass().getResource("/resources/graphics/background.png"));
        this.paint(img.getGraphics());
        BufferedImage img2 = img.getSubimage(0,0,1113,812); // cut image

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file to save");

        int userSelection = fileChooser.showSaveDialog(frame);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();

            try {
                String fileName = fileToSave.getCanonicalPath();
                if (!fileName.endsWith(".png")) {
                    fileToSave = new File(fileName + ".png");
                }
                ImageIO.write(img2, "png", fileToSave);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void showSpecialsValues(List<Integer> specialsBaseValues, List<Integer> specialsFinalValues) {
        specialsPanel.showSpecialsValues(specialsBaseValues, specialsFinalValues);
    }

    public void showCharPoints(int specialPointsToUse) {
        specialsPanel.showCharPoints(specialPointsToUse);
    }

    public void showSkillsValues(List<Integer> skillsValues, List<Integer> skillPointsValues, List<Integer> booksAmountValues) {
        skillsPanel.showSkillsValues(skillsValues, skillPointsValues, booksAmountValues);
    }

    public void showStatsValues(List<String> statsValues) {
        statsPanel.showStatsValues(statsValues);
    }

    public void setFirstLineRed(boolean bool) {
        displayTextPanel.setFirstLineRed(bool);
    }

    public void setCharBuildingMessage(int specialPointsToUse, int traitsLeft, int skillTagsLeft) {
        displayTextPanel.setCharBuildingMessage(specialPointsToUse, traitsLeft, skillTagsLeft);
    }

    public void showLevelAndExpValues(int level, int exp, boolean hasNewPerk) {
        displayTextPanel.showLevelAndExpValues(level, exp, hasNewPerk);
    }

    public void showSkillPoints(int points) {
        skillPointsPanel.showSkillPoints(points);
    }

    public void setPerksColors(List<String> takenPerksNames, List<String> availablePerksNames, List<String> unAvailablePerksNames) {
        perksPanel.setColors(takenPerksNames, availablePerksNames, unAvailablePerksNames);
    }

    public void setSupportPerksColors(List<String> takenSupportPerksNames, List<String> availableSupportPerksNames, List<String> unAvailableSupportPerksNames) {
        supportsPanel.setColors(takenSupportPerksNames, availableSupportPerksNames, unAvailableSupportPerksNames);
    }

    public void setImplantsColors(List<String> takenImplantsNames, List<String> availableImplantsNames, List<String> unAvailableImplantsNames) {
        implantsPanel.setColors(takenImplantsNames, availableImplantsNames, unAvailableImplantsNames);
    }

    public void setMasteriesColors(List<String> takenMasteriesNames, List<String> availableMasteriesNames, List<String> unAvailableMasteriesNames) {
        masteriesPanel.setColors(takenMasteriesNames, availableMasteriesNames, unAvailableMasteriesNames);
    }

    public void setDrugsColors(Boolean created, List<String> takenDrugsNames) {
        drugsPanel.setColors(created, takenDrugsNames);
    }

    public void setTraitsColors(Boolean created, List<String> takenTraitsNames) {
        traitsPanel.setColors(created, takenTraitsNames);
    }

    public void setSkillsColors(List<String> taggedSkills) {
        skillsPanel.setColors(taggedSkills);
    }

    public void changeSkillPointsPerClickIcons(int skillPointsPerClick) {
        skillPointsPanel.changeIcons(skillPointsPerClick);
    }


    public void refreshTraitsTips(Map<String, String> traitsTipsMap) {
        traitsPanel.refreshTips(traitsTipsMap);
    }

    public void refreshDrugsTips(Map<String, String> drugsTipsMap) {
        drugsPanel.refreshTips(drugsTipsMap);
    }

    public void refreshPerksTips(Map<String, String> perksTipsMap) {
        perksPanel.refreshTips(perksTipsMap);
    }

    public void refreshMasteriesTips(Map<String, String> perksTipsMap) {
        masteriesPanel.refreshTips(perksTipsMap);
    }

    public void refreshImplantsTips(Map<String, String> implantsTipsMap) {
        implantsPanel.refreshTips(implantsTipsMap);
    }

    public void refreshSupportsTips(Map<String, String> supportsTipsMap) {
        supportsPanel.refreshTips(supportsTipsMap);
    }
}

