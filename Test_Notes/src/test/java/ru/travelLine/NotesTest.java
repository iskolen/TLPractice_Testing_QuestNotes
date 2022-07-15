package ru.travelLine;

import org.junit.*;
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
    @DisplayName("This test checks the case when the status is 'Performed'" +
                 "and the note text is 'Maximum character value'")
    public void notesTestsPerformedMax() {
        loginPage.authorization(ConfProperties.getProperty("login"), ConfProperties.getProperty("password"));

        notesPage.clickBtnAddNotes();
        notesPage.inputNoteText(ConfProperties.getProperty("noteTextMaxChar"));
        notesPage.setStatusPerformed();
        String textExam = notesPage.getText();
        String statusExam = notesPage.getStatus();
        notesPage.clickNoteReady();
        Assert.assertEquals(ConfProperties.getProperty("noteTextMaxChar"), textExam);
        Assert.assertEquals("Выполнено", statusExam);
        System.out.println(textExam);
        System.out.println(statusExam);
    }

    @Test
    @DisplayName("This test checks the case when the status is 'Performed'" +
                 "and the note text is 'Special characters'")
    public void notesTestsPerformedSpec() {
        loginPage.authorization(ConfProperties.getProperty("login"), ConfProperties.getProperty("password"));

        notesPage.clickBtnAddNotes();
        notesPage.inputNoteText(ConfProperties.getProperty("noteTextSpecChar"));
        notesPage.setStatusPerformed();
        String textExam = notesPage.getText();
        String statusExam = notesPage.getStatus();
        notesPage.clickNoteReady();
        Assert.assertEquals(ConfProperties.getProperty("noteTextSpecChar"), textExam);
        Assert.assertEquals("Выполнено", statusExam);
        System.out.println(textExam);
        System.out.println(statusExam);

    }

    @Test
    @DisplayName("This test checks the case when the status is 'Performed'" +
                 "and the note text is 'Empty value'")
    public void notesTestsPerformedEmpty() {
        loginPage.authorization(ConfProperties.getProperty("login"), ConfProperties.getProperty("password"));

        notesPage.clickBtnAddNotes();
        notesPage.inputNoteText(ConfProperties.getProperty("noteTextEmptyChar"));
        notesPage.setStatusPerformed();
        String textExam = notesPage.getText();
        String statusExam = notesPage.getStatus();
        notesPage.clickNoteReady();
        Assert.assertEquals(ConfProperties.getProperty("noteTextEmptyChar"), textExam);
        Assert.assertEquals("Выполнено", statusExam);
        System.out.println(textExam);
        System.out.println(statusExam);

    }

    @Test
    @DisplayName("This test checks the case when the status is 'NoPlaned'" +
                 "and the note text is 'Special characters'")
    public void notesTestsNoPlanedSpec() {
        loginPage.authorization(ConfProperties.getProperty("login"), ConfProperties.getProperty("password"));

        notesPage.clickBtnAddNotes();
        notesPage.inputNoteText(ConfProperties.getProperty("noteTextSpecChar"));
        notesPage.setStatusNoPlaned();
        String textExam = notesPage.getText();
        String statusExam = notesPage.getStatus();
        notesPage.clickNoteReady();
        Assert.assertEquals(ConfProperties.getProperty("noteTextSpecChar"), textExam);
        Assert.assertEquals("Не запланировано", statusExam);
        System.out.println(textExam);
        System.out.println(statusExam);
    }

    @Test
    @DisplayName("This test checks the case when the status is 'NoPlaned'" +
                 "and the note text is 'Maximum character value'")
    public void notesTestsNoPlanedMax() {
        loginPage.authorization(ConfProperties.getProperty("login"), ConfProperties.getProperty("password"));

        notesPage.clickBtnAddNotes();
        notesPage.inputNoteText(ConfProperties.getProperty("noteTextMaxChar"));
        notesPage.setStatusNoPlaned();
        String textExam = notesPage.getText();
        String statusExam = notesPage.getStatus();
        notesPage.clickNoteReady();
        Assert.assertEquals(ConfProperties.getProperty("noteTextMaxChar"), textExam);
        Assert.assertEquals("Не запланировано", statusExam);
        System.out.println(textExam);
        System.out.println(statusExam);
    }

    @Test
    @DisplayName("This test checks the case when the status is 'NoPlaned'" +
                 "and the note text is 'Empty value'")
    public void notesTestsNoPlanedEmpty() {
        loginPage.authorization(ConfProperties.getProperty("login"), ConfProperties.getProperty("password"));

        notesPage.clickBtnAddNotes();
        notesPage.inputNoteText(ConfProperties.getProperty("noteTextEmptyChar"));
        notesPage.setStatusNoPlaned();
        String textExam = notesPage.getText();
        String statusExam = notesPage.getStatus();
        notesPage.clickNoteReady();
        Assert.assertEquals(ConfProperties.getProperty("noteTextEmptyChar"), textExam);
        Assert.assertEquals("Не запланировано", statusExam);
        System.out.println(textExam);
        System.out.println(statusExam);
    }

    @Test
    @DisplayName("This test checks the case when the status is 'RequiresExecution' after 5 years" +
                 "and the note text is 'Empty value'" +
                 "and the note time is '15:00'")
    public void notesTestsRequiresExecutionFiveYearsEmptyOne() {
        loginPage.authorization(ConfProperties.getProperty("login"), ConfProperties.getProperty("password"));

        notesPage.clickBtnAddNotes();
        notesPage.inputNoteText(ConfProperties.getProperty("noteTextEmptyChar"));
        notesPage.setStatusRequiresExecution();
        notesPage.setTime(ConfProperties.getProperty("hoursTestThree"), ConfProperties.getProperty("minutesTestThree"));
        notesPage.setDateFiveYears();
        String textExam = notesPage.getText();
        String hoursExam = notesPage.getHours();
        String minutesExam = notesPage.getMinutes();
        String statusExam = notesPage.getStatus();
        notesPage.clickNoteReady();
        Assert.assertEquals(ConfProperties.getProperty("noteTextEmptyChar"), textExam);
        Assert.assertEquals(ConfProperties.getProperty("hoursTestThree"), hoursExam);
        Assert.assertEquals(ConfProperties.getProperty("minutesTestThree"), minutesExam);
        Assert.assertEquals("Требует выполнения", statusExam);
        System.out.println(textExam);
        System.out.println(hoursExam);
        System.out.println(minutesExam);
        System.out.println(statusExam);

    }

    @Test
    @DisplayName("This test checks the case when the status is 'RequiresExecution' after 5 years" +
                 "and the note text is 'Empty value'" +
                 "and the note time is '0:00'")
    public void notesTestsRequiresExecutionFiveYearsEmptyTwo() {
        loginPage.authorization(ConfProperties.getProperty("login"), ConfProperties.getProperty("password"));

        notesPage.clickBtnAddNotes();
        notesPage.inputNoteText(ConfProperties.getProperty("noteTextEmptyChar"));
        notesPage.setStatusRequiresExecution();
        notesPage.setTime(ConfProperties.getProperty("hoursTestTwo"), ConfProperties.getProperty("minutesTestTwo"));
        notesPage.setDateFiveYears();
        String textExam = notesPage.getText();
        String hoursExam = notesPage.getHours();
        String minutesExam = notesPage.getMinutes();
        String statusExam = notesPage.getStatus();
        notesPage.clickNoteReady();
        Assert.assertEquals(ConfProperties.getProperty("noteTextEmptyChar"), textExam);
        Assert.assertEquals(ConfProperties.getProperty("hoursTestTwo"), hoursExam);
        Assert.assertEquals(ConfProperties.getProperty("minutesTestTwo"), minutesExam);
        Assert.assertEquals("Требует выполнения", statusExam);
        System.out.println(textExam);
        System.out.println(hoursExam);
        System.out.println(minutesExam);
        System.out.println(statusExam);
    }

    @Test
    @DisplayName("This test checks the case when the status is 'RequiresExecution' after 5 years" +
                 "and the note text is 'Maximum character value'" +
                 "and the note time is '23:59'")
    public void notesTestsRequiresExecutionFiveYearsMax() {
        loginPage.authorization(ConfProperties.getProperty("login"), ConfProperties.getProperty("password"));

        notesPage.clickBtnAddNotes();
        notesPage.inputNoteText(ConfProperties.getProperty("noteTextMaxChar"));
        notesPage.setStatusRequiresExecution();
        notesPage.setTime(ConfProperties.getProperty("hoursTestOne"), ConfProperties.getProperty("minutesTestOne"));
        notesPage.setDateFiveYears();
        String textExam = notesPage.getText();
        String hoursExam = notesPage.getHours();
        String minutesExam = notesPage.getMinutes();
        String statusExam = notesPage.getStatus();
        notesPage.clickNoteReady();
        Assert.assertEquals(ConfProperties.getProperty("noteTextMaxChar"), textExam);
        Assert.assertEquals(ConfProperties.getProperty("hoursTestOne"), hoursExam);
        Assert.assertEquals(ConfProperties.getProperty("minutesTestOne"), minutesExam);
        Assert.assertEquals("Требует выполнения", statusExam);
        System.out.println(textExam);
        System.out.println(hoursExam);
        System.out.println(minutesExam);
        System.out.println(statusExam);
    }

    @Test
    @DisplayName("This test checks the case when the status is 'RequiresExecution' after 5 years" +
                 "and the note text is 'Special characters'" +
                 "and the note time is '0:00'")
    public void notesTestsRequiresExecutionFiveYearsSpec() {
        loginPage.authorization(ConfProperties.getProperty("login"), ConfProperties.getProperty("password"));

        notesPage.clickBtnAddNotes();
        notesPage.inputNoteText(ConfProperties.getProperty("noteTextSpecChar"));
        notesPage.setStatusRequiresExecution();
        notesPage.setTime(ConfProperties.getProperty("hoursTestTwo"), ConfProperties.getProperty("minutesTestTwo"));
        notesPage.setDateFiveYears();
        String textExam = notesPage.getText();
        String hoursExam = notesPage.getHours();
        String minutesExam = notesPage.getMinutes();
        String statusExam = notesPage.getStatus();
        notesPage.clickNoteReady();
        Assert.assertEquals(ConfProperties.getProperty("noteTextSpecChar"), textExam);
        Assert.assertEquals(ConfProperties.getProperty("hoursTestTwo"), hoursExam);
        Assert.assertEquals(ConfProperties.getProperty("minutesTestTwo"), minutesExam);
        Assert.assertEquals("Требует выполнения", statusExam);
        System.out.println(textExam);
        System.out.println(hoursExam);
        System.out.println(minutesExam);
        System.out.println(statusExam);
    }

    @Test
    @DisplayName("This test checks the case when the status is 'RequiresExecution' after month" +
                 "and the note text is 'Maximum character value'" +
                 "and the note time is '15:00'")
    public void notesTestsRequiresExecutionNextMonthMax() {
        loginPage.authorization(ConfProperties.getProperty("login"), ConfProperties.getProperty("password"));

        notesPage.clickBtnAddNotes();
        notesPage.inputNoteText(ConfProperties.getProperty("noteTextMaxChar"));
        notesPage.setStatusRequiresExecution();
        notesPage.setTime(ConfProperties.getProperty("hoursTestThree"), ConfProperties.getProperty("minutesTestThree"));
        notesPage.setDateNextMonth();
        String textExam = notesPage.getText();
        String hoursExam = notesPage.getHours();
        String minutesExam = notesPage.getMinutes();
        String statusExam = notesPage.getStatus();
        notesPage.clickNoteReady();
        Assert.assertEquals(ConfProperties.getProperty("noteTextMaxChar"), textExam);
        Assert.assertEquals(ConfProperties.getProperty("hoursTestThree"), hoursExam);
        Assert.assertEquals(ConfProperties.getProperty("minutesTestThree"), minutesExam);
        Assert.assertEquals("Требует выполнения", statusExam);
        System.out.println(textExam);
        System.out.println(hoursExam);
        System.out.println(minutesExam);
        System.out.println(statusExam);
    }

    @Test
    @DisplayName("This test checks the case when the status is 'RequiresExecution' after month" +
                 "and the note text is 'Special characters'" +
                 "and the note time is '0:00'")
    public void notesTestsRequiresExecutionNextMonthSpec() {
        loginPage.authorization(ConfProperties.getProperty("login"), ConfProperties.getProperty("password"));

        notesPage.clickBtnAddNotes();
        notesPage.inputNoteText(ConfProperties.getProperty("noteTextSpecChar"));
        notesPage.setStatusRequiresExecution();
        notesPage.setTime(ConfProperties.getProperty("hoursTestTwo"), ConfProperties.getProperty("minutesTestTwo"));
        notesPage.setDateNextMonth();
        String textExam = notesPage.getText();
        String hoursExam = notesPage.getHours();
        String minutesExam = notesPage.getMinutes();
        String statusExam = notesPage.getStatus();
        notesPage.clickNoteReady();
        Assert.assertEquals(ConfProperties.getProperty("noteTextSpecChar"), textExam);
        Assert.assertEquals(ConfProperties.getProperty("hoursTestTwo"), hoursExam);
        Assert.assertEquals(ConfProperties.getProperty("minutesTestTwo"), minutesExam);
        Assert.assertEquals("Требует выполнения", statusExam);
        System.out.println(textExam);
        System.out.println(hoursExam);
        System.out.println(minutesExam);
        System.out.println(statusExam);
    }

    @Test
    @DisplayName("This test checks the case when the status is 'RequiresExecution' after month" +
                 "and the note text is 'Empty value'" +
                 "and the note time is '23:59'")
    public void notesTestsRequiresExecutionNextMonthEmpty() {
        loginPage.authorization(ConfProperties.getProperty("login"), ConfProperties.getProperty("password"));

        notesPage.clickBtnAddNotes();
        notesPage.inputNoteText(ConfProperties.getProperty("noteTextEmptyChar"));
        notesPage.setStatusRequiresExecution();
        notesPage.setTime(ConfProperties.getProperty("hoursTestOne"), ConfProperties.getProperty("minutesTestOne"));
        notesPage.setDateNextMonth();
        String textExam = notesPage.getText();
        String hoursExam = notesPage.getHours();
        String minutesExam = notesPage.getMinutes();
        String statusExam = notesPage.getStatus();
        notesPage.clickNoteReady();
        Assert.assertEquals(ConfProperties.getProperty("noteTextEmptyChar"), textExam);
        Assert.assertEquals(ConfProperties.getProperty("hoursTestOne"), hoursExam);
        Assert.assertEquals(ConfProperties.getProperty("minutesTestOne"), minutesExam);
        Assert.assertEquals("Требует выполнения", statusExam);
        System.out.println(textExam);
        System.out.println(hoursExam);
        System.out.println(minutesExam);
        System.out.println(statusExam);
    }


    @Test
    @DisplayName("This test checks the case when the status is 'RequiresExecution' tomorrow" +
                 "and the note text is 'Maximum character value'" +
                 "and the note time is '0:00'")
    public void notesTestsRequiresExecutionTomorrowMax() {
        loginPage.authorization(ConfProperties.getProperty("login"), ConfProperties.getProperty("password"));

        notesPage.clickBtnAddNotes();
        notesPage.inputNoteText(ConfProperties.getProperty("noteTextMaxChar"));
        notesPage.setStatusRequiresExecution();
        notesPage.setTime(ConfProperties.getProperty("hoursTestTwo"), ConfProperties.getProperty("minutesTestTwo"));
        notesPage.setDateTomorrow();
        String textExam = notesPage.getText();
        String hoursExam = notesPage.getHours();
        String minutesExam = notesPage.getMinutes();
        String statusExam = notesPage.getStatus();
        notesPage.clickNoteReady();
        Assert.assertEquals(ConfProperties.getProperty("noteTextMaxChar"), textExam);
        Assert.assertEquals(ConfProperties.getProperty("hoursTestTwo"), hoursExam);
        Assert.assertEquals(ConfProperties.getProperty("minutesTestTwo"), minutesExam);
        Assert.assertEquals("Требует выполнения", statusExam);
        System.out.println(textExam);
        System.out.println(hoursExam);
        System.out.println(minutesExam);
        System.out.println(statusExam);
    }

    @Test
    @DisplayName("This test checks the case when the status is 'RequiresExecution' tomorrow" +
                 "and the note text is 'Empty value'" +
                 "and the note time is '15:00'")
    public void notesTestsRequiresExecutionTomorrowEmpty() {
        loginPage.authorization(ConfProperties.getProperty("login"), ConfProperties.getProperty("password"));

        notesPage.clickBtnAddNotes();
        notesPage.inputNoteText(ConfProperties.getProperty("noteTextEmptyChar"));
        notesPage.setStatusRequiresExecution();
        notesPage.setTime(ConfProperties.getProperty("hoursTestThree"), ConfProperties.getProperty("minutesTestThree"));
        notesPage.setDateTomorrow();
        String textExam = notesPage.getText();
        String hoursExam = notesPage.getHours();
        String minutesExam = notesPage.getMinutes();
        String statusExam = notesPage.getStatus();
        notesPage.clickNoteReady();
        Assert.assertEquals(ConfProperties.getProperty("noteTextEmptyChar"), textExam);
        Assert.assertEquals(ConfProperties.getProperty("hoursTestThree"), hoursExam);
        Assert.assertEquals(ConfProperties.getProperty("minutesTestThree"), minutesExam);
        Assert.assertEquals("Требует выполнения", statusExam);
        System.out.println(textExam);
        System.out.println(hoursExam);
        System.out.println(minutesExam);
        System.out.println(statusExam);
    }

    @Test
    @DisplayName("This test checks the case when the status is 'RequiresExecution' tomorrow" +
                 "and the note text is 'Special characters'" +
                 "and the note time is '15:00'")
    public void notesTestsRequiresExecutionTomorrowSpecOne() {
        loginPage.authorization(ConfProperties.getProperty("login"), ConfProperties.getProperty("password"));

        notesPage.clickBtnAddNotes();
        notesPage.inputNoteText(ConfProperties.getProperty("noteTextSpecChar"));
        notesPage.setStatusRequiresExecution();
        notesPage.setTime(ConfProperties.getProperty("hoursTestThree"), ConfProperties.getProperty("minutesTestThree"));
        notesPage.setDateTomorrow();
        String textExam = notesPage.getText();
        String hoursExam = notesPage.getHours();
        String minutesExam = notesPage.getMinutes();
        String statusExam = notesPage.getStatus();
        notesPage.clickNoteReady();
        Assert.assertEquals(ConfProperties.getProperty("noteTextSpecChar"), textExam);
        Assert.assertEquals(ConfProperties.getProperty("hoursTestThree"), hoursExam);
        Assert.assertEquals(ConfProperties.getProperty("minutesTestThree"), minutesExam);
        Assert.assertEquals("Требует выполнения", statusExam);
        System.out.println(textExam);
        System.out.println(hoursExam);
        System.out.println(minutesExam);
        System.out.println(statusExam);
    }

    @Test
    @DisplayName("This test checks the case when the status is 'RequiresExecution' tomorrow" +
                 "and the note text is 'Special characters'" +
                 "and the note time is '23:59'")
    public void notesTestsRequiresExecutionTomorrowSpecTwo() {
        loginPage.authorization(ConfProperties.getProperty("login"), ConfProperties.getProperty("password"));

        notesPage.clickBtnAddNotes();
        notesPage.inputNoteText(ConfProperties.getProperty("noteTextSpecChar"));
        notesPage.setStatusRequiresExecution();
        notesPage.setTime(ConfProperties.getProperty("hoursTestOne"), ConfProperties.getProperty("minutesTestOne"));
        notesPage.setDateTomorrow();
        String textExam = notesPage.getText();
        String hoursExam = notesPage.getHours();
        String minutesExam = notesPage.getMinutes();
        String statusExam = notesPage.getStatus();
        notesPage.clickNoteReady();
        Assert.assertEquals(ConfProperties.getProperty("noteTextSpecChar"), textExam);
        Assert.assertEquals(ConfProperties.getProperty("hoursTestOne"), hoursExam);
        Assert.assertEquals(ConfProperties.getProperty("minutesTestOne"), minutesExam);
        Assert.assertEquals("Требует выполнения", statusExam);
        System.out.println(textExam);
        System.out.println(hoursExam);
        System.out.println(minutesExam);
        System.out.println(statusExam);
    }
}
