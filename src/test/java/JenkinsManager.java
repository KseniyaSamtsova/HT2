import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class JenkinsManager {
    static WebDriver driver;

    public static WebDriver startBrowser(String browserName, String url){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Kseniya\\IdeaProjects\\WebDriverTest\\tools\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://localhost:8080");

        return driver;
    }

    @FindBy (id="j_username")
    WebElement username;

    @FindBy (name="j_password")
    WebElement password;

    @FindBy (xpath = "//button[@id='yui-gen1-button']")
    WebElement submit_button;

    @FindBy(xpath = "//a[contains(text(),'Настроить Jenkins')]")
    WebElement manage_Jenkins;

    @FindBy (xpath = "//dt[contains(text(),'Управление пользователями')]")
    WebElement manage_users;

    @FindBy (xpath = "//a[contains(text(),'Создать пользователя')]")
    WebElement create_user;

    @FindBy (id = "username")
    WebElement create_username;

    @FindBy (name = "password1")
    WebElement create_password;

    @FindBy (name = "password2")
    WebElement confirm_password;

    @FindBy (name = "fullname")
    WebElement full_name;

    @FindBy (name = "email")
    WebElement create_email;

    @FindBy (xpath = "//button[@id='yui-gen1-button']")
    WebElement create_user_button;

    @FindBy (xpath = "//a[contains(@href, 'user/someuser/delete')]")
    WebElement delete_link;

    @FindBy (xpath = "//button[@id='yui-gen1-button']")
    WebElement delete_button;

    public void loginJenkins(String login,String pass){
        username.sendKeys("kseniya");
        password.sendKeys("qazwsxedcc");
        submit_button.click();
    }

    public void createUser(String username, String pass1, String pass2, String fullname, String email){
        manage_Jenkins.click();
        manage_users.click();
        create_user.click();
        create_username.sendKeys("someuser");
        create_password.sendKeys("somepassword");
        confirm_password.sendKeys("somepassword");
        full_name.sendKeys("someFullName");
        create_email.sendKeys("some@addr.dom");
        create_user_button.click();
    }

    public void deleteUser(){
        manage_Jenkins.click();
        manage_users.click();
        delete_link.click();
        delete_button.click();
    }
}
