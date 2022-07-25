package front.front.pageObject;

import front.front.methods.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static constants.Constant.Urls.LOG_IN_PAGE;

public class LogInPage extends BasePage {

    public LogInPage(WebDriver driver) {
        super(driver); }

    @Step("Opening Log in page")
    public void open(){
        BasePage basePage = new BasePage(driver);
        basePage.open(LOG_IN_PAGE); }

    //Username login field
    private final By usernameField = By.id("username");

    //Password login field
    private final By passwordField = By.id("password");

    //Log in btn
    private final By btnLogIn = By.xpath("//*[@class='btn loginButton']");

    //Remember me checker
    private final By rememberMeChecker = By.xpath("//*[@class='rememberMe']");

    //Reset password button
    private final By resetPasswordButton = By.id("resetPasswordContainer");

    //Error message "Incorrect username or password."
    private final By errorMessageWrongNamePass= By.id("errorMessage");

    //Red edging because of error in username field
    private final By usernameRedEdging = By.xpath("//*[@class='text errorField'][@id ='username']");

    //Red edging because of error in password field
    private final By passwordRedEdging = By.xpath("//*[@class='text errorField'][@id ='password']");

    @Step("Finding 'Username' field")
    public WebElement usernameFieldFind() {
        WebElement usernameFieldFind = driver.findElement(usernameField);
        waitElementIsVisible(usernameFieldFind);
        return usernameFieldFind; }

    @Step("Clicking 'Username' field")
    public void usernameFieldClick() {
        waitElementClickable(usernameFieldFind()).click(); }

    @Step("Filling 'Username' field")
    public void usernameFieldFill(String text) {
        usernameFieldClick();
        driver.findElement(usernameField).sendKeys(text); }

    @Step("Finding 'Password' field")
    public WebElement passwordFieldFind() {
        WebElement passwordFieldFind = driver.findElement(passwordField);
        waitElementIsVisible(passwordFieldFind);
        return passwordFieldFind; }

    @Step("Clicking 'Password' field")
    public void passwordFieldClick() {
        waitElementClickable(passwordFieldFind()).click(); }

    @Step("Filling 'Password' field")
    public void passwordFieldFill(String text) {
        passwordFieldClick();
        driver.findElement(passwordField).sendKeys(text); }

    @Step("Finding 'Log in' button")
    public WebElement btnLogInFind() {
        WebElement btnLogInFind = driver.findElement(btnLogIn);
        waitElementIsVisible(btnLogInFind);
        return btnLogInFind; }

    @Step("Clicking 'Log in' button")
    public void btnLogInClick() {
        waitElementClickable(btnLogInFind()).click(); }

    @Step("Finding 'Remember me' checker")
    public WebElement rememberMeCheckerFind() {
        WebElement rememberMeCheckerFind = driver.findElement(rememberMeChecker);
        waitElementIsVisible(rememberMeCheckerFind);
        return rememberMeCheckerFind; }

    @Step("Clicking 'Remember me' checker")
    public void rememberMeCheckerClick() {
        waitElementClickable(rememberMeCheckerFind()).click(); }

    @Step("Finding 'Reset password' button")
    public WebElement resetPasswordButtonFind() {
        WebElement resetPasswordButtonFind = driver.findElement(resetPasswordButton);
        waitElementIsVisible(resetPasswordButtonFind);
        return resetPasswordButtonFind; }

    @Step("Clicking 'Reset password' button")
    public void resetPasswordButtonClick() {
        waitElementClickable(resetPasswordButtonFind()).click(); }

    @Step("Finding error message 'Incorrect username or password.'")
    public WebElement errorMessageWrongNamePassFind() {
        WebElement errorMessageWrongNamePassFind = driver.findElement(errorMessageWrongNamePass);
        waitElementIsVisible(errorMessageWrongNamePassFind);
        return errorMessageWrongNamePassFind; }

    @Step("Finding red edging on 'Username'")
    public WebElement usernameRedEdgingFind() {
        WebElement usernameRedEdgingFind = driver.findElement(usernameRedEdging);
        waitElementIsVisible(usernameRedEdgingFind);
        return usernameRedEdgingFind; }

    @Step("Finding red edging on 'Password'")
    public WebElement passwordRedEdgingFind() {
        WebElement passwordRedEdgingFind = driver.findElement(passwordRedEdging);
        waitElementIsVisible(passwordRedEdgingFind);
        return passwordRedEdgingFind; }
}
