import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

/*
Testirati rad kalkulatora https://testsheepnz.github.io/BasicCalculator.html. Testirati rad svih
operacija posebno.
Za njega napisati edge case-eve na koje naletite, ili ispunite neka matematicka pravila (deljenje sa nulom,
jedinicom, veliki/mali brojevi itd). Napisati minimum 4 edge case-a po testnoj metodi, 16 ukupno (minimum),
zanemarujuci Concatenate.
 */
public class CalculatorTest {

    private WebDriver driver;

    @BeforeClass
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "D:\\bootcamp\\browserDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterClass
    public void afterClass(){
        driver.quit();
    }

    @BeforeMethod
    public void beforeMethod(){
        driver.get("https://testsheepnz.github.io/BasicCalculator.html");
        driver.manage().deleteAllCookies();
    }
    @Test
    public void addTest(){
        String expectedResult = "7";
        WebElement firstNumber = driver.findElement(By.id("number1Field"));
        firstNumber.sendKeys("5");
        WebElement secondNumber = driver.findElement(By.id("number2Field"));
        secondNumber.sendKeys("2");
        WebElement operation = driver.findElement(By.id("selectOperationDropdown"));
        Select select = new Select(operation);
        select.selectByVisibleText("Add");
        WebElement calculate = driver.findElement(By.id("calculateButton"));
        calculate.click();
        WebElement answer = driver.findElement(By.id("numberAnswerField"));
        String actualResult = answer.getAttribute("value");
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void addNegativePositiveTest(){
        String expectedResult = "-1";
        WebElement firstNumber = driver.findElement(By.id("number1Field"));
        firstNumber.sendKeys("-2");
        WebElement secondNumber = driver.findElement(By.id("number2Field"));
        secondNumber.sendKeys("1");
        WebElement operation = driver.findElement(By.id("selectOperationDropdown"));
        Select select = new Select(operation);
        select.selectByVisibleText("Add");
        WebElement calculate = driver.findElement(By.id("calculateButton"));
        calculate.click();
        WebElement answer = driver.findElement(By.id("numberAnswerField"));
        String actualResult = answer.getAttribute("value");
        Assert.assertEquals(expectedResult, actualResult);
    }
    @Test
    public void addNegativeNegativeTest(){
        String expectedResult = "-8";
        WebElement firstNumber = driver.findElement(By.id("number1Field"));
        firstNumber.sendKeys("-4");
        WebElement secondNumber = driver.findElement(By.id("number2Field"));
        secondNumber.sendKeys("-4");
        WebElement operation = driver.findElement(By.id("selectOperationDropdown"));
        Select select = new Select(operation);
        select.selectByVisibleText("Add");
        WebElement calculate = driver.findElement(By.id("calculateButton"));
        calculate.click();
        WebElement answer = driver.findElement(By.id("numberAnswerField"));
        String actualResult = answer.getAttribute("value");
        Assert.assertEquals(expectedResult, actualResult);
    }
    @Test
    public void addZeroNegativeTest(){
        String expectedResult = "-1";
        WebElement firstNumber = driver.findElement(By.id("number1Field"));
        firstNumber.sendKeys("0");
        WebElement secondNumber = driver.findElement(By.id("number2Field"));
        secondNumber.sendKeys("-1");
        WebElement operation = driver.findElement(By.id("selectOperationDropdown"));
        Select select = new Select(operation);
        select.selectByVisibleText("Add");
        WebElement calculate = driver.findElement(By.id("calculateButton"));
        calculate.click();
        WebElement answer = driver.findElement(By.id("numberAnswerField"));
        String actualResult = answer.getAttribute("value");
        Assert.assertEquals(expectedResult, actualResult);

    }
    @Test
    public void addZeroPositiveTest(){
        String expectedResult = "1";
        WebElement firstNumber = driver.findElement(By.id("number1Field"));
        firstNumber.sendKeys("0");
        WebElement secondNumber = driver.findElement(By.id("number2Field"));
        secondNumber.sendKeys("1");
        WebElement operation = driver.findElement(By.id("selectOperationDropdown"));
        Select select = new Select(operation);
        select.selectByVisibleText("Add");
        WebElement calculate = driver.findElement(By.id("calculateButton"));
        calculate.click();
        WebElement answer = driver.findElement(By.id("numberAnswerField"));
        String actualResult = answer.getAttribute("value");
        Assert.assertEquals(expectedResult, actualResult);
    }
    @Test
    public void addMaxNumber(){

        String expectedResult = "19999999998";
        WebElement firstNumber = driver.findElement(By.id("number1Field"));
        firstNumber.sendKeys("9999999999");
        WebElement secondNumber = driver.findElement(By.id("number2Field"));
        secondNumber.sendKeys("9999999999");
        WebElement operation = driver.findElement(By.id("selectOperationDropdown"));
        Select select = new Select(operation);
        select.selectByVisibleText("Add");
        WebElement calculate = driver.findElement(By.id("calculateButton"));
        calculate.click();
        WebElement answer = driver.findElement(By.id("numberAnswerField"));
        String actualResult = answer.getAttribute("value");
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void addMinNumber(){
        String expectedResult = "-1999999998";
        WebElement firstNumber = driver.findElement(By.id("number1Field"));
        firstNumber.sendKeys("-999999999");
        WebElement secondNumber = driver.findElement(By.id("number2Field"));
        secondNumber.sendKeys("-999999999");
        WebElement operation = driver.findElement(By.id("selectOperationDropdown"));
        Select select = new Select(operation);
        select.selectByVisibleText("Add");
        WebElement calculate = driver.findElement(By.id("calculateButton"));
        calculate.click();
        WebElement answer = driver.findElement(By.id("numberAnswerField"));
        String actualResult = answer.getAttribute("value");
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void subtract(){
        String expectedResult = "2";
        WebElement firstNumber = driver.findElement(By.id("number1Field"));
        firstNumber.sendKeys("4");
        WebElement secondNumber = driver.findElement(By.id("number2Field"));
        secondNumber.sendKeys("2");
        WebElement operation = driver.findElement(By.id("selectOperationDropdown"));
        Select select = new Select(operation);
        select.selectByVisibleText("Subtract");
        WebElement calculate = driver.findElement(By.id("calculateButton"));
        calculate.click();
        WebElement answer = driver.findElement(By.id("numberAnswerField"));
        String actualResult = answer.getAttribute("value");
        Assert.assertEquals(expectedResult, actualResult);
    }
    @Test
    public void subtractPositiveNegative(){
        String expectedResult = "6";
        WebElement firstNumber = driver.findElement(By.id("number1Field"));
        firstNumber.sendKeys("4");
        WebElement secondNumber = driver.findElement(By.id("number2Field"));
        secondNumber.sendKeys("-2");
        WebElement operation = driver.findElement(By.id("selectOperationDropdown"));
        Select select = new Select(operation);
        select.selectByVisibleText("Subtract");
        WebElement calculate = driver.findElement(By.id("calculateButton"));
        calculate.click();
        WebElement answer = driver.findElement(By.id("numberAnswerField"));
        String actualResult = answer.getAttribute("value");
        Assert.assertEquals(expectedResult, actualResult);
    }
     @Test
    public void substractNegativeNegativeTest(){
         String expectedResult = "0";
         WebElement firstNumber = driver.findElement(By.id("number1Field"));
         firstNumber.sendKeys("-2");
         WebElement secondNumber = driver.findElement(By.id("number2Field"));
         secondNumber.sendKeys("-2");
         WebElement operation = driver.findElement(By.id("selectOperationDropdown"));
         Select select = new Select(operation);
         select.selectByVisibleText("Subtract");
         WebElement calculate = driver.findElement(By.id("calculateButton"));
         calculate.click();
         WebElement answer = driver.findElement(By.id("numberAnswerField"));
         String actualResult = answer.getAttribute("value");
         Assert.assertEquals(expectedResult, actualResult);
     }
     @Test
    public void subtractMaxnegativeMaxNegativeTest(){
         String expectedResult = "0";
         WebElement firstNumber = driver.findElement(By.id("number1Field"));
         firstNumber.sendKeys("-999999999");
         WebElement secondNumber = driver.findElement(By.id("number2Field"));
         secondNumber.sendKeys("-999999999");
         WebElement operation = driver.findElement(By.id("selectOperationDropdown"));
         Select select = new Select(operation);
         select.selectByVisibleText("Subtract");
         WebElement calculate = driver.findElement(By.id("calculateButton"));
         calculate.click();
         WebElement answer = driver.findElement(By.id("numberAnswerField"));
         String actualResult = answer.getAttribute("value");
         Assert.assertEquals(expectedResult, actualResult);
     }

     @Test
    public void subtractMaxnegativeMaxpositiveTest(){
         String expectedResult = "-10999999998";
         WebElement firstNumber = driver.findElement(By.id("number1Field"));
         firstNumber.sendKeys("-999999999");
         WebElement secondNumber = driver.findElement(By.id("number2Field"));
         secondNumber.sendKeys("9999999999");
         WebElement operation = driver.findElement(By.id("selectOperationDropdown"));
         Select select = new Select(operation);
         select.selectByVisibleText("Subtract");
         WebElement calculate = driver.findElement(By.id("calculateButton"));
         calculate.click();
         WebElement answer = driver.findElement(By.id("numberAnswerField"));
         String actualResult = answer.getAttribute("value");
         Assert.assertEquals(expectedResult, actualResult);
     }

}
