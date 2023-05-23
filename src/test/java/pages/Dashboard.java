package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard {

    @FindBy(className = "oxd-userdropdown-tab")
    public WebElement btnProfileImage;

    @FindBy(partialLinkText = "Logout")
    public WebElement linkLogout;
    WebDriver driver;

    public Dashboard(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void doLogout() throws InterruptedException {
        Thread.sleep(3000);

        btnProfileImage.click();
        Thread.sleep(3000);
        linkLogout.click();
        Thread.sleep(3000);

    }
}
