package exmenu;

import java.util.List;

import javax.swing.ImageIcon;

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
		gui.getRecommendButton().addActionListener(e -> {
			List<String> recent = JsonRest.getRecentMenus();
			gui.updateRecentMenus(recent);

			// menuNameLabel 바꾸기
			gui.getmenuNameLabel().setText(new FoodRecommend().FoodRecommendFunc());
			// photoLabel 바꾸기
			gui.getphotoLabel().setIcon(null);
			gui.getphotoLabel().setText("");

			// 이벤트 확인용 코드
			// System.out.println(new FoodRecommend().FoodRecommendFunc());
		});
	} // setupEvents()

} // class
