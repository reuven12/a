package Tests;

import Pages.Transfer_a_file_to_a_folder;
import Tests.Base;
import io.restassured.response.Response;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
public class Get_ancestors_file extends Base {

    @Test
    public void get_ancestor_file() throws InterruptedException {

        WebDriver options = initialized();

        Transfer_a_file_to_a_folder transfer_a_file_to_a_folder = new Transfer_a_file_to_a_folder(options);
        transfer_a_file_to_a_folder.Transfer_a_file_to_a_folder();

//        api
        request.header("Authorization", Authorization)
                .header("Content-Type", "application/json")
                .header("Cookie", Cookie);
        Response response = request.get(link + "/files/" + Upload_file.All_id.get(0) + "/ancestors");
        idsAllFiles = response.body().jsonPath().get("name");
        for (String a : idsAllFiles) {
            System.out.println(a);
            Assert.assertEquals(a,"test1");
            System.out.println(response.getStatusCode());
        }
    }
}
