package chap08.interfacee03;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

interface Printable {
	void print();
	int getPageCount();
}

interface Saveable {
	void save(String path);
}

interface Shareable {
	void share(String recipient);		// 지정된 수신자에게 문서를 공유한다
	String getShareLink();				// 공유 링크를 반환
}

interface Searchable {
	int search(String keywrod);			// 키워드를 검색하여 발견 횟수를 반환한다
	void highlight(String keyword);		// 키워드를 하이라이트 처리한다 
}

class WordDocument implements Printable, Saveable, Shareable, Searchable {
	
	// 필드 
	private String title;
	private String content;
	private int pageCount;
	private String lastSavedTime;
	private String shareLink;				// 공유 링크 
	
	// 생성자
	public WordDocument(String title, String content, int pageCount) {
		//super();
		this.title = title;
		this.content = content;
		this.pageCount = pageCount;
		this.lastSavedTime = "저장 안됨";		// 초기 상태: 아직 저장 안됨
		this.shareLink = null;				// 초기 상태: 공유 링크 없음 
	}	

	@Override
	public int search(String keyword) {
		System.out.println("    >> [WordDocument.search() 호출됨]");
		int count = 0;			// 찾은 횟수 (처음엔 0)
		int index = 0;			// 검색 시작 위치 (처음엔 맨 앞 0부터)
		
		while((index = content.indexOf(keyword, index)) != -1) {
			count++;				// 찾았으니까 +1
			index += keyword.length();	// 찾은 위치 + 키워드 길이 = 다음 검색 시작 위치 (같은 위치에서 또 찾으면 무한루프!)
		}
		return count;				// 총 발견 횟수 반환 
	}

	@Override
	public void highlight(String keyword) {
		// 검색된 키워드를 시각적으로 강조 표시
		System.out.println("    >> [WordDocument.highlight() 호출됨]");
		System.out.println("  \"  "+keyword+"  \" 하이라이트 적용됨  ");
	}

	@Override
	public void share(String recipient) {
		System.out.println("    >> [WordDocument.share() 호출됨]");
		shareLink = "https://docs.company.com/share/" + title.hashCode();
		System.out.println("    Word 문서를 " +recipient+ "에게 공유합니다.");
	}

	@Override
	public String getShareLink() {
		
		return shareLink != null ? shareLink : "공유 링크 없음";
	}

	@Override
	public void save(String path) {
		System.out.println("    >> [WordDocument.save() 호출됨]");
		// 현재 시간을 "년-월-일 시:분:초" 형식으로 저장
		lastSavedTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		System.out.println("    Word 문서 저장됨: " +path+"/"+title+ ".docx");
		System.out.println("    저장 시간: " + lastSavedTime);
	}

	@Override
	public void print() {
		System.out.println("    >> [WordDocument.print() 호출됨]");
		System.out.println("       [Word 문서 출력]             ");
		System.out.println("    제목: " + title);
		String preview = content.length() > 20 
				? content.substring(0, 20) + "..."				// 20자 초과: 앞 20자 + "...."
				: content;										// 20자 이하: 전체 내용
		System.out.println("    내용: " + preview);		
	}

	@Override
	public int getPageCount() {
		return pageCount;
	}
	
}


/*
 *  PDFDocument 클래스 : PDF 문서
 *   - 필요한 기능만 선택적으로 구현 
 */

class PDFDocument implements Printable, Searchable {
	private String fileName;			// PDF 파일명
	private String content;				// PDF 내용
	private int pageCount;				// 총 페이지 수

	public PDFDocument(String fileName, String content, int pageCount) {
		//super();
		this.fileName = fileName;
		this.content = content;
		this.pageCount = pageCount;
	}

	@Override
	public int search(String keyword) {
		System.out.println("    >> [PDFDocument.search() 호출됨]");
		int count = 0;			// 찾은 횟수 (처음엔 0)
		int index = 0;			// 검색 시작 위치 (처음엔 맨 앞 0부터)
		
		while((index = content.indexOf(keyword, index)) != -1) {
			count++;				// 찾았으니까 +1
			index += keyword.length();	// 찾은 위치 + 키워드 길이 = 다음 검색 시작 위치 (같은 위치에서 또 찾으면 무한루프!)
		}
		return count;				// 총 발견 횟수 반환 
	}

	@Override
	public void highlight(String keyword) {
		// 검색된 키워드를 시각적으로 강조 표시
		System.out.println("    >> [PDFDocument.highlight() 호출됨]");
		System.out.println("  \"  "+keyword+"  \" PDF 주석으로 하이라이트됨  ");
		
	}

	@Override
	public void print() {
		System.out.println("    >> [PDFDocument.print() 호출됨]");
		System.out.println("       [PDF 문서 출력]             ");
		System.out.println("    파일: " + fileName);
		System.out.println("    (PDF 뷰어에서 인쇄 대화상자 열림)  ");
	}

