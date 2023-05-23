package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Employee {

    @FindBy(xpath = "//button[.=' Add ']")
    WebElement btnAddEmployee;
    @FindBy(xpath= "//input[@class='oxd-input oxd-input--active orangehrm-firstname']")
    WebElement textFirstName;
    @FindBy(xpath= "//input[@class='oxd-input oxd-input--active orangehrm-lastname']")
    WebElement textLastName;
    @FindBy(className = "oxd-switch-input")
    WebElement toggleButton;
    @FindBy(className = "oxd-input")
    List<WebElement> textUserCredential;
    @FindBy(css= "[type=submit]")
    public WebElement btnSubmit;

    @FindBy(className = "oxd-select-text-input")
    public List<WebElement> dropdownBox;

    public WebDriver driver;
    public WebDriverWait wait;
    public Employee(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void createEmployee(String firstName, String lastName, String userName, String password, String confirmPassword) throws InterruptedException {

        Thread.sleep(3000);
        btnAddEmployee.click();
        Thread.sleep(3000);
        textFirstName.sendKeys(firstName);
        Thread.sleep(3000);
        textLastName.sendKeys(lastName);
        Thread.sleep(3000);
        toggleButton.click();
        textUserCredential.get(5).sendKeys(userName);
        Thread.sleep(3000);
        textUserCredential.get(6).sendKeys(password);
        Thread.sleep(3000);
        textUserCredential.get(7).sendKeys(confirmPassword);
        Thread.sleep(3000);
        btnSubmit.click();
        Thread.sleep(3000);
    }
}
