package Tests;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;

public class Base {
    public WebDriverWait wait;
//    public WebDriver driver;

    public static String Link = "http://drive-develop.northeurope.cloudapp.azure.com";

    String api = "/api";
    String link = Link + api;

    public String id;
    public WebDriver driver;


    String Authorization = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjVlNTY4ODMyNDIwM2ZjNDAwNDM1OTFhYSIsImFkZnNJZCI6InQyMzQ1ODc4OUBqZWxsby5jb20iLCJnZW5lc2lzSWQiOiI1ZTU2ODgzMjQyMDNmYzQwMDQzNTkxYWEiLCJuYW1lIjp7ImZpcnN0TmFtZSI6Iteg15nXmden15kiLCJsYXN0TmFtZSI6IteQ15PXmdeT16EifSwiZGlzcGxheU5hbWUiOiJ0MjM0NTg3ODlAamVsbG8uY29tIiwicHJvdmlkZXIiOiJHZW5lc2lzIiwiZW50aXR5VHlwZSI6ImRpZ2ltb24iLCJjdXJyZW50VW5pdCI6Im5pdHJvIHVuaXQiLCJkaXNjaGFyZ2VEYXkiOiIyMDIyLTExLTMwVDIyOjAwOjAwLjAwMFoiLCJyYW5rIjoibWVnYSIsImpvYiI6Iteo15XXpteXIiwicGhvbmVOdW1iZXJzIjpbIjAyNjY2Njk5OCIsIjA1Mi0xMjM0NTY1Il0sImFkZHJlc3MiOiLXqNeX15XXkSDXlNee157Xqten15nXnSAzNCIsInBob3RvIjpudWxsLCJqdGkiOiI2MmI0NmI0NC03ZWYzLTRiZjUtOGE1Mi0xNWI1OWYxNzA3YWUiLCJpYXQiOjE2MjQxODIyMDksImV4cCI6MTYyNjc3NDIwOSwiZmlyc3ROYW1lIjoi16DXmdeZ16fXmSIsImxhc3ROYW1lIjoi15DXk9eZ15PXoSJ9.Z17cKjNADNnXmEwIowehKyXT3fK8V84Oon7WX6I8Ux0";

    String Cookie = "SignInSecret=9yt37wI92pXpH6hIpp1ZfUGyx6BI%2Fi0QHTZKVqcrlcxdXldHhj7pILskpz%2BAvotpsWqFBFbqRzPfaXiq2Pig2xarNi5f1hn1mQRc0ENWZzxbQkFk6aCr0rPc9y%2FHIDxymVwphoD%2FZSASlJ7NGcKwPDmm0b1tKgwiGJMmCNkm%2BAxDAG27%2F396dt5Qc7JY75jt5LxA%2BzWwt%2Fn4nhvd6UXzOz6y1rI8Eed04a5mqqXnKaTc%2BgZ53%2F9Bjo9xCfo4RbkSO6zATJXm%2B4xmqbVXSy0sxLaqQ5sQMQk6Go2CaXP6vQ1xvYlYq3kkUdkAYbJjX%2Bn4EC6xE6m8YIkYVMhVjbey0Q%3D%3D; kd-token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjVlNTY4ODMyNDIwM2ZjNDAwNDM1OTFhYSIsImFkZnNJZCI6InQyMzQ1ODc4OUBqZWxsby5jb20iLCJnZW5lc2lzSWQiOiI1ZTU2ODgzMjQyMDNmYzQwMDQzNTkxYWEiLCJuYW1lIjp7ImZpcnN0TmFtZSI6Iteg15nXmden15kiLCJsYXN0TmFtZSI6IteQ15PXmdeT16EifSwiZGlzcGxheU5hbWUiOiJ0MjM0NTg3ODlAamVsbG8uY29tIiwicHJvdmlkZXIiOiJHZW5lc2lzIiwiZW50aXR5VHlwZSI6ImRpZ2ltb24iLCJjdXJyZW50VW5pdCI6Im5pdHJvIHVuaXQiLCJkaXNjaGFyZ2VEYXkiOiIyMDIyLTExLTMwVDIyOjAwOjAwLjAwMFoiLCJyYW5rIjoibWVnYSIsImpvYiI6Iteo15XXpteXIiwicGhvbmVOdW1iZXJzIjpbIjAyNjY2Njk5OCIsIjA1Mi0xMjM0NTY1Il0sImFkZHJlc3MiOiLXqNeX15XXkSDXlNee157Xqten15nXnSAzNCIsInBob3RvIjpudWxsLCJqdGkiOiI3ZmE0ZDU3NC0wZTUxLTQzMDQtOTJlOS03MDk0ZTlhZmViNDAiLCJpYXQiOjE2MjI0NjEzNjMsImV4cCI6MTYyNTA1MzM2MywiZmlyc3ROYW1lIjoi16DXmdeZ16fXmSIsImxhc3ROYW1lIjoi15DXk9eZ15PXoSJ9.dpSjHVqY8YQoCzHcgHIgKibGaB0N5xJ0gljfvLEK1KQ; connect.sid=s%3A-OCIZQZta4INNRdTKIanXnzadfRyBCo5.FyhywbgsAKV9Jn3QxVpx2Y6SyWEn%2F5ULZG7nT7u1068";

    String name;
    List<String> idsAllFiles;
    List<String> nameAllFiles;
    RequestSpecification request = RestAssured.given();

    public WebDriver initialized() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        ChromeDriver driver = new ChromeDriver(options);
//        driver.manage().window().maximize();
        driver.get(Link);
//        driver.get(Base.Link);

        Thread.sleep(1000);
        driver.findElement(By.id("username")).sendKeys("user1");
        driver.findElement(By.id("password")).sendKeys("user1pass");
        driver.findElement(By.id("submit")).click();
        Thread.sleep(1000);

        //while runing test in UI
//        driver.findElement(By.cssSelector(".nav-wrapper #proceed-button")).click();
        Thread.sleep(2000);

        return driver;
    }

    public WebDriver getDriver() {
        return driver;
    }
}