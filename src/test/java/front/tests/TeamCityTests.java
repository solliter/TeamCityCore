package front.tests;

import front.BaseFront;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.Test;

import static constants.Constant.Urls.*;
import static constants.Constant.Variables.*;

public class TeamCityTests extends BaseFront {


    @AfterMethod(description = "Deleting project after test")
    public void deleteProject(){
        mainPage.administrationBtnClick();
        administrationPage.projectNameAdmClick(repositoryNamePositive);
        administrationPage.actionsBtnClick();
        administrationPage.deleteBtnClick();
        administrationPage.deleteDialogWindowFind();
        administrationPage.deleteDialogWindowFieldFill(port);
        administrationPage.deleteDialogWindowBtnClick();
        helpers.checkUrl(EDIT_PROJECT_PAGE);
        helpers.checkText(administrationPage.successMessageFind(), successMessageProjectDeleted);
    }

    @Test(description="Create build configuration with version control on github")
    public void createProjectAndBuildFromGit() {
        logInPage.open();
        logInPage.usernameFieldFill(usernameValid);
        logInPage.passwordFieldFill(passwordValid);
        logInPage.btnLogInClick();
        helpers.checkUrl(MAIN_PAGE);
        helpers.checkText(mainPage.mainPageTitleFind(), mainPageText);
        mainPage.createProjectBtnClick();
        helpers.checkText(createProjectPage.createProjectFromUrlTitleFind(), createProjectTitle);
        createProjectPage.fromGitHubBtnClick();
        createProjectPage.parentProjectFieldFind();
        createProjectPage.chooseRepositoryFieldFind();
        createProjectPage.gitHubRepoClick(repositoryNamePositive);
        helpers.checkText(createProjectPage.successfulMessageConnectionFind(), successConnection);
        helpers.checkText(createProjectPage.createProjectFromUrlTitleFind(), createProjFromUrlTitle);
        createProjectPage.projectNameFieldFill(repositoryNamePositive);
        createProjectPage.buildConfigurationNameFieldFind();
        createProjectPage.vcsRootFieldFind();
        createProjectPage.defaultBranchFieldFind();
        createProjectPage.branchSpecificationFieldFind();
        createProjectPage.cancelBtnFind();
        createProjectPage.proceedBtnClick();
        helpers.checkText(createProjectPage.successMessageFind(), successMessageNewProject);
        createProjectPage.autoDetectedBuildStepsFind();
        createProjectPage.loadingBuildStepsFind();
        createProjectPage.checkBoxBuildStepsClick();
        createProjectPage.refreshBtnFind();
        createProjectPage.useSelectedBtnClick();
        helpers.checkText(createProjectPage.successMessageFind(), successMessageNewBuildStep);

        //shortcut! comment this part to pass this test without build run
        createProjectPage.runFirstBuildBtnClick();
        mainPage.buildDateTimeFind(helpers.dateTimeNow());
        mainPage.waitingTillTestsPassFind();
        mainPage.projectNameFind(repositoryNamePositive);
        mainPage.buildNameFind(repositoryNamePositive);
        //shortcut ends!

        mainPage.projectsBtnClick();
        mainPage.projectNameProjectsFind(repositoryNamePositive);
        mainPage.buildNameFind(repositoryNamePositive);
    }

