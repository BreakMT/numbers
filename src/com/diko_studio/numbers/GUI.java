package com.diko_studio.numbers;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.diko_studio.numbers.number.InnFL;
import com.diko_studio.numbers.number.InnUL;
import com.diko_studio.numbers.number.Kpp;
import com.diko_studio.numbers.number.OgrnIP;
import com.diko_studio.numbers.number.OgrnUL;
import com.diko_studio.numbers.number.OkpoIP;
import com.diko_studio.numbers.number.OkpoUL;
import com.diko_studio.numbers.number.Snils;

public class GUI extends JFrame implements ClipboardOwner {

	private static final long serialVersionUID = 1L;
	public static final int WINDOW_WIDTH = 300;
	public static final int WINDOW_HEIGHT = 300;
	
	private Numbers numbers;	
	
	JTextField textInnUL;
	JTextField textInnFL;
	JTextField textKpp;
	JTextField textOgrnUL;
	JTextField textOgrnIP;
	JTextField textOkpoUL;
	JTextField textOkpoIP;
	JTextField textSnils;
	
	public GUI(Numbers numbers) throws HeadlessException {
		super(Main.APP_TITLE + " " + Main.APP_VERSION);

		this.numbers = numbers;
		
		// ИНН ЮЛ
		Box boxInnUL = Box.createHorizontalBox();
		
		textInnUL = new JTextField();
		textInnUL.setEditable(false);
		JButton copyInnUL = new JButton("Copy");
		copyInnUL.addActionListener(new copyInnUL());
		
		boxInnUL.add(new JLabel(InnUL.title + ": "));
		boxInnUL.add(textInnUL);
		boxInnUL.add(copyInnUL);

		// ИНН ИП
		Box boxInnFL = Box.createHorizontalBox();
		
		textInnFL = new JTextField();
		textInnFL.setEditable(false);
		JButton copyInnFL = new JButton("Copy");
		copyInnFL.addActionListener(new copyInnFL());
		
		boxInnFL.add(new JLabel(InnFL.title + ": "));
		boxInnFL.add(textInnFL);
		boxInnFL.add(copyInnFL);
		
		// КПП
		Box boxKpp = Box.createHorizontalBox();
		
		textKpp = new JTextField();
		textKpp.setEditable(false);
		JButton copyKpp = new JButton("Copy");
		copyKpp.addActionListener(new copyKpp());
		
		boxKpp.add(new JLabel(Kpp.title + ": "));
		boxKpp.add(textKpp);
		boxKpp.add(copyKpp);
		
		// ОГРН ЮЛ
		Box boxOgrnUL = Box.createHorizontalBox();
		
		textOgrnUL = new JTextField();
		textOgrnUL.setEditable(false);
		JButton copyOgrnUL = new JButton("Copy");
		copyOgrnUL.addActionListener(new copyOgrnUL());
		
		boxOgrnUL.add(new JLabel(OgrnUL.title + ": "));
		boxOgrnUL.add(textOgrnUL);
		boxOgrnUL.add(copyOgrnUL);
		
		// ОГРН ИП
		Box boxOgrnIP = Box.createHorizontalBox();
		
		textOgrnIP = new JTextField();
		textOgrnIP.setEditable(false);
		JButton copyOgrnIP = new JButton("Copy");
		copyOgrnIP.addActionListener(new copyOgrnIP());
		
		boxOgrnIP.add(new JLabel(OgrnIP.title + ": "));
		boxOgrnIP.add(textOgrnIP);
		boxOgrnIP.add(copyOgrnIP);
		
		// ОКПО ЮЛ
		Box boxOkpoUL = Box.createHorizontalBox();
		
		textOkpoUL = new JTextField();
		textOkpoUL.setEditable(false);
		JButton copyOkpoUL = new JButton("Copy");
		copyOkpoUL.addActionListener(new copyOkpoUL());
		
		boxOkpoUL.add(new JLabel(OkpoUL.title + ": "));
		boxOkpoUL.add(textOkpoUL);
		boxOkpoUL.add(copyOkpoUL);
		
		// ОКПО ИП
		Box boxOkpoIP = Box.createHorizontalBox();
		
		textOkpoIP = new JTextField();
		textOkpoIP.setEditable(false);
		JButton copyOkpoIP = new JButton("Copy");
		copyOkpoIP.addActionListener(new copyOkpoIP());
		
		boxOkpoIP.add(new JLabel(OkpoIP.title + ": "));
		boxOkpoIP.add(textOkpoIP);
		boxOkpoIP.add(copyOkpoIP);
		
		// СНИЛС
		Box boxSnils = Box.createHorizontalBox();
		
		textSnils = new JTextField();
		textSnils.setEditable(false);
		JButton copySnils = new JButton("Copy");
		copySnils.addActionListener(new copySnils());
		
		boxSnils.add(new JLabel(Snils.title + ": "));
		boxSnils.add(textSnils);
		boxSnils.add(copySnils);
		
		// Кнопка
		JPanel buttonPanel = new JPanel();	
		JButton buttonRegenerate = new JButton("Regenerate");
		buttonRegenerate.addActionListener(new regenerateListener());
		buttonPanel.add(buttonRegenerate);

		// Скомпоновать по-вертикали
		Box commonBox = Box.createVerticalBox();
		commonBox.add(boxInnUL);
		commonBox.add(boxInnFL);
		commonBox.add(boxKpp);
		commonBox.add(boxOgrnUL);
		commonBox.add(boxOgrnIP);
		commonBox.add(boxOkpoUL);
		commonBox.add(boxOkpoIP);
		commonBox.add(boxSnils);
		commonBox.add(buttonPanel);
		
		getContentPane().add(BorderLayout.NORTH, commonBox);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setLocationRelativeTo(null);
		setResizable(false);
		
		updateTextFields();
	}

	public void updateTextFields() {
		textInnUL.setText(numbers.innUL.getNumber());
		textInnFL.setText(numbers.innFL.getNumber());
		textKpp.setText(numbers.kpp.getNumber());
		textOgrnUL.setText(numbers.ogrnUL.getNumber());
		textOgrnIP.setText(numbers.ogrnIP.getNumber());
		textOkpoUL.setText(numbers.okpoUL.getNumber());
		textOkpoIP.setText(numbers.okpoIP.getNumber());
		textSnils.setText(numbers.snils.getNumber());
	}
	
	public void setClipboardContents(String aString){
		StringSelection stringSelection = new StringSelection(aString);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, this);
	}	
	
	class copyInnUL implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			setClipboardContents(numbers.innUL.getNumber());
		}		
	}
	
	class copyInnFL implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			setClipboardContents(numbers.innFL.getNumber());
		}		
	}

	class copyKpp implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			setClipboardContents(numbers.kpp.getNumber());
		}		
	}
	
	class copyOgrnUL implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			setClipboardContents(numbers.ogrnUL.getNumber());
		}		
	}
	
	class copyOgrnIP implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			setClipboardContents(numbers.ogrnIP.getNumber());
		}		
	}
	
	class copyOkpoUL implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			setClipboardContents(numbers.okpoUL.getNumber());
		}		
	}
	
	class copyOkpoIP implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			setClipboardContents(numbers.okpoIP.getNumber());
		}		
	}
	
	class copySnils implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			setClipboardContents(numbers.snils.getNumber());
		}		
	}
	
	class regenerateListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			numbers.regenerateAll();
			updateTextFields();
		}		
	}

	@Override
	public void lostOwnership(Clipboard arg0, Transferable arg1) {
	}	

}
