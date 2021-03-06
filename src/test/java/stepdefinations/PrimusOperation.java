package stepdefinations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PrimusOperation {
	WebDriver driver;
	@When("^I open PrimusBank Url on Chrome$")
	public void i_open_PrimusBank_Url_on_Chrome() throws Throwable {
		System.setProperty("webdriver.chrome.driver","E:\\Selenium Materials and Setup\\SeleniumDrivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://www.primusbank.qedgetech.com/");
	}

	@When("^I enter UserName and Password in respected fields$")
	public void i_enter_UserName_and_Password_in_respected_fields() throws Throwable {
		driver.findElement(By.id("txtuId")).sendKeys("Admin");
		driver.findElement(By.id("txtPword")).sendKeys("Admin");
	}

	@When("^I click on Login Button$")
	public void i_click_on_Login_Button() throws Throwable {
		driver.findElement(By.id("login")).click();
	}
	@Then("^I should see adminflow text on CrrentUrl$")
	public void i_should_see_adminflow_text_on_CrrentUrl() throws Throwable {
		if(driver.getCurrentUrl().contains("adminflow"))
		{
			System.out.println("Login Successful");
		}
		else
		{
			System.out.println("Login failed");
		}
	}

	@When("^I click on Branch Link$")
	public void i_click_on_Branch_Link() throws Throwable {
		driver.findElement(By.xpath("//tr//tr//tr//tr//tr[2]//td[1]//a[1]//img[1]")).click();
	}

	@When("^I click on NewBranch Link$")
	public void i_click_on_NewBranch_Link() throws Throwable {
		driver.findElement(By.xpath("//input[@id='BtnNewBR']")).click();
	}

	@When("^I enter allfields as on New Branch Entry form$")
	public void i_enter_allfields_as_on_New_Branch_Entry_form() throws Throwable {
		driver.findElement(By.xpath("//input[@id='txtbName']")).sendKeys("Cucumber");
		driver.findElement(By.xpath("//input[@id='txtAdd1']")).sendKeys("Qedge");
		driver.findElement(By.xpath("//input[@id='Txtadd2']")).sendKeys("Ammerpet");
		driver.findElement(By.xpath("//input[@id='txtadd3']")).sendKeys("Hydarbad");
		driver.findElement(By.xpath("//input[@id='txtZip']")).sendKeys("45896");
		new Select(driver.findElement(By.xpath("//select[@id='lst_counrtyU']"))).selectByVisibleText("INDIA");;
		new Select(driver.findElement(By.xpath("//select[@id='lst_stateI']"))).selectByVisibleText("Delhi");
		new Select(driver.findElement(By.xpath("//select[@id='lst_cityI']"))).selectByVisibleText("Delhi");
	}

	@When("^I click on Submit Button$")
	public void i_click_on_Submit_Button() throws Throwable {
		driver.findElement(By.xpath("//input[@id='btn_insert']")).click();
	}

	@Then("^I should see created Sucessfully text on PopUp Window$")
	public void i_should_see_created_Sucessfully_text_on_PopUp_Window() throws Throwable {
		String msg2=driver.switchTo().alert().getText();		
	    if(msg2.contains("created Sucessfully"))
	    {
	    	System.out.println("Branch Creation Successful");
	    }
	    else
	    {
	    	System.out.println("Branch Creation Failed");
	    }	     
	}

	@When("^I click on OK Button$")
	public void i_click_on_OK_Button() throws Throwable {
		driver.switchTo().alert().accept();
	}

	@When("^I click on Edit Icon$")
	public void i_click_on_Edit_Icon() throws Throwable {
		driver.findElement(By.xpath("//tr//tr[2]//td[7]//a[1]//img[1]")).click();
	}

	@When("^I enter BranchName and Addressone in specific field$")
	public void i_enter_BranchName_and_Addressone_in_specific_field() throws Throwable {
		driver.findElement(By.xpath("//input[@id='txtbnameU']")).clear();
		driver.findElement(By.xpath("//input[@id='txtbnameU']")).sendKeys("CucumberBdd");
		driver.findElement(By.xpath("//input[@id='txtadd1u']")).clear();
		driver.findElement(By.xpath("//input[@id='txtadd1u']")).sendKeys("QedgeCorner");
	}

	@When("^I click on Update Button$")
	public void i_click_on_Update_Button() throws Throwable {
		driver.findElement(By.xpath("//input[@id='btnupdate']")).click();
	}

	@Then("^I should see Branch updated Sucessfully text on popUp Window$")
	public void i_should_see_Branch_updated_Sucessfully_text_on_popUp_Window() throws Throwable {
		String msg3=driver.switchTo().alert().getText();		
	    if(msg3.contains("Branch updated Sucessfully"))
	    {
	    	System.out.println("Branch Updation Successful");
	    }
	    else
	    {
	    	System.out.println("Branch Updation Failed");
	    }	
	    driver.switchTo().alert().accept();
	}

	@When("^I click on Delete Icon$")
	public void i_click_on_Delete_Icon() throws Throwable {
		driver.findElement(By.xpath("//tr//tr[2]//td[8]//a[1]//img[1]")).click();
	}

	@Then("^I should see delete this record text on popUp Window$")
	public void i_should_see_delete_this_record_text_on_popUp_Window() throws Throwable {
		String msg4= driver.switchTo().alert().getText();
		   driver.switchTo().alert().accept();
		   driver.switchTo().alert().accept();
		   if(msg4.contains("delete this record"))
		   {
			   System.out.println("Delete record conformation popup appear");
		   }
		   else
		   {
			   System.out.println("No conformation popup for delete record");
		   }			   
	}
	@When("^I click on Logout Button$")
	public void i_click_on_Logout_Button() throws Throwable {
		 driver.findElement(By.xpath("//td[3]//a[1]//img[1]")).click();
		   driver.close();
	}
}
