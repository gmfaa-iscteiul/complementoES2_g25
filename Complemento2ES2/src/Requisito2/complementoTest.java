package Requisito2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class complementoTest {

	public static WebDriver driver;
	public static WebDriver driverRecord;
	public static int num1;
	public static int num2;
	public static int num3;
	public static int num4;
	public static int num5;

	//	@BeforeAll
	//	public static void setUpBeforeClass() throws Exception {
	//
	//		//com import do jupiter isto funciona
	//
	//		// location of drivers
	//		//		System.setProperty("webdriver.chrome.driver", "C:/iscte/chromedriver.exe");
	//		System.setProperty("webdriver.gecko.driver", "C:/iscte/geckodriver.exe");
	//		//		 create a new instance of the driver
	//		//		driver = new ChromeDriver();
	//		driver = new FirefoxDriver();
	//	}
	//
	//	@AfterAll
	//	public static void tearDownAfterClass() throws Exception {
	//		//				driver.close();   // close the tab it has opened
	//		//				driver.quit();    // close the browser
	//	}


	@Test
	public void test() throws InterruptedException, IOException {

		try {

			System.setProperty("webdriver.gecko.driver", "C:/iscte/geckodriver.exe");
			driver = new FirefoxDriver();
			driverRecord = new FirefoxDriver();

		} catch (Exception e) {

			System.setProperty("webdriver.chrome.driver", "C:/iscte/chromedriver.exe");
			driver = new ChromeDriver();
			driverRecord = new ChromeDriver();

		}

		System.out.println("Abrir ficheiro");
		File f = new File("C:/iscte/record.html");
		if(! (f.exists() && !f.isDirectory()) ) { 
			BufferedWriter bw = new BufferedWriter(new FileWriter("C:/iscte/record.html"));
			bw.write("<html><head><title>Record Analytics</title></head><body>" + 
					"<p><label name=\"qq1\">Página funciona e foi acedida: </label><label name=\"num1\"> 0 </label> </p>" + 
					"<p><label name=\"qq2\">Login funciona e foi efetuado: </label><label name=\"num2\"> 0 </label> </p>" + 
					"<p><label name=\"qq3\">Repositórios verificados: </label><label name=\"num3\"> 0 </label> </p>" + 
					"<p><label name=\"qq4\">Contactos verificados: </label><label name=\"num4\"> 0 </label> </p>" + 
					"<p><label name=\"qq5\">Ocorreu falha no site: </label><label name=\"num5\"> 0 </label> </p>" +
					"</body></html>");
			bw.close();			
		}

		try {

			driverRecord.get("file:///C:/iscte/record.html");
			num1 = Integer.parseInt(driverRecord.findElement(By.name("num1")).getText());
			num2 = Integer.parseInt(driverRecord.findElement(By.name("num2")).getText());
			num3 = Integer.parseInt(driverRecord.findElement(By.name("num3")).getText());
			num4 = Integer.parseInt(driverRecord.findElement(By.name("num4")).getText());
			num5 = Integer.parseInt(driverRecord.findElement(By.name("num5")).getText());


			driver.get("https://www.google.pt");
			Thread.sleep(1000);

			//entra no website
			driver.get("http://192.168.99.100:8000/");
			num1++;
			System.out.println(num1);
			Thread.sleep(1000);

			//troca de página
			WebElement element = driver.findElement(By.linkText("Sample Page"));
			element.click();
			Thread.sleep(1000);

			//Contactos e emails disponiveis
			element = driver.findElement(By.name("contactus"));
			if(element != null) 
				System.out.println("Tem serviço 'Contact Us'");
			num4++;
			System.out.println(num4);
			Thread.sleep(1000);

			//repositórios disponiveis
			element = driver.findElement(By.linkText("June 2020"));
			if(element != null) 
				System.out.println("Tem serviço 'Archive'");
			num3++;
			System.out.println(num3);
			Thread.sleep(1000);

			element = driver.findElement(By.linkText("complemento"));
			element.click();
			Thread.sleep(1000);

			//			element = driver.findElement(By.linkText("Log in"));
			//			element.click();

			driver.get("http://192.168.99.100:8000/wp-login.php");
			Thread.sleep(1000);
			element = driver.findElement(By.id("user_login"));
			element.sendKeys("gmfapt");
			Thread.sleep(1000);
			element = driver.findElement(By.id("user_pass"));
			element.sendKeys("senhag250");

			num2++;
			System.out.println(num2);
			Thread.sleep(1000);

			element.submit();
			Thread.sleep(1000);

			//html

		} catch (Exception e) {
			// gerar email

			String username = "decimo.segundo2e@gmail.com";
			String password = "economia2e";
			String fromEmail = "decimo.segundo2e@gmail.com";
			String toEmail = "goncalomiguelalmeida@gmail.com";

			Properties properties = new Properties();
			properties.put("mail.smtp.auth", "true");
			properties.put("mail.smtp.starttls.enable", "true");
			properties.put("mail.smtp.host", "smtp.gmail.com");
			properties.put("mail.smtp.port", "587");

			Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			});


			MimeMessage msg = new MimeMessage(session);

			try {
				
				Transport transport = session.getTransport("smtp");
				transport.connect("smtp.gmail.com", username, password);

				msg.setFrom(new InternetAddress(fromEmail));
				msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
				msg.setSubject("Wordpress Error");
				msg.setText("The Log in to the WordPress had failured");
				transport.sendMessage(msg, msg.getAllRecipients());
			} catch (AddressException e1) {
				e1.printStackTrace();
			} catch (MessagingException e1) {
				e1.printStackTrace();
			}

			System.out.println("Email sent");
			//html
			num5++;

		} finally {
			// check the title of the page
			System.out.println("Page title is: " + driver.getTitle());

			BufferedWriter bw2;
			bw2 = new BufferedWriter(new FileWriter("C:/iscte/record.html"));
			bw2.write("<html><head><title>Record Analytics</title></head><body>" + 
					"<p><label name=\"qq1\">Página funciona e foi acedida: </label><label name=\"num1\"> " + num1 + " </label> </p>" + 
					"<p><label name=\"qq2\">Login funciona e foi efetuado: </label><label name=\"num2\"> " + num2 + " </label> </p>" + 
					"<p><label name=\"qq3\">Repositórios verificados: </label><label name=\"num3\"> " + num3 + " </label> </p>" + 
					"<p><label name=\"qq4\">Contactos verificados: </label><label name=\"num4\"> " + num4 + " </label> </p>" + 
					"<p><label name=\"qq5\">Ocorreu falha no site: </label><label name=\"num5\"> " + num5 + " </label> </p>" +
					"<p><label name=\"time\">Última verificação: </label><label name=\"num6\"> " + LocalDateTime.now() +" </label> </p>" +
					"</body></html>");
			bw2.close();	


			Thread.sleep(5000);
			driver.close();   // close the tab it has opened
			driverRecord.close();   // close the tab it has opened
			//		driver.quit();    // close the browser
		}


	}
}