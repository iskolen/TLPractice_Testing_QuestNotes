package ru.travelLine;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NotesPage {
    public WebDriver driver;
    public NotesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }
    @FindBy(xpath = "//tl-button[@tl-click='addNote()']")
    private WebElement btn_add_notes;
    @FindBy(name = "noteText")
    private WebElement text_area;
    @FindBy(xpath = "//select[@ng-model='status']")
    private WebElement select_status;
    @FindBy(xpath = "//option[@label='Требует выполнения']")
    private WebElement note_select_status_RequiresExecution;
    @FindBy(xpath = "//option[@label='Не запланировано']")
    private WebElement note_select_status_NoPlaned;
    @FindBy(xpath = "//option[@label='Выполнено']")
    private WebElement note_select_status_Performed;
    @FindBy(xpath = "//tl-control-time[@ng-model='dateTimeParams.time']")
    private WebElement select_time;
    @FindBy(xpath = "//input[@ng-model='modelViewValue.string.hours']")
    private WebElement select_time_hours;
    @FindBy(xpath = "//input[@ng-disabled='lockMinutes']")
    private WebElement select_time_minutes;
    @FindBy(xpath = "//tl-button[@tl-click='saveDate()']")
    private WebElement select_time_apply;
    @FindBy(xpath = "//tl-control-date[@ng-model='dateTimeParams.date']")
    private WebElement month_selection;
    @FindBy(xpath = "//button[@ng-click='move(1)']")
    private WebElement arrow_btn;
    @FindBy(xpath = "//span[normalize-space()='13']")
    private WebElement day_selection_5years;
    @FindBy(xpath = "//span[normalize-space()='16']")
    private WebElement day_selection_NextMonth;
    @FindBy(xpath = "//span[normalize-space()='16']")
    private WebElement day_selection_Tomorrow;
    @FindBy(xpath = "//tl-button[@tl-click='ctrl.onEdited()']")
    private WebElement note_ready;
    @FindBy(xpath = "//strong[@class='ng-binding']")
    private WebElement btn_select_date;
    @FindBy(xpath = "//span[contains(text(),'Июль')]")
    private WebElement btn_select_month;
    @FindBy(xpath = "//span[normalize-space()='2027']")
    private WebElement btn_select_year;


    public void inputNoteText(String noteText) {
        text_area.sendKeys(noteText);}
    public void click_btn_add_notes() {
        btn_add_notes.click();}
    public void click_note_ready(){
        note_ready.click();}
    public void set_status_RequiresExecution(){
        select_status.click();
        note_select_status_RequiresExecution.click();
        select_status.click();}
    public void set_status_NoPlaned(){
        select_status.click();
        note_select_status_NoPlaned.click();
        select_status.click();}
    public void set_status_Performed(){
        select_status.click();
        note_select_status_Performed.click();
        select_status.click();}
    public void set_date_5years(){
        month_selection.click();
        btn_select_date.click();
        btn_select_date.click();
        btn_select_year.click();
        btn_select_month.click();
        day_selection_5years.click();}
    public void set_date_NextMonth(){
        month_selection.click();
        arrow_btn.click();
        day_selection_NextMonth.click();}
    public void set_date_Tomorrow(){
        month_selection.click();
        day_selection_Tomorrow.click();}
    public void set_time(String hours, String minutes){
        select_time.click();
        select_time_hours.clear();
        select_time_hours.click();
        select_time_hours.sendKeys(hours);
        select_time_minutes.clear();
        select_time_minutes.click();
        select_time_minutes.sendKeys(minutes);
        select_time_apply.click();}
}

