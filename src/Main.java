import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		ArrayList<Word> wordList = WordStorage.loadWords();  // 起動時に読み込み
        System.out.println("📂 単語データを読み込みました。現在の単語数：" + wordList.size());
		Scanner scanner = new Scanner(System.in); //入力
		
		while (true) {
			//メニューの表示
			System.out.println("\n==== 単語帳メニュー ====");
            System.out.println("1. 単語を追加する");
            System.out.println("2. 単語一覧を表示する");
            System.out.println("3. 終了する");
            System.out.println("4. 単語を検索する");
            System.out.print("選択してください（1〜4）：");
            
            String choice = scanner.nextLine();
            
            switch (choice) {
            case "1":
            	//単語追加
            	System.out.println("単語を入力してください:");
            	String term = scanner.nextLine(); //単語を入力
            	
            	System.out.println("意味を入力してください:");
            	String meaning = scanner.nextLine(); //単語を入力
            	
            	Word newWord = new Word(term, meaning);
            	wordList.add(newWord);
            	
            	
            	System.out.println("✅ 単語を登録しました！");
            	break;
            	
            case "2":
            	//単語一覧
            	System.out.println("\n📘 登録済みの単語一覧：");
            	
            	if (wordList.isEmpty()) {
            		System.out.println("※ まだ単語が登録されていません。");
            	} else {
            		for (int i = 0; i < wordList.size(); i++) {
            			Word w = wordList.get(i); //i番目のWordを取得
            			System.out.println((i + 1) + ". " + w.getTerm()); //番号と単語名だけ表示
            		}
            		
            		System.out.println("意味を見たい単語の番号を入力してください（キャンセルは0）：");
            		String input = scanner.nextLine();
            		
            		try {
            			int num = Integer.parseInt(input);
            			if (num == 0) {
            				System.out.println("▶ 意味の表示をキャンセルしました。");
            			} else if (num >= 1 && num <= wordList.size()) {
            				Word selected = wordList.get(num - 1);
            				System.out.println("📖 " + selected.getTerm() + ": " + selected.getMeaning());
            			} else {
            				System.out.println("⚠ 指定された番号は無効です。");
            			}
            		} catch (NumberFormatException e) {
            			System.out.println("⚠ 数字を入力してください。");
            		}
        
            	}
            	break;
            	
            case "3":
            	System.out.println("単語帳を終了します。お疲れさまでした！");
            	WordStorage.saveWords(wordList);  // 終了時に保存
            	System.out.println("💾 単語データを保存しました。");
            	scanner.close();
            	return;
            	
            case "4":
            	System.out.println("🔍 検索ワードを入力してください：");
            	String keyword = scanner.nextLine();
            	boolean found = false;
                for (Word w : wordList) {
                    if (w.getTerm().contains(keyword) || w.getMeaning().contains(keyword)) {
                        System.out.println("✅ " + w.getTerm() + "： " + w.getMeaning());
                        found = true;
                    }
                }

                if (!found) {
                    System.out.println("❌ 該当する単語が見つかりませんでした。");
                }
                break;
            	
        	default:
        		System.out.println("⚠ 1〜4の数字を入力してください。");
            }
		}
	}

}
