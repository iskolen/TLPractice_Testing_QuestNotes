package ru.travelLine;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(css = "input[class='pull-right tl-control-full form-control tl-control']")
    private WebElement loginField;
    @FindBy(css = "input[name='password']")
    private WebElement passwdField;
    @FindBy(xpath = "//button[@type='button']//span[@class='ng-binding ng-scope'][contains(text(),'Войти')]")
    private WebElement loginBtn;


    public void authorization(String login, String password) {
        loginField.sendKeys(login);
        passwdField.sendKeys(password);
        loginBtn.click();}
}
