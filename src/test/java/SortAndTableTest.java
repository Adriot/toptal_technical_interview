import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class SortAndTableTest {
    @Test
    public void sortAndTables() {
        try {
            WebDriverManager.chromedriver().setup();
            ChromeDriver driver = new ChromeDriver();
            driver.get("http://website.multiformis.com/");
            Thread.sleep(3000);

            driver.manage().window().maximize();

            WebElement popup = driver.findElement(By.xpath("//*[@id=\"popmake-57\"]/button"));
            popup.click();

            WebElement sortAndTable = driver.findElement(By.xpath("//*[@id=\"menu-item-40\"]/a"));
            sortAndTable.click();
            Thread.sleep(1000);

            WebElement view = driver.findElement(By.xpath("//*[@id=\"tablepress-2_length\"]/label/select"));
            view.click();
            Thread.sleep(1000);

            WebElement view100 = driver.findElement(By.xpath("//*[@id=\"tablepress-2_length\"]/label/select/option[4]"));
            view100.click();
            Thread.sleep(1000);

            List<WebElement> tableData = driver.findElements(By.xpath("//*[@id=\"tablepress-2\"]/tbody/tr"));
            assertEquals(tableData.size(), 25);

            WebElement ageSort = driver.findElement(By.xpath("//*[@id=\"tablepress-2\"]/thead/tr/th[8]"));
            ageSort.click();
            Thread.sleep(2000);

            WebElement firstAge = driver.findElement(By.xpath("//*[@id=\"tablepress-2\"]/tbody/tr[1]/td[8]"));
            String ageValue = firstAge.getText();
            Assert.assertTrue(Integer.parseInt(ageValue) == 65);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
