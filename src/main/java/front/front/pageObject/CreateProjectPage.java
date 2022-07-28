package front.front.pageObject;

import front.front.methods.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.*;

import java.util.List;

public class CreateProjectPage extends BasePage {

    public CreateProjectPage(WebDriver driver) {
        super(driver); }

    //Create project from Git Hub btn
    private final By fromGitHubBtn = By.xpath("//a[contains(@href,'#github')]");

    //TeamCityLogIn repository
    private  By gitHubRepo(int number) {
        return By.xpath("//*[@id='1328233730']/li["+ number +"]");}

    //Parent project field
    private final By parentProjectField = By.xpath("//label[contains(text(), 'Parent project:')]");

    //Choose a repository field
    private final By chooseRepositoryField = By.xpath("//th[contains(text(), 'Choose a repository:')]//span");

    //Create Project title
    private final By createProjectTitle = By.xpath("//*[@id='restPageTitle']");

    //Message about successful connection
    private final By successfulMessageConnection = By.xpath("//*[@class='connectionSuccessful']");

    //Project name field
    private final By projectNameField = By.xpath("//*[@name ='buildTypeName']");

    //Build configuration name field
    private final By buildConfigurationNameField = By.xpath("//th[contains(text(), 'Build configuration name:')]");

    //VCS root field
    private final By vcsRootField = By.xpath("//th[contains(text(), 'VCS root:')]");

    //Default branch field
    private final By defaultBranchField = By.xpath("//label[contains(text(), 'Default branch:')]");

    //Branch specification field
    private final By branchSpecificationField = By.xpath("//label[contains(text(), 'Branch specification:')]");

    //Btn proceed
    private final By proceedBtn = By.xpath("//*[@name='createProject']");

    //Btn cancel
    private final By cancelBtn = By.xpath("//div[@class='saveButtonsBlock']//a[contains(text(), 'Cancel')]");

    //Message about success operation create new project
    private final By successMessage = By.xpath("//*[@class = 'successMessage ']");

    //Auto-detected Build Steps title
    private final By autoDetectedBuildSteps = By.xpath("//h2[contains(text(), 'Auto-detected Build Steps')]");

    //Auto-detected Build Steps
    private By checkBoxBuildSteps(int id) { return By.xpath("(//*[@class='custom-checkbox ring-checkbox-checkbox'])["+id+"]");}

    //Use selected btn
    private final By useSelectedBtn = By.xpath("//*[@class='btn btn_primary']");

    //Refresh btn
    private final By refreshBtn = By.id("updateDiscoveryContainer");

    //Loading build steps
    private final By loadingBuildSteps = By.xpath("//div[@id='discoveryProgressContainer'][contains(@style,'display: none;')]");

    //Run first build btn
    private final By runFirstBuildBtn = By.xpath("//*[@class = 'btn btn_mini runFirstBuild']");



    @Step("Finding 'from Git Hub' btn on create project page")
    public WebElement fromGitHubBtnFind() {
        WebElement fromGitHubBtnFind = driver.findElement(fromGitHubBtn);
        waitElementIsVisible(fromGitHubBtnFind);
        return fromGitHubBtnFind; }

    @Step("Clicking 'from Git Hub' btn")
    public void fromGitHubBtnClick() {
        waitElementClickable(fromGitHubBtnFind()).click(); }

    @Step("Searching id by repository name")
    public int getRepositoryIdByName(String text) {
        List<WebElement> runBuildBtnFind = driver.findElements(By.xpath("//*[@id='1328233730']//li"));
        int i;
        for(i = 1;i<runBuildBtnFind.size(); i++){
            if(runBuildBtnFind.get(i).getText().startsWith(text)){
                i++;
                break;
            }} return i; }

    @Step("Finding 'from Git Hub' btn on create project page")
    public WebElement gitHubRepoFind(String text) {
        WebElement gitHubRepoFind = driver.findElement(gitHubRepo(getRepositoryIdByName(text)));
        waitElementIsVisible(gitHubRepoFind);
        return gitHubRepoFind; }

    @Step("Clicking 'from Git Hub' btn")
    public void gitHubRepoClick(String text) {
        waitElementClickable(gitHubRepoFind(text)).click(); }

    @Step("Finding 'Parent project' field")
    public WebElement parentProjectFieldFind() {
        WebElement parentProjectFieldFind = driver.findElement(parentProjectField);
        waitElementIsVisible(parentProjectFieldFind);
        return parentProjectFieldFind; }

    @Step("Finding 'Choose a repository' field")
    public WebElement chooseRepositoryFieldFind() {
        WebElement chooseRepositoryFieldFind = driver.findElement(chooseRepositoryField);
        waitElementIsVisible(chooseRepositoryFieldFind);
        return chooseRepositoryFieldFind; }

    @Step("Finding 'Create Project From URL' title")
    public WebElement createProjectFromUrlTitleFind() {
        WebElement createProjectFromUrlTitleFind = driver.findElement(createProjectTitle);
        waitElementIsVisible(createProjectFromUrlTitleFind);
        return createProjectFromUrlTitleFind; }

    @Step("Finding message about successful connection")
    public WebElement successfulMessageConnectionFind() {
        WebElement successfulMessageConnectionFind = driver.findElement(successfulMessageConnection);
        waitElementIsVisible(successfulMessageConnectionFind);
        return successfulMessageConnectionFind; }

