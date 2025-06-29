import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		ArrayList<Word> wordList = new ArrayList<>(); //単語リスト
		Scanner scanner = new Scanner(System.in); //入力
		
		while (true) {
			//メニューの表示
			System.out.println("\n==== 単語帳メニュー ====");
            System.out.println("1. 単語を追加する");
            System.out.println("2. 単語一覧を表示する");
            System.out.println("3. 終了する");
            System.out.print("選択してください（1〜3）：");
            
            String choice = scanner.nextLine();
            
            switch (choice) {
            case "1":
            	//単語追加
            	System.out.println("単語追加機能（予定）");
            	break;
            	
            case "2":
            	//単語一覧
            	System.out.println("単語一覧表示（予定）");
            	break;
            	
            case "3":
            	System.out.println("単語帳を終了します。お疲れさまでした！");
            	scanner.close();
            	return;
            	
        	default:
        		System.out.println("⚠ 1〜3の数字を入力してください。");
            }
		}
	}

}
