package ru.travelLine;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("The test checks for 3 cases where the status is 'Performed':" +
                "1) Maximum number of characters" +
                "2) A set of special characters" +
                "3) Empty value")
    public void notesTests_Performed() {
        loginPage.authorization(ConfProperties.getProperty("login"), ConfProperties.getProperty("password"));

        notesPage.click_btn_add_notes();
        notesPage.inputNoteText(ConfProperties.getProperty("noteTextMaxChar"));
        notesPage.set_status_Performed();
        notesPage.click_note_ready();

        notesPage.click_btn_add_notes();
        notesPage.inputNoteText(ConfProperties.getProperty("noteTextSpecChar"));
        notesPage.set_status_Performed();
        notesPage.click_note_ready();

        notesPage.click_btn_add_notes();
        notesPage.inputNoteText(ConfProperties.getProperty("noteTextEmptyChar"));
        notesPage.set_status_Performed();
        notesPage.click_note_ready();

    }

    @Test
    @DisplayName("The test checks for 3 cases where the status is 'NoPlaned':" +
                 "1) Maximum number of characters" +
                 "2) A set of special characters" +
                 "3) Empty value")
    public void notesTests_NoPlaned() {
        loginPage.authorization(ConfProperties.getProperty("login"), ConfProperties.getProperty("password"));

        notesPage.click_btn_add_notes();
        notesPage.inputNoteText(ConfProperties.getProperty("noteTextSpecChar"));
        notesPage.set_status_NoPlaned();
        notesPage.click_note_ready();

        notesPage.click_btn_add_notes();
        notesPage.inputNoteText(ConfProperties.getProperty("noteTextMaxChar"));
        notesPage.set_status_NoPlaned();
        notesPage.click_note_ready();

        notesPage.click_btn_add_notes();
        notesPage.inputNoteText(ConfProperties.getProperty("noteTextEmptyChar"));
        notesPage.set_status_NoPlaned();
        notesPage.click_note_ready();
    }

    @Test
    @DisplayName("The test checks for 4 cases where the status is 'RequiresExecution after 5 years':" +
            "1) Maximum number of characters, time - 23:59" +
            "2) A set of special characters,  time - 0:00" +
            "3) Empty value,                  time - 0:00" +
            "4) Empty value,                  time - 15:00")
    public void notesTests_RequiresExecution_5years() {
        loginPage.authorization(ConfProperties.getProperty("login"), ConfProperties.getProperty("password"));

        notesPage.click_btn_add_notes();
        notesPage.inputNoteText(ConfProperties.getProperty("noteTextEmptyChar"));
        notesPage.set_status_RequiresExecution();
        notesPage.set_time(ConfProperties.getProperty("hoursTest3"), ConfProperties.getProperty("minutesTest3"));
        notesPage.set_date_5years();
        notesPage.click_note_ready();

        notesPage.click_btn_add_notes();
        notesPage.inputNoteText(ConfProperties.getProperty("noteTextEmptyChar"));
        notesPage.set_status_RequiresExecution();
        notesPage.set_time(ConfProperties.getProperty("hoursTest2"), ConfProperties.getProperty("minutesTest2"));
        notesPage.set_date_5years();
        notesPage.click_note_ready();

        notesPage.click_btn_add_notes();
        notesPage.inputNoteText(ConfProperties.getProperty("noteTextMaxChar"));
        notesPage.set_status_RequiresExecution();
        notesPage.set_time(ConfProperties.getProperty("hoursTest1"), ConfProperties.getProperty("minutesTest1"));
        notesPage.set_date_5years();
        notesPage.click_note_ready();

        notesPage.click_btn_add_notes();
        notesPage.inputNoteText(ConfProperties.getProperty("noteTextSpecChar"));
        notesPage.set_status_RequiresExecution();
        notesPage.set_time(ConfProperties.getProperty("hoursTest2"), ConfProperties.getProperty("minutesTest2"));
        notesPage.set_date_5years();
        notesPage.click_note_ready();
    }

    @Test
    @DisplayName("The test checks for 4 cases where the status is 'RequiresExecution after 5 years':" +
            "1) Maximum number of characters, time - 0:00" +
            "2) A set of special characters,  time - 0:00" +
            "3) Empty value,                  time - 23:59")
    public void notesTests_RequiresExecution_NextMonth() {
        loginPage.authorization(ConfProperties.getProperty("login"), ConfProperties.getProperty("password"));

        notesPage.click_btn_add_notes();
        notesPage.inputNoteText(ConfProperties.getProperty("noteTextMaxChar"));
        notesPage.set_status_RequiresExecution();
        notesPage.set_time(ConfProperties.getProperty("hoursTest2"), ConfProperties.getProperty("minutesTest2"));
        notesPage.set_date_NextMonth();
        notesPage.click_note_ready();

        notesPage.click_btn_add_notes();
        notesPage.inputNoteText(ConfProperties.getProperty("noteTextSpecChar"));
        notesPage.set_status_RequiresExecution();
        notesPage.set_time(ConfProperties.getProperty("hoursTest2"), ConfProperties.getProperty("minutesTest2"));
        notesPage.set_date_NextMonth();
        notesPage.click_note_ready();

        notesPage.click_btn_add_notes();
        notesPage.inputNoteText(ConfProperties.getProperty("noteTextEmptyChar"));
        notesPage.set_status_RequiresExecution();
        notesPage.set_time(ConfProperties.getProperty("hoursTest1"), ConfProperties.getProperty("minutesTest1"));
        notesPage.set_date_NextMonth();
        notesPage.click_note_ready();
    }


    @Test
    @DisplayName("The test checks for 4 cases where the status is 'RequiresExecution after 5 years':" +
            "1) Maximum number of characters, time - 0:00" +
            "2) A set of special characters,  time - 23:59" +
            "3) A set of special characters,  time - 15:00" +
            "4) Empty value,                  time - 15:00")
    public void notesTests_RequiresExecution_Tomorrow() {
        loginPage.authorization(ConfProperties.getProperty("login"), ConfProperties.getProperty("password"));

        notesPage.click_btn_add_notes();
        notesPage.inputNoteText(ConfProperties.getProperty("noteTextMaxChar"));
        notesPage.set_status_RequiresExecution();
        notesPage.set_time(ConfProperties.getProperty("hoursTest2"), ConfProperties.getProperty("minutesTest2"));
        notesPage.set_date_Tomorrow();
        notesPage.click_note_ready();

        notesPage.click_btn_add_notes();
        notesPage.inputNoteText(ConfProperties.getProperty("noteTextEmptyChar"));
        notesPage.set_status_RequiresExecution();
        notesPage.set_time(ConfProperties.getProperty("hoursTest3"), ConfProperties.getProperty("minutesTest3"));
        notesPage.set_date_Tomorrow();
        notesPage.click_note_ready();

        notesPage.click_btn_add_notes();
        notesPage.inputNoteText(ConfProperties.getProperty("noteTextSpecChar"));
        notesPage.set_status_RequiresExecution();
        notesPage.set_time(ConfProperties.getProperty("hoursTest3"), ConfProperties.getProperty("minutesTest3"));
        notesPage.set_date_Tomorrow();
        notesPage.click_note_ready();

        notesPage.click_btn_add_notes();
        notesPage.inputNoteText(ConfProperties.getProperty("noteTextSpecChar"));
        notesPage.set_status_RequiresExecution();
        notesPage.set_time(ConfProperties.getProperty("hoursTest1"), ConfProperties.getProperty("minutesTest1"));
        notesPage.set_date_Tomorrow();
        notesPage.click_note_ready();
    }
}
