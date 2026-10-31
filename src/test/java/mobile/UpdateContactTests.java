package mobile;

import dto.ContactDto;
import dto.UserLombok;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.*;
import utils.ContactFactory;

import static utils.PropertiesReader.getProperty;


public class UpdateContactTests extends TestBase {
    ContactsScreen contactsScreen;
    AddContactScreen addContactScreen;
    ContactDto contact;
    UpdateContactScreen updateContactScreen;

    @BeforeMethod
    public void goToRegistrationScreen() {
        new SplashScreen(driver).goToRegistrationScreen();
        RegistrationLoginScreen registrationLoginScreen =
                new RegistrationLoginScreen(driver);
        UserLombok userLombok = UserLombok.builder()
                .username(getProperty("base.properties", "email"))
                .password(getProperty("base.properties", "password"))
                .build();
        registrationLoginScreen.typeFormLoginRegistration(userLombok);
        registrationLoginScreen.clickBtnLogin();
        contactsScreen = new ContactsScreen(driver);
        contactsScreen.clickBtnAddContact();
        addContactScreen = new AddContactScreen(driver);
        //contact = positiveContact();
        contact = ContactFactory.positiveContact();
        addContactScreen.typeAddNewContactForm(contact);
        addContactScreen.clickBtnCreate();

    }

    @Test
    public void updateContactPositiveTest() {
        contact.setName("Max");
        contactsScreen.goToUpdateScreen();
        updateContactScreen = new UpdateContactScreen(driver);
        updateContactScreen.typeUpdateContactForm(contact);
        updateContactScreen.clickBtnUpdate();
        Assert.assertTrue(contactsScreen
                .validateMessageContactWasUpdate("Contact was updated!"));

    }

}