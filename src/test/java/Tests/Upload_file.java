package Tests;

import Tests.Base;
import junit.framework.Assert;
import okhttp3.*;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Upload_file extends Base {
    public static String Id;
    public static ArrayList<String> All_id = new ArrayList();

    public Upload_file() throws IOException {
    }

    @Test
    public void upload_file() throws IOException {

        File files = new File(System.getProperty("user.dir") + File.separator + "Upload_File");

        for (File Path : files.listFiles()) {

            OkHttpClient client = new OkHttpClient().newBuilder().build();
            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                    .addFormDataPart("file", Path.getName(),
                            RequestBody.create(MediaType.parse("application/octet-stream"),
                                    new File(Path.getPath()))).build();
            Request request = new Request.Builder()
                    .url(link + "/upload?uploadType=multipart")
                    .method("POST", body)
                    .addHeader("Authorization", Authorization)
                    .addHeader("Cookie", Cookie)
                    .build();
            Response response = client.newCall(request).execute();
            Assert.assertEquals(response.code(), 200);
            Id = response.body().string();
            All_id.add(Id);
        }
    }
}



