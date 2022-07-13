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

    //Button "add notes"
    @FindBy(xpath = "//tl-button[@tl-click='addNote()']")
    private WebElement btn_add_notes;

    //Text area
    @FindBy(name = "noteText")
    private WebElement text_area;

    //Button "select status"
    @FindBy(xpath = "//select[@ng-model='status']")
    private WebElement select_status;

    //Note selection status
    @FindBy(xpath = "//option[@label='Требует выполнения']")
    private WebElement note_select_status_RE;

    @FindBy(xpath = "//option[@label='Не запланировано']")
    private WebElement note_select_status_NP;

    @FindBy(xpath = "//option[@label='Выполнено']")
    private WebElement note_select_status_P;

    //Button "select time"
    @FindBy(xpath = "//tl-control-time[@ng-model='dateTimeParams.time']")
    private WebElement select_time;

    //Select hours
    @FindBy(xpath = "//input[@ng-model='modelViewValue.string.hours']")
    private WebElement select_time_hours;

    //Select minutes
    @FindBy(xpath = "//input[@ng-disabled='lockMinutes']")
    private WebElement select_time_minutes;

    //Button "apply time"
    @FindBy(xpath = "//tl-button[@tl-click='saveDate()']")
    private WebElement select_time_apply;

    //Button "month selection"
    @FindBy(xpath = "//tl-control-date[@ng-model='dateTimeParams.date']")
    private WebElement month_selection;

    //Button "arrow"
    @FindBy(xpath = "//button[@ng-click='move(1)']")
    private WebElement arrow_btn;

    //Select day
    @FindBy(xpath = "//span[normalize-space()='13']")
    private WebElement day_selection_5Y;

    @FindBy(xpath = "/html[1]/body[1]/div[3]/tl-extranet-host[1]/tl-popup[1]/div[2]/div[1]/div[1]/tl-window[1]/div[1]/tl-window-content[1]/div[1]/ng-form[1]/tl-form-item[3]/div[1]/tl-form-item-content[1]/tl-control-date[1]/div[1]/ul[1]/li[1]/div[1]/table[1]/tbody[1]/tr[3]/td[2]/button[1]/span[1]")
    private WebElement day_selection_NM;

    @FindBy(xpath = "/html[1]/body[1]/div[3]/tl-extranet-host[1]/tl-popup[1]/div[2]/div[1]/div[1]/tl-window[1]/div[1]/tl-window-content[1]/div[1]/ng-form[1]/tl-form-item[3]/div[1]/tl-form-item-content[1]/tl-control-date[1]/div[1]/ul[1]/li[1]/div[1]/table[1]/tbody[1]/tr[3]/td[6]/button[1]/span[1]")
    private WebElement day_selection_T;



    //Button "note ready"
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

    public void inputHours(String hours) {
        select_time_hours.sendKeys(hours);}

    public void inputMinutes(String minutes){
        select_time_minutes.sendKeys(minutes);}

    public void click_btn_add_notes() {
        btn_add_notes.click();}

    public void click_select_status(){
        select_status.click();}

    public void click_note_select_status_RE(){
        note_select_status_RE.click();}

    public void click_select_time(){
        select_time.click();}

    public void click_select_time_hours(){
        select_time_hours.click();}

    public void click_select_time_minutes(){
        select_time_minutes.click();}

    public void click_select_time_apply(){
        select_time_apply.click();}

    public void click_month_selection(){
        month_selection.click();}

    public void click_arrow(){
        arrow_btn.click();}

    public void click_day_selection_5Y(){
        day_selection_5Y.click();}

    public void click_day_selection_NM(){
        day_selection_NM.click();}

    public void click_day_selection_T(){
        day_selection_T.click();}

    public void click_note_ready(){
        note_ready.click();}

    public void click_btn_select_month(){
        btn_select_month.click();}

    public void click_btn_select_year(){
        btn_select_year.click();}

    public void click_btn_select_date(){
        btn_select_date.click();}

    public void clear_hours(){
        select_time_hours.clear();}

    public void clear_minutes(){
        select_time_minutes.clear();}

    public void click_note_select_status_NP(){
        note_select_status_NP.click();}

    public void click_note_select_status_P(){
        note_select_status_P.click();}
}

