package mobile;

import dto.UserLombok;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.ContactsScreen;
import screens.RegistrationLoginScreen;
import screens.SplashScreen;

import static utils.PropertiesReader.getProperty;

public class AddNewContactTests extends TestBase{
    ContactsScreen contactsScreen;

    @BeforeMethod
    public void goToRegistrationScreen(){
        new SplashScreen(driver).goToRegistrationScreen();
        RegistrationLoginScreen registrationLoginScreen = new RegistrationLoginScreen(driver);
        UserLombok userLombok = UserLombok.builder()
                .username(getProperty("base.properties", "email"))
                .password(getProperty("base.properties", "password"))
                .build();
        registrationLoginScreen.typeFormLoginRegistration(userLombok);
        registrationLoginScreen.clickBtnLogin();
        contactsScreen = new ContactsScreen(driver);
        contactsScreen.clickBtnAddContact();
    }


    @Test
    public void addNewContactPositiveTest(){

    }
}
