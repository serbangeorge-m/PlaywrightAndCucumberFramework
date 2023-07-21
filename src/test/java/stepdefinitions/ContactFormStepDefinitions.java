package stepdefinitions;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ContactFormPage;
import utils.Notification;
import utils.WebActions;

import java.util.List;
import java.util.Map;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ContactFormStepDefinitions {
    ContactFormPage contactFormPage = new ContactFormPage(DriverFactory.getPage());

    private void fillContactForm(Map<String, String> formData) {
        String name = formData.get("Name");
        String personalCode = formData.get("Personal Code");
        String caseNumber = formData.get("Case Number");
        String phoneNumber = formData.get("Phone Number");
        String email = formData.get("Email");
        String address = formData.get("Address");
        String comments = formData.get("Comments");

        contactFormPage.fill(name, personalCode, caseNumber, phoneNumber, email, address, comments, Notification.Email);
    }
    @Given("I am on the contact form page")
    public void iAmOnTheContactFormPage() {
        String url = WebActions.getProperty("url");
        contactFormPage.goToUrl(url);
    }

    @And("I accept the cookies")
    public void iAcceptTheCookies() {
        contactFormPage.acceptCookies();
    }

    @And("I initiate the contact form")
    public void iInitiateTheContactForm() { contactFormPage.initiate();}

    @When("^I fill out the contact form with the following details:$")
    public void iFillOutTheContactFormWithTheFollowingDetails(DataTable dataTable) {
        List<Map<String, String>> user = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> form : user) {
            fillContactForm(form);
        }
    }

    @And("I submit the contact form")
    public void iSubmitTheContactForm() {
        contactFormPage.submit();
    }

    @And("If the contact form was not successfully submitted I fill out the contact form again with the following details:")
    public void ifTheContactFormWasNotSuccessfullySubmittedIFillOutTheContactFormAgainWithTheFollowingDetails(DataTable dataTable) {
        if (contactFormPage.submitFormButton.isVisible()){
            contactFormPage.submit();
            List<Map<String, String>> user = dataTable.asMaps(String.class, String.class);
            for (Map<String, String> form : user) {
                fillContactForm(form);
            }
            contactFormPage.submit();
        }
    }

    @Then("I should see a success message")
    public void iShouldSeeASuccessMessage() {
        WebActions.waitUntilLocatorIsDisplayed(DriverFactory.getPage(), contactFormPage.firstLocatorToCheck, 2);

        assertThat(contactFormPage.firstLocatorToCheck).isVisible();
        assertThat(contactFormPage.secondLocatorToCheck).isVisible();
        assertThat(contactFormPage.thirdLocatorToCheck).isVisible();
        assertThat(contactFormPage.forthLocatorToCheck).isVisible();
        assertThat(contactFormPage.fifthLocatorToCheck).isVisible();
        assertThat(contactFormPage.submitFormButton).not().isVisible();
    }
}
