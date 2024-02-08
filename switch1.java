package Basicwebdriver;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class switch1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.tirabeauty.com/");
		//Identify Searchtf
		WebElement searchtf = driver.findElement(By.id("search"));
		//Enter perfumes in search tf
		searchtf.sendKeys("Perfumes");
		Thread.sleep(2000);
		//Clicking on enter button
		searchtf.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		//Clicking on perfume image
		driver.findElement(By.cssSelector("img[alt='Estee Lauder | Estee Lauder Pleasures Eau De Parfum Spray (30ml)']")).click();
		Thread.sleep(2000);
		
		//To know how many window are there
		Set<String> ids = driver.getWindowHandles();
		System.out.println(ids);
		
		//To transfer control from parent window to child window
		for(String a : ids) {
			String title = driver.switchTo().window(a).getTitle();
		System.out.println(title);
		
		String childtitle = "Estee Lauder Pleasures Eau De Parfum Spray (30ml)";
		if(title.contains(childtitle)) {
			
			break;
		}
		}
		//Clicking on Add to bag in child window
		driver.findElement(By.xpath("//span[text()='Add to Bag']")).click();
	
		Thread.sleep(2000);
		
		//To transfer control from child window to parent window
		for(String b : ids) {
			String titles = driver.switchTo().window(b).getTitle();
			System.out.println(titles);
			
			String parenttitle = "Tira: Shop Makeup, Skin, Hair & Beauty Products Online | www.tirabeauty.com";
			
			if(titles.contains(parenttitle)) {
				break;
			}
		}
		Thread.sleep(2000);
	
		//Click on brand-parent window
		driver.findElement(By.xpath("//span[text()='Brand']")).click();
		
		Thread.sleep(2000);
		
		//Clicking on Engage
		driver.findElement(By.xpath("//div[text()=' Engage ']")).click();
	
	
	
	
	}

}
