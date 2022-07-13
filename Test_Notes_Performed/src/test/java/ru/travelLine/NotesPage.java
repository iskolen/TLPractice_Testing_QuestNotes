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
    @FindBy(xpath = "//option[@label='Выполнено']")
    private WebElement note_select_status;

    //Button "note ready"
    @FindBy(xpath = "//tl-button[@tl-click='ctrl.onEdited()']")
    private WebElement note_ready;


    public void inputNoteText(String noteText) {
        text_area.sendKeys(noteText);}

    public void click_btn_add_notes() {
        btn_add_notes.click();}

    public void click_select_status(){
        select_status.click();}

    public void click_note_select_status(){
        note_select_status.click();}
    public void click_note_ready(){
        note_ready.click();}
}

