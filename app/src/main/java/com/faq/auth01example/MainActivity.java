package com.faq.auth01example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.scribe.builder.ServiceBuilder;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.oauth.OAuthService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String consumerKey    = "XXXX"; //api key
        String consumerSecret = "XXXX"; //api secret
        String requestUrl = "your context.io request url";

        OAuthService service = new ServiceBuilder()
                .provider(OAuthProvider.class)
                .apiKey(consumerKey)
                .apiSecret(consumerSecret)
                .build();

        OAuthRequest request = new OAuthRequest(Verb.GET, requestUrl);

        Token accessToken = new Token("", ""); //not required for context.io
        service.signRequest(accessToken, request);

        Response response = request.send();
        Log.d("OAuthTask",response.getBody());
    }
}
