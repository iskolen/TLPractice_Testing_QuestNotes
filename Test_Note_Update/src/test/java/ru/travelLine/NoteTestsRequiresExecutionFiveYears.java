package ru.travelLine;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

@RunWith(value = Parameterized.class)
public class NoteTestsRequiresExecutionFiveYears {

    public static LoginPage loginPage;
    public static NotesPage notesPage;
    public static WebDriver driver;

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
        //авторизация
        loginPage.authorization(ConfProperties.getProperty("login"), ConfProperties.getProperty("password"));

    }

    @After
    public void tearDown() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        driver.quit();
    }

    private String noteText;
    private String noteHours;
    private String noteMinutes;

    public NoteTestsRequiresExecutionFiveYears(String noteText, String noteHours, String noteMinutes) {
        this.noteText = noteText;
        this.noteHours = noteHours;
        this.noteMinutes = noteMinutes;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][]{{ConfProperties.getProperty("noteTextEmptyChar"), "15", "00"}, {ConfProperties.getProperty("noteTextMaxChar"), "23", "59"}, {ConfProperties.getProperty("noteTextEmptyChar"), "00", "00"}, {ConfProperties.getProperty("noteTextSpecChar"), "00", "00"}};
        return Arrays.asList(data);
    }

    @Test
    @DisplayName("This test checks the 3 case when the status is 'RequiresExecution' after 5 years and :" +
                 "1)Note text is: 'Empty value',             time is: 15:00" +
                 "2)Note text is: 'Empty value',             time is: 0:00" +
                 "3)Note text is: 'Maximum character value', time is: 23:59" +
                 "4)Note text is: 'Special characters',      time is: 0:00")
    public void testsRequiresExecutionFiveYears() throws InterruptedException {
        notesPage.clickBtnAddNotes();
        notesPage.inputNoteText(noteText);
        notesPage.setStatusRequiresExecution();
        notesPage.setTime(noteHours, noteMinutes);
        notesPage.setDateFiveYears();
        notesPage.clickNoteReady();
        TimeUnit.SECONDS.sleep(2);
        String textExam = notesPage.getText();
        String hoursExam = notesPage.getHours();
        String minutesExam = notesPage.getMinutes();
        String statusExam = notesPage.getStatus();
        Assert.assertEquals("Текст введён не верно!", noteText, textExam);
        Assert.assertEquals("Часы введены не верно!", noteHours, hoursExam);
        Assert.assertEquals("Минуты введены не верно!", noteMinutes, minutesExam);
        Assert.assertEquals("Статус выбран не верно!","Требует выполнения", statusExam);
    }
}