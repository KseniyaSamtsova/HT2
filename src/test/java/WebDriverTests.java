import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class WebDriverTests {

    @Test
    public void loginJenkinsTest(){
        WebDriver driver = JenkinsManager.startBrowser("chrome","http://localhost:8080");
        JenkinsManager login_page = PageFactory.initElements(driver,JenkinsManager.class);
        login_page.loginJenkins("kseniya","qweasdzxcc");
    }

    @Test
    public void createUserTest(){
        WebDriver driver = JenkinsManager.startBrowser("chrome","http://localhost:8080");
        JenkinsManager login_page = PageFactory.initElements(driver,JenkinsManager.class);
        login_page.loginJenkins("Kseniya","kseniya777");
        JenkinsManager manager_create_user = PageFactory.initElements(driver, JenkinsManager.class);
        manager_create_user.createUser("someuser","somepassword","somepassword", "someFullName", "some@addr.dom");
    }

    @Test
    public void deleteUserTest(){
        WebDriver driver = JenkinsManager.startBrowser("chrome","http://localhost:8080");
        JenkinsManager login_page = PageFactory.initElements(driver,JenkinsManager.class);
        login_page.loginJenkins("Kseniya","kseniya777");
        JenkinsManager delete_user = PageFactory.initElements(driver, JenkinsManager.class);
        delete_user.deleteUser();
    }
}
