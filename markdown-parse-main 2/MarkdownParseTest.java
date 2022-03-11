import static org.junit.Assert.*;
import org.junit.*;
import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
//ssh cs15lwi22aes@ieng6.ucsd.edu
//javac -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar MarkdownParseTest.java
//java -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore MarkdownParseTest

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(4, 4);
    }
    @Test
    public void testTestfile() throws IOException {
        Path fileName = Path.of("test-file.md");
	    String contents = Files.readString(fileName);
        assertEquals(List.of("https://something.com","some-page.html"),MarkdownParse.getLinks(contents));
    }
    @Test
    public void testImagemd() throws IOException {
        Path fileName = Path.of("image.md");
	    String contents = Files.readString(fileName);
        assertEquals(List.of(),MarkdownParse.getLinks(contents));
    }
    @Test
    public void testWhatever() throws IOException {
        Path fileName = Path.of("whatever.md");
	    String contents = Files.readString(fileName);
        assertEquals(List.of("abc.com"),MarkdownParse.getLinks(contents));
    }

    @Test
    public void testSnippet1() throws IOException{
        Path fileName = Path.of("Snippet1.md");
	    String contents = Files.readString(fileName);
        List<String> expected = List.of("`google.com", "google.com", "ucsd.edu");
        assertEquals(expected, MarkdownParse.getLinks(contents));
    }

    @Test
    public void testSnippet2() throws IOException {
        Path fileName = Path.of("Snippet2.md");
        String contents = Files.readString(fileName);
        List<String> expected = List.of("a.com", "a.com(())", "example.com");
        assertEquals(expected, MarkdownParse.getLinks(contents));
    }

    @Test
    public void testSnippet3() throws IOException {
        Path fileName = Path.of("Snippet3.md");
        String contents = Files.readString(fileName);
        List<String> expected = List.of("https://ucsd-cse15l-w22.github.io/");
        assertEquals(expected, MarkdownParse.getLinks(contents));
    }
    @Test
    public void testInvalidlink() throws IOException {
        Path fileName = Path.of("invalidlink.md");
	    String contents = Files.readString(fileName);
        assertEquals(List.of(),MarkdownParse.getLinks(contents));
    }
   
    
}