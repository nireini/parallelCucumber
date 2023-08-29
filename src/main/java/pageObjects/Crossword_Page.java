package pageObjects;

import enums.ByTypes;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class Crossword_Page extends Base_PO{

    public @FindBy(xpath = "//button[@mode=\"primary\"]") WebElement AGREE_BUTTON_XPATH;
    public @FindBy(css = "div.ark-ad-button-text.ctaButtonText") WebElement PLAY_BUTTON_CSS;
    public @FindBy(css = "h3._3zgsysvIVJUoGnTj1_uckR.title_title__1huCZ.gameEndPopup_title__1wufI") WebElement TITLE_RESULTS_CSS;

 //   public @FindBy(xpath = "//h4[text()=\"Daily Bonus\"]/../../..") WebElement Current_Day_With_Daily_Bonus_XPATH;
    public @FindBy(id = GAMEIFRAME_ID) WebElement GAMEIFRAME_Element_ID;
    public @FindBy(css = DateOfPuzzle_CSS) WebElement DateOfPuzzle_Element_CSS;
    private static final String Current_Day_With_Daily_Bonus_XPATH = "//h4[text()=\"Daily Bonus\"]/../../..";
    private static final String DateOfPuzzle_CSS = "span.game_inlinePuzzleInfo__3UbfO";



    private static final String REVEAL_BUTTON_CSS = "section._2cce2lyM9ASVcbS1hdRuAG._1AGIG0RqUtmcCzoW6cNRBH.game_hud__3COkM._39wC1gQoLh7Dua95rb15b5._140yJY3xbL2XQ0uyfbmrHk._3EpPQDKCBPGUiusdrEq0pV > button:nth-child(4) > div";
    private static final String REVEAL_PUZZLE_BUTTON_CSS = "section._2cce2lyM9ASVcbS1hdRuAG._1AGIG0RqUtmcCzoW6cNRBH.game_hud__3COkM._39wC1gQoLh7Dua95rb15b5._140yJY3xbL2XQ0uyfbmrHk._3EpPQDKCBPGUiusdrEq0pV > button:nth-child(4) > ul:nth-child(2) > li:nth-child(3)";
    private static final String GAMEIFRAME_ID = "game-canvas";

    public Crossword_Page() throws IOException {
        super();
    }

    public void getCrosswordPage() throws IOException {
        navigateTo_URL("https://www.gamelab.com/games/daily-quick-crossword");
    }

    public void clickOnAgreeButton() throws Exception {
        waitForWebElementAndClick(AGREE_BUTTON_XPATH);
    }

    public void clickOnPlayButton() throws Exception {
        waitForWebElementAndClick(PLAY_BUTTON_CSS);
    }

//    public void waitForCurrentDayLiElement() throws Exception {
//        switchToFrameAndWaitForElement(Current_Day_With_Daily_Bonus_XPATH, ByTypes.id, GAMEIFRAME_ID);
//    }

    public void clickOnCurrentDayWithDailyBonus() throws Exception {
        switchToFrameAndClickElement(ByTypes.xpath, Current_Day_With_Daily_Bonus_XPATH, GAMEIFRAME_ID, true);
    }

    public void CompareDateText(String ExpectedPuzzleDate) throws Exception {

        String searchText_1 = "Daily Quick Crossword: ";
        String searchText_2 = "By Michael Curl";

        //String Date_In_Crossword = waitForWebElementAndGetText(DateOfPuzzle_Element_CSS);
        String Date_In_Crossword  = GetTextFromElementInsideIframeByCSS(DateOfPuzzle_CSS, GAMEIFRAME_ID);

        String Date_In_Crossword_fix = Date_In_Crossword.replace(searchText_1, "");
        Date_In_Crossword_fix = Date_In_Crossword_fix.replace(searchText_2, "");

        System.out.println("Fixed date String: " + Date_In_Crossword_fix);

        Assert.assertEquals(Date_In_Crossword_fix, ExpectedPuzzleDate);
    }

    public void clickOnRevealButton() throws Exception {
        switchToFrameAndClickElement(ByTypes.css, REVEAL_BUTTON_CSS, GAMEIFRAME_ID, false);
    }

    public void clickOnRevealPuzzleButton() throws Exception {
        switchToFrameAndClickElement(ByTypes.css, REVEAL_PUZZLE_BUTTON_CSS, GAMEIFRAME_ID, false);
    }


}