    @Test(description="Create build configuration with version control on github and delete its build")
    public void deleteBuildFromGit() {
        logInPage.open();
        logInPage.usernameFieldFill(usernameValid);
        logInPage.passwordFieldFill(passwordValid);
        logInPage.btnLogInClick();
        helpers.checkUrl(MAIN_PAGE);
        mainPage.createProjectBtnClick();
        createProjectPage.fromGitHubBtnClick();
        createProjectPage.gitHubRepoClick(repositoryNamePositive);
        helpers.checkText(createProjectPage.successfulMessageConnectionFind(), successConnection);
        createProjectPage.projectNameFieldFill(repositoryNamePositive);
        createProjectPage.proceedBtnClick();
        createProjectPage.checkBoxBuildStepsClick();
        createProjectPage.useSelectedBtnClick();

        //shortcut! comment this part to pass this test without build run
        createProjectPage.runFirstBuildBtnClick();
        mainPage.waitingTillTestsPassFind();
        //shortcut ends!

        mainPage.projectsBtnClick();
        mainPage.buildNameClick(repositoryNamePositive);
        mainPage.buildNameFind(repositoryNamePositive);
        mainPage.editConfigBtnClick();
        mainPage.buildNameFind(repositoryNamePositive);
        helpers.checkUrl(EDIT_BUILD_PAGE);
        administrationPage.buildActionsBtnClick();
        administrationPage.buildAdministrationDeleteBtnClick();
        administrationPage.acceptDeleteAlert();
        helpers.checkText(administrationPage.administrationProjectNameFind(), repositoryNamePositive);
        administrationPage.getSuccessMessageBuildRemovedFind();
        mainPage.projectsBtnClick();
        mainPage.emptyProjectTextFind();
    }

    @Test(description="Create build configuration with version control on github and update its build")
    public void updateBuildFromGit() throws InterruptedException {
        logInPage.open();
        logInPage.usernameFieldFill(usernameValid);
        logInPage.passwordFieldFill(passwordValid);
        logInPage.btnLogInClick();
        helpers.checkUrl(MAIN_PAGE);
        mainPage.createProjectBtnClick();
        createProjectPage.fromGitHubBtnClick();
        createProjectPage.gitHubRepoClick(repositoryNamePositive);
        helpers.checkText(createProjectPage.successfulMessageConnectionFind(), successConnection);
        createProjectPage.projectNameFieldFill(repositoryNamePositive);
        createProjectPage.proceedBtnClick();
        createProjectPage.checkBoxBuildStepsClick();
        createProjectPage.useSelectedBtnClick();

        //shortcut! comment this part to pass this test without build run
        createProjectPage.runFirstBuildBtnClick();
        mainPage.waitingTillTestsPassFind();
        //shortcut ends!

        mainPage.projectsBtnClick();
        mainPage.buildNameClick(repositoryNamePositive);
        mainPage.buildNameFind(repositoryNamePositive);
        mainPage.editConfigBtnClick();
        mainPage.buildNameFind(repositoryNamePositive);
        helpers.checkUrl(EDIT_BUILD_PAGE);
        administrationPage.buildNameFieldFill(repositoryNameNegative);
        administrationPage.descriptionFieldFill(repositoryNameNegative);
        administrationPage.saveBtnClick();
        mainPage.buildNameFind(repositoryNameNegative);
        administrationPage.vcsTabClick();
        administrationPage.vcsTabTitleFind();
        administrationPage.vcsRootEditBtnClick();
        administrationPage.gitHubBtnClick();
        administrationPage.gitHubRepoClick(repositoryNameNegative);
        helpers.scrollToElement(administrationPage.saveEditVcsBtnFind());
        administrationPage.saveEditVcsBtnClick();
        mainPage.buildNameFind(repositoryNameNegative);
        administrationPage.vcsTabTitleFind();
        mainPage.projectsBtnClick();
        mainPage.buildNameClick(repositoryNameNegative);
        mainPage.buildNameFind(repositoryNameNegative);
        helpers.checkText(mainPage.buildDescriptionFind(), repositoryNameNegative);
        //shortcut! comment this part to pass this test without build run
        mainPage.runBuildBtnCl1ick();
        mainPage.buildNameClick(repositoryNameNegative);
        mainPage.buildDetailBtnClick();
        mainPage.buildNameFind(repositoryNameNegative);
        mainPage.buildDateTimeFind(helpers.dateTimeNow());
        mainPage.waitingTillTestsFallFind();
        mainPage.projectsBtnClick();
        //shortcut ends!

    }


}
