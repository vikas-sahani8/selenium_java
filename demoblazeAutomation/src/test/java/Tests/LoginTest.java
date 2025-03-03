package Tests;

import static org.testng.Assert.assertEquals;
import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import demoblazeAutomation.pages.HomePage;
import demoblazeAutomation.pages.LoginPage;

public class LoginTest extends Base {

    public LoginTest() {
        super();
    }

    @BeforeMethod
    public void setUp() throws IOException {
        browserSetup();
    }

    @Test(priority = 1)
    public void LoggingInWithValidDetails() throws InterruptedException {
        HomePage homepage = new HomePage(driver);
        homepage.getMyaccountdropdown().click();
        homepage.getLogin().click();

        LoginPage login = new LoginPage(driver);
        login.getEmailfield().sendKeys("Taffazulansari7979@gmail.com");
        login.getPasswordfield().sendKeys("Taffazul123");
        login.getLoginbtn().click();

        Thread.sleep(2000);
        assertEquals(login.getEditYourAccountLinkText().getText(), getExpectedText("accountcreated"));
    }

    @AfterMethod
    public void tearDown() {
        configAfterMethod();
    }

    private String getExpectedText(String key) {
        // Placeholder for reading expected test data (modify as needed)
        if (key.equals("accountcreated")) {
            return "Edit your account information";
        }
        return "";
    }
		
		//LoggingInWithInvalidDetails
//		@Test(priority = 2)
//		public void LoggingInWithInvalidDetails() throws IOException, InterruptedException {
//			WebUtils.implicitWait(driver);
//			HomePage homepage = new HomePage(driver);
//			homepage.getMyaccountdropdown().click();
//			homepage.getLogin().click();
//			LogInPage login = new LogInPage(driver);
//			login.getEmailfield().sendKeys("55454n79*&n5gmail.com");
//			login.getPasswordfield().click();
//			login.getPasswordfield().sendKeys("njjv555555555");
//			login.getLoginbtn().click();
//			Thread.sleep(2000);
//			assertEquals(login.getWarningmessage().getText(), FileUtils.readCommonData("warningmessage"));
//
//		}
//		//LoggingInWithInvalidEmailValidPassword
//		@Test(priority = 3)
//		public void LoggingInWithInvalidEmailValidPassword() throws IOException, InterruptedException {
//			WebUtils.implicitWait(driver);
//			HomePage homepage = new HomePage(driver);
//			homepage.getMyaccountdropdown().click();
//			homepage.getLogin().click();
//			LogInPage login = new LogInPage(driver);
//			login.getEmailfield().sendKeys("@fshe53sftaffazulgmail.com");
//			login.getPasswordfield().click();
//			login.getPasswordfield().sendKeys("Taffazul123");
//			login.getLoginbtn().click();
//			Thread.sleep(2000);
//			assertEquals(login.getWarningmessage().getText();
//
//		}
//		
//		//LoginWithValidEmailInvalidPassword
//		@Test(priority = 4)
//		public void LoginWithValidEmailInvalidPassword() throws IOException, InterruptedException
//		{
//			WebUtils.implicitWait(driver);
//			HomePage homepage = new HomePage(driver);
//			homepage.getMyaccountdropdown().click();
//			homepage.getLogin().click();
//			LogInPage login = new LogInPage(driver);
//			login.getEmailfield().sendKeys("Taffazulansari7979@gmail.com");
//			login.getPasswordfield().click();
//			login.getPasswordfield().sendKeys("fkkkkkk555555555");
//			login.getLoginbtn().click();
//			Thread.sleep(2000);
//			assertEquals(login.getWarningmessage().getText(), FileUtils.readCommonData("warningmessage"));
//
//		}
//		
//		//LoginWithoutProvidingAnyCredentials
//		@Test(priority = 5)
//		public void LoginWithoutProvidingAnyCredentials() throws IOException, InterruptedException 
//		{
//			WebUtils.implicitWait(driver);
//			HomePage homepage = new HomePage(driver);
//			homepage.getMyaccountdropdown().click();
//			homepage.getLogin().click();
//			LogInPage login = new LogInPage(driver);
//			login.getEmailfield().sendKeys("");
//			login.getPasswordfield().click();
//			login.getPasswordfield().sendKeys("");
//			login.getLoginbtn().click();
//			Thread.sleep(2000);
//			assertEquals(login.getWarningmessage().getText(), FileUtils.readCommonData("warningmessage"));
//			
//		}
//		
//		//VerifyForgottenPasswordLink
//		@Test(priority = 6)
//		public void VerifyForgottenPasswordLink() throws IOException, InterruptedException
//		{
//			ClickonLogin(driver);
//			LogInPage login = new LogInPage(driver);
//			login.getForgottenpassword().click();
//			Thread.sleep(2000);
//			assertEquals(login.getForgottenpasswordpage().getText(),FileUtils.readCommonData("forgottenpagepage"));
//			
//		}
//		
//		//LoginUsingKeyboardTab
//		@Test(priority = 7)
//		public void LoginUsingKeyboardTab() throws IOException, InterruptedException
//		{
//			ClickonLogin(driver);
//			LogInPage login = new LogInPage(driver);
//			login.getEmailfield().sendKeys(("Taffazulansari7979@gmail.com")+Keys.TAB);
//			login.getPasswordfield().sendKeys(("Taffazul123")+Keys.ENTER);
//			Thread.sleep(2000);
//			
//		}
//		
//		//LoginAndNavigatingBack
//		@Test(priority = 8)
//		public void LoginAndNavigatingBack() throws IOException, InterruptedException
//		{
//			ClickonLogin(driver);
//			LogInPage login = new LogInPage(driver);
//			login.getEmailfield().sendKeys("Taffazulansari7979@gmail.com");
//			login.getPasswordfield().click();
//			login.getPasswordfield().sendKeys("Taffazul123");
//			login.getLoginbtn().submit();
//			driver.navigate().back();
//			Thread.sleep(2000);
//			assertTrue(login.getLoginpageverify().isDisplayed());
//			}
}
