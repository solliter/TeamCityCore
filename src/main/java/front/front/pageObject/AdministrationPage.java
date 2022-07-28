package front.front.pageObject;

import front.front.methods.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.util.List;

public class AdministrationPage extends BasePage {

    public AdministrationPage(WebDriver driver) {
        super(driver); }

    //Project name in administration btn
    private By projectNameAdmBtn(String repositoryName){ return By.xpath("//*[@href='/admin/editProject.html?init=1&projectId="+repositoryName+"']");}

    //Message about success operation delete of project
    private final By successMessage = By.xpath("//*[@id = 'message_projectRemoved']");

    //Name of the project in administration
    private final By administrationProjectName = By.xpath("//div[@class='selected project']//a");

    //Success message - build removed
    private final By getSuccessMessageBuildRemoved = By.xpath("//div[@id='message_buildTypeRemoved']");

    //Actions btn
    private final By actionsBtn = By.xpath("//span[@id = 'sp_span_prjActionsTeamCityLogIn']");
    //Actions btn in build administration
    private final By buildActionsBtn = By.xpath("//div[@data-hint-container-id = 'build-configuration-admin-actions']");
    //Actions

    //Delete btn
    private final By deleteBtn = By.xpath("//a[@title = 'Delete project']");
    //Delete dialog window
    private final By deleteDialogWindow = By.xpath("//div[@id = 'confirmDialog']");
    //Delete dialog window field
    private final By deleteDialogWindowField = By.xpath("//input[@id = 'deleteProject__hostnameConfirmation']");
    //Delete dialog window delete btn
    private final By deleteDialogWindowDeleteBtn = By.xpath("//input[@value= 'Delete']");

    //Delete in build administration
    private final By buildAdministrationDeleteBtn = By.xpath("//a[contains(text(), 'Delete...')] ");

    //Administration - build
    //Build name
    private final By buildNameField = By.xpath("//*[@id ='name']");

    //Regenerate id btn
    private final By regenerateIdBtn = By.xpath("//*[@class='regenerate']");

    //Build configuration ID field
    private final By buildConfigIdField = By.xpath("//*[@id ='externalId']");

    //Save btn
    private final By saveBtn = By.xpath("//*[@name='submitButton']");

    //Description field
    private final By descriptionField = By.xpath("//*[@id='description']");

    //Tabs

    //Version Control Settings tab
    private final By vcsTab = By.xpath("//li[@id='vcsRoots_Tab']");
    //VCS root title
    private final By vcsTabTitle = By.xpath("//*[contains(text(), 'VCS Roots')]");
    //VCS root edit btn
    private final By vcsRootEditBtn = By.xpath("//*[@class='edit highlight']/a[contains(text(), 'Edit')]");
    //Edit VCS root github btn
    private final By gitHubBtn = By.xpath("//*[@class='githubRepoControl']");
    //Edit VCS root save btn
    private final By saveEditVcsBtn = By.xpath("//*[@class='saveButtonsBlock']/input[@value='Save']");


    //TeamCityLogIn repository
    private  By gitHubRepo(int number) {
        return By.xpath("//*[@id='749239219']/li["+ number +"]");}


    @Step("Finding project name btn in administration")
    public WebElement projectNameAdmFind(String repositoryName) {
        WebElement projectNameAdmFind = driver.findElement(projectNameAdmBtn(repositoryName));
        waitElementIsVisible(projectNameAdmFind);
        return projectNameAdmFind; }

    @Step("Clicking project name btn in administration")
    public void projectNameAdmClick(String repositoryName) {
        waitElementClickable(projectNameAdmFind(repositoryName)).click(); }

    @Step("Finding 'Actions' btn")
    public WebElement actionsBtnFind() {
        WebElement actionsBtnFind = driver.findElement(actionsBtn);
        waitElementIsVisible(actionsBtnFind);
        return actionsBtnFind; }

    @Step("Clicking 'Actions' btn")
    public void actionsBtnClick() {
        waitElementClickable(actionsBtnFind()).click(); }

