package org.swim;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TermClass extends BaseClas {
	
		public static void main(String[] args) throws InterruptedException {
			BrowserLaunch("Chrome");
			getsURL("https://www.saucedemo.com/");	
		
			
			WebElement username = driver.findElement(By.xpath("(//input[@class='input_error form_input'])[1]"));
			username.sendKeys(setvalue(0, 0));
			
			WebElement password = driver.findElement(By.id("password"));
			password.sendKeys(setvalue(0, 1));
			
			WebElement loginbutton = driver.findElement(By.xpath("//input[@type=\"submit\"]"));
			loginbutton.click();
			
			WebElement Backbag = driver.findElement(By.xpath("(//div[@class=\"inventory_item_name\"])[1]"));
			Backbag.click();
			
			Thread.sleep(1000);
			
			WebElement addtocart = driver.findElement(By.xpath("//button[@data-test='add-to-cart-sauce-labs-backpack']"));
			addtocart.click();
			
		WebElement addtocartbutton = driver.findElement(By.xpath("//span[@class=\"shopping_cart_badge\"]"));
		addtocartbutton.click();
			
			WebElement checkout = driver.findElement(By.xpath("//button[@class='btn btn_action btn_medium checkout_button']"));
			checkout.click();
			
			WebElement firstname = driver.findElement(By.xpath("(//input[@class=\"input_error form_input\"])[1]"));
            firstname.sendKeys(setvalue(0, 2));
            
    		WebElement lastname = driver.findElement(By.id("last-name"));
    		lastname.sendKeys(setvalue(0, 3));
    		
    		driver.findElement(By.id("postal-code")).sendKeys(setvalue(0, 4));
    		
    		Thread.sleep(1000);
    		
    		WebElement submit = driver.findElement(By.xpath("//input[@type=\"submit\"]"));
    		submit.click();
    		
    		WebElement finish = driver.findElement(By.id("finish"));
    		finish.click();
    		
    		Thread.sleep(2000);
    		

    		
    		driver.findElement(By.id("back-to-products")).click();
    		
    		
    		

    		
    		

            
            
			


					
			
		}
		
		
		
		
	

}


