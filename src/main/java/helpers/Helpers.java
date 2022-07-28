package helpers;

import front.front.methods.BasePage;
import io.qameta.allure.Step;
import org.awaitility.Awaitility;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.startsWith;

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
            Awaitility.given().ignoreException(AssertionError.class)
                    .await().pollInterval(5, TimeUnit.MILLISECONDS).atMost(10, TimeUnit.SECONDS)
                    .until(elementsToFind::getText, startsWith(elements)); }


   @Step("scroll down to element")
    public void scrollToElement(WebElement element) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // This will scroll the page till the element is found
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(600); }

    @Step("Getting date and time")
    public String dateTimeNow(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d MMM yy HH:mm");
        LocalDateTime localDate = LocalDateTime.now();
        return dtf.format(localDate); }

}
