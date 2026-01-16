package chap01.environment;

public class EnvironmentCheck {

	public static void main(String[] args) {
		System.out.println("===== Java 환경 확인 ====");
		
		// Java 버전, 시스템 정보
		printJavaInfo();
		
		// 메모리 정보
		printMemoryInfo();
		
		
	}

	private static void printMemoryInfo() {
		 Runtime runtime = Runtime.getRuntime();		// 싱글톤 인스턴스 획득 
		 long maxMemory = runtime.maxMemory();
		 long totalMemory = runtime.totalMemory();
		 long freeMemory = runtime.freeMemory();
		 long usedMemory = totalMemory - freeMemory;
		 
		 System.out.println("[메모리 정보]");
		 System.out.println("최대 메모리 : " + formatBytes(maxMemory));
		 System.out.println("할당된 메모리 : " + formatBytes(totalMemory));
		 System.out.println("사용 중인 메모리 : " + formatBytes(usedMemory));
		 System.out.println("사용 가능한 메모리 : " + formatBytes(freeMemory));
		 System.out.println("CPU 코어 수 : " + runtime.availableProcessors());
		 System.out.println();
	}

	private static String formatBytes(long bytes) {
		// 1KB 미만 : 바이트 단위로 표시
		if(bytes < 1024) return bytes + " B";
		// 1MB 미만 : KB 단위로 표시
		if(bytes < 1024 * 1024) return String.format("%.2f KB", bytes / 1024.0);
		// 1GB 미만 : MB 단위로 표시
		if(bytes < 1024 * 1024 * 1024) return String.format("%.2f MB", bytes / (1024.0 * 1024));
		// 1GB 이상 : GB 단위로 표시
		return String.format("%.2f GB", bytes / (1024.0 * 1024 * 1024));
	}
	
	
	private static void printJavaInfo() {
		System.out.println("[Java 정보]");
		System.out.println("Java 버전: " + System.getProperty("java.version"));
		System.out.println("Java 벤더: " + System.getProperty("java.vendor"));
		System.out.println("Java 홈: " + System.getProperty("java.home"));
		System.out.println("Java 클래스 버전: " + System.getProperty("java.class.version"));
		System.out.println();
		
		System.getProperties().forEach((k, v) -> 
				System.out.println(k + " = " + v)
		);
	}
}























