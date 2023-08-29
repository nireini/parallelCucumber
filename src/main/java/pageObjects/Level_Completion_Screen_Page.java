package pageObjects;

import enums.ByTypes;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Level_Completion_Screen_Page extends Base_PO{

    @FindBy(css = "h3._3zgsysvIVJUoGnTj1_uckR.title_title__1huCZ.gameEndPopup_title__1wufI") WebElement TITLE_RESULTS_CSS;
    @FindBy(css = "section._2cce2lyM9ASVcbS1hdRuAG.game_subContainer__2Z9rk._39wC1gQoLh7Dua95rb15b5._140yJY3xbL2XQ0uyfbmrHk > div > article > section > section > section._2cce2lyM9ASVcbS1hdRuAG.gameEndPopup_submitContainer__3c7bp._39wC1gQoLh7Dua95rb15b5._140yJY3xbL2XQ0uyfbmrHk.lrDkyz8O__XunQqaHezep._3EpPQDKCBPGUiusdrEq0pV > button:nth-child(1)") WebElement BUTTON_REVIEW_ANSWERS_CSS;
    @FindBy(css = "section._1WOLqIpDmSmsJGpFvS9fPR.gameEndPopup_window__Y44DQ > section:nth-child(2) > section:nth-child(2) > h4") WebElement SECTION_COMPLETED_WITHOUT_HELP_OR_ERRORS_CSS;
    @FindBy(css = "section._1WOLqIpDmSmsJGpFvS9fPR.gameEndPopup_window__Y44DQ > section:nth-child(2) > section:nth-child(2) > h2") WebElement RESULT_FOR_COMPLETED_WITHOUT_HELP_OR_ERRORS_CSS;
    @FindBy(css = "section._1WOLqIpDmSmsJGpFvS9fPR.gameEndPopup_window__Y44DQ > section:nth-child(2) > section:nth-child(3) > h4") WebElement SECTION_COMPLETION_SCORE_CSS;
    @FindBy(css = "section._1WOLqIpDmSmsJGpFvS9fPR.gameEndPopup_window__Y44DQ > section:nth-child(2) > section:nth-child(3) > h2") WebElement RESULT_FOR_COMPLETION_SCORE_CSS;
    @FindBy(css = "section._1WOLqIpDmSmsJGpFvS9fPR.gameEndPopup_window__Y44DQ > section:nth-child(2) > section:nth-child(4) > h4") WebElement SECTION_TIME_CSS;
    @FindBy(css = "section._1WOLqIpDmSmsJGpFvS9fPR.gameEndPopup_window__Y44DQ > section:nth-child(2) > section:nth-child(4) > h2") WebElement RESULT_FOR_PUZZLE_TIME_COMPLETION_CSS;
    @FindBy(css = "section._1WOLqIpDmSmsJGpFvS9fPR.gameEndPopup_window__Y44DQ > section:nth-child(2) > section:nth-child(5) > h4") WebElement SECTION_DAILY_BONUS_CSS;
    @FindBy(css = "section._1WOLqIpDmSmsJGpFvS9fPR.gameEndPopup_window__Y44DQ > section:nth-child(2) > section:nth-child(5) > h2") WebElement RESULT_FOR_DAILY_BONUS_CSS;
    @FindBy(css = "section._1WOLqIpDmSmsJGpFvS9fPR.gameEndPopup_window__Y44DQ > section:nth-child(2) > section:nth-child(6) > h4") WebElement SECTION_PUZZLE_SCORE_CSS;
    @FindBy(css = "section._1WOLqIpDmSmsJGpFvS9fPR.gameEndPopup_window__Y44DQ > section:nth-child(2) > section:nth-child(6) > h2") WebElement RESULT_FOR_PUZZLE_SCORE_CSS;
    @FindBy(css = "section._1WOLqIpDmSmsJGpFvS9fPR.gameEndPopup_window__Y44DQ > section:nth-child(2) > section:nth-child(8) > section:nth-child(1) > h4:nth-child(1)") WebElement SECTION_TOTAL_SCORE_CSS;
    @FindBy(css = "section._1WOLqIpDmSmsJGpFvS9fPR.gameEndPopup_window__Y44DQ > section:nth-child(2) > section:nth-child(8) > h2") WebElement RESULT_FOR_TOTAL_SCORE_CSS;
    @FindBy(css = "section._1WOLqIpDmSmsJGpFvS9fPR.gameEndPopup_window__Y44DQ > section:nth-child(2) > section:nth-child(8) > section:nth-child(1) > h4:nth-child(2)") WebElement SECTION_ONE_PUZZLE_THIS_MONTH_CSS;
    private static final String GAMEIFRAME_ID = "game-canvas";

    private static final String BUTTON_SUBMIT_TOTAL_SCORE_CSS = "section._2cce2lyM9ASVcbS1hdRuAG.game_subContainer__2Z9rk._39wC1gQoLh7Dua95rb15b5._140yJY3xbL2XQ0uyfbmrHk > div > article > section > section > section._2cce2lyM9ASVcbS1hdRuAG.gameEndPopup_submitContainer__3c7bp._39wC1gQoLh7Dua95rb15b5._140yJY3xbL2XQ0uyfbmrHk.lrDkyz8O__XunQqaHezep._3EpPQDKCBPGUiusdrEq0pV > button:nth-child(2)";

    public Level_Completion_Screen_Page() {
        super();
    }

    public void CheckResultsTitleIsDisplayed() throws Exception {
        switchToFrameAndWaitForElement(TITLE_RESULTS_CSS, ByTypes.id, GAMEIFRAME_ID);
    }

    public void Check_SECTION_COMPLETED_WITHOUT_HELP_OR_ERRORS_Is_Displayed() throws Exception {
        switchToFrameAndWaitForElement(SECTION_COMPLETED_WITHOUT_HELP_OR_ERRORS_CSS, ByTypes.id, GAMEIFRAME_ID);
    }

    public void Check_RESULT_FOR_COMPLETED_WITHOUT_HELP_OR_ERRORS_Is_Displayed() throws Exception {
        switchToFrameAndWaitForElement(RESULT_FOR_COMPLETED_WITHOUT_HELP_OR_ERRORS_CSS, ByTypes.id, GAMEIFRAME_ID);
    }

    public void Check_SECTION_COMPLETION_SCORE_Is_Displayed() throws Exception {
        switchToFrameAndWaitForElement(SECTION_COMPLETION_SCORE_CSS, ByTypes.id, GAMEIFRAME_ID);
    }

    public void Check_RESULT_FOR_COMPLETION_SCORE_Is_Displayed() throws Exception {
        switchToFrameAndWaitForElement(RESULT_FOR_COMPLETION_SCORE_CSS, ByTypes.id, GAMEIFRAME_ID);
    }

    public void Check_SECTION_TIME_Is_Displayed() throws Exception {
        switchToFrameAndWaitForElement(SECTION_TIME_CSS, ByTypes.id, GAMEIFRAME_ID);
    }

    public void Check_RESULT_FOR_PUZZLE_TIME_COMPLETION_Is_Displayed() throws Exception {
        switchToFrameAndWaitForElement(RESULT_FOR_PUZZLE_TIME_COMPLETION_CSS, ByTypes.id, GAMEIFRAME_ID);
    }

    public void Check_SECTION_DAILY_BONUS_Is_Displayed() throws Exception {
        switchToFrameAndWaitForElement(SECTION_DAILY_BONUS_CSS, ByTypes.id, GAMEIFRAME_ID);
    }

    public void Check_RESULT_FOR_DAILY_BONUS_Is_Displayed() throws Exception {
        switchToFrameAndWaitForElement(RESULT_FOR_DAILY_BONUS_CSS, ByTypes.id, GAMEIFRAME_ID);
    }

    public void Check_SECTION_PUZZLE_SCORE_Is_Displayed() throws Exception {
        switchToFrameAndWaitForElement(SECTION_PUZZLE_SCORE_CSS, ByTypes.id, GAMEIFRAME_ID);
    }

    public void Check_RESULT_FOR_PUZZLE_SCORE_Is_Displayed() throws Exception {
        switchToFrameAndWaitForElement(RESULT_FOR_PUZZLE_SCORE_CSS, ByTypes.id, GAMEIFRAME_ID);
    }

    public void Check_SECTION_TOTAL_SCORE_Is_Displayed() throws Exception {
        switchToFrameAndWaitForElement(SECTION_TOTAL_SCORE_CSS, ByTypes.id, GAMEIFRAME_ID);
    }

    public void Check_RESULT_FOR_TOTAL_SCORE_Is_Displayed() throws Exception {
        switchToFrameAndWaitForElement(RESULT_FOR_TOTAL_SCORE_CSS, ByTypes.id, GAMEIFRAME_ID);
    }

    public void Check_SECTION_ONE_PUZZLE_THIS_MONTH_Is_Displayed() throws Exception {
        switchToFrameAndWaitForElement(SECTION_ONE_PUZZLE_THIS_MONTH_CSS, ByTypes.id, GAMEIFRAME_ID);
    }

    public void Check_REVIEW_ANSWERS_BUTTON_Is_Displayed() throws Exception {
        switchToFrameAndWaitForElement(BUTTON_REVIEW_ANSWERS_CSS, ByTypes.id, GAMEIFRAME_ID);
    }

    public void Click_Submit_Total_Score_Button() throws Exception {
        switchToFrameAndClickElement(ByTypes.css, BUTTON_SUBMIT_TOTAL_SCORE_CSS, GAMEIFRAME_ID, false);
    }

    public static void captureScreenshot(){
        captureScreenshot();
    }




}
