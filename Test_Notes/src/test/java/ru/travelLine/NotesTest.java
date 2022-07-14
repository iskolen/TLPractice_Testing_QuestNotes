package ru.travelLine;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class NotesTest {
    public static LoginPage loginPage;
    public static NotesPage notesPage;
    public static WebDriver driver;

    /**
     * осуществление первоначальной настройки
     */
    @Before
    public void setup() {
        //определение пути до драйвера и его настройка
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        //создание экземпляра драйвера
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        notesPage = new NotesPage(driver);
        //окно разворачивается на полный экран
        driver.manage().window().maximize();
        //задержка на выполнение теста = 10 сек.
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //получение ссылки на страницу входа из файла настроек
        driver.get(ConfProperties.getProperty("loginpage"));

    }

    @After
    public void tearDown() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        driver.quit();
    }

    @Test
    public void notesTestMaxChar_Performed() {
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.inputPass(ConfProperties.getProperty("passwd"));
        loginPage.clickLoginBtn();

        notesPage.click_btn_add_notes();
        notesPage.inputNoteText(ConfProperties.getProperty("noteTextMaxChar"));
        notesPage.click_select_status();
        notesPage.click_note_select_status_P();
        notesPage.click_select_status();
        notesPage.click_note_ready();

    }

    @Test
    public void notesTestSpecChar_Performed() {
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.inputPass(ConfProperties.getProperty("passwd"));
        loginPage.clickLoginBtn();

        notesPage.click_btn_add_notes();
        notesPage.inputNoteText(ConfProperties.getProperty("noteTextSpecChar"));
        notesPage.click_select_status();
        notesPage.click_note_select_status_P();
        notesPage.click_select_status();
        notesPage.click_note_ready();

    }

    @Test
    public void notesTestEmptyChar_Performed() {
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.inputPass(ConfProperties.getProperty("passwd"));
        loginPage.clickLoginBtn();

        notesPage.click_btn_add_notes();
        notesPage.inputNoteText(ConfProperties.getProperty("noteTextEmptyChar"));
        notesPage.click_select_status();
        notesPage.click_note_select_status_P();
        notesPage.click_select_status();
        notesPage.click_note_ready();

    }

    @Test
    public void notesTestMaxChar_NoPlaned() {
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.inputPass(ConfProperties.getProperty("passwd"));
        loginPage.clickLoginBtn();

        notesPage.click_btn_add_notes();
        notesPage.inputNoteText(ConfProperties.getProperty("noteTextMaxChar"));
        notesPage.click_select_status();
        notesPage.click_note_select_status_NP();
        notesPage.click_select_status();
        notesPage.click_note_ready();
    }

    @Test
    public void notesTestSpecChar_NoPlaned() {
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.inputPass(ConfProperties.getProperty("passwd"));
        loginPage.clickLoginBtn();

        notesPage.click_btn_add_notes();
        notesPage.inputNoteText(ConfProperties.getProperty("noteTextSpecChar"));
        notesPage.click_select_status();
        notesPage.click_note_select_status_NP();
        notesPage.click_select_status();
        notesPage.click_note_ready();
    }

    @Test
    public void notesTestEmptyChar_NoPlaned() {
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.inputPass(ConfProperties.getProperty("passwd"));
        loginPage.clickLoginBtn();

        notesPage.click_btn_add_notes();
        notesPage.inputNoteText(ConfProperties.getProperty("noteTextEmptyChar"));
        notesPage.click_select_status();
        notesPage.click_note_select_status_NP();
        notesPage.click_select_status();
        notesPage.click_note_ready();
    }

    @Test
    public void notesTestMaxChar_ReqExec_5Year() {
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.inputPass(ConfProperties.getProperty("passwd"));
        loginPage.clickLoginBtn();

        notesPage.click_btn_add_notes();
        notesPage.inputNoteText(ConfProperties.getProperty("noteTextMaxChar"));
        notesPage.click_select_status();
        notesPage.click_note_select_status_RE();
        notesPage.click_select_status();
        notesPage.click_select_time();
        notesPage.click_select_time_hours();
        notesPage.clear_hours();
        notesPage.inputHours(ConfProperties.getProperty("hoursTest1"));
        notesPage.click_select_time_minutes();
        notesPage.clear_minutes();
        notesPage.inputMinutes(ConfProperties.getProperty("minutesTest1"));
        notesPage.click_select_time_apply();
        notesPage.click_month_selection();
        notesPage.click_btn_select_date();
        notesPage.click_btn_select_date();
        notesPage.click_btn_select_year();
        notesPage.click_btn_select_month();
        notesPage.click_day_selection_5Y();
        notesPage.click_note_ready();
    }

    @Test
    public void notesTestSpecChar_ReqExec_5Year() {
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.inputPass(ConfProperties.getProperty("passwd"));
        loginPage.clickLoginBtn();

        notesPage.click_btn_add_notes();
        notesPage.inputNoteText(ConfProperties.getProperty("noteTextSpecChar"));
        notesPage.click_select_status();
        notesPage.click_note_select_status_RE();
        notesPage.click_select_status();
        notesPage.click_select_time();
        notesPage.click_select_time_hours();
        notesPage.clear_hours();
        notesPage.inputHours(ConfProperties.getProperty("hoursTest2"));
        notesPage.click_select_time_minutes();
        notesPage.clear_minutes();
        notesPage.inputMinutes(ConfProperties.getProperty("minutesTest2"));
        notesPage.click_select_time_apply();
        notesPage.click_month_selection();
        notesPage.click_btn_select_date();
        notesPage.click_btn_select_date();
        notesPage.click_btn_select_year();
        notesPage.click_btn_select_month();
        notesPage.click_day_selection_5Y();
        notesPage.click_note_ready();
    }

    @Test
    public void notesTestEmptyChar1_ReqExec_5Year() {
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.inputPass(ConfProperties.getProperty("passwd"));
        loginPage.clickLoginBtn();

        notesPage.click_btn_add_notes();
        notesPage.inputNoteText(ConfProperties.getProperty("noteTextEmptyChar"));
        notesPage.click_select_status();
        notesPage.click_note_select_status_RE();
        notesPage.click_select_status();
        notesPage.click_select_time();
        notesPage.click_select_time_hours();
        notesPage.clear_hours();
        notesPage.inputHours(ConfProperties.getProperty("hoursTest2"));
        notesPage.click_select_time_minutes();
        notesPage.clear_minutes();
        notesPage.inputMinutes(ConfProperties.getProperty("minutesTest2"));
        notesPage.click_select_time_apply();
        notesPage.click_month_selection();
        notesPage.click_btn_select_date();
        notesPage.click_btn_select_date();
        notesPage.click_btn_select_year();
        notesPage.click_btn_select_month();
        notesPage.click_day_selection_5Y();
        notesPage.click_note_ready();
    }

    @Test
    public void notesTestEmptyChar2_ReqExec_5Year() {
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.inputPass(ConfProperties.getProperty("passwd"));
        loginPage.clickLoginBtn();

        notesPage.click_btn_add_notes();
        notesPage.inputNoteText(ConfProperties.getProperty("noteTextEmptyChar"));
        notesPage.click_select_status();
        notesPage.click_note_select_status_RE();
        notesPage.click_select_status();
        notesPage.click_select_time();
        notesPage.click_select_time_hours();
        notesPage.clear_hours();
        notesPage.inputHours(ConfProperties.getProperty("hoursTest3"));
        notesPage.click_select_time_minutes();
        notesPage.clear_minutes();
        notesPage.inputMinutes(ConfProperties.getProperty("minutesTest3"));
        notesPage.click_select_time_apply();
        notesPage.click_month_selection();
        notesPage.click_btn_select_date();
        notesPage.click_btn_select_date();
        notesPage.click_btn_select_year();
        notesPage.click_btn_select_month();
        notesPage.click_day_selection_5Y();
        notesPage.click_note_ready();


    }

    @Test
    public void notesTestMaxChar_ReqExec_NxMnt() {
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.inputPass(ConfProperties.getProperty("passwd"));
        loginPage.clickLoginBtn();

        notesPage.click_btn_add_notes();
        notesPage.inputNoteText(ConfProperties.getProperty("noteTextMaxChar"));
        notesPage.click_select_status();
        notesPage.click_note_select_status_RE();
        notesPage.click_select_status();
        notesPage.click_select_time();
        notesPage.click_select_time_hours();
        notesPage.clear_hours();
        notesPage.clear_minutes();
        notesPage.inputHours(ConfProperties.getProperty("hoursTest3"));
        notesPage.click_select_time_minutes();
        notesPage.inputMinutes(ConfProperties.getProperty("minutesTest3"));
        notesPage.click_select_time_apply();
        notesPage.click_month_selection();
        notesPage.click_arrow();
        notesPage.click_day_selection_NM();
        notesPage.click_note_ready();
    }

    @Test
    public void notesTestSpecChar_ReqExec_NxMnt() {
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.inputPass(ConfProperties.getProperty("passwd"));
        loginPage.clickLoginBtn();

        notesPage.click_btn_add_notes();
        notesPage.inputNoteText(ConfProperties.getProperty("noteTextSpecChar"));
        notesPage.click_select_status();
        notesPage.click_note_select_status_RE();
        notesPage.click_select_status();
        notesPage.click_select_time();
        notesPage.click_select_time_hours();
        notesPage.clear_hours();
        notesPage.clear_minutes();
        notesPage.inputHours(ConfProperties.getProperty("hoursTest2"));
        notesPage.click_select_time_minutes();
        notesPage.inputMinutes(ConfProperties.getProperty("minutesTest2"));
        notesPage.click_select_time_apply();
        notesPage.click_month_selection();
        notesPage.click_arrow();
        notesPage.click_day_selection_NM();
        notesPage.click_note_ready();
    }

    @Test
    public void notesTestEmptyChar_ReqExec_NxMnt() {
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.inputPass(ConfProperties.getProperty("passwd"));
        loginPage.clickLoginBtn();

        notesPage.click_btn_add_notes();
        notesPage.inputNoteText(ConfProperties.getProperty("noteTextEmptyChar"));
        notesPage.click_select_status();
        notesPage.click_note_select_status_RE();
        notesPage.click_select_status();
        notesPage.click_select_time();
        notesPage.click_select_time_hours();
        notesPage.clear_hours();
        notesPage.clear_minutes();
        notesPage.inputHours(ConfProperties.getProperty("hoursTest1"));
        notesPage.click_select_time_minutes();
        notesPage.inputMinutes(ConfProperties.getProperty("minutesTest1"));
        notesPage.click_select_time_apply();
        notesPage.click_month_selection();
        notesPage.click_arrow();
        notesPage.click_day_selection_NM();
        notesPage.click_note_ready();
    }

    @Test
    public void notesTestMaxChar_ReqExec_Tomorrow() {
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.inputPass(ConfProperties.getProperty("passwd"));
        loginPage.clickLoginBtn();

        notesPage.click_btn_add_notes();
        notesPage.inputNoteText(ConfProperties.getProperty("noteTextMaxChar"));
        notesPage.click_select_status();
        notesPage.click_note_select_status_RE();
        notesPage.click_select_status();
        notesPage.click_select_time();
        notesPage.click_select_time_hours();
        notesPage.clear_hours();
        notesPage.clear_minutes();
        notesPage.inputHours(ConfProperties.getProperty("hoursTest2"));
        notesPage.click_select_time_minutes();
        notesPage.inputMinutes(ConfProperties.getProperty("minutesTest2"));
        notesPage.click_select_time_apply();
        notesPage.click_month_selection();
        notesPage.click_day_selection_T();
        notesPage.click_note_ready();
    }

    @Test
    public void notesTestEmptyChar_ReqExec_Tomorrow() {
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.inputPass(ConfProperties.getProperty("passwd"));
        loginPage.clickLoginBtn();

        notesPage.click_btn_add_notes();
        notesPage.inputNoteText(ConfProperties.getProperty("noteTextEmptyChar"));
        notesPage.click_select_status();
        notesPage.click_note_select_status_RE();
        notesPage.click_select_status();
        notesPage.click_select_time();
        notesPage.click_select_time_hours();
        notesPage.clear_hours();
        notesPage.clear_minutes();
        notesPage.inputHours(ConfProperties.getProperty("hoursTest3"));
        notesPage.click_select_time_minutes();
        notesPage.inputMinutes(ConfProperties.getProperty("minutesTest3"));
        notesPage.click_select_time_apply();
        notesPage.click_month_selection();
        notesPage.click_day_selection_T();
        notesPage.click_note_ready();
    }

    @Test
    public void notesTestSpecChar1_ReqExec_Tomorrow() {
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.inputPass(ConfProperties.getProperty("passwd"));
        loginPage.clickLoginBtn();

        notesPage.click_btn_add_notes();
        notesPage.inputNoteText(ConfProperties.getProperty("noteTextSpecChar"));
        notesPage.click_select_status();
        notesPage.click_note_select_status_RE();
        notesPage.click_select_status();
        notesPage.click_select_time();
        notesPage.click_select_time_hours();
        notesPage.clear_hours();
        notesPage.clear_minutes();
        notesPage.inputHours(ConfProperties.getProperty("hoursTest3"));
        notesPage.click_select_time_minutes();
        notesPage.inputMinutes(ConfProperties.getProperty("minutesTest3"));
        notesPage.click_select_time_apply();
        notesPage.click_month_selection();
        notesPage.click_day_selection_T();
        notesPage.click_note_ready();
    }

    @Test
    public void notesTestSpecChar2_ReqExec_Tomorrow() {
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.inputPass(ConfProperties.getProperty("passwd"));
        loginPage.clickLoginBtn();

        notesPage.click_btn_add_notes();
        notesPage.inputNoteText(ConfProperties.getProperty("noteTextSpecChar"));
        notesPage.click_select_status();
        notesPage.click_note_select_status_RE();
        notesPage.click_select_status();
        notesPage.click_select_time();
        notesPage.click_select_time_hours();
        notesPage.clear_hours();
        notesPage.clear_minutes();
        notesPage.inputHours(ConfProperties.getProperty("hoursTest1"));
        notesPage.click_select_time_minutes();
        notesPage.inputMinutes(ConfProperties.getProperty("minutesTest1"));
        notesPage.click_select_time_apply();
        notesPage.click_month_selection();
        notesPage.click_day_selection_T();
        notesPage.click_note_ready();
    }
}
