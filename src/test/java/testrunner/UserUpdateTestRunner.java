package testrunner;

import Setup.Setup;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Dashboard;
import pages.Employee;
import pages.Login;
import utils.Utils;

import java.io.IOException;
import java.util.List;

public class UserUpdateTestRunner extends Setup {

    Login login;

    @BeforeTest
    public void doingLogin() throws IOException, ParseException, InterruptedException {

        driver.get("https://opensource-demo.orangehrmlive.com");

        List data = Utils.readJSONArray("./src/test/resources/Users.json");
        login = new Login(driver);
        JSONObject userObj = (JSONObject) data.get(data.size() - 1);
        String userName = (String) userObj.get("userName");
        String password = (String) userObj.get("password");

        login.doLogin(userName, password);
    }

    @Test
    public void updateUserInfo() throws InterruptedException {
        Thread.sleep(3000);
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewPersonalDetails/empNumber/53");
        List<WebElement> headerTitle = driver.findElements(By.className("orangehrm-main-title"));
        Utils.waitForElement(driver, headerTitle.get(0), 50);
        if (headerTitle.get(0).isDisplayed()) {

            Employee employee = new Employee(driver);

            employee.dropdownBox.get(0).click();
            employee.dropdownBox.get(0).sendKeys("b");
            for (int i = 0; i < 2; i++) {

                employee.dropdownBox.get(0).sendKeys(Keys.ARROW_DOWN);
            }
            employee.dropdownBox.get(0).sendKeys(Keys.ENTER);
            List<WebElement> saveBtn = driver.findElements(By.cssSelector("[type=submit]"));
            saveBtn.get(1).click();

        }

    }

    @AfterTest
    public void logout() throws InterruptedException {
        Thread.sleep(3000);
        Dashboard dashboard = new Dashboard(driver);
        dashboard.btnProfileImage.click();
        Thread.sleep(3000);
        dashboard.linkLogout.click();
        Thread.sleep(3000);

    }
}
