```java
    import java.net.http.HttpClient;
    import java.net.http.HttpRequest;
    import java.net.http.HttpResponse;
    import java.net.URI;
    /**
     * Metodo per effettuare la richiesta HTTP
    */
    public void FreelancersRequest() {
        HttpClient client = HttpClient.newHttpClient(); // creo il client
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(this.URLGenerator())).build(); // creo la richesta con il link di URLGenerator
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString()) // richiesta asincrona al client
                .thenApply(HttpResponse::body) // applica la risposta al body
                .thenApply(FreelancersParser::parser) // parsing del conenuto
                .thenAccept(System.out::println)
                .join();
    }
```
``` java
   /**
     * Metodo per generare l'URL desiderato
     * 
     * @return URL
     */
    
    public String URLGenerator() {
        String URL = "https://upwork.com/api/profiles/v2/search/"; // entry point della documentazione
        URL += ("jobs.json?q=");
        URL += ("java"); // per cambiare la skill da cercare
        URL += ("&callback=?");
        URL += ("&oauth_params=");
        URL += ("xxxxx"); // per cambiare il parametro di autenticazione
        return URL;
    }
    // link per prendere la gente con la skill java
    // https://www.upwork.com/api/profiles/v2/search/jobs.json?q=java&callback=?&oauth_params=xxxxx

```