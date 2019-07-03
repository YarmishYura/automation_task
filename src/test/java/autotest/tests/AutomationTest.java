package autotest.tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class AutomationTest extends SetUpTest {
    //Verify if a user will be able to login with a valid username and valid password.
    @Test
    public void automationTestMain_1() {
        WebElement signIn = driver.findElement(By.className("maia-button"));
        signIn.click();
        WebElement email = driver.findElement(By.id("identifierId"));
        email.sendKeys("yarmish.yura1234567@gmail.com");
        wait.until(ExpectedConditions.elementToBeClickable(By.className("RveJvd")));
        driver.findElement(By.className("RveJvd")).click();
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("RUR%@QhLSbRn");
        wait.until(ExpectedConditions.elementToBeClickable(By.className("RveJvd")));
        driver.findElement(By.className("RveJvd")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.className("gb_xa")));
        driver.findElement(By.className("gb_xa")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='gb_gb']")));
        String gmailUser = driver.findElement(By.xpath("//div[@class='gb_gb']")).getText();
        Assert.assertEquals("yarmish.yura1234567@gmail.com", gmailUser);
    }
    //2	Verify if a user cannot login with a valid username and an invalid password.	Negative
    @Test
    public void automationTestMain_2() {
        WebElement signIn = driver.findElement(By.className("maia-button"));
        signIn.click();
        WebElement email = driver.findElement(By.id("identifierId"));
        email.sendKeys("yarmish.yura1234567@gmail.com");
        wait.until(ExpectedConditions.elementToBeClickable(By.className("RveJvd")));
        driver.findElement(By.className("RveJvd")).click();
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("Xw0zDO^4CSo8");
        wait.until(ExpectedConditions.elementToBeClickable(By.className("RveJvd")));
        driver.findElement(By.className("RveJvd")).click();
        WebElement hint = driver.findElement(By.xpath("(//span[contains(.,'Неправильний пароль. Повторіть спробу або натисніть \"Не пам’ятаю пароль\", щоб скинути його.')])[3]"));
        String message = hint.getText();
        Assert.assertEquals("Неправильний пароль. Повторіть спробу або натисніть \"Не пам’ятаю пароль\", щоб скинути його.", message);
    }
    //3 Verify the login page for login, when the field is blank and Submit button is clicked. Negative
    @Test
    public void automationTestMain_3(){
        WebElement signIn = driver.findElement(By.className("maia-button"));
        signIn.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.className("RveJvd")));
        driver.findElement(By.className("RveJvd")).click();
        WebElement hint = driver.findElement(By.className("GQ8Pzc"));
        String message = hint.getText();
        Assert.assertEquals("Введіть електронну адресу або номер телефону", message);
    }
    //Enter the valid email address & click next. Verify if the user gets an option to enter the password. Positive
    @Test
    public void automationTestMain_4() {
        WebElement signIn = driver.findElement(By.className("maia-button"));
        signIn.click();
        WebElement email = driver.findElement(By.id("identifierId"));
        email.sendKeys("yarmish.yura1234567@gmail.com");
        wait.until(ExpectedConditions.elementToBeClickable(By.className("RveJvd")));
        driver.findElement(By.className("RveJvd")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='RveJvd snByac'])[2]")));
        Assert.assertEquals("Забули пароль?", driver.findElement(By.xpath("(//span[@class='RveJvd snByac'])[2]")).getText());
    }

    //5	Verify the ‘Forgot Password’ functionality. Positive
    @Test
    public void automationTestMain_5() {
        WebElement signIn = driver.findElement(By.className("maia-button"));
        signIn.click();
        WebElement email = driver.findElement(By.id("identifierId"));
        email.sendKeys("yarmish.yura1234567@gmail.com");
        wait.until(ExpectedConditions.elementToBeClickable(By.className("RveJvd")));
        driver.findElement(By.className("RveJvd")).click();
        WebElement forgotPassword = driver.findElement(By.xpath("(//span[contains(.,'Забули пароль?')])[2]"));
        wait.until(ExpectedConditions.elementToBeClickable(forgotPassword));
        forgotPassword.click();
        WebElement header = driver.findElement(By.xpath("(//div[@class='ck6P8'])[2]"));
        wait.until(ExpectedConditions.elementToBeClickable(header));
        String message = header.getText();
        Assert.assertEquals("Введіть останній пароль для входу в обліковий запис Google", message);
    }

    //6	Verify the messages for invalid login.	Positive
    @Test
    public void automationTestMain_6() {
        WebElement signIn = driver.findElement(By.className("maia-button"));
        signIn.click();
        WebElement email = driver.findElement(By.id("identifierId"));
        email.sendKeys("yarmish.yura123456@gmail.com");
        wait.until(ExpectedConditions.elementToBeClickable(By.className("RveJvd")));
        driver.findElement(By.className("RveJvd")).click();
        WebElement hint = driver.findElement(By.className("GQ8Pzc"));
        wait.until(ExpectedConditions.elementToBeClickable(hint));
        String message = hint.getText();
        Assert.assertEquals("Не вдалося знайти ваш обліковий запис Google", message);
    }
    //7	Verify the ‘Forgot Email’ functionality. Positive
    @Test
    public void automationTestMain_7() {
        WebElement signIn = driver.findElement(By.className("maia-button"));
        signIn.click();
        WebElement rememberMe = driver.findElement(By.xpath("//button[contains(.,'Забули електронну адресу?')]"));
        wait.until(ExpectedConditions.elementToBeClickable(rememberMe));
        rememberMe.click();
        WebElement header = driver.findElement(By.xpath("//span[contains(.,'Знайдіть свою електронну адресу')]"));
        wait.until(ExpectedConditions.elementToBeClickable(header));
        String message = header.getText();
        Assert.assertEquals("Знайдіть свою електронну адресу", message);
    }
    //8	Verify if a user can log in with a valid phone number and password. Positive
    @Test
    public void automationTestMain_8() {
        WebElement signIn = driver.findElement(By.className("maia-button"));
        signIn.click();
        WebElement email = driver.findElement(By.id("identifierId"));
        email.sendKeys("0662747699");
        wait.until(ExpectedConditions.elementToBeClickable(By.className("RveJvd")));
        driver.findElement(By.className("RveJvd")).click();
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("RUR%@QhLSbRn");
        wait.until(ExpectedConditions.elementToBeClickable(By.className("RveJvd")));
        driver.findElement(By.className("RveJvd")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.className("gb_xa")));
        driver.findElement(By.className("gb_xa")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='gb_gb']")));
        String gmailUser = driver.findElement(By.xpath("//div[@class='gb_gb']")).getText();
        Assert.assertEquals("yarmish.yura1234567@gmail.com", gmailUser);
    }
    //9	Verify if a user cannot log in with a valid phone number and an invalid password.
    @Test
    public void automationTestMain_9(){
        WebElement signIn = driver.findElement(By.className("maia-button"));
        signIn.click();
        WebElement email = driver.findElement(By.id("identifierId"));
        email.sendKeys("0662747699");
        wait.until(ExpectedConditions.elementToBeClickable(By.className("RveJvd")));
        driver.findElement(By.className("RveJvd")).click();
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("Xw0zDO^4CSo8");
        wait.until(ExpectedConditions.elementToBeClickable(By.className("RveJvd")));
        driver.findElement(By.className("RveJvd")).click();
        WebElement hint = driver.findElement(By.xpath("(//span[contains(.,'Неправильний пароль. Повторіть спробу або натисніть \"Не пам’ятаю пароль\", щоб скинути його.')])[3]"));
        String message = hint.getText();
        Assert.assertEquals("Неправильний пароль. Повторіть спробу або натисніть \"Не пам’ятаю пароль\", щоб скинути його.", message);
    }
    //10 Enter an invalid phone number & click the Next button. Verify if the user will get the correct message. Negative
    @Test
    public void automationTestMain_10(){
        WebElement signIn = driver.findElement(By.className("maia-button"));
        signIn.click();
        WebElement email = driver.findElement(By.id("identifierId"));
        email.sendKeys("0662747688");
        wait.until(ExpectedConditions.elementToBeClickable(By.className("RveJvd")));
        driver.findElement(By.className("RveJvd")).click();
        WebElement hint = driver.findElement(By.xpath("//div[@class='GQ8Pzc']"));
        String message = hint.getText();
        Assert.assertEquals("Не вдалося знайти ваш обліковий запис Google. Спробуйте натомість указати свою електронну адресу.", message);
    }
}