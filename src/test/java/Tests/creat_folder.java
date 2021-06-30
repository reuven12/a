package Tests;

import Tests.Base;
import okhttp3.*;
import org.testng.annotations.Test;

import java.io.IOException;

public class creat_folder extends Base {

    @Test
    public void Creat_folder() throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        MediaType mediaType = MediaType.parse("application/vnd.drive.folder");
        RequestBody body = RequestBody.create(mediaType, "");
        Request request = new Request.Builder()
                .url(link+"/upload")
                .method("POST", body)
                .addHeader("Authorization", Authorization)
                .addHeader("Content-Disposition", "filename=test1")
                .build();
        okhttp3.Response response = client.newCall(request).execute();

    }
}
