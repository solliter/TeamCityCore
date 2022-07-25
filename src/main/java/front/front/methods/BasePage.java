package front.front.methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static constants.Constant.TimeOutVariables.EXPLICIT_WAIT;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public void open(String url){
        driver.get(url);
    }

    public WebElement waitElementIsVisible(WebElement element){
        new WebDriverWait(driver, EXPLICIT_WAIT).until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public WebElement waitElementClickable(WebElement element){
        new WebDriverWait(driver, EXPLICIT_WAIT).until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }
    public Boolean waitAttribute(WebElement element, String attribute, String value){
        return new WebDriverWait(driver, EXPLICIT_WAIT).until(ExpectedConditions.attributeContains(element,attribute,value));
    }

    public Boolean waitElementHaveText(WebElement element, String text){
        return new WebDriverWait(driver, EXPLICIT_WAIT).until(ExpectedConditions.textToBePresentInElementValue(element, text));
    }

    public WebElement waitElementEnabled(WebElement element){
        new WebDriverWait(driver, EXPLICIT_WAIT).until(ExpectedConditions.stalenessOf(element));
        return element;
    }

    public String waitTextIsVisible(By by, String text){
        new WebDriverWait(driver,EXPLICIT_WAIT).until(ExpectedConditions.textToBe(by,text));
        return text;
    }

    public String waitElementLocated(String cssSelector){
    new WebDriverWait(driver, EXPLICIT_WAIT).until(
            ExpectedConditions.presenceOfElementLocated((By.cssSelector(cssSelector))));
            return cssSelector;

    }
}
