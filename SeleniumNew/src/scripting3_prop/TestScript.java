package scripting3_prop;

import org.openqa.selenium.WebDriver;
import java.util.Map;

public class TestScript extends ReusableMethods {
    public static void main(String[] args) {
        TS_LoginLogout();
        TS_CreateAndDeleteUser();
    }

    public static void TS_LoginLogout(){
        WebDriver oBrowser = null;
        Map<String, String> data = null;
        try{
            data = getPropData("TestData");
            oBrowser = launchBrowser(data.get("browserName"));
            boolean blnRes = navigateURL(oBrowser, data.get("url"));
            blnRes = loginToApplication(oBrowser, data.get("userName"), data.get("password"));
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
        Map<String, String> data = null;
        try{
            data = getPropData("TestData");
            oBrowser = launchBrowser(data.get("browserName"));
            boolean blnRes = navigateURL(oBrowser, data.get("url"));
            blnRes = loginToApplication(oBrowser, data.get("userName"), data.get("password"));
            String userName = createUser(oBrowser, data);
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
