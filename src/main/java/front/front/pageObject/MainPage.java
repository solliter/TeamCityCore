package front.front.pageObject;

import front.front.methods.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static constants.Constant.Urls.LOG_IN_PAGE;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver); }

    //Main page title
    private final By mainPageTitle = By.id("restPageTitle");


    public WebElement mainPageTitleFind() {
        WebElement mainPageTitleFind = driver.findElement(mainPageTitle);
        waitElementIsVisible(mainPageTitleFind);
        return mainPageTitleFind; }



}
