import java.io.IOException;
import java.net.URI;

class Handler implements URLHandler {
    // The one bit of state on the server: a number that will be manipulated by
    // various requests.
    int num = 0;

    public String handleRequest(URI url) {
        ArrayList<String> num = new ArrayList<String>();
        if (url.getPath().equals("/")) {
            return String.format("item: %d", inputs.toString());
        } else {
            System.out.println("Path: " + url.getPath());
            if (url.getPath().contains("/add")) {
                String[] parameters = url.getQuery().split("=");
                if (parameters[0].equals("d")) {
                    num.add(parameters[1]);
                    return String.format("item %d added", parameters[1]);
                }
            }
            return "404 Not Found!";
        }
    }
}
