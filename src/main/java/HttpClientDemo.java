import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

public class HttpClientDemo {

    public HttpClientDemo() throws IOException, InterruptedException {
        // return a version with default settings
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest req = HttpRequest.newBuilder(URI.create("https://pluralsight.com"))
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(req, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.headers().map());
    }

    public HttpClientDemo(String path){
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .build();
        HttpRequest request = HttpRequest.newBuilder(URI.create(path))
                .GET()
                .build();

        //Waiting for the code to complete before it prints out
        CompletableFuture<HttpResponse<String>> resFuture =  client.sendAsync(request, HttpResponse.BodyHandlers.ofString());
        resFuture.thenAccept(result -> System.out.println(result.version()));
        resFuture.join();
    }

}