    @Step("Finding 'Project name' field")
    public WebElement projectNameFieldFind() {
        WebElement projectNameFieldFind = driver.findElement(projectNameField);
        waitElementIsVisible(projectNameFieldFind);
        return projectNameFieldFind; }

    @Step("Clicking 'Project name' field")
    public void projectNameFieldClick() {
        waitElementClickable(projectNameFieldFind()).click(); }

    @Step("Filling 'Project name' field")
    public void projectNameFieldFill(String text) {
        projectNameFieldClick();
        driver.findElement(projectNameField).clear();
        driver.findElement(projectNameField).sendKeys(text +" build");}

    @Step("Finding 'Build configuration name' field")
    public WebElement buildConfigurationNameFieldFind() {
        WebElement buildConfigurationNameFieldFind = driver.findElement(buildConfigurationNameField);
        waitElementIsVisible(buildConfigurationNameFieldFind);
        return buildConfigurationNameFieldFind; }

    @Step("Finding 'VCS root' field")
    public WebElement vcsRootFieldFind() {
        WebElement vcsRootFieldFind = driver.findElement(vcsRootField);
        waitElementIsVisible(vcsRootFieldFind);
        return vcsRootFieldFind; }

    @Step("Finding 'Default branch' field")
    public WebElement defaultBranchFieldFind() {
        WebElement defaultBranchFieldFind = driver.findElement(defaultBranchField);
        waitElementIsVisible(defaultBranchFieldFind);
        return defaultBranchFieldFind; }

    @Step("Finding 'Branch specification' field")
    public WebElement branchSpecificationFieldFind() {
        WebElement branchSpecificationFieldFind = driver.findElement(branchSpecificationField);
        waitElementIsVisible(branchSpecificationFieldFind);
        return branchSpecificationFieldFind; }

    @Step("Finding 'Proceed' btn")
    public WebElement proceedBtnFind() {
        WebElement proceedBtnFind = driver.findElement(proceedBtn);
        waitElementIsVisible(proceedBtnFind);
        return proceedBtnFind; }

    @Step("Clicking 'Proceed' btn")
    public void proceedBtnClick() {
        waitElementClickable(proceedBtnFind()).click(); }

    @Step("Finding 'Cancel' btn")
    public WebElement cancelBtnFind() {
        WebElement cancelBtnFind = driver.findElement(cancelBtn);
        waitElementIsVisible(cancelBtnFind);
        return cancelBtnFind; }

    @Step("Clicking 'Cancel' btn")
    public void cancelBtnClick() {
        waitElementClickable(cancelBtnFind()).click(); }

    @Step("Finding Success message")
    public WebElement successMessageFind() {
        WebElement successMessageFind = driver.findElement(successMessage);
        try {
            waitElementIsVisible(successMessageFind);
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            waitElementIsVisible(successMessageFind);
        }
        return successMessageFind; }

    @Step("Auto-detected Build Steps title")
    public WebElement autoDetectedBuildStepsFind() {
        WebElement autoDetectedBuildStepsFind = driver.findElement(autoDetectedBuildSteps);
        waitElementIsVisible(autoDetectedBuildStepsFind);
        return autoDetectedBuildStepsFind; }

    @Step("Finding build Steps checkbox")
    public WebElement checkBoxBuildStepsFind() {
        WebElement checkBoxBuildStepsFind = driver.findElement(checkBoxBuildSteps(2));
            try{
                waitElementIsVisible(checkBoxBuildStepsFind);
            }catch (TimeoutException e ){
                return driver.findElement(checkBoxBuildSteps(1));
            }
        return checkBoxBuildStepsFind; }

    @Step("Clicking build Steps checkbox")
    public void checkBoxBuildStepsClick() {
        waitElementClickable(checkBoxBuildStepsFind()).click(); }

    @Step("Finding 'Use selected' btn")
    public WebElement useSelectedBtnFind() {
        WebElement useSelectedBtnFind = driver.findElement(useSelectedBtn);
        waitElementIsVisible(useSelectedBtnFind);
        return useSelectedBtnFind; }

    @Step("Clicking 'Use selected' btn")
    public void useSelectedBtnClick() {
        waitElementClickable(useSelectedBtnFind()).click(); }

    @Step("Finding 'Refresh' btn")
    public WebElement refreshBtnFind() {
        WebElement refreshBtnFind = driver.findElement(refreshBtn);
        waitElementIsVisible(refreshBtnFind);
        return refreshBtnFind; }

    @Step("Clicking 'Refresh' btn")
    public void refreshBtnClick() {
        waitElementClickable(refreshBtnFind()).click(); }

    @Step("Waiting loading build steps")
    public By loadingBuildStepsFind() {
        return waitElementIsInvisible(loadingBuildSteps);}

    @Step("Finding 'Run' btn")
    public WebElement runFirstBuildBtnFind() {
        WebElement runFirstBuildBtnFind = driver.findElement(runFirstBuildBtn);
        waitElementIsVisible(runFirstBuildBtnFind);
        return runFirstBuildBtnFind; }

    @Step("Clicking 'Run' btn")
    public void runFirstBuildBtnClick() {
        waitElementClickable(runFirstBuildBtnFind()).click(); }





}
