package mobile;

import dto.UserLombok;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.ContactsScreen;
import screens.RegistrationLoginScreen;
import screens.SplashScreen;
import utils.UserFactory;

public class RegistrationTests extends TestBase{
    RegistrationLoginScreen registrationLoginScreen;
    UserLombok userLombok;

    @BeforeMethod
    public void goToRegistrationScreen(){
        new SplashScreen(driver).goToRegistrationScreen();
        registrationLoginScreen = new RegistrationLoginScreen(driver);
        userLombok = UserFactory.positiveUser();
    }

    @Test
    public void registrationPositiveTest(){
        registrationLoginScreen.typeFormLoginRegistration(userLombok);
        registrationLoginScreen.clickBtnRegistration();
        Assert.assertTrue(new ContactsScreen(driver).validateTextInTextNoContact("No Contacts. Add One more!"));



    }
}
