package ru.travelLine;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class NotesPage {
    public WebDriver driver;
    public NotesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }
    @FindBy(xpath = "//tl-button[@tl-click='addNote()']")
    private WebElement btnAddNotes;
    @FindBy(name = "noteText")
    private WebElement textArea;
    @FindBy(xpath = "//select[@ng-model='status']")
    private WebElement selectStatus;
    @FindBy(xpath = "//option[@label='Требует выполнения']")
    private WebElement noteSelectStatusRequiresExecution;
    @FindBy(xpath = "//option[@label='Не запланировано']")
    private WebElement noteSelectStatusNoPlaned;
    @FindBy(xpath = "//option[@label='Выполнено']")
    private WebElement noteSelectStatusPerformed;
    @FindBy(xpath = "//tl-control-time[@ng-model='dateTimeParams.time']")
    private WebElement selectTime;
    @FindBy(xpath = "//input[@ng-model='modelViewValue.string.hours']")
    private WebElement selectTimeHours;
    @FindBy(xpath = "//input[@ng-disabled='lockMinutes']")
    private WebElement selectTimeMinutes;
    @FindBy(xpath = "//tl-button[@tl-click='saveDate()']")
    private WebElement selectTimeApply;
    @FindBy(xpath = "//tl-control-date[@ng-model='dateTimeParams.date']")
    private WebElement monthSelection;
    @FindBy(xpath = "//button[@ng-click='move(1)']")
    private WebElement arrowBtn;
    @FindBy(xpath = "//span[normalize-space()='13']")
    private WebElement daySelectionFiveYears;
    @FindBy(xpath = "//span[normalize-space()='16']")
    private WebElement daySelectionNextMonth;
    @FindBy(xpath = "//span[normalize-space()='16']")
    private WebElement daySelectionTomorrow;
    @FindBy(xpath = "//tl-button[@tl-click='ctrl.onEdited()']")
    private WebElement noteReady;
    @FindBy(xpath = "//strong[@class='ng-binding']")
    private WebElement btnSelectDate;
    @FindBy(xpath = "//span[contains(text(),'Июль')]")
    private WebElement btnSelectMonth;
    @FindBy(xpath = "//span[normalize-space()='2027']")
    private WebElement btnSelectYear;
    @FindBy(xpath = "//textarea[@name='noteText']")
    private WebElement textAreaExam;









    public void inputNoteText(String noteText) {
        textArea.sendKeys(noteText);}
    public void clickBtnAddNotes() {
        btnAddNotes.click();}
    public void clickNoteReady(){
        noteReady.click();}
    public void setStatusRequiresExecution(){
        selectStatus.click();
        noteSelectStatusRequiresExecution.click();
        selectStatus.click();}
    public void setStatusNoPlaned(){
        selectStatus.click();
        noteSelectStatusNoPlaned.click();
        selectStatus.click();}
    public void setStatusPerformed(){
        selectStatus.click();
        noteSelectStatusPerformed.click();
        selectStatus.click();}
    public void setDateFiveYears(){
        monthSelection.click();
        btnSelectDate.click();
        btnSelectDate.click();
        btnSelectYear.click();
        btnSelectMonth.click();
        daySelectionFiveYears.click();}
    public void setDateNextMonth(){
        monthSelection.click();
        arrowBtn.click();
        daySelectionNextMonth.click();}
    public void setDateTomorrow(){
        monthSelection.click();
        daySelectionTomorrow.click();}
    public void setTime(String hours, String minutes){
        selectTime.click();
        selectTimeHours.clear();
        selectTimeHours.click();
        selectTimeHours.sendKeys(hours);
        selectTimeMinutes.clear();
        selectTimeMinutes.click();
        selectTimeMinutes.sendKeys(minutes);
        selectTimeApply.click();}
    public String getText() {
        String textExam = textAreaExam.getAttribute("value");
        return textExam;}
    public String getHours(){
        selectTime.click();
        String hoursExam = selectTimeHours.getAttribute("value");
        selectTime.click();
        return hoursExam;}
    public String getMinutes(){
        selectTime.click();
        String minutesExam = selectTimeMinutes.getAttribute("value");
        selectTime.click();
        return minutesExam;}
    public String getStatus(){
        Select selectStatus = new Select(driver.findElement(By.xpath("//select[@ng-model='status']")));
        WebElement optionStatus = selectStatus.getFirstSelectedOption();
        String nowStatus = optionStatus.getText();
        return nowStatus;}

}

