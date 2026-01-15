package chap01.args;

public class ArgsCommand {

	public static void main(String[] args) {
		System.out.println("==================================");
		System.out.println(" Command Line Arguments");
		System.out.println("==================================");
		
		System.out.println("전달된 인수 개수 : " + args.length);
		
		if(args.length == 0) {
			System.out.println("(인수 없음 - 실행 시 인수를 추가해보세요)");
			System.out.println("예: java chap01.args.ArgsCommand --port 8080 --env dev");
		} else {
			System.out.println("전달된 인수들: ");
			for(String arg : args) {
				System.out.println(" - " + arg);
			}
		}
	}
}
















