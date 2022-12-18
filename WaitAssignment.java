package week7.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitAssignment {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/waits.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//Wait for visibility(1-10 sec)
		WebElement visible = driver.findElement(By.xpath("(//span[text()='Click'])[1]"));
		
		visible.click();
		
		//Explicit wait
		//create obj for webdriverwait
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		//wait till the element 
		wait.until(ExpectedConditions.visibilityOf(visible));
		//verification
		String text = driver.findElement(By.xpath("//span[text()='I am here']")).getText();
        System.out.println(text);
        
        //Wait for Clickability
       WebElement clickable = driver.findElement(By.xpath("//span[text()='Click First Button']"));
        clickable.click();
    	WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(50));
    	wait1.until(ExpectedConditions.elementToBeClickable(clickable));
      	String text2 = driver.findElement(By.xpath("//span[text()='Click Second']")).getText();
    	 System.out.println(text2);
    	 
    	 //Wait for Invisibility (1 - 10 Sec)
    	driver.findElement(By.xpath("(//span[text()='Click'])[2]")).click();
    	WebElement invisible = driver.findElement(By.xpath("//span[text()='I am about to hide']"));
    	 WebDriverWait wait2=new WebDriverWait(driver,Duration.ofSeconds(10));
     	wait2.until(ExpectedConditions.invisibilityOf(invisible));
     	
        //Wait for Text Change (1 - 10 Sec)
     	 driver.findElement(By.xpath("(//span[text()='Click'])[3]")).click();
     	 
     	WebDriverWait wait3=new WebDriverWait(driver,Duration.ofSeconds(10));
     	WebElement didyouNotice = driver.findElement(By.xpath("//span[text()='Did you notice?']"));
     	wait3.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Did you notice?']")));
		String text3 = didyouNotice.getText();
		wait3.until(ExpectedConditions.textToBePresentInElement(didyouNotice, text3));


	}

}
