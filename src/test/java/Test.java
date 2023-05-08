import com.thoughtworks.gauge.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Test extends Base{
    protected By userRegister = By.id("io.selendroid.testapp:id/startUserRegistration");
    protected WebElement find(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return appiumDriver.findElement(locator);
    }

    protected void type(String text, By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        find(locator).sendKeys(text);
    }

    protected void click(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        find(locator).click();
    }
    @Step({"<seconds> saniye bekle", "Wait <seconds> seconds"})
    public void waitBySecond(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
            logger.info(seconds+" saniye bekletilecek.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Step({"<> elementine click yap"})
    public void clickBy(By locator) {
        click(locator);
    }

}
