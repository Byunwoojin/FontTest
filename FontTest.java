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
	int size=15; // �⺻ ���� ũ�� 
	
	public FontTest() {
		setTitle("Font ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BorderLayout(10,10));
		MyItemListener ml1 = new MyItemListener();
		MyActionListener ml2 = new MyActionListener();
	
		// �����̳��� West�� ������ ������Ʈ
		JPanel panelLeft = new JPanel();
		panelLeft.setLayout(new GridLayout(0,1,10,10));
		panelLeft.add(new JLabel("Font����"));
		panelLeft.add(new JLabel("Style����"));
		panelLeft.add(new JLabel("Size����"));
		panelLeft.add(new JLabel("Text����"));
		
		
		// �����̳��� Center�� ������ ������Ʈ
		JPanel panelCenter = new JPanel(); 
		panelCenter.setLayout(new GridLayout(0,1,5,5));
		// Font������ ���� ���� ��ư 
		JPanel panelFont = new JPanel();
		ButtonGroup font = new ButtonGroup(); //��ư�׷� ��ü ����
		rbG = new JRadioButton("����");
		rbG.addItemListener(ml1); // ���� ��ư�� Item������ ���
		rbD = new JRadioButton("����");
		rbD.addItemListener(ml1); // ���� ��ư�� Item������ ���
		rbGo = new JRadioButton("�ü�");
		rbGo.addItemListener(ml1); // ���� ��ư�� Item������ ���
		font.add(rbG); font.add(rbD); font.add(rbGo); // ���� ��ư�� ��ư �׷쿡 ����
		panelFont.add(rbG); panelFont.add(rbD); panelFont.add(rbGo); // ���� ��ư�� JPanel�� ����
		
		// Style������ ���� CheckBox
		JPanel panelStyle = new JPanel(); 
		cbBold = new JCheckBox("Bold");
		cbBold.addItemListener(ml1); // üũ �ڽ��� Item������ ���
		cbItalic = new JCheckBox("Italic");
		cbItalic.addItemListener(ml1); // üũ �ڽ��� Item������ ���
		panelStyle.add(cbBold); panelStyle.add(cbItalic); // üũ �ڽ��� JPanel�� ����
		
		// Size������ ���� TextField
		tfSize = new JTextField("");
		tfSize.addActionListener(ml2); // �ؽ�Ʈ�ʵ忡  Action������ ���
		
		// Text������ ���� TextField
		tfContents = new JTextField("");
		tfContents.addActionListener(ml2); // �ؽ�Ʈ�ʵ忡  Action������ ���
		
		panelCenter.add(panelFont);
		panelCenter.add(panelStyle);
		panelCenter.add(tfSize);
		panelCenter.add(tfContents);
		
		
		// �����̳��� South�� ������ ������Ʈ
		JPanel panelBottom = new JPanel(); 		
		panelBottom.setLayout(new FlowLayout());
		Border resultBorder = BorderFactory.createTitledBorder("Font ���� ���"); // ������ �ٿ��� ��踦 ����
		panelBottom.setBorder(resultBorder);
		lblResult = new JLabel(" "); // Font���� ����� ��Ÿ���� ����, Label��ü ����
		panelBottom.add(lblResult);
		
		c.add(panelLeft,BorderLayout.WEST);
		c.add(panelCenter, BorderLayout.CENTER);
		c.add(panelBottom, BorderLayout.SOUTH);
		
		setSize(300,300);
		setVisible(true);
	}
	// ����Ŭ������ Item������ ����
	class MyItemListener implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			if(rbG.isSelected())  // Font 
				font = "����";
			else if(rbD.isSelected())
				font = "����";
			else if(rbGo.isSelected())
				font = "�ü�";
			if(cbBold.isSelected() && cbItalic.isSelected()) // Style
				style = Font.BOLD + Font.ITALIC;
			else if(cbBold.isSelected())
				style = Font.BOLD;
			else if(cbItalic.isSelected())
				style = Font.ITALIC;
			else
				style = Font.PLAIN;
			lblResult.setFont(new Font(font, style, size)); // Label��ü�� Font,Style ����
			
		}
		
	}
	// ����Ŭ������ Action������ ����
	class MyActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == tfSize){   // Size����
				size = Integer.parseInt(tfSize.getText());
				lblResult.setFont(new Font(font, style, size));
		}
			if(e.getSource() == tfContents) {  // Text����
				lblResult.setText(tfContents.getText()+" ");
			}
		}
		
	}
	public static void main(String[] args) {
		new FontTest();
	}

}
