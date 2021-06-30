package Tests;

import Tests.Base;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Get_single_file extends Base {
    @Test
    public void get_single_file(){
        request.header("Authorization",Authorization);
        Response response=request.get(link+"/files/"+Upload_file.All_id.get(2));
        name=response.body().jsonPath().get("name");
        Assert.assertEquals(name,"test.docx");
        Assert.assertEquals(response.getStatusCode(),200);
    }
}
