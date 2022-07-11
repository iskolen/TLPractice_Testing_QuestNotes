import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "E:\\Test_Notes\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();



        driver.get("https://www.travelline.ru/secure/webpms/extranet/#/WebPmsNotes");
        //login
        WebElement login = driver.findElement(By.cssSelector("input[class='pull-right tl-control-full form-control tl-control']"));
        login.clear();
        login.sendKeys("vadim.petrov");

        //password
        WebElement password = driver.findElement(By.cssSelector("input[class='tl-control-full form-control tl-control tl-control-password ng-isolate-scope show-password']"));
        password.clear();
        password.sendKeys("9vAxWihC");

        //press button "Войти"
        WebElement button_auth = driver.findElement(By.xpath("//tl-button[@class='pull-right tl-control-full ng-scope ng-isolate-scope']"));
        button_auth.click();

        //Timeout for "Add notes"
        driver.manage().timeouts().implicitlyWait(5000,
                TimeUnit.MILLISECONDS);







        //Note entry page

        //Press button Add Notes
        WebElement button_add_notes = driver.findElement(By.xpath("//tl-button[@tl-click='addNote()']"));
        button_add_notes.click();




        //Timeout for "Text area"
        driver.manage().timeouts().implicitlyWait(5000,
                TimeUnit.MILLISECONDS);


        //We write the text
        WebElement text_area = driver.findElement(By.name("noteText"));
        text_area.clear();
        text_area.sendKeys("ООООООООООООООООООООООООООООООООООООООООООООООООООЧЧЧЧЧЧЧЧЧЧЧЧЧЧЧЧЧЧЧЧЧЧЧЧЧЧЧЧЧЧЧЕЕЕЕЕЕЕЕЕЕЕЕЕЕЕЕЕЕЕЕЕЕЕЕЕЕЕЕЕНННННННЬЬЬЬЬЬЬЬЬЬЬЬЬЬЬЬЬЬЬЬЬЬЬЬЬ МНООООООООООООООООООООООООООООООООООООООООООООООООООООООООООООООООООООООООООГГГГГГГГГГГГГГОООООООООООООООООООООООООО ТТТТТТТТТТЕКСТАААААААААААААААААА");

        //Note status selection
        WebElement select_status = driver.findElement(By.xpath("//select[@ng-model='status']"));
        select_status.click();
        WebElement note_select_status = driver.findElement(By.xpath("//option[@label='Требует выполнения']"));
        note_select_status.click();
        select_status.click();



        //Date selection

        //Time selection
        WebElement select_time = driver.findElement(By.xpath("//tl-control-time[@ng-model='dateTimeParams.time']"));
        select_time.click();
        WebElement select_time_hours = driver.findElement(By.xpath("//input[@ng-model='modelViewValue.string.hours']"));
        select_time_hours.clear();
        select_time_hours.sendKeys("20");
        WebElement select_time_minutes = driver.findElement(By.xpath("//input[@ng-model='modelViewValue.string.minutes']"));
        select_time_minutes.clear();
        select_time_minutes.sendKeys("00");
        WebElement select_time_apply = driver.findElement(By.xpath("//tl-button[@tl-click='saveDate()']"));
        select_time_apply.click();


//        //Month selection
//        WebElement month_selection = driver.findElement(By.xpath("//tl-control-date[@ng-model='dateTimeParams.date']"));
//        month_selection.click();
//        WebElement arrow_click = driver.findElement((By.xpath("//button[@ng-click='move(1)']")));
//        arrow_click.click();
//        WebElement day_selection = driver.findElement(By.xpath("//td[(@ng-repeat='dt in row track by dt.date') and (@id='datepicker-485-2097-29')]"));
//        day_selection.click();

        WebElement ready = driver.findElement(By.xpath("//tl-button[@tl-click='ctrl.onEdited()']"));
        ready.click();

    }
}


//By.XPath
//
//<div class='main'>
//     <p>text</p>
//     <p>Another text</p>
//</div>
//Поиск элемента:
//
//WebElement element = driver.findElement(By.xpath("//div[@class='main']"));