    @Step("Finding 'Actions' btn")
    public WebElement buildActionsBtnFind() {
        WebElement buildActionsBtnFind = driver.findElement(buildActionsBtn);
        waitElementIsVisible(buildActionsBtnFind);
        return buildActionsBtnFind; }

    @Step("Clicking 'Actions' btn")
    public void buildActionsBtnClick() {
        waitElementClickable(buildActionsBtnFind()).click(); }

    @Step("Finding 'Actions' btn")
    public WebElement deleteBtnFind() {
        WebElement deleteBtnFind = driver.findElement(deleteBtn);
        waitElementIsVisible(deleteBtnFind);
        return deleteBtnFind; }

    @Step("Clicking 'Actions' btn")
    public void deleteBtnClick() {
        waitElementClickable(deleteBtnFind()).click(); }

    @Step("Finding delete dialog window")
    public WebElement deleteDialogWindowFind() {
        WebElement deleteBtnFind = driver.findElement(deleteDialogWindow);
        waitElementIsVisible(deleteBtnFind);
        return deleteBtnFind; }

    @Step("Finding delete dialog window field")
    public WebElement deleteDialogWindowFieldFind() {
        WebElement deleteDialogWindowFieldFind = driver.findElement(deleteDialogWindowField);
        waitElementIsVisible(deleteDialogWindowFieldFind);
        return deleteDialogWindowFieldFind; }

    @Step("Clicking delete dialog window field")
    public void deleteDialogWindowFieldClick() {
        waitElementClickable(deleteDialogWindowFieldFind()).click(); }

    @Step("Filling delete dialog window field")
    public void deleteDialogWindowFieldFill(String port) {
        deleteDialogWindowFieldClick();
        driver.findElement(deleteDialogWindowField).clear();
        driver.findElement(deleteDialogWindowField).sendKeys("localhost:"+port);}

    @Step("Finding delete btn in delete dialog window field")
    public WebElement deleteDialogWindowBtnFind() {
        WebElement deleteDialogWindowBtnFind = driver.findElement(deleteDialogWindowDeleteBtn);
        waitElementIsVisible(deleteDialogWindowBtnFind);
        return deleteDialogWindowBtnFind; }

    @Step("Clicking delete btn in delete dialog window field")
    public void deleteDialogWindowBtnClick() {
        waitElementClickable(deleteDialogWindowBtnFind()).click(); }

    @Step("Finding Success delete message")
    public WebElement successMessageFind() {
        WebElement successMessageFind = driver.findElement(successMessage);
        waitElementIsVisible(successMessageFind);
        return successMessageFind; }

    @Step("Finding delete btn Actions")
    public WebElement buildAdministrationDeleteBtnFind() {
        WebElement buildAdministrationDeleteBtnFind = driver.findElement(buildAdministrationDeleteBtn);
        waitElementIsVisible(buildAdministrationDeleteBtnFind);
        return buildAdministrationDeleteBtnFind; }

    @Step("Clicking delete btn Actions")
    public void buildAdministrationDeleteBtnClick() {
        waitElementClickable(buildAdministrationDeleteBtnFind()).click(); }

    @Step("Accept delete alert")
    public void acceptDeleteAlert() {
            Alert alt = driver.switchTo().alert();
            alt.accept();}

    @Step("Finding Name of the project in administration")
    public WebElement administrationProjectNameFind() {
        WebElement administrationProjectNameFind = driver.findElement(administrationProjectName);
        waitElementIsVisible(administrationProjectNameFind);
        return administrationProjectNameFind; }

    @Step("Finding Success message - build removed")
    public WebElement getSuccessMessageBuildRemovedFind() {
        WebElement getSuccessMessageBuildRemovedFind = driver.findElement(getSuccessMessageBuildRemoved);
        waitElementIsVisible(getSuccessMessageBuildRemovedFind);
        return getSuccessMessageBuildRemovedFind; }

    @Step("Finding build name field")
    public WebElement buildNameFieldFind() {
        WebElement buildNameFieldFind = driver.findElement(buildNameField);
        waitElementIsVisible(buildNameFieldFind);
        return buildNameFieldFind; }

