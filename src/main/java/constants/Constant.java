package constants;

import java.time.Duration;

public class Constant {

    public static class TimeOutVariables{
        public static final Duration IMPLICIT_WAIT = Duration.ofSeconds(10);
        public static final Duration EXPLICIT_WAIT = Duration.ofSeconds(10);

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
        private static final String port = "8111";
        public static final String LOG_IN_PAGE = "http://localhost:"+port+"/login.html";
        public static final String MAIN_PAGE = "http://localhost:"+port+"/overview.html";
    }
    public static class Variables {

        //Username
        public static final String usernameValid = "Andy";

        //Password
        public static final String passwordValid = "qQ12345";
        public static final String passwordWrong = "qq12345";

        //Main page title
        public static final String mainPageText = "Getting started with TeamCity";
    }

}
