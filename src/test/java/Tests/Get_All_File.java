package Tests;

import Tests.Base;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Get_All_File extends Base {
public static List<String> IdsAllFiles;
public String b;
    @Test
    public void get_all_files(){
        request.header("Authorization",Authorization);
        Response response=request.get(link+"/files");
        IdsAllFiles=response.body().jsonPath().get("id");
        nameAllFiles=response.body().jsonPath().get("name");
        System.out.println(nameAllFiles);
//        System.out.println(idsAllFiles);
        System.out.println(response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(),200);

        }
    }

