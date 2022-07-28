package front.front.pageObject;

import front.front.methods.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver); }

    //Main page title
    private final By mainPageTitle = By.id("restPageTitle");

    //Main page create project btn
    private final By createProjectBtn = By.xpath("//span[contains(text(), 'Create project')]");

    //Project name in build
    private By projectNameBuild(String repositoryName){ return By.xpath("//*[@data-projectid = '"+repositoryName+"']");}

    //Project name in projects
    private By projectNameProjects(String repositoryName){ return By.xpath("//a[contains(text(), '"+repositoryName+"')]");}

    //Build name
    private By buildName(String repositoryName){ return By.xpath("//a[contains(text(), '"+repositoryName+" build')]");}

    //Build date time
    private By buildDateTime(String date) { return By.xpath("//span[contains(text(), '"+date+"')]");}

    //Projects btn
    private final By projectBtn = By.xpath("//a[@title='Projects']/span[@class= 'ring-link-inner']");

    //Administration btn
    private final By administrationBtn = By.xpath("//*[@title= 'Administration']//span");

    //Waiting autotests pass
    private final By waitingTillTestsPass = By.xpath("//*[@class='passCount']");

    //Edit Configuration Settings btn
    private final By editConfigBtn = By.xpath("//*[@title='Edit build configuration settings']");

    //No builds in this project text
    private final By emptyProjectText = By.xpath("//p[@class='empty-project-text']");

    //Description of the build on a build page
    private final By buildDescription = By.xpath("//div[@id='restPageDescription']");

    //Run build btn
    private final By runBuildBtn = By.xpath("//*[@class = 'btn btn_mini ']");

    //Build detail btn
    private By buildDetailBtn(int i) {  return By.xpath("//*[@class='ring-link-link BuildNumber__link--of Link__link--ZK Link__conservative--M2 ring-link-text']["+i+"]");}

    //Searching problems in bad repository build
    private final By problemsBuild = By.xpath("//*[@id='buildProblems']");


    @Step("Finding main page title")
    public WebElement mainPageTitleFind() {
        WebElement mainPageTitleFind = driver.findElement(mainPageTitle);
        waitElementIsVisible(mainPageTitleFind);
        return mainPageTitleFind; }

    @Step("Finding 'create project' btn on main page")
    public WebElement createProjectBtnFind() {
        WebElement createProjectBtnFind = driver.findElement(createProjectBtn);
        waitElementIsVisible(createProjectBtnFind);
        return createProjectBtnFind; }

    @Step("Clicking 'create project' btn")
    public void createProjectBtnClick() {
        waitElementClickable(createProjectBtnFind()).click(); }

    @Step("Finding project name")
    public WebElement projectNameFind(String repositoryName) {
        WebElement projectNameFind = driver.findElement(projectNameBuild(repositoryName));
        waitElementIsVisible(projectNameFind);
        return projectNameFind; }

    @Step("Finding build name")
    public WebElement buildNameFind(String repositoryName) {
        WebElement projectNameFind = driver.findElement(buildName(repositoryName));
        waitElementIsVisible(projectNameFind);
        return projectNameFind; }


    @Step("Clicking build name")
    public void buildNameClick(String repositoryName) {
        waitElementClickable(buildNameFind(repositoryName)).click(); }

    @Step("Finding date time")
    public WebElement buildDateTimeFind(String date) {
        WebElement buildDateTimeFind = driver.findElement(buildDateTime(date));
        waitElementIsVisible(buildDateTimeFind);
        return buildDateTimeFind; }

    @Step("Finding 'Projects' btn")
    public WebElement projectsBtnFind() {
        WebElement projectsBtnFind = driver.findElement(projectBtn);
        waitElementIsVisible(projectsBtnFind);
        return projectsBtnFind; }

    @Step("Clicking 'Projects' btn")
    public void projectsBtnClick() {
        try {
            waitElementClickable(projectsBtnFind()).click();
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            waitElementClickable(projectsBtnFind()).click();
        } }

    @Step("Finding project name in projects")
    public WebElement projectNameProjectsFind(String repositoryName) {
        WebElement projectBtnFind = driver.findElement(projectNameProjects(repositoryName));
        waitElementIsVisible(projectBtnFind);
        return projectBtnFind; }

    @Step("Find 'Administration' btn")
    public WebElement administrationBtnFind() {
        WebElement administrationBtnFind = driver.findElement(administrationBtn);
        waitElementIsVisible(administrationBtnFind);
        return administrationBtnFind; }

    @Step("Click 'Administration' btn")
    public void administrationBtnClick() {
        waitElementClickable(administrationBtnFind()).click(); }

    @Step("Waiting until all tests passed")
    public WebElement waitingTillTestsPassFind() {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofMillis(5))
                .ignoring(NoSuchElementException.class);
        return wait.until(driver1 -> driver1.findElement(waitingTillTestsPass)); }

    @Step("Find 'Edit Configuration Settings' btn")
    public WebElement editConfigBtnFind() {
        WebElement editConfigBtnFind = driver.findElement(editConfigBtn);
        waitElementIsVisible(editConfigBtnFind);
        return editConfigBtnFind; }

    @Step("Click 'Edit Configuration Settings' btn")
    public void editConfigBtnClick() {
        waitElementClickable(editConfigBtnFind()).click(); }

    @Step("Finding empty project text ")
    public WebElement emptyProjectTextFind() {
        WebElement emptyProjectTextFind = driver.findElement(emptyProjectText);
        waitElementIsVisible(emptyProjectTextFind);
        return emptyProjectTextFind; }

    @Step("Finding description of the build ")
    public WebElement buildDescriptionFind() {
        WebElement buildDescriptionFind = driver.findElement(buildDescription);
        waitElementIsVisible(buildDescriptionFind);
        return buildDescriptionFind; }

    @Step("Finding 'Run' btn")
    public WebElement runBuildBtnFind() {
        WebElement runBuildBtnFind = driver.findElement(runBuildBtn);
        waitElementIsVisible(runBuildBtnFind);
        return runBuildBtnFind; }

    @Step("Clicking 'Run' btn")
    public void runBuildBtnCl1ick() {
        waitElementClickable(runBuildBtnFind()).click(); }

    @Step("Finding buildDetail btn")
    public WebElement buildDetailBtnFind() {
        int i = 1;
        WebElement buildDetailBtnFind = driver.findElement(buildDetailBtn(i));
        try{waitElementIsVisible(buildDetailBtnFind);} catch (Exception e){
            i++;
            buildDetailBtnFind = driver.findElement(buildDetailBtn(i));
            waitElementIsVisible(buildDetailBtnFind);
        }
        return buildDetailBtnFind; }

    @Step("Clicking buildDetail btn")
    public void buildDetailBtnClick() {
        waitElementClickable(buildDetailBtnFind()).click(); }

    @Step("Waiting until all tests passed")
    public WebElement waitingTillAddedToQueueFind() {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofMillis(5))
                .ignoring(NoSuchElementException.class);
        return wait.until(driver1 -> driver1.findElement(By.xpath("//*[@class='ring-link-link BuildNumber__link--of Link__link--ZK Link__conservative--M2 ring-link-text']"))); }

    @Step("Finding problems in bad repository build")
    public WebElement problemsBuildFind() {
        WebElement problemsBuildFind = driver.findElement(problemsBuild);
        waitElementIsVisible(problemsBuildFind);
        return problemsBuildFind; }

    @Step("Waiting until all tests fall")
    public WebElement waitingTillTestsFallFind() {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofMillis(5))
                .ignoring(NoSuchElementException.class);
        return wait.until(driver1 -> driver1.findElement(problemsBuild)); }
}
