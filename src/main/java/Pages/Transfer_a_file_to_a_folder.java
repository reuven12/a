package Pages;

import org.openqa.selenium.By;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import java.io.File;
import java.util.List;

    public class Transfer_a_file_to_a_folder extends PageObject {
    public Transfer_a_file_to_a_folder(WebDriver driver) {
        super(driver);
    }


    @FindBy(className = "v-icon notranslate material-icons theme--light white--text")
    protected WebElement button_add_folder_or_files;
    @FindBy(className = "v-btn__content")
    protected List<WebElement> add_folder_or_files;
    @FindBy(id = "input-104")
    protected WebElement Name_The_Folder;
    @FindBy(id = "confirm-button")
    protected WebElement Confirm;
    @FindBy(id = "upload-input")
    protected WebElement upload;
    @FindBy(className = "file-name")
    protected List<WebElement> file_name;
    @FindBy(className = "#action-bar .v-btn__content")
    protected List<WebElement> move_button;
    @FindBy(className = "v-list-item__title")
    protected List<WebElement> menuitem;
    @FindBy(css = "ul~.v-card__actions.popup-confirm #confirm-button")
    protected WebElement accept;
    @FindBy(css = "#action-bar .v-btn__content")
    protected List<WebElement> regularClickOptions;
    @FindBy(css = "#action-bar")
    protected WebElement actionBar;
    @FindBy(id = "confirm-button")
    protected List<WebElement> confirmation;
    @FindBy(className = "v-card v-sheet theme--light")
    protected WebElement popup;
    @FindBy(id = "upload-input")
    protected  WebElement uplod;

    public void Wait(WebElement element) {
//        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void Transfer_a_file_to_a_folder() throws InterruptedException {
        Actions actions = new Actions(driver);

        WebElement element = null;
        List<WebElement> file_name = driver.findElements(By.className("file-name"));
        for (int i = 0; i < file_name.size(); i++) {
            if (file_name.get(i).getText().equals("document16")) {
                element = file_name.get(i);
                actions.moveToElement(element).click().build().perform();
                break;
            }
        }
        Thread.sleep(3500);
        actions.moveToElement(actionBar);
        Thread.sleep(2500);
        actions.moveToElement(regularClickOptions.get(3)).build().perform();
        regularClickOptions.get(3).click();

        WebElement element1 = null;

        for (int i = 0; i < menuitem.size(); i++) {
            Thread.sleep(1000);
            if (menuitem.get(i).getText().equals("test1")) {
                element1 = menuitem.get(i);
                break;
            }
        }
            Thread.sleep(3500);
            actions.moveToElement(element1).click().build().perform();
            Thread.sleep(3000);
            actions.moveToElement(accept).build().perform();
            Thread.sleep(1000);
            actions.click(accept).build().perform();
//        }
//    public void Transfer_a_file_to_a_folder() throws InterruptedException {
//        ElementsCollection RegularClick =$$("#action-bar .v-btn__content");
//        ElementsCollection list_name = $$(".file-name");
//        ElementsCollection transfer_folder=$$(".v-list-item__title");
//        SelenideElement accept=$("ul~.v-card__actions.popup-confirm #confirm-button");
//        SelenideElement element;
//        for (SelenideElement a:list_name) {
//            if (a.getText().equals("document16")) {
//                element = a;
//                element.click();
//                System.out.println(element);
//
//            }
//        }
//        RegularClick.get(3).click();
//        for (SelenideElement a:transfer_folder){
//            if (transfer_folder.equals("test1")){
//                a.click();
//            }
//        }
//        accept.click();
    }
}






