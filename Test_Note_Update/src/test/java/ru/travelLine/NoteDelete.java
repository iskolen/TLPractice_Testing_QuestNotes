package ru.travelLine;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class NoteDelete {

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

    @Test
    public void deleteNote() throws InterruptedException {
        notesPage.deleteNote();
        TimeUnit.SECONDS.sleep(1);
        notesPage.deleteNote();
        TimeUnit.SECONDS.sleep(1);
        notesPage.deleteNote();
        TimeUnit.SECONDS.sleep(1);
        notesPage.deleteNote();
        TimeUnit.SECONDS.sleep(1);
        notesPage.deleteNote();
        TimeUnit.SECONDS.sleep(1);
        notesPage.deleteNote();
        TimeUnit.SECONDS.sleep(1);
        notesPage.deleteNote();
        TimeUnit.SECONDS.sleep(1);
        notesPage.deleteNote();
        TimeUnit.SECONDS.sleep(1);
        notesPage.deleteNote();
        TimeUnit.SECONDS.sleep(1);
        notesPage.deleteNote();
        TimeUnit.SECONDS.sleep(1);
        notesPage.deleteNote();
        TimeUnit.SECONDS.sleep(1);
        notesPage.deleteNote();
        TimeUnit.SECONDS.sleep(1);
        notesPage.deleteNote();
        TimeUnit.SECONDS.sleep(1);
        notesPage.deleteNote();
        TimeUnit.SECONDS.sleep(1);
        notesPage.deleteNote();
        TimeUnit.SECONDS.sleep(1);
        notesPage.deleteNote();
        TimeUnit.SECONDS.sleep(1);
        notesPage.deleteNote();
        TimeUnit.SECONDS.sleep(1);
        notesPage.deleteNote();
        TimeUnit.SECONDS.sleep(1);
        notesPage.deleteNote();
        TimeUnit.SECONDS.sleep(1);
        notesPage.deleteNote();
        TimeUnit.SECONDS.sleep(1);
        notesPage.deleteNote();
        TimeUnit.SECONDS.sleep(1);
        notesPage.deleteNote();
        TimeUnit.SECONDS.sleep(1);
        notesPage.deleteNote();
    }
}