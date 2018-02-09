import java.sql.SQLOutput;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
public class WebScraper {

    public static void main(String[] args) {
	// write your code here
        String url = "http://erdani.com/tdpl/hamlet.txt";
        System.out.println(oneWordCount(urlToString(url), "Hamlet"));
    }

    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

    public static int wordCount(String url) {
        String[] urlArray = url.split(" ");
        return urlArray.length;
    }

    public static int oneWordCount(String url, String word) {
        String[] urlArray = url.split(word);
        int count = 0;
        for (String element : urlArray) {
            if (element.startsWith(word)) {
                count++;
            }
        }
        return count;
    }
}
