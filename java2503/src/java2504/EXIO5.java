package pub2504.exio;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EXIO5 {

	private static final String FILE_PATH 
		= "C:\\pub2504\\files\\Enter_korea_by_age.csv";
	
	private static List<KoreaVisitor> kvList = new ArrayList<>();

	public static void main(String[] args) {
		loadData(FILE_PATH);
		System.out.println("원하시는 통계를 입력하세요 (1:국가별 평균방문자수, 2:국가별 평균성장률)");
		try (Scanner scanner = new Scanner(System.in)) {
			String input = scanner.nextLine();
			Map<String, Double> resultMap = getResultMap(input);
			int rank = 1;
			for (Map.Entry<String, Double> entry : resultMap.entrySet()) {
				System.out.printf("%d위\t%s\t%.1f\n", rank++, entry.getKey(), entry.getValue());
			}
		}
	} // main

	private static void loadData(String path) {
		try (Scanner scanner = new Scanner(Paths.get(path))) {
			scanner.nextLine();
			while (scanner.hasNextLine()) {
				String[] tokens = scanner.nextLine().split(",");
				kvList.add(
						new KoreaVisitor(
								tokens[0], 
								tokens[1], 
								Integer.parseInt(tokens[2]),
								Double.parseDouble(tokens[3])
						)
				);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	} // loadData

	private static Map<String, Double> getResultMap(String option) {
		if (option.equals("1")) {
			return sortByValueDesc(kvList.stream()
					.collect(Collectors.groupingBy(
							KoreaVisitor::getNation, 
							Collectors.averagingInt(KoreaVisitor::getVisitor))
					)
			);
		} else if (option.equals("2")) {
			return sortByValueDesc(kvList.stream()
					.collect(Collectors.groupingBy(
							KoreaVisitor::getNation,
							Collectors.averagingDouble(KoreaVisitor::getGrowth))
					)
			);
		} else {
			return Collections.emptyMap();
		}
	} // getResultMap

	private static Map<String, Double> sortByValueDesc(Map<String, Double> input) {
		return input.entrySet().stream()
			.sorted(Map.Entry.<String, Double>comparingByValue().reversed())
			.collect(
				Collectors.toMap(
						Map.Entry::getKey, 
						Map.Entry::getValue, 
						(e1, e2) -> e1, // 동일한 키가 충돌할 경우 첫 번째 값을 유지
						LinkedHashMap::new // 순서를 유지하는 LinkedHashMap으로 반환
				)
		);
	} // sortByValueDesc
	
} // class







