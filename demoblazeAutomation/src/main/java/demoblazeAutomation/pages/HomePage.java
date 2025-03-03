package demoblazeAutomation.pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='My Account']")
    private WebElement myaccountdropdown;

    @FindBy(xpath = "//a[text()='Login']")
    private WebElement login;

    @FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']/descendant::a[text()='Register']")
    private WebElement register;

    @FindBy(xpath = "//ul[contains(@class,'dropdown-menu dropdown')]/descendant::a[text()='Logout']")
    private WebElement logout;

    @FindBy(xpath = "//div[@id='content']/child::h1[text()='Account Logout']")
    private WebElement loggedOut;

    @FindBy(xpath = "//div[@class='list-group']/child::a[text()='Logout']")
    private WebElement logOutListOption;

    @FindBys({
        @FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//li")
    })
    private List<WebElement> myacclist;

    public WebElement getMyaccountdropdown() {
        return myaccountdropdown;
    }

    public WebElement getLogin() {
        return login;
    }

    public WebElement getRegister() {
        return register;
    }

    public WebElement getLogout() {
        return logout;
    }

    public WebElement getLoggedOut() {
        return loggedOut;
    }

    public WebElement getLogOutListOption() {
        return logOutListOption;
    }

    public List<WebElement> getMyacclist() {
        return myacclist;
    }
}
