import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AddWorkShiftTest implements AddWorkShift {
    private static AddWorkShift startInstance;

    private static final String loginUsername = "Admin";
    private static final String loginPassword = "admin123";

    private static final String shiftName = "Work Shift Name";
    private static final String fromTime = "06:00 AM";
    private static final String toTime = "06:00 PM";
    private static final String assignedEmployeeName = "Odis Adalwin";

    private final WebDriver driver = new ChromeDriver();
    private final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));


    public static AddWorkShift start() {
        if (startInstance == null) {
            startInstance = new AddWorkShiftTest();
        }
        return startInstance;
    }

    private AddWorkShiftTest() {
        driver.manage().window().maximize();
        loginPage();
        mainPage();
        addWorkShift();
        if (checkShift()) {
            removeShift();
        }
    }

    public void loginPage() {
        driver.get("https://opensource-demo.orangehrmlive.com/");
        String stringXpath = "//input[@name=\"username\"]";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(stringXpath))).sendKeys(loginUsername);
        driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys(loginPassword);
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
    }

    @SuppressWarnings("ReassignedVariable")
    public void mainPage() {
        String stringXpath = "//span[text()=\"Admin\"]";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(stringXpath))).click();

        stringXpath = "//span[contains(text(),\"Job\")]";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(stringXpath))).click();
        driver.findElement(By.xpath("//a[contains(text(),\"Work Shifts\")]")).click();

        stringXpath = "//button[contains(.,\"Add\")]";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(stringXpath))).click();
    }

    @SuppressWarnings("ReassignedVariable")
    public void addWorkShift() {
        String stringXpath = "//input[@class=\"oxd-input oxd-input--active\" and not(@placeholder)]";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(stringXpath))).sendKeys(shiftName);

        stringXpath = "//input[@class=\"oxd-input oxd-input--active\"]";
        List<WebElement> salariesInputs = driver.findElements(By.xpath(stringXpath));
        salariesInputs.get(1).clear();
        salariesInputs.get(1).sendKeys(fromTime);
        salariesInputs.get(2).clear();
        salariesInputs.get(2).sendKeys(toTime);

        stringXpath = "//input[@placeholder='Type for hints...']";
        driver.findElement(By.xpath(stringXpath)).sendKeys(assignedEmployeeName);

        stringXpath = "//span[contains(text(), 'Odis')]";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(stringXpath))).click();

        stringXpath = "//button[contains(.,\"Save\")]";
        driver.findElement(By.xpath(stringXpath)).click();
    }

    public Boolean checkShift() {
        try {
            String[] arrayOfStringXpath = new String[4];
            arrayOfStringXpath[0] = "//div[contains(.,\"Work Shift Name\")]";
            arrayOfStringXpath[1] = "//div[contains(.,\"06:00\")]";
            arrayOfStringXpath[2] = "//div[contains(.,\"18:00\")]";
            arrayOfStringXpath[3] = "//div[contains(.,\"12\")]";

            for (String s : arrayOfStringXpath) {
                new WebDriverWait(driver, Duration.ofSeconds(5))
                        .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(s))).isDisplayed();
            }
        } catch (TimeoutException e) {
            return false;
        }
        return true;
    }

    @SuppressWarnings("ReassignedVariable")
    public void removeShift() {
        String stringXpath = "//div[@class=\"oxd-table-row oxd-table-row--with-border\" and " +
                String.format("./div/div[contains(text(), \"%s\")]]//i[@class=\"oxd-icon bi-trash\"]", shiftName);

        driver.findElement(By.xpath(stringXpath)).click();
        stringXpath = "//button[contains(., \"Yes, Delete\")]";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(stringXpath))).click();
        driver.close();
    }
}
