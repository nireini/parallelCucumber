package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.Base_PO;
import pageObjects.Crossword_Page;
import pageObjects.Level_Completion_Screen_Page;
import pageObjects.PlayMorePage;
import utils.Date;

import java.io.IOException;

public class CrosswordSteps extends Base_PO {

    private Crossword_Page crosswordPage;
    private Level_Completion_Screen_Page level_completion_screen_page;
    private PlayMorePage playMorePage;

    public CrosswordSteps(Crossword_Page crosswordPage, Level_Completion_Screen_Page level_completion_screen_page, PlayMorePage playMorePage) {
        this.crosswordPage = crosswordPage;
        this.level_completion_screen_page = level_completion_screen_page;
        this.playMorePage = playMorePage;
    }

    @Given("I access the Daily Quick Crossword page")
    public void I_access_the_Daily_Quick_Crossword_page() throws IOException {
        crosswordPage.getCrosswordPage();
    }

    @When("I click agree button")
    public void I_click_agree_button() throws Exception {
        crosswordPage.clickOnAgreeButton();
    }

    @And("I click play button")
    public void I_click_play_button() throws Exception {
        crosswordPage.clickOnPlayButton();
    }

    @And("click On Current Day With Daily Bonus")
    public void click_on_current_day_with_daily_bonus() throws Exception {
        crosswordPage.clickOnCurrentDayWithDailyBonus();
    }

    @And("Compare Date Text")
    public void Compare_Date_Text() throws Exception {
        Date date = new Date();
        crosswordPage.CompareDateText(date.getCurrentDate());
    }

    @And("click On Reveal Button")
    public void click_on_reveal_button() throws Exception {
        crosswordPage.clickOnRevealButton();
    }
    @And("click On Reveal Puzzle Button")
    public void click_on_reveal_puzzle_button() throws Exception {
        crosswordPage.clickOnRevealPuzzleButton();
    }
    @And("Check Results Title Is Displayed")
    public void check_results_title_is_displayed() throws Exception {
        level_completion_screen_page.CheckResultsTitleIsDisplayed();
    }

    @And("Check SECTION COMPLETED WITHOUT HELP OR ERRORS Is_Displayed")
    public void check_section_completed_without_help_or_errors_is_displayed() throws Exception {
        level_completion_screen_page.Check_SECTION_COMPLETED_WITHOUT_HELP_OR_ERRORS_Is_Displayed();
    }
    @And("Check RESULT FOR COMPLETED WITHOUT HELP OR ERRORS Is Displayed")
    public void check_result_for_completed_without_help_or_errors_is_displayed() throws Exception {
        level_completion_screen_page.Check_RESULT_FOR_COMPLETED_WITHOUT_HELP_OR_ERRORS_Is_Displayed();
    }
    @And("Check SECTION COMPLETION SCORE is displayed")
    public void check_section_completion_score_is_displayed() throws Exception {
        level_completion_screen_page.Check_SECTION_COMPLETION_SCORE_Is_Displayed();
    }
    @And("Check RESULT FOR COMPLETION SCORE is displayed")
    public void check_result_for_completion_score_is_displayed() throws Exception {
        level_completion_screen_page.Check_RESULT_FOR_COMPLETION_SCORE_Is_Displayed();
    }
    @And("Check SECTION TIME is displayed")
    public void check_section_time_is_displayed() throws Exception {
        level_completion_screen_page.Check_SECTION_TIME_Is_Displayed();
    }
    @And("Check RESULT FOR PUZZLE TIME COMPLETION is displayed")
    public void check_result_for_puzzle_time_completion_is_displayed() throws Exception {
        level_completion_screen_page.Check_RESULT_FOR_PUZZLE_TIME_COMPLETION_Is_Displayed();
    }
    @And("Check SECTION DAILY BONUS is displayed")
    public void check_section_daily_bonus_is_displayed() throws Exception {
        level_completion_screen_page.Check_SECTION_DAILY_BONUS_Is_Displayed();
    }
    @And("Check RESULT FOR DAILY BONUS is displayed")
    public void check_result_for_daily_bonus_is_displayed() throws Exception {
        level_completion_screen_page.Check_RESULT_FOR_DAILY_BONUS_Is_Displayed();
    }
    @And("Check SECTION PUZZLE SCORE is displayed")
    public void check_section_puzzle_score_is_displayed() throws Exception {
        level_completion_screen_page.Check_SECTION_PUZZLE_SCORE_Is_Displayed();
    }
    @And("Check RESULT FOR PUZZLE SCORE is displayed")
    public void check_result_for_puzzle_score_is_displayed() throws Exception {
        level_completion_screen_page.Check_RESULT_FOR_PUZZLE_SCORE_Is_Displayed();
    }
    @And("Check SECTION TOTAL SCORE is displayed")
    public void check_section_total_score_is_displayed() throws Exception {
        level_completion_screen_page.Check_SECTION_TOTAL_SCORE_Is_Displayed();
    }
    @And("Check RESULT FOR TOTAL SCORE is displayed")
    public void check_result_for_total_score_is_displayed() throws Exception {
        level_completion_screen_page.Check_RESULT_FOR_TOTAL_SCORE_Is_Displayed();
    }
    @And("Check SECTION ONE PUZZLE THIS MONTH is displayed")
    public void check_section_one_puzzle_this_month_is_displayed() throws Exception {
        level_completion_screen_page.Check_SECTION_ONE_PUZZLE_THIS_MONTH_Is_Displayed();
    }

    @And("Check REVIEW ANSWERS BUTTON is displayed")
    public void check_review_answers_button_is_displayed() throws Exception {
        level_completion_screen_page.Check_REVIEW_ANSWERS_BUTTON_Is_Displayed();
        captureScreenshot();
    }


    @And("Click Submit total score button")
    public void Click_submit_total_score_button() throws Exception {
        level_completion_screen_page.Click_Submit_Total_Score_Button();
    }

    @Then("Click on play again button")
    public void click_On_Play_Again_Button() throws Exception {
        playMorePage.clickOnPlayAgainButton();
    }


}
