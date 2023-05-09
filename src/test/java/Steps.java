import com.thoughtworks.gauge.Step;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.ElementOption;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Steps extends Base {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    TouchAction action = new TouchAction(appiumDriver);
    protected By enButton = By.id("buttonTest");
    protected By androidNoButton = By.id("android:id/button2");
    protected By userRegister = By.id("startUserRegistration");
    protected By inputUsername = By.id("inputUsername");
    protected By inputEmail = By.id("inputEmail");
    protected By inputPassword = By.id("inputPassword");
    protected By inputName = By.id("inputName");
    protected By language = By.id("input_preferedProgrammingLanguage");
    protected By acceptAddCheckbox = By.id("input_adds");
    protected By registerUserVerifyBtn = By.id("btnRegisterUser");
    protected By labelNameData = By.id("label_name_data");
    protected By labelUsernameData = By.id("label_username_data");
    protected By labelEmailData = By.id("label_email_data");
    protected By labelPreferredProgrammingLanguageData = By.id("label_preferedProgrammingLanguage_data");
    protected By labelAcceptAddsData = By.id("label_acceptAdds_data");
    protected By buttonRegisterUser = By.id("buttonRegisterUser");
    protected By touchTestBtn = By.id("touchTest");
    protected By scaleFactorTextView = By.id("scale_factor_text_view");
    protected By gestureTypeTextView = By.id("gesture_type_text_view");
    protected By visibleButtonTest = By.id("visibleButtonTest");
    protected By visibleTextView = By.id("visibleTextView");

    protected WebElement find(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        logger.info(locator + " elementi bulundu.");
        return appiumDriver.findElement(locator);
    }

    protected void clickByText(String text) {
        String xpath = "//*[@text='" + text + "']";
        By findText = By.xpath(xpath);
        wait.until(ExpectedConditions.visibilityOfElementLocated(findText)).click();
        logger.info(findText + " text'li elemente tıklandı.");
    }

    protected void clear(By locator) {
        find(locator).clear();
        logger.info(locator + " elementinin içeriği temizlendi.");
    }

    protected void type(String text, By locator) {
        find(locator).sendKeys(text);
    }

    protected void click(By locator) {
        find(locator).click();
        logger.info(locator + " elementine tıklandı.");
    }

    public void longPress(By locator) {
        WebElement element = appiumDriver.findElement(locator);
        action.waitAction().longPress(ElementOption.element(element)).perform();
    }

    protected void verifyElementValue(By locator, String text) {
        Assert.assertEquals("Element değeri, beklenen değer değildir!", text, find(locator).getText());
        logger.info(locator + " elementinin değeri " + text + " ile karşılaştırıldı.");
    }

    @Step({"<seconds> saniye bekle", "Wait <seconds> seconds"})
    public void waitBySecond(int seconds) {
        try {
            logger.info(seconds + " saniye bekletilecek.");
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Step({"EN Buttonunun varlığını kontrol et.", "Verify visibility of EN Button"})
    public void verifyENButton() {
        find(enButton);
    }

    @Step({"EN Button elementine tıkla.", "Click to EN Button"})
    public void clickToENButton() {
        click(enButton);
    }

    @Step({"Android No Butonuna tıkla.", "Click to Android No Button"})
    public void clickToAndroidNoButton() {
        click(androidNoButton);
    }

    @Step({"Yeni kullanıcı ekle butonuna tıkla.", "Click to Register New user Button"})
    public void clickToRegisterNewUserButton() {
        click(userRegister);
    }

    @Step({"Kullanıcı adı alanına <userneme> değerini gir.", "Type <username> to username field."})
    public void inputUsername(String username) {
        type(username, inputUsername);
    }

    @Step({"Email alanına <email> değerini gir.", "Type <email> to email field."})
    public void inputEmail(String email) {
        type(email, inputEmail);
    }

    @Step({"Password alanına <password> değerini gir.", "Type <password> to password field."})
    public void inputPassword(String password) {
        type(password, inputPassword);
    }

    @Step({"Name alanını temizle ve <name> değerini gir.", "Clear and type <name> to name field."})
    public void inputName(String name) {
        clear(inputName);
        type(name, inputName);
    }

    @Step({"Programlama dili seçim elementine tıkla.", "Click to programming language."})
    public void clickToProgrammingLanguage() {
        click(language);
    }

    @Step({"<language> programlama dili seç.", "Select to <language> programming language."})
    public void selectToProgrammingLanguage(String language) {
        clickByText(language);
    }

    @Step({"Reklamları kabul ediyor musun? true/false <selection>"})
    public void clickToAcceptAddCheckbox(String selection) {
        if (selection.equals("true")) {
            click(acceptAddCheckbox);
        }
    }

    @Step({"Yeni kullanıcı kaydet(doğrulama) butonuna tıkla.", "Click to Register User(verify) button."})
    public void clickToRegisterUserVerifyButton() {
        click(registerUserVerifyBtn);
    }

    @Step({"Kayıt ekranında adı <name> olmalı.", "Name should be <name> on register screen."})
    public void verifyName(String name) {
        verifyElementValue(labelNameData, name);
    }

    @Step({"Kayıt ekranında username <username> olmalı.", "Username should be <username> on register screen."})
    public void verifyUsername(String username) {
        verifyElementValue(labelUsernameData, username);
    }

    @Step({"Kayıt ekranında email <email> olmalı.", "Email should be <email> on register screen."})
    public void verifyEmail(String email) {
        verifyElementValue(labelEmailData, email);
    }

    @Step({"Kayıt ekranında tercih edilen dil <language> olmalı.", "Preferred language should be <language> on register screen."})
    public void verifyProgrammingLanguage(String language) {
        verifyElementValue(labelPreferredProgrammingLanguageData, language);
    }

    @Step({"Kayıt ekranında reklamları kabul et <select> olmalı.", "I accept adds should be <select> on register screen."})
    public void verifyAcceptAdds(String select) {
        verifyElementValue(labelAcceptAddsData, select);
    }

    @Step({"Kullanıcı kaydet butonuna tıkla.", "Click to registered button."})
    public void clickToBtnRegisteredUser() {
        click(buttonRegisterUser);
    }

    @Step({"TouchsTest butonuna tıkla.", "Click to TouchTest button."})
    public void clickToTouchTestBtn() {
        click(touchTestBtn);
    }

    @Step({"Ekranda bir kez tıkla.", "Only one click on the screen."})
    public void oneClickToTouchTestScreen() {
        click(scaleFactorTextView);
    }

    @Step({"Ekranda uzun süre basılı tutulur.", "Long press on the screen."})
    public void longPress() {
        longPress(scaleFactorTextView);
    }

    @Step({"Tıklama türüne göre ekrandaki mesaj <message> olmalı.", "Screen message should be <message>."})
    public void verifyClickMessage(String message) {
        verifyElementValue(gestureTypeTextView, message);
    }

    @Step({"Display text view butonuna tıklandıktan sonra çıkan mesaj <message> olmalı", "Message should be <message> after click to display text view button"})
    public void verifyMessageAfterClickToButton(String message) {
        click(visibleButtonTest);
        verifyElementValue(visibleTextView, message);
    }
}