	@Override
	public int getPageCount() {
		return pageCount;
	}
	
	// 클래스 고유 메서드 
	public String getFileName() {
		return fileName;
	}	
	
}

/*
 * 	Memo 클래스 : 간단한 메모 
 */

class Memo implements Saveable, Searchable {
	
	private String content;					// 메모 내용
	private String lastSavedTime;			// 마지막 저장 시간
	
	public Memo(String content) {
		//super();
		this.content = content;
		this.lastSavedTime = "저장 안됨";
	}

	@Override
	public int search(String keyword) {
		System.out.println("    >> [Memo.search() 호출됨]");
		int count = 0;			// 찾은 횟수 (처음엔 0)
		int index = 0;			// 검색 시작 위치 (처음엔 맨 앞 0부터)
		
		while((index = content.indexOf(keyword, index)) != -1) {
			count++;				// 찾았으니까 +1
			index += keyword.length();	// 찾은 위치 + 키워드 길이 = 다음 검색 시작 위치 (같은 위치에서 또 찾으면 무한루프!)
		}
		return count;				// 총 발견 횟수 반환 
	}

	@Override
	public void highlight(String keyword) {
		// 검색된 키워드를 시각적으로 강조 표시
		System.out.println("    >> [Memo.highlight() 호출됨]");
		System.out.println("  메모에서 \"  "+keyword+"  \" 텍스트 선택됨  ");
		
	}

	@Override
	public void save(String path) {
		System.out.println("    >> [Memo.save() 호출됨]");
		// 현재 시간을 "년-월-일 시:분:초" 형식으로 저장
		lastSavedTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		System.out.println("    Memo 저장됨: " +path+"/memo.txt");
		System.out.println("    저장 시간: " + lastSavedTime);
	}
	
}

/*
 * 	문서 관리자 클래스 (다형성 활용)
 * 
 */
class DocumentManager {
	//문서를 저장하는 배열 (다양한 타입 수용을 위해 Object 사용)
	private Object[] documents;
	private int count;
	
	public DocumentManager(int capacity) {
		//super();
		documents = new Object[capacity];
		count = 0;
	}
	
	public void addDocument(Object doc) {
		if(count < documents.length) {
			documents[count++] = doc;
			System.out.println("문서 추가됨: " + doc.getClass().getSimpleName());
		}
	}
	
	// 출력가능한 문서만 출력한다
	public void printAllPrintable() {
		System.out.println("\n[출력가능한 문서 출력]");
		System.out.println("-".repeat(50));
		for(int i = 0; i < count; i++) {
			if(documents[i] instanceof Printable p) {
				System.out.println("▶ " +documents[i].getClass().getSimpleName());
				p.print();
				System.out.println(" 페이지 수: " + p.getPageCount());
				System.out.println();
			}
		}
		
	}
	
	// 저장 가능한 문서만 저장한다 (Saveable)
	public void saveAllSaveable(String basePath) {
		System.out.println("\n[저장 가능한 문서 저장]");
		System.out.println("-".repeat(50));
		for(int i = 0; i < count; i++) {
			if(documents[i] instanceof Saveable s) {
				System.out.println("▶ " + documents[i].getClass().getSimpleName());
				s.save(basePath +"/doc"+i);
				System.out.println();
			}
		}
		
	}
	
}


public class MultiInterface {

	public static void main(String[] args) {
		System.out.println("다중 인터페이스 - 문서 처리 시스템");
		
		// 테스트 1: 다양한 문서 생성
		System.out.println("\n▶ 테스트 1: 다양한 문서 생성 및 등록");
		System.out.println("----------------------------------");	
		
		DocumentManager manager = new DocumentManager(10);
		
		// 다양한 문서 추가 -- 각각 다른 인터페이스 조합을 구현함
		manager.addDocument(new WordDocument("기획서", "프로젝트 기획 내용입니다.", 5));
		manager.addDocument(new PDFDocument("메뉴얼.pdf", "사용 설명서 내용", 20));
		manager.addDocument(new Memo("회의 메모: 오늘 회의 내용 정리"));
		manager.addDocument(new WordDocument("보고서", "분기별 보고서 내용입니다.", 10));
		
		// 테스트 2: 출력 가능한 문서만 출력 (Printable)
		System.out.println("\n▶ 테스트 2: 출력 가능한 문서만 출력 (Printable)");
		manager.printAllPrintable();
		
		// 테스트 3: 저장 가능한 문서만 저장 (Saveable)
		System.out.println("\n▶ 테스트 3: 저장 가능한 문서만 저장 (Saveable)");
		manager.saveAllSaveable("/documents");
	}
}
