    @Step("Clicking build name field")
    public void buildNameFieldClick() {
        waitElementClickable(buildNameFieldFind()).click(); }

    @Step("Filling build name field")
    public void buildNameFieldFill(String name) {
        buildNameFieldClick();
        driver.findElement(buildNameField).clear();
        driver.findElement(buildNameField).sendKeys(name +" build");}

    @Step("Finding Regenerate id btn")
    public WebElement regenerateIdBtnFind() {
        WebElement regenerateIdBtnFind = driver.findElement(regenerateIdBtn);
        waitElementIsVisible(regenerateIdBtnFind);
        return regenerateIdBtnFind; }

    @Step("Finding 'Save' btn")
    public WebElement saveBtnFind() {
        WebElement saveBtnFind = driver.findElement(saveBtn);
        waitElementIsVisible(saveBtnFind);
        return saveBtnFind; }

    @Step("Clicking 'Save' btn")
    public void saveBtnClick() {
        waitElementClickable(saveBtnFind()).click(); }

    @Step("Finding 'Description' field")
    public WebElement descriptionFieldFind() {
        WebElement descriptionFieldFind = driver.findElement(descriptionField);
        waitElementIsVisible(descriptionFieldFind);
        return descriptionFieldFind; }

    @Step("Clicking 'Description' field")
    public void descriptionFieldClick() {
        waitElementClickable(descriptionFieldFind()).click(); }

    @Step("Filling 'Description' field")
    public void descriptionFieldFill(String name) {
        descriptionFieldClick();
        driver.findElement(descriptionField).clear();
        driver.findElement(descriptionField).sendKeys(name);}

    @Step("Finding 'Version Control Settings' tab")
    public WebElement vcsTabFind() {
        WebElement vcsTabFind = driver.findElement(vcsTab);
        waitElementIsVisible(vcsTabFind);
        return vcsTabFind; }

    @Step("Clicking 'Version Control Settings' field")
    public void vcsTabClick() {
        waitElementClickable(vcsTabFind()).click(); }

    @Step("Finding VCS root 'Edit' btn")
    public WebElement vcsRootEditBtnFind() {
        WebElement vcsRootEditBtnFind = driver.findElement(vcsRootEditBtn);
        waitElementIsVisible(vcsRootEditBtnFind);
        return vcsRootEditBtnFind; }

    @Step("Clicking VCS root 'Edit' btn")
    public void vcsRootEditBtnClick() {
        waitElementClickable(vcsRootEditBtnFind()).click(); }

    @Step("Finding 'github' btn")
    public WebElement gitHubBtnFind() {
        WebElement gitHubBtnFind = driver.findElement(gitHubBtn);
        waitElementIsVisible(gitHubBtnFind);
        return gitHubBtnFind; }

    @Step("Clicking 'github' btn")
    public void gitHubBtnClick() {
        waitElementClickable(gitHubBtnFind()).click(); }

    @Step("Searching id by repository name")
    public int getRepositoryIdByName(String text) {
        List<WebElement> runBuildBtnFind = driver.findElements(By.xpath("//*[@id='749239219']//li"));
        int i;
        for(i = 0;i<runBuildBtnFind.size(); i++){
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

    @Step("Finding 'save' btn")
    public WebElement saveEditVcsBtnFind() {
        WebElement saveEditVcsBtnFind = driver.findElement(saveEditVcsBtn);
        waitElementIsVisible(saveEditVcsBtnFind);
        return saveEditVcsBtnFind; }

    @Step("Clicking 'save btn")
    public void saveEditVcsBtnClick() {
        waitElementClickable(saveEditVcsBtnFind()).click(); }

    @Step("Finding 'VCS Roots' title")
    public WebElement vcsTabTitleFind() {
        WebElement vcsTabTitleFind = driver.findElement(vcsTabTitle);
        waitElementIsVisible(vcsTabTitleFind);
        return vcsTabTitleFind; }




}
