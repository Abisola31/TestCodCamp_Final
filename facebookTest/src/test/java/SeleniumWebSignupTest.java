import com.google.common.annotations.VisibleForTesting;
import net.bytebuddy.build.Plugin;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class SeleniumWebSignupTest {
    // import Selenium WebDriver
    private WebDriver driver;

    @BeforeTest
    public void start() throws InterruptedException {

        //locate where the driver is
        System.setProperty("webdriver.chrome.driver", "Resources/chromedriver.exe");

        //1. Open your chrome browser
        driver = new ChromeDriver();
        //2. Input your selenium Demo Page (https://selenium-blog.herokuapp.com)
        driver.get("https://selenium-blog.herokuapp.com");

        //Test 1. Verify User input Url and  is on the right page
        if(driver.getCurrentUrl().contains ("https://selenium-blog.herokuapp.com"))
            //Pass
            System.out.println("Correct Webpage");
        else
            //Fail
            System.out.println("Wrong Webpage");

        //Wait Globally for full loading
        Thread.sleep(5000);
        //3. Maximize your browser
        driver.manage().window().maximize();
        //4. Click on Sign up button to open Sign up page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);
    }


    @Test (priority = 0)
    public void Positivesignup() throws InterruptedException {
        //Test 7. Verify that User sign up with valid details
        //5. Input Username in Username field
        driver.findElement(By.id("user_username")).sendKeys("Bisbee31");
        //6. Input Email in Email field
        driver.findElement(By.id("user_email")).sendKeys("Bisbee31@mailinator.com");
        //7. Locate the Password field and input your password
        driver.findElement(By.id("user_password")).sendKeys("Admin31");
        //8. Click on the Signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
    }
        @Test (priority = 1)
    public void clickUserItem1() throws InterruptedException {
            //9. Click on User1 item on the listpage
            driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/div/div/li[1]/a")).click();
            //Test 2.  Verify that when User clicks on  sign up button,user is directed to sign up page
            String expectedUrl = "https://selenium-blog.herokuapp.com";
            String actualUrl = driver.getCurrentUrl();
            if (actualUrl.contains(expectedUrl))
                //Pass
                System.out.println("Correct Webpage");
            else
                //Fail
                System.out.println("Wrong Webpage");
            Thread.sleep(5000);
        }

        @Test (priority = 2)
                public void verifyItem() throws InterruptedException {
            //Test 9. Search for an item (Using python with Selenium) and confirm that it is present
            //10. Search for an item (using python with selenium) and confirm it is present
            driver.findElement(By.xpath("/html/body/div[2]/div[35]/div/div/div[1]/a")).click();
            String expectedPageUrl = "https://selenium-blog.herokuapp.com/users/1";
            String actualPageUrl = driver.getTitle();
            if (actualPageUrl.contains(expectedPageUrl))
                //Pass
                System.out.println("Correct User1Page");
            else
                //Fail
                System.out.println("Wrong User1Page");

            Thread.sleep(5000);
        }

            @Test (priority = 3)
                    public void logoutsuccessfully() throws InterruptedException {

                //Test 10. Verify that when user logout,user is directed to the home page
                //11. Click on logout
                driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a")).click();
                String expectedTitle = "AlphaBlog";
                String actualTitle = driver.getTitle();
                if (actualTitle.contains(expectedTitle))
                    //Pass
                    System.out.println("Correct Title");
                else
                    //Fail
                    System.out.println("Wrong Title");
                Thread.sleep(5000);
            }
            @Test (priority = 4)
                public void Negativesignup() throws InterruptedException {
                    //Test 3. Verify  that user cannot signup with Username less than 3 characters
                //4. Click on Sign up button to open Sign up page
                driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
                Thread.sleep(5000);
                    //5. Input Username in Username field
                    driver.findElement(By.id("user_username")).sendKeys("Ti");
                    //6. Input Email in Email field
                    driver.findElement(By.id("user_email")).sendKeys("Tife31@mailinator.com");
                    //7. Locate the Password field and input your password
                    driver.findElement(By.id("user_password")).sendKeys("Admin31");
                    //8. Click on the Signup button
                    driver.findElement(By.id("submit")).click();
                    Thread.sleep(5000);
                // Clear data
                driver.findElement(By.id("user_username")).clear();
                driver.findElement(By.id("user_email")).clear();
                driver.findElement(By.id("user_password")).clear();
                Thread.sleep(5000);

                }

    @Test (priority = 5)
    public void InvalidEmail() throws InterruptedException {
        //Test 4. Verify  that user cannot signup with invalid email address
        //5. Input Username in Username field
        driver.findElement(By.id("user_username")).sendKeys("Tife");
        //6. Input Email in Email field
        driver.findElement(By.id("user_email")).sendKeys("Tife31ail.");
        //7. Locate the Password field and input your password
        driver.findElement(By.id("user_password")).sendKeys("Admin31");
        //8. Click on the Signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
        // Clear data
        driver.findElement(By.id("user_username")).clear();
        driver.findElement(By.id("user_email")).clear();
        driver.findElement(By.id("user_password")).clear();
        Thread.sleep(5000);

    }

    @Test (priority = 6)
    public void InvalidPassword() throws InterruptedException {
        //Test 5. Verify  that user cannot signup with equals or less than 1 character Password
        //5. Input Username in Username field
        driver.findElement(By.id("user_username")).sendKeys("Tife");
        //6. Input Email in Email field
        driver.findElement(By.id("user_email")).sendKeys("Tife31@mail.com");
        //7. Locate the Password field and input your password
        driver.findElement(By.id("user_password")).sendKeys("1");
        //8. Click on the Signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
        // Clear data
        driver.findElement(By.id("user_username")).clear();
        driver.findElement(By.id("user_email")).clear();
        driver.findElement(By.id("user_password")).clear();
        Thread.sleep(5000);

    }

    @Test (priority = 7)
    public void Blankfield() throws InterruptedException {
        //Test 6. Verify  that user cannot signup with Blankfields
        //5. Input Username in Username field
        driver.findElement(By.id("user_username")).sendKeys("");
        //6. Input Email in Email field
        driver.findElement(By.id("user_email")).sendKeys("Tife@mailinator.com");
        //7. Locate the Password field and input your password
        driver.findElement(By.id("user_password")).sendKeys("1");
        //8. Click on the Signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
    }
    @AfterTest
            public void closeBrowser(){
        //Quit the browser
        driver.quit();
    };

    }




