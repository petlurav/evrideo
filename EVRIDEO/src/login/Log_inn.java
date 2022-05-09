package login;

import java.awt.image.BufferedImage;

import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.jboss.aerogear.security.otp.Totp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

public class Log_inn {
	
	public static void main(String[] args) throws NotFoundException, IOException, InterruptedException {
	    System.setProperty("webdriver.chrome.driver","C:\\JAR\\chromeNew\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();	
		String	 baseUrl = "http://ovh-stg2.evrideo.com/login/";	
	    driver.get(baseUrl);;
        driver.manage().window().maximize();
        
      
      // INSERT USER NAME
    driver.findElement(By.cssSelector("#username")).sendKeys("petlurav@yahoo.com");
   //INSERT PASSWORD
    driver.findElement(By.cssSelector("#password")).sendKeys("!23Qweasd");
   //CLICK ON LOGIN BUTTON

   driver.findElement(By.cssSelector("body > my-app > div > div > section > ichannel-login-form > form > div.step-1 > div.footer > button")).click();
   //QR-CODE IDENTIFY ELEMENT
   // String src = driver.findElement(By.cssSelector("body > my-app > div > div > section > ichannel-login-form > form > div.step-2")).getAttribute("src");
   //PRINT QR URL
   // System.out.println("image url is : "+src); 
   //CONVERT THE URL TO THE IMAGE METHODE
   // URL urlOfImage = new URL(src);
   /// BufferedImage bufferedImage = ImageIO.read(urlOfImage);
    //EXTRACTED IMAGE TO PARTICULAR LINK
   // LuminanceSource source = new BufferedImageLuminanceSource(bufferedImage);
    //EXTRACTED RESULT  AND DECODE THE IMAGE
    //BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));    
   // Result result =new MultiFormatReader().decode(bitmap);
	// RESULT PRINT
    //System.out.println(result.getText());
	//Thread.sleep(3000);
	// CLICK BACK TO THE LOGIN MENU
//	driver.findElement(By.xpath("/html/body/my-app/div/div/section/ichannel-login-form/form/div[2]/footer/a")).click();
	
	String otpKeyStr = "MMYDKYLGHE3TMLLDMFRWKLLFMMYTCLJZGBTDELJSGQ2GEZTFMI4DCMLFMU"; 
	Totp totp = new Totp(otpKeyStr);
	String twoFactorCode = totp.now(); 
	

	Thread.sleep(3000);
	//INSERT TOKEN VALUE
	driver.findElement(By.cssSelector("#token")).sendKeys(twoFactorCode);
	//CLICK  ON LOGIN BUTTON
	driver.findElement(By.cssSelector("body > my-app > div > div > section > ichannel-login-form > form > div.step-1 > div.footer > button")).click();
	}	
	



	

	

	

}