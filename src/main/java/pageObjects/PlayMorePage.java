package pageObjects;

import enums.ByTypes;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class PlayMorePage extends Base_PO{
    public PlayMorePage() throws IOException {
        super();
    }

    public @FindBy(css = "button[data-element-description=\"game-end play-again-button\"]") WebElement PLAY_AGAIN_BUTTON_CSS;

    public void clickOnPlayAgainButton() throws Exception {
        waitForWebElementAndClick(PLAY_AGAIN_BUTTON_CSS);
    }
}
