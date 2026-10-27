package mobile;

import dto.UserLombok;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.ContactsScreen;
import screens.RegistrationLoginScreen;
import screens.SplashScreen;
import static utils.PropertiesReader.*;

public class LoginTests extends TestBase{
    RegistrationLoginScreen registrationLoginScreen;
    UserLombok userLombok;

    @BeforeMethod
    public void goToRegistrationScreen(){
        new SplashScreen(driver).goToRegistrationScreen();
        registrationLoginScreen = new RegistrationLoginScreen(driver);
        userLombok = UserLombok.builder()
                .username(getProperty("base.properties", "email"))
                .password(getProperty("base.properties", "password"))
                .build();
    }

    @Test
    public void loginPositiveTest(){
        registrationLoginScreen.typeFormLoginRegistration(userLombok);
        registrationLoginScreen.clickBtnLogin();
        Assert.assertTrue(new ContactsScreen(driver).isBtnAddContactPresent());


    }
}
