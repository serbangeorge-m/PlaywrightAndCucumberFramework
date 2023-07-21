package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utils.Notification;

public class ContactFormPage {
    private Page page;
    public Locator nameAndSurname;
    public Locator personalCode;
    public Locator caseNumberIsOptional;
    public Locator contactPhoneNumber;
    public Locator emailAddress;
    public Locator address;
    public Locator commentsAndObjections;
    public Locator communicationChannel;
    public Locator acceptCookies;
    public Locator initiateFormButton;
    public Locator submitFormButton;
    public Locator firstLocatorToCheck;
    public Locator secondLocatorToCheck;
    public Locator thirdLocatorToCheck;
    public Locator forthLocatorToCheck;
    public Locator fifthLocatorToCheck;

    public ContactFormPage(Page page) {
        this.page = page;
        nameAndSurname = page.getByLabel("Vārds, uzvārds");
        personalCode = page.getByLabel("Personas kods");
        caseNumberIsOptional = page.getByLabel("Lietas numurs (nav obligāts)");
        contactPhoneNumber = page.getByLabel("Kontakttālrunis");
        emailAddress = page.getByLabel("E-pasta adrese");
        address = page.getByLabel("Adrese *", new Page.GetByLabelOptions().setExact(true));
        commentsAndObjections = page.getByLabel("Komentāra/iebildumu būtība");
        communicationChannel = page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Kā vēlos saņemt atbildi *"));
        acceptCookies = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Accept All Cookies"));
        initiateFormButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Forma"));
        submitFormButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Iesniegt"));
        firstLocatorToCheck = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Iebildumu un komentāru forma"));
        secondLocatorToCheck = page.getByText("Lūdzu, korekti aizpildiet formu");
        thirdLocatorToCheck = page.locator(".col-md-7 > div > div").first();
        forthLocatorToCheck = page.getByText("Intrum pieņem arī anonīmas sūdzības/pateicības, bet atbilde šajā gadījumā netiks");
        fifthLocatorToCheck = page.getByText("Lai iegūtu informāciju par to, kā mēs apstrādājam Jūsu personas datus un kādas i");
    }

    public void goToUrl(String url){page.navigate(url);}

    public void acceptCookies() {
        acceptCookies.click();
    }

    private void fillNameAndSurname(String name) {
        nameAndSurname.fill(name);
    }

    private void fillPersonalCode(String code){personalCode.fill(code);}

    private void fillCaseNumberOptional(String caseNumber){
        caseNumberIsOptional.fill(caseNumber);
    }

    private void fillContactPhoneNumber(String phoneNumber){
        contactPhoneNumber.fill(phoneNumber);
    }

    private void fillEmailAddress(String email){
        emailAddress.fill(email);
    }

    private void fillAddress(String addressDetails){
        address.fill(addressDetails);
    }

    private void fillCommentOrObjection(String comments){
        commentsAndObjections.fill(comments);
    }

    private void selectNotification(Notification notification){
        communicationChannel.selectOption(notification.getStringValue());
    }

    public void initiate(){
        initiateFormButton.click();
    }

    public void submit() {
        submitFormButton.click();
    }

    public void fill(String name, String personalCode, String caseNumber, String phoneNumber, String email, String address, String comments, Notification notification) {
        fillNameAndSurname(name);
        fillPersonalCode(personalCode);
        fillCaseNumberOptional(caseNumber);
        fillContactPhoneNumber(phoneNumber);
        fillEmailAddress(email);
        fillAddress(address);
        fillCommentOrObjection(comments);
        selectNotification(notification);
    }
}
