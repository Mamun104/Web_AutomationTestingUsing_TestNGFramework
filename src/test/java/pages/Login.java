package pages;

import utils.Utils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class Login {
    @FindBy(name =  "username")
    WebElement textUsername;
    @FindBy(name =  "password")
    WebElement textPassword;
    @FindBy(css =  "[type=submit]")
    WebElement btnSubmit;
    @FindBy(className=  "oxd-userdropdown-img")
    WebElement imgProfile;

    @FindBy(css = "[type=submit]")
    WebElement btnSearch;

    @FindBy(className = "oxd-table-body")
    WebElement tableBody;
    public WebDriver driver;
    WebDriverWait wait;
    public Login(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void doLogin(String username, String password) throws InterruptedException {

        Thread.sleep(2000);
        textUsername.sendKeys(username);
        Thread.sleep(2000);
        textPassword.sendKeys(password);
        Thread.sleep(2000);
        btnSubmit.click();
        Thread.sleep(2000);
    }
    public void assertion() throws InterruptedException {
        Thread.sleep(3000);
        String urlActual = driver.getCurrentUrl();
        String urlExpected = "index";
        System.out.println(urlActual);
        Assert.assertTrue(urlActual.contains(urlExpected));
        Thread.sleep(3000);
        boolean isDisplayed = imgProfile.isDisplayed();
        //Assert.assertTrue(isDisplayed);
        if (isDisplayed = true){

          imgProfile.click();
        }

        else {

            System.out.println("not found");
        }
        Thread.sleep(2000);

    }
    public void selectEmployeeStatus() throws InterruptedException {

        // drop down handle
        Thread.sleep(3000);
        List<WebElement> dropdowns = driver.findElements(By.className("oxd-select-text-input"));
        dropdowns.get(0).click();
        Thread.sleep(3000);

        for (int i = 0; i < 3; i++) {

            dropdowns.get(0).sendKeys(Keys.ARROW_DOWN);
        }

        dropdowns.get(0).sendKeys(Keys.ENTER);

        Thread.sleep(2000);

        btnSearch.click();

        Thread.sleep(3000);
    }

    public void getEmployeeStatus() throws InterruptedException {

        Utils.scrollDown(driver);
        Thread.sleep(3000);
        // table handle
        List<WebElement> allRows = tableBody.findElements(By.cssSelector("[role=row]"));
        for (WebElement row : allRows) {

            List<WebElement> cells = row.findElements(By.cssSelector("[role = cell]"));
            System.out.println(cells.get(5).getText());

            Assert.assertTrue(cells.get(5).getText().contains("Full-Time Permanent"));

        }
    }
}
