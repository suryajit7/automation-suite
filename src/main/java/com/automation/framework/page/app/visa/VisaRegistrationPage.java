package com.automation.framework.page.app.visa;

import com.automation.framework.core.annotation.Page;
import com.automation.framework.page.BasePage;
import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.util.Objects;

@Page
@Data
public class VisaRegistrationPage extends BasePage {

    @FindBy(id = "first_4")
    private WebElement firstName;

    @FindBy(id = "last_4")
    private WebElement lastName;

    @FindBy(id = "input_46")
    private WebElement fromCountry;

    @FindBy(id = "input_47")
    private WebElement toCountry;

    @FindBy(id = "input_24_month")
    private WebElement month;

    @FindBy(id = "input_24_day")
    private WebElement day;

    @FindBy(id = "input_24_year")
    private WebElement year;

    @FindBy(id = "input_6")
    private WebElement email;

    @FindBy(id = "input_27_phone")
    private WebElement phone;

    @FindBy(id = "input_45")
    private WebElement comments;

    @FindBy(id = "submitBtn")
    private WebElement submit;

    @FindBy(id = "requestnumber")
    private WebElement requestNumber;

    public void goTo() {
        this.driver.get("https://vins-udemy.s3.amazonaws.com/sb/visa/udemy-visa.html");
    }

    public VisaRegistrationPage setNames(String firstName, String lastName) {
        logger.info("Getting names : " + firstName);
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        return this;
    }

    public VisaRegistrationPage setCountryFromAndTo(String countryFrom, String countryTo) {
        new Select(this.fromCountry).selectByValue(countryFrom);
        new Select(this.toCountry).selectByValue(countryTo);
        return this;
    }

    public VisaRegistrationPage setBirthDate(LocalDate localDate) {
        new Select(this.year).selectByVisibleText(String.valueOf(localDate.getYear()));
        new Select(this.day).selectByVisibleText(String.valueOf(localDate.getDayOfMonth()));
        new Select(this.month).selectByValue(localDate.getMonth().toString());
        return this;
    }

    public VisaRegistrationPage setContactDetails(String email, String phone) {
        this.email.sendKeys(email);
        this.phone.sendKeys(phone);
        return this;
    }

    public VisaRegistrationPage setComments(String comments) {
        this.comments.sendKeys(Objects.toString(comments, ""));
        return this;
    }

    public VisaRegistrationPage submit() {
        this.submit.click();
        return this;
    }

    public String getConfirmationNumber() {
        this.wait.until((d) -> this.requestNumber.isDisplayed());
        return this.requestNumber.getText();
    }

}
