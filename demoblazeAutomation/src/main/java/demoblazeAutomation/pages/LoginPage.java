package demoblazeAutomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "input-email")
    private WebElement emailfield;

    @FindBy(id = "input-password")
    private WebElement passwordfield;

    @FindBy(xpath = "//input[@value='Login']")
    private WebElement loginbtn;

    @FindBy(xpath = "//a[text()='Edit your account information']")
    private WebElement editYourAccountLinkText;

    @FindBy(xpath = "//div[contains(@class,'alert')]")
    private WebElement warningmessage;

    @FindBy(xpath = "//div[@class='form-group']/child::a[text()='Forgotten Password']")
    private WebElement forgottenpassword;

    @FindBy(xpath = "//strong[text()='I am a returning customer']")
    private WebElement loginpagedisplay;

    @FindBy(xpath = "//h1[text()='Forgot Your Password?']")
    private WebElement forgottenpasswordpage;

    @FindBy(xpath = "//div[@class='well']")
    private WebElement loginpageverify;

    public WebElement getEmailfield() {
        return emailfield;
    }

    public WebElement getPasswordfield() {
        return passwordfield;
    }

    public WebElement getLoginbtn() {
        return loginbtn;
    }

    public WebElement getEditYourAccountLinkText() {
        return editYourAccountLinkText;
    }

    public WebElement getWarningmessage() {
        return warningmessage;
    }

    public WebElement getForgottenpassword() {
        return forgottenpassword;
    }

    public WebElement getLoginpagedisplay() {
        return loginpagedisplay;
    }

    public WebElement getForgottenpasswordpage() {
        return forgottenpasswordpage;
    }

    public WebElement getLoginpageverify() {
        return loginpageverify;
    }
}
