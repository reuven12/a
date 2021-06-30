package Tests;

//import utils.ExtentReport.ExtentTestManager;
//import ExtentReport.ExtentTestManager;
import ExtentReport.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.jsoup.select.Evaluator;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;

import java.io.IOException;

public class DeleteTheFile extends Base {
    Response response ;
    @Test
    public void DeleteTheFile() throws InterruptedException, IOException {

        request.header("Content-type","application/jason");
        request.header("Authorization",Authorization)
                .header("Cookie",Cookie);

        Response response=request.delete(link+"/files/"+Upload_file.All_id.get(1));
        String Delete=response.asString();
        System.out.println(Delete);
        }
//        ExtentTestManager.getTest().log(LogStatus.PASS,"the Folder has ben delete successfully ");
    }


