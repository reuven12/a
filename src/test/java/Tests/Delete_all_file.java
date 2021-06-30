package Tests;

import okhttp3.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class Delete_all_file extends Base{
    @Test
    public void delete_all_file() throws IOException {
        for (String test:Get_All_File.IdsAllFiles){

            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            MediaType mediaType = MediaType.parse("text/plain");
            RequestBody body = RequestBody.create(mediaType, "");
            Request request = new Request.Builder()
                    .url(link+"/files/"+test)
                    .method("DELETE", body)
                    .addHeader("Authorization", Authorization)
                    .build();
            Response response = client.newCall(request).execute();
            System.out.println(response.body().string());
        }
    }
}

