package exmenu;

public class GUIMain {

	public static void main(String[] args) {
		
		MenuRecommendGUI gui = new MenuRecommendGUI();
		// 만들어진 gui 에 controller에 작성된 이벤트 기능들을 부여
		MenuController controller = new MenuController(gui);
		
		// GUI 활성
		gui.showGUI();
		
	} // main
} // class
