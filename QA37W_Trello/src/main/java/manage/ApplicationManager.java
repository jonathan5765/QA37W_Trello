package manage;

import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.time.Duration;

public class ApplicationManager {
    WebDriver wd;

    UserHelper user;
    BoardHelper board;

    public BoardHelper getBoard() {
        return board;
    }

    public void init(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        wd = new ChromeDriver(options);
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wd.navigate().to("https://trello.com/");

        user = new UserHelper(wd);

        board = new BoardHelper(wd);
        user.login("jonathan5765@gmail.com", "Zeylik2504");

    }

    public UserHelper getUser() {
        return user;
    }
    public void quit(){
        wd.close();
        wd.quit();
    }

}
