package exmenu;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MenuRecommendGUI extends JFrame {

	private JLabel photoLabel; // 메뉴 사진
	private JLabel menuNameLabel; // 메뉴명
	private  JLabel[] recentMenuLabels = new JLabel[5];
	private JButton recommendBtn = new JButton("추천 버튼");
	private JButton confirmBtn = new JButton("확정");
	// 생성자 함수
	public MenuRecommendGUI() {
		setTitle("메뉴 추천 프로그램");
		setSize(900, 600);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);

		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.addTab("메뉴", new JPanel());
		tabbedPane.addTab("날씨", new JPanel());
		tabbedPane.addTab("추천", createRecommendPanel()); // 아래에서 만든 패널을 붙히기
		tabbedPane.addTab("메뉴추가", new JPanel());

		add(tabbedPane);
	} // 생성자 함수
	
	// 외부에서 추천 버튼을 접근하기 위한 getter
	public JButton getRecommendBtn() {
	    return recommendBtn;
	}
	// 외부에서 확정 버튼을 접근하기 위한 getter
	public JButton getconfirmBtn() {
		return confirmBtn;
	}
	// 외부에서 메뉴 Label 을 접근하기 위한 getter
	public JLabel getmenuNameLabel() {
		return menuNameLabel;
	}
	// 외부에서 사진 Label 을 접근하기 위한 getter
	public JLabel getphotoLabel() {
		return photoLabel;
	}
	
	// 추천 탭에 들어갈 패널
	private JPanel createRecommendPanel() {
		JPanel panel = new JPanel(new BorderLayout());

		// 왼쪽: 메뉴 정보
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
		centerPanel.setPreferredSize(new Dimension(450, 0));

		// 메뉴 사진 - 크기 크게
		photoLabel = new JLabel("메뉴 사진", SwingConstants.CENTER);
		photoLabel.setPreferredSize(new Dimension(400, 240));
		photoLabel.setMaximumSize(new Dimension(400, 240));
		photoLabel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
		photoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

		// 메뉴명 (출력 전용 라벨)
		menuNameLabel = new JLabel("메뉴명", SwingConstants.CENTER);
		menuNameLabel.setFont(new Font("맑은 고딕", Font.BOLD, 24));
		menuNameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		menuNameLabel.setPreferredSize(new Dimension(400, 40));
		menuNameLabel.setMaximumSize(new Dimension(200, 100));
		menuNameLabel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));

		confirmBtn.setMaximumSize(new Dimension(200, 100));
		confirmBtn.setAlignmentX(Component.CENTER_ALIGNMENT);

		// 위에 만들어놓은 recommendBtn 사이즈 조절
		recommendBtn.setMaximumSize(new Dimension(200, 100));
		recommendBtn.setAlignmentX(Component.CENTER_ALIGNMENT);

		centerPanel.add(Box.createVerticalStrut(40)); // 사진 위 간격
		centerPanel.add(photoLabel);
		centerPanel.add(Box.createVerticalStrut(40)); // 사진-메뉴명 간격
		centerPanel.add(menuNameLabel);
		centerPanel.add(Box.createVerticalStrut(30)); // 메뉴명-확정 버튼 간격
		centerPanel.add(confirmBtn);
		centerPanel.add(Box.createVerticalStrut(40)); // 확정-추천 버튼 간격
		centerPanel.add(recommendBtn);
		centerPanel.add(Box.createVerticalStrut(40)); // 추천 버튼 아래 간격

		// 오른쪽: 최근 5일 먹은 메뉴
		JPanel rightPanel = new JPanel();
		rightPanel.setLayout(new GridLayout(5, 1, 5, 15));
		for (int i = 0; i < 5; i++) {
			recentMenuLabels[i] = new JLabel("기록 없음", SwingConstants.CENTER);
			recentMenuLabels[i].setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));
			recentMenuLabels[i].setFont(new Font("맑은 고딕", Font.PLAIN, 18));
			rightPanel.add(recentMenuLabels[i]);
		}
		rightPanel.setPreferredSize(new Dimension(260, 0));

		// 메인 패널에 만든 패널들 추가
	    panel.add(centerPanel, BorderLayout.CENTER); 
	    panel.add(rightPanel, BorderLayout.EAST);
		
		return panel;
	} // createRecommendPanel()

	// recentMenuLabels 를 최신화 하기위한 메소드 MenuController에서 메소드 실행 시킬거다.
	public void updateRecentMenus(List<String> recentMenus) {
	    for (int i = 0; i < 5; i++) {
	        String menu = (i < recentMenus.size()) ? recentMenus.get(i) : "기록 없음";
	        recentMenuLabels[i].setText((5 - i) + "일전: " + menu);
	    }
	}
	
	// main에서 사용할 showGUI 메소드
	public void showGUI() {
		setVisible(true);
	}
} // class
