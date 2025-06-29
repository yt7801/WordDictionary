import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WordStorage {
	private static final String FILE_NAME = "words.txt";
	
	//保存処理
	public static void saveWords(ArrayList<Word> wordList) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
			for (Word word : wordList) {
				//単語と意味をカンマで区切って保存
				writer.write(word.getTerm() + "," + word.getMeaning());
				writer.newLine();
			}
		} catch (IOException e) {
			System.out.println("⚠ 単語の保存に失敗しました：" + e.getMessage());
		}
	}
	
	//読み込み処理
	public static ArrayList<Word> loadWords() {
		ArrayList<Word> wordList = new ArrayList<>();
		
		File file = new File(FILE_NAME);
		if (!file.exists()) {
			return wordList; //ファイルがなければ空のリストを返す
		}
		
		try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(",", 2);
				if (parts.length == 2) {
					Word word = new Word(parts[0], parts[1]);
					wordList.add(word);
				}
			}
		} catch (IOException e) {
			System.out.println("⚠ 単語の読み込みに失敗しました：" + e.getMessage());
		}
		return wordList;
	} 

}
