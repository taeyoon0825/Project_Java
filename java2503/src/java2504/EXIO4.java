package pub2504.exio;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import pub2504.excollection.Card;
import pub2504.excollection.Player;
import pub2504.excollection.PokerRule;

public class EXIO4 {

	public static void main(String[] args) {

		// 플레이어를 5명 만든다
		List<Player> playerList = Arrays.asList(
				new Player("홍길동", Collections.EMPTY_LIST),
				new Player("이순신", Collections.EMPTY_LIST),
				new Player("강감찬", Collections.EMPTY_LIST),
				new Player("권율", Collections.EMPTY_LIST),
				new Player("최영", Collections.EMPTY_LIST)
			);

		// 카드를 52장 만든다 (S2~S14, D2~D14, H2~H14, C2~C14)
		List<Card> totalCardList = new ArrayList<Card>();

		List<String> shapeList 
			= Arrays.asList("♠️", "♦️", "♥️", "♣️");		

		for (int i = 0; i < shapeList.size(); i++) {
			for (int j = 2; j < 15; j++) {
				totalCardList.add(new Card(j, shapeList.get(i)));
			}
		}

		// 카드를 섞자
		Collections.shuffle(totalCardList);

		// 플레이어들에게 7장씩 나눠준다
		// List 인터페이스에 List<E> subList(int fromIndex, int toIndex) 메소드
		for (int i = 0; i < playerList.size(); i++) {
			playerList.get(i).setCardList(totalCardList.subList(i * 7, (i * 7) + 7));
		}

		// 카드의 숫자, 무늬 카운팅
		for (int i = 0; i < playerList.size(); i++) {
			Player player = playerList.get(i);
			for (Card card : player.getCardList()) {
				player.getNumCountMap().put(card.getNum(), player.getNumCountMap().get(card.getNum()) + 1);
				player.getShapeCountMap().put(card.getShape(), player.getShapeCountMap().get(card.getShape()) + 1);
			}
		}

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

		File file = new File(
				"C:\\pub2504\\files\\result_" + sdf.format(new Date(System.currentTimeMillis())) + ".txt");

		Writer writer = null;

		try {
			writer = new FileWriter(file);
			for (Player player : playerList) {
				writer.write(player.toString());
				writer.write("\n" + getResult(player) + "\n\n");
			}
			writer.flush();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
	} // main

	private static String getResult(Player player) {
		String resultStr = "";
		if (PokerRule.isRoyalStraightFlush(player))
			resultStr = "[로열스트레이트플러시]";
		else if (PokerRule.isStraightFlush(player))
			resultStr = "[스트레이트플러시]";
		else if (PokerRule.isFourCard(player))
			resultStr = "[포카드]";
		else if (PokerRule.isFullHouse(player))
			resultStr = "[풀하우스]";
		else if (PokerRule.isFlush(player))
			resultStr = "[플러시]";
		else if (PokerRule.isStraight(player))
			resultStr = "[스트레이트]";
		else if (PokerRule.isTriple(player))
			resultStr = "[트리플]";
		else if (PokerRule.isTwoPair(player))
			resultStr = "[투 페어]";
		else if (PokerRule.isOnePair(player))
			resultStr = "[원 페어]";
		else
			resultStr = "[족보 없음]";
		return resultStr;
	}

}
