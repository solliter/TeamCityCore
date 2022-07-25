package front.tests;

import front.BaseFront;
import org.testng.annotations.Test;

import java.awt.*;

import static constants.Constant.Urls.MAIN_PAGE;
import static constants.Constant.Variables.*;

public class LogInTests extends BaseFront {

    @Test(description="Checking all fields, buttons and checkers that we are needed on a page")
    public void checkFieldsBtnTerms() {
        logInPage.open();
        logInPage.usernameFieldFind();
        logInPage.passwordFieldFind();
        logInPage.rememberMeCheckerFind();
        logInPage.resetPasswordButtonFind();
        logInPage.btnLogInFind(); }

    @Test(description="Using valid login and password to pass login page and checking redirecting")
    public void usernamePasswordValid(){
        logInPage.open();
        logInPage.usernameFieldFill(usernameValid);
        logInPage.passwordFieldFill(passwordValid);
        logInPage.btnLogInClick();
        helpers.checkUrl(MAIN_PAGE);
        helpers.checkText(mainPage.mainPageTitleFind(), mainPageText); }

    @Test(description="Checking that we have error text and red edging on fields with invalid password ")
    public void passwordInvalid() throws AWTException {
        logInPage.open();
        logInPage.usernameFieldFill(usernameValid);
        logInPage.passwordFieldFill(passwordWrong);
        logInPage.btnLogInClick();
        logInPage.errorMessageWrongNamePassFind();
        helpers.clickPage();
        logInPage.usernameRedEdgingFind();
        logInPage.passwordRedEdgingFind();
    }
}
