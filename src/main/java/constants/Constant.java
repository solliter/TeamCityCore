package constants;

import java.time.Duration;

import static constants.Constant.Variables.repositoryNamePositive;

public class Constant {

    public static class TimeOutVariables{
        public static final Duration IMPLICIT_WAIT = Duration.ofSeconds(15);
        public static final Duration EXPLICIT_WAIT = Duration.ofSeconds(15);

    }

    public static class Configuration {
        /*
         * Clear browser cookies on each iteration
         * if TRUE - clear cookies
         * */
        public static final Boolean CLEAR_COOKIES_AND_STORAGE = true;
        /*
         * To keep the browser open after test
         * if true - browser close
         * */
        public static final Boolean HOLD_BROWSER_OPEN = true;
    }

    public static class Urls{
        public static final String port = "8111";
        public static final String LOG_IN_PAGE = "http://localhost:"+port+"/login.html";
        public static final String MAIN_PAGE = "http://localhost:"+port+"/overview.html";
        public static final String EDIT_PROJECT_PAGE = "http://localhost:"+port+"/admin/editProject.html?projectId=_Root";
        public static final String EDIT_BUILD_PAGE = "http://localhost:"+port+"/admin/editBuild.html?id=buildType:"+ repositoryNamePositive +"_"+ repositoryNamePositive +"Build";


    }
    public static class Variables {
        //Name of repository in GitHub
        public static final String repositoryNamePositive = "TeamCityLogIn";
        public static final String repositoryURLPositive = "https://github.com/solliter/TeamCityLogIn#refs/heads/master";
        public static final String repositoryNameNegative = "catsbuilder";
        public static final String repositoryURLNegative = "https://github.com/solliter/catsbuilder";



        //Username
        public static final String usernameValid = "Andy";

        //Password
        public static final String passwordValid = "qQ12345";
        public static final String passwordWrong = "qq12345";

        //Main page title
        public static final String mainPageText = "Getting started with TeamCity";

        //Create project texts
        //Titles
        public static final String createProjectTitle = "Create Project";
        public static final String createProjFromUrlTitle = "Create Project From URL";

        //Success messages
        public static final String successConnection = "✓ The connection to the VCS repository has been verified";
        public static final String successMessageNewProject = "New project \""+ repositoryNamePositive +"\", build configuration \""+ repositoryNamePositive +" build\" and VCS root \""+ repositoryURLPositive +"\" have been successfully created.";
        public static final String successMessageNewBuildStep = "New build step added.";
        public static final String successMessageProjectDeleted = "Project \""+ repositoryNamePositive +"\" has been moved to the \"config/_trash\" directory. All project related data (build history, artifacts, and so on) will be cleaned from the database during the next clean-up. See clean-up policy configuration.";


    }

}
