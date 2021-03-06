import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class MadLibs {

	public static void main(String[] args) throws IOException {

		Scanner scan = new Scanner(System.in);

		//0. Give variable names for each of the arraylists below and create Madlibs stories.
		ArrayList<String> nouns = new ArrayList<String>();
		ArrayList<String> adjectives = new ArrayList<String>();
		Arraylist<String> adverbs = new ArrayList<String>();
		Arraylist<String> verbs = new ArrayList<String>();
		String fileName;
		String vword = "<<VERB>>";
		String nword = "<<NOUN>>";
		String aword = "<<ADJECTIVE>>";
		String adword = "<<ADVERB>>";
		String total = "";

		//1. Read a nouns.txt file and store its list of nouns into an arraylist.
		BufferedReader br1 = new BufferedReader(new FileReader("nouns.txt"));
 		while (br1.ready()) {
 		nouns.add(br1.readLine());
 		}
 		br1.close();

		//2. Read a verbs.txt file and store its list of verbs into an arraylist.
		BufferedReader br2 = new BufferedReader(new FileReader("verbs.txt"));
 		while (br2.ready()) {
 			verbs.add(br.readLine());
 		}
 		br2.close();

		//3. Read an adjectives.txt file and store its list of adjectives into an arraylist.
		BufferedReader br3 = new BufferedReader(new FileReader("adjectives.txt"));
 		while (br3.ready()) {
 			adjectives.add(br3.readLine());
 		}
 		br3.close();

		//4. Read an adverbs.txt file and store its list of adverbs into an arraylist.
		BufferedReader br4 = new BufferedReader(new FileReader("adverbs.txt"));
		while (br4.ready()) {
			adverbs.add(br4.readLine());
		}
		br.close();

		//5. Prompt user for the name of a file containing a MadLibs story.
		// Read the story from that file and write it to System.out, but replacing each instance of
		// <<NOUN>>, <<VERB>>, etc. with a randomly chosen word from the corresponding list.

		System.out.println("Name of file: ");
		String filename= scan.nextLine();

		BufferedReader br = new BufferedReader(new FileReader(filename));
		while (br.ready()) {
			total += ((char) br.read());
		}
		br.close();
		System.out.println(total);

		String s = "This is a sample sentence.";
		String[] words = total.split("\\s+");
		for (int i = 0; i < words.length; i++) {
		    if (words[i].equals(vword)) {
		    	words[i] = randomItem(verbs);
		    }
		    else if (words[i].equals(nword)) {
		    	words[i] = randomItem(nouns);
		    }
		    else if (words[i].equals(aword)) {
		    	words[i] = randomItem(adjectives);
		    }
		    else if (words[i].equals(adword)) {
		    	words[i] = randomItem(adverbs);
		    }
		    System.out.print(words[i] + " ");
		}
	}

	public static String randomItem(ArrayList<String> mylist) {
	    Random rand = new Random();
	    String randomInt = mylist.get(rand.nextInt(mylist.size()));
	    return randomInt;
	}
}
