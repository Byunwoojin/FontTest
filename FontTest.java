import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.event.*;

public class FontTest extends JFrame{
	JLabel lblResult;
	JRadioButton rbG, rbD, rbGo;
	JCheckBox cbBold, cbItalic;
	JTextField tfSize, tfContents;
	String font;
	int style; 
	int size=15; // 기본 글자 크기 
	
	public FontTest() {
		setTitle("Font 설정");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BorderLayout(10,10));
		MyItemListener ml1 = new MyItemListener();
		MyActionListener ml2 = new MyActionListener();
	
		// 컨테이너의 West에 삽입할 컴포넌트
		JPanel panelLeft = new JPanel();
		panelLeft.setLayout(new GridLayout(0,1,10,10));
		panelLeft.add(new JLabel("Font설정"));
		panelLeft.add(new JLabel("Style설정"));
		panelLeft.add(new JLabel("Size설정"));
		panelLeft.add(new JLabel("Text내용"));
		
		
		// 컨테이너의 Center에 삽입할 컴포넌트
		JPanel panelCenter = new JPanel(); 
		panelCenter.setLayout(new GridLayout(0,1,5,5));
		// Font설정을 위한 라디오 버튼 
		JPanel panelFont = new JPanel();
		ButtonGroup font = new ButtonGroup(); //버튼그룹 객체 생성
		rbG = new JRadioButton("굴림");
		rbG.addItemListener(ml1); // 라디오 버튼에 Item리스너 등록
		rbD = new JRadioButton("돋움");
		rbD.addItemListener(ml1); // 라디오 버튼에 Item리스너 등록
		rbGo = new JRadioButton("궁서");
		rbGo.addItemListener(ml1); // 라디오 버튼에 Item리스너 등록
		font.add(rbG); font.add(rbD); font.add(rbGo); // 라디오 버튼을 버튼 그룹에 삽입
		panelFont.add(rbG); panelFont.add(rbD); panelFont.add(rbGo); // 라디오 버튼을 JPanel에 삽입
		
		// Style설정을 위한 CheckBox
		JPanel panelStyle = new JPanel(); 
		cbBold = new JCheckBox("Bold");
		cbBold.addItemListener(ml1); // 체크 박스에 Item리스너 등록
		cbItalic = new JCheckBox("Italic");
		cbItalic.addItemListener(ml1); // 체크 박스에 Item리스너 등록
		panelStyle.add(cbBold); panelStyle.add(cbItalic); // 체크 박스를 JPanel에 삽입
		
		// Size설정을 위한 TextField
		tfSize = new JTextField("");
		tfSize.addActionListener(ml2); // 텍스트필드에  Action리스너 등록
		
		// Text설정을 위한 TextField
		tfContents = new JTextField("");
		tfContents.addActionListener(ml2); // 텍스트필드에  Action리스너 등록
		
		panelCenter.add(panelFont);
		panelCenter.add(panelStyle);
		panelCenter.add(tfSize);
		panelCenter.add(tfContents);
		
		
		// 컨테이너의 South에 삽입할 컴포넌트
		JPanel panelBottom = new JPanel(); 		
		panelBottom.setLayout(new FlowLayout());
		Border resultBorder = BorderFactory.createTitledBorder("Font 설정 결과"); // 제목이 붙여진 경계를 생성
		panelBottom.setBorder(resultBorder);
		lblResult = new JLabel(" "); // Font설정 결과를 나타내기 위한, Label객체 생성
		panelBottom.add(lblResult);
		
		c.add(panelLeft,BorderLayout.WEST);
		c.add(panelCenter, BorderLayout.CENTER);
		c.add(panelBottom, BorderLayout.SOUTH);
		
		setSize(300,300);
		setVisible(true);
	}
	// 내부클래스로 Item리스너 구현
	class MyItemListener implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			if(rbG.isSelected())  // Font 
				font = "굴림";
			else if(rbD.isSelected())
				font = "돋움";
			else if(rbGo.isSelected())
				font = "궁서";
			if(cbBold.isSelected() && cbItalic.isSelected()) // Style
				style = Font.BOLD + Font.ITALIC;
			else if(cbBold.isSelected())
				style = Font.BOLD;
			else if(cbItalic.isSelected())
				style = Font.ITALIC;
			else
				style = Font.PLAIN;
			lblResult.setFont(new Font(font, style, size)); // Label객체의 Font,Style 설정
			
		}
		
	}
	// 내부클래스로 Action리스너 구현
	class MyActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == tfSize){   // Size설정
				size = Integer.parseInt(tfSize.getText());
				lblResult.setFont(new Font(font, style, size));
		}
			if(e.getSource() == tfContents) {  // Text설정
				lblResult.setText(tfContents.getText()+" ");
			}
		}
		
	}
	public static void main(String[] args) {
		new FontTest();
	}

}
