package bsr.bank2;

import com.squareup.okhttp.*;

import java.io.IOException;

/**
 * Created by Varn on 2017-01-13.
 */
public class TransferExecutor {

    public static Response execute(Transfer transfer, String url) throws IOException{
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\n  \"amount\": "
                +transfer.getAmount()+",\n  \"sender_account\": \""
                +transfer.getSender_account()+"\",\n  \"receiver_account\": \""
                +transfer.getReceiver_account()+"\",\n  \"title\": \""
                +transfer.getTitle()+"\"\n}");
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .addHeader("content-type", "application/json")
                .addHeader("authorization", "Baseic "+BasicAuth.getCredentials())
                .addHeader("cache-control", "no-cache")
                .build();

        return client.newCall(request).execute();
    }
}
