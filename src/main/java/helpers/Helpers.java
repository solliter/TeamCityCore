package helpers;

import front.front.methods.BasePage;
import io.qameta.allure.Step;
import org.awaitility.Awaitility;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class Helpers extends BasePage {
    protected WebDriver driver;

    public Helpers(WebDriver driver){
        super(driver);
        this.driver = driver; }

    @Step("Checking URL")
    public void checkUrl(String url){
    Awaitility.given().ignoreException(AssertionError.class)
                .await().pollInterval(5, TimeUnit.MILLISECONDS).atMost(10, TimeUnit.SECONDS)
                .until(() -> driver.getCurrentUrl().equals(url)); }

    @Step("Checking text")
    public void checkText(WebElement elementsToFind, String elements){
        waitElementIsVisible(elementsToFind);
        assertThat(elementsToFind.getText(), is(elements)); }

    @Step("Performing click on the page")
    public void clickPage() throws AWTException {
    Actions actions = new Actions(driver);
    Robot robot = new Robot();
    robot.mouseMove(50,50);
    actions.click().build().perform();}
}
