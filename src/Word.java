
public class Word {
	private String term; //単語
	private String meaning; //意味
	
	//初期化
	public Word(String term, String meaning) {
		this.term = term;
		this.meaning = meaning;
	}
	
	//単語を取得
	public String getTerm() {
		return term;
	}
	
	//意味を取得
	public String getMeaning() {
		return meaning;
	}
	
	//単語と意味を文字列として返す
	@Override
	public String toString() {
		return term + ": " + meaning;
	}

}
