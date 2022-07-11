import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "E:\\Test_Notes\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();


        driver.get("https://www.youtube.com/");

        WebElement search = driver.findElement(By.cssSelector("input[class='gsfi ytd-searchbox']"));
        search.clear();
        search.sendKeys("TravelLine");

        WebElement press_search = driver.findElement(By.id("search-icon-legacy"));
        press_search.click();

    }
}

