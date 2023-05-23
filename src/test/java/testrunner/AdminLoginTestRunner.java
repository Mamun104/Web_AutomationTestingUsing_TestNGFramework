package testrunner;

import pages.Dashboard;
import pages.Login;
import Setup.Setup;
import org.testng.annotations.Test;

public class AdminLoginTestRunner extends Setup {
    Login login;
    Dashboard dashboard;

    @Test(priority = 0, description = "Login with valid data")
    public void testLogin() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com");
        login = new Login(driver);
        login.doLogin("Admin","admin123" );
        login.assertion();
    }

    @Test(priority = 1, description = "Check employee status")
    public void testSelectEmployeeStatus() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList");
        login.selectEmployeeStatus();
    }

    @Test(priority = 2, description = "Check employee status")
    public void testGetEmployeeStatus() throws InterruptedException {
        login.getEmployeeStatus();
    }
    @Test(priority = 3, description = "Check log out")
    public void testDoLogout() throws InterruptedException {
        dashboard = new Dashboard(driver);
        dashboard.doLogout();
    }

}
