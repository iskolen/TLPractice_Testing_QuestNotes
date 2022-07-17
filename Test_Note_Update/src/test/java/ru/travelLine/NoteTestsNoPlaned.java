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
public class NoteTestsNoPlaned {

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
    public NoteTestsNoPlaned(String noteText) {
        this.noteText = noteText;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][]{{ConfProperties.getProperty("noteTextMaxChar")}, {ConfProperties.getProperty("noteTextSpecChar")}, {ConfProperties.getProperty("noteTextEmptyChar")}};
        return Arrays.asList(data);
    }

    @Test
    @DisplayName("This test checks the 3 case when the status is 'NoPlaned' and the note text is :" +
            "1)Maximum character value" +
            "2)Special characters" +
            "3)Empty value")
    public void testNoPlaned() throws InterruptedException {
        notesPage.clickBtnAddNotes();
        notesPage.inputNoteText(noteText);
        notesPage.setStatusNoPlaned();
        notesPage.clickNoteReady();
        TimeUnit.SECONDS.sleep(2);
        String textExam = notesPage.getText();
        String statusExam = notesPage.getStatus();
        Assert.assertEquals("Текст введён не верно!", noteText, textExam);
        Assert.assertEquals("Статус выбран не верно!","Не запланировано", statusExam);
    }
}