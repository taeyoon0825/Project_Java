package exmenu;

import java.awt.Image;
import java.util.List;
import java.util.UUID;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class MenuController {

	private MenuRecommendGUI gui;

	// 생성자
	public MenuController(MenuRecommendGUI gui) {
		this.gui = gui;
		// 예시: 버튼에 이벤트 연결
		setupEvents();
	}

	// 이벤트 설정 메소드
	private void setupEvents() {

		// getRecommendButton 이벤트 추가
		gui.getRecommendBtn().addActionListener(e -> {

			// 최근에 먹은 메뉴를 불러와서 5일전 먹은 리스트 변경
			List<String> recent = JsonRest.getRecentMenus();
			gui.updateRecentMenus(recent);

			// 추천된 메뉴 menu 변수에 할당
			String menu = new FoodRecommend().FoodRecommendFunc();

			// menuNameLabel 바꾸기
			gui.getmenuNameLabel().setText(menu);

			// photoLabel 바꾸기위해 img 파일을 가져오기(ImageIcon을 사용하면 손 쉽게 가져올 수 있다.)
			ImageIcon icon = new ImageIcon(
					"C:\\Users\\gmldn\\OneDrive\\바탕 화면\\TeamProject\\JavaProject\\StockDividends\\img_" + menu
							+ ".jpg");
			// 이미지 파일 크기 조절
			Image img = icon.getImage().getScaledInstance(400, 240, Image.SCALE_SMOOTH);

			// 이미지 적용하고, 글씨는 지우기
			gui.getphotoLabel().setIcon(new ImageIcon(img));
			gui.getphotoLabel().setText("");

			// 이벤트 확인용 코드
			// System.out.println(new FoodRecommend().FoodRecommendFunc());
		});

		// 확정버튼 클릭 이벤트
		gui.getconfirmBtn().addActionListener(e -> {

			// 확정 확인 창을 띄우기 위한 코드
			int result = JOptionPane.showConfirmDialog(gui, // 부모 컴포넌트
					gui.getmenuNameLabel().getText() +" 메뉴를(을) 확정 하겠습니까?", 
					"확인", JOptionPane.YES_NO_OPTION);

			// Yes 클릭, No 클릭 처리
			if (result == JOptionPane.YES_OPTION) {
				// Yes 클릭 시 처리
				System.out.println("확정되었습니다.");

				// 오늘의 음식 JSON 서버에 POST요청 id 부분을 자동 카운팅하지 않고 그냥 랜덤 id를 주었다.
				JsonRest.postFood(new Food(UUID.randomUUID().toString(), gui.getmenuNameLabel().getText()));

				// json데이터에 있는 크기가 5이상이면 1번째의 요소를 삭제한다. 제일 먹은지 오래된 음식이
				// 처음 아이디쪽으로 밀어지기 때문에
				if (JsonRest.jsonFoodList.size() >= 5) {
					JsonRest.delFood(JsonRest.jsonFoodList.get(0).getId());
				}
				// getmenuNameLabel 에 text 가져오는지 확인용 코드
				//System.out.println(gui.getmenuNameLabel().getText());
				
			} else {
				// No 클릭 시 처리
				System.out.println("취소되었습니다.");
			}
		});

	} // setupEvents()

} // class
