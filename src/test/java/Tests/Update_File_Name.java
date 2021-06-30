package Tests;

import Tests.Base;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class Update_File_Name extends Base {
    @Test
    public void update_file_name() throws IOException {
        Upload_file upload_file = new Upload_file();
        request.header("Content-type", "application/json")
                .header("Authorization", Authorization)
                .body("{\n\"name\": \"document15\"\n})");

        Response response = request.put(link + "/files/" + Upload_file.All_id.get(0));
        System.out.println(response.getStatusCode());

        response = request.get(link + "/files/" + Upload_file.All_id.get(0));
        name = response.body().jsonPath().get("name");
        System.out.println(name);
        Assert.assertEquals(name, "document15");
    }
}
