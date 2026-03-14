import java.io.File;
import java.util.*;
public class DictionaryTranslater {
    static void printHTMLHeader(){
	System.out.println("<!DOCTYPE html>\n"+
			   "<html lang=\"ja\">\n"+
			   "<head>\n"+
			   "<meta charset=\"UTF-8\">\n"+
			   "<title>DictionaryTranslater</title>\n"+
			   "</head>\n"+
			   "<body>\n"+
			   "<iframe name=\"iframe\">"+
			   "</iframe>");
    }
    static void printHTMLFooter(){System.out.println("</body>\n"+"</html>");}
    public static void main(String[] args) {
        String dictFile = "ejdic-hand-utf8-2.txt";
        Dictionary dict = new Dictionary(dictFile);
        String inputFile = "java.txt";
        StringBuilder text = new StringBuilder();
        try (Scanner input = new Scanner(new File(inputFile), "UTF-8")){
            while(input.hasNextLine()){text.append(input.nextLine()).append(" ");}
        } 
        catch(Exception e){System.err.println("Error reading input file: " + e); return;}
        String cleaned = text.toString().replaceAll("[^a-zA-Z0-9 ]", " ");
        String[] rawWords = cleaned.trim().split("\\s+");
        List<String> htmlWords = new ArrayList<>();
        Set<String> foundWords = new LinkedHashSet<>();
        for (String word : rawWords) {
            String lower = word.toLowerCase();
            String result = dict.searchEWord(lower);
            if(result != null){
                htmlWords.add("<a href=\"#_" + lower + "\" target=\"iframe\">" + word + "</a>");
                foundWords.add(lower);
            } 
            else{htmlWords.add(word);}
        }
        printHTMLHeader();
        System.out.println("<p>");
        for (String word : htmlWords) {
            System.out.print(word + " ");
        }
        System.out.println("</p>");
        for (String word : foundWords) {
            String result = dict.searchEWord(word);
            if (result != null) {
                String anchorId = "_"+word;
                String meaning = result.split(":", 2)[1].replace("'", "\\'");
                System.out.println("<p><a id=\"" + anchorId + "\">" + word + ": " + meaning + "</a></p>");
            }
        }
        printHTMLFooter();
    }
}
class Dictionary { // 辞書と検索
    private int wordNum = 46725;
    private String[] eWords;
    private String[] jWords;
    public Dictionary(String filename) {
        eWords = new String[wordNum];
        jWords = new String[wordNum];
        try {
            Scanner scan = new Scanner(new File(filename), "UTF-8");
            int index = 0;
            while (scan.hasNextLine() && index < wordNum) {
                String line = scan.nextLine().trim();
                String[] parts = line.split("\\t", 2);
                if (parts.length == 2) {
                    eWords[index] = parts[0].toLowerCase();
                    jWords[index] = parts[1];
                    index++;
                }
            }
            scan.close();
        } catch (Exception e) {
            System.out.println("Error loading dictionary: " + e);
            System.exit(0);
        }
    }
    public String searchEWord(String word){
        for (int i = 0; i < wordNum; i++){
            if (eWords[i] != null && eWords[i].equals(word)) {
                return eWords[i] + ":" + jWords[i];
            }
        }
        return null;
    }
}