import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Movie_details_From_Different_websites {

   @Test
    public void GetIMDB_details() throws InterruptedException
     {
        System.setProperty("webdriver.chrome.driver", "C:/driver/chromedriver.exe/");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.imdb.com/");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Pushpa the rise");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[contains(text(),\"Pushpa: The Rise - Part 1\")]")).click();
        Thread.sleep(5000);
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,6000)");
        Thread.sleep(5000);
        String Release_date_IMDB=driver.findElement(By.xpath("//a[contains(text(),'December 17, 2021 (United States)')]")).getText();
        System.out.println("**************************");
        System.out.println("Release_date"+"-->"+Release_date_IMDB);
        String Country_of_origin_IMDB=driver.findElement(By.xpath("//a[contains(text(),'India')][1]")).getText();
        System.out.println("Country_of_origin"+"-->"+Country_of_origin_IMDB);
        System.out.println("**************************");

    }
   @Test
   public void GetWikipedia_details() throws InterruptedException
   {
      System.setProperty("webdriver.chrome.driver", "C:/driver/chromedriver.exe/");
      WebDriver driver = new ChromeDriver();
      driver.get("https://en.wikipedia.org/wiki/Main_Page");
      driver.manage().window().maximize();
      WebElement Wb= driver.findElement(By.xpath("//input[@class='vector-search-box-input']"));
      Wb.sendKeys("Pushpa the rise");
      Thread.sleep(5000);
      Wb.sendKeys(Keys.ARROW_DOWN);
      Wb.sendKeys(Keys.ENTER);
      String Release_date_Wikipedia=driver.findElement(By.xpath("/html/body/div[3]/div[3]/div[5]/div[1]/table[1]/tbody/tr[12]/td/div/ul/li")).getText();
      System.out.println("**************************");
      System.out.println("Release_date"+"-->"+Release_date_Wikipedia);
      String Country_of_origin_Wikipedia=driver.findElement(By.xpath("//td[contains(text(),\"India\")]")).getText();
      System.out.println("Country_of_origin"+"-->"+Country_of_origin_Wikipedia);
      System.out.println("****************************");


   }

   @Test
   public void Verify_Movie_details() throws InterruptedException
   {
      Assert.assertEquals("Release_date_IMDB","Release_date_Wikipedia");
      Assert.assertEquals("Country_of_origin_IMDB","Country_of_origin_Wikipedia");

   }
}



