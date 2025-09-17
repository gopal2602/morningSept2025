package scripting2;

import org.openqa.selenium.WebDriver;

public class TestScript extends ReusableMethods{
    public static void main(String[] args) {
        TS_LoginLogout();
        TS_CreateAndDeleteUser();
    }

    public static void TS_LoginLogout(){
        WebDriver oBrowser = null;
        try{
            oBrowser = launchBrowser("Edge");
            boolean blnRes = navigateURL(oBrowser, "http://localhost/login.do");
            blnRes = loginToApplication(oBrowser, "admin", "manager");
            blnRes = logoutFromActiTime(oBrowser);
        }catch(Exception e){
            System.out.println("Exception in  'TS_LoginLogout()' test script");
        }finally {
            oBrowser.close();
            oBrowser = null;
        }
    }


    public static void TS_CreateAndDeleteUser(){
        WebDriver oBrowser = null;
        try{
            oBrowser = launchBrowser("Chrome");
            boolean blnRes = navigateURL(oBrowser, "http://localhost/login.do");
            blnRes = loginToApplication(oBrowser, "admin", "manager");
            String userName = createUser(oBrowser);
            blnRes = deleteUser(oBrowser, userName);
            blnRes = logoutFromActiTime(oBrowser);
        }catch(Exception e){
            System.out.println("Exception in  'TS_CreateAndDeleteUser()' test script");
        }finally {
            oBrowser.close();
            oBrowser = null;
        }
    }
}
