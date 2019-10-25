package okHttp;

import okhttp3.*;
import java.io.IOException;

public class okHttpGet {

    private final OkHttpClient httpClient = new OkHttpClient();

    public static void main(String[] args) throws IOException {
    	okHttpGet obj = new okHttpGet();
        obj.infoGET();
    }

    private void infoGET() throws IOException {

        Request request = new Request.Builder()
                .url("https://httpbin.org/ge")
                .build();

    	httpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            	  e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                	
                	// If access to URL is not successful
                    if (!response.isSuccessful()) {
                    	System.out.println("\nWebsite cannot be contacted.\n\n");
                    	System.exit(0);
                    }

                    // If access to URL is successful
                    // Get response body and print it
                    System.out.println(responseBody.string());
                }
            }
        });

    }
    
}