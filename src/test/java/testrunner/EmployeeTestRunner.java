package testrunner;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.Employee;
import pages.Login;
import Setup.Setup;
import utils.Utils;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class EmployeeTestRunner extends Setup {

    Login login;
    Employee employee;

    @Test(priority = 0)
    public void doLogin() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com");
        login = new Login(driver);
        String AdminUser = "Admin";
        String AdminPassword = "admin123";
        login.doLogin(AdminUser,AdminPassword);
    }

    @Test(priority = 1)
    public void testCreateEmployee() throws InterruptedException, IOException, ParseException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList");
        employee = new Employee(driver);

        Utils utils = new Utils();
        utils.generateRandomData();
        String firstName  = utils.getFirstName();
        String lastName = utils.getLastName();
        int randomId = Utils.generateRandomNumber(1000,9999);
        String userName = utils.getFirstName()+randomId;
        String password = "P@ssword123";
        String confirmPassword = "P@ssword123";

        employee.createEmployee(firstName,lastName,userName,password,confirmPassword);

        List<WebElement> headerTitle = driver.findElements(By.className("orangehrm-main-title"));
        Assert.assertTrue(headerTitle.get(0).isDisplayed());

        Utils.waitForElement(driver,headerTitle.get(0),50);
        if (headerTitle.get(0).isDisplayed()){

            utils.saveJsonList(userName,password);
        }

    }

    public static class UserLoginTestRunner extends Setup {

        Login login;

        @Test
        public void doLogin() throws IOException, ParseException, InterruptedException {
            driver.get("https://opensource-demo.orangehrmlive.com");

            List data = Utils.readJSONArray("./src/test/resources/Users.json");
            login = new Login(driver);
            JSONObject userObj = (JSONObject) data.get(data.size() - 1);
            String userName = (String) userObj.get("userName");
            String password = (String) userObj.get("password");
            login.doLogin(userName, password);
            login.assertion();

        }


    }
}
