//sg
/*
    "Copyright 2011 CSE DEPTT. BVCOE  <http://bvcoend.ac.in/Deptt_CSE.asp>"
    
     This file is part of Weka Grain.

    Weka Grain is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Weka Grain is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Weka Grain.  If not, see <http://www.gnu.org/licenses/>.*/

package com.wekagrain.bvp;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class MainWindow {

	private JFrame frame;
	 JFileChooser fc;
	 ImageIcon ic;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		 fc = new JFileChooser();
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(238, 232, 170));
		frame.setBounds(150, 150, 671, 444);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		final JTextArea txtrSg = new JTextArea();
		txtrSg.setForeground(SystemColor.textHighlight);
		txtrSg.setToolTipText("ATTRIBUTE_NAME:DATATYPE");
		txtrSg.setBackground(Color.WHITE);
		txtrSg.setFont(new Font("SansSerif", Font.BOLD, 15));
		txtrSg.setLineWrap(true);
		txtrSg.setBounds(27, 108, 240, 150);
		frame.getContentPane().add(txtrSg);
		JLabel lblEnterYourGrain = new JLabel("Enter Your Grain String");
		lblEnterYourGrain.setBounds(50, 81, 175, 15);
		frame.getContentPane().add(lblEnterYourGrain);
		String infoStr="Data Types Available\n1. name : Name  \n2. int_id : Integer ID" +
				"\n3. dept: Department\n4. yn : Yes /No\n5. tf : True / False\n6. gender :" +
				" Gender\n7. ph : Mobile Phone Number\n8. clang : Computer Language\n9. grocery : Grocery Item\n10. state : Indian State and UT" +
				"\n11. weather:Weather Conditions\n12. marks : Marks (out of 100) ";
		JTextPane txtpnSg = new JTextPane();
		txtpnSg.setEditable(false);
		txtpnSg.setBackground(SystemColor.info);
		txtpnSg.setText(infoStr);
		txtpnSg.setBounds(402, 81, 240, 239);
		frame.getContentPane().add(txtpnSg);
		java.net.URL imgURL = getClass().getResource("grain.png");
		 ic=new ImageIcon(imgURL,"LOTS OF GRAIN!");
		
		JLabel lblWekaGrainfoodFor = new JLabel("WEKA GRAIN:FOOD FOR WEKA",ic,JLabel.CENTER);
		lblWekaGrainfoodFor.setForeground(new Color(105, 105, 105));
		lblWekaGrainfoodFor.setFont(new Font("PakType Tehreer", Font.BOLD, 14));
		lblWekaGrainfoodFor.setBounds(174, 12, 340, 40);
		frame.getContentPane().add(lblWekaGrainfoodFor);
		
		final JSpinner spinner = new JSpinner();
		spinner.setBounds(174, 268, 69, 20);
		spinner.setValue((Integer)3);
		frame.getContentPane().add(spinner);
		
		JLabel lblSelectNumberOf = new JLabel("How many records?");
		lblSelectNumberOf.setBounds(27, 273, 167, 15);
		frame.getContentPane().add(lblSelectNumberOf);
		JButton btnGetCsv = new JButton("Generate Data");
		btnGetCsv.setBounds(291, 352, 152, 25);
		frame.getContentPane().add(btnGetCsv);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(291, 63, -11, 145);
		frame.getContentPane().add(separator);
		
		JLabel lblTypeOfRecord = new JLabel("Type Of Record File");
		lblTypeOfRecord.setBounds(27, 305, 143, 15);
		frame.getContentPane().add(lblTypeOfRecord);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"arff", "csv"}));
		comboBox.setBounds(174, 296, 69, 24);
		frame.getContentPane().add(comboBox);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmAboutWekaGrain = new JMenuItem("About Weka Grain");
		mntmAboutWekaGrain.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String aboutMessage="Weka Grain (c) generates (random) data " +
						"and can be used for \nstudying data analysers like weka (These guys like it when they are given data in tons :) )" +
						"\n                         current Version 1.1\n                         DEPT OF CSE ,BVCOE, NEW DELHI";
				JOptionPane.showMessageDialog(frame,aboutMessage,"About Weka Grain",JOptionPane.INFORMATION_MESSAGE,ic );
				
			}
			
			
		});
		mnFile.add(mntmAboutWekaGrain);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent ae)
			{
				System.exit(0);
			}
		});
		
		mnFile.add(mntmExit);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmWritingTheGrain = new JMenuItem("Writing the grain string");
		mnHelp.add(mntmWritingTheGrain);
		mntmWritingTheGrain.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{
				
				String helpMessage="\nThe format is \"attribute name:datatype\" with attribute names seperated " +
						"by a semicolon (;)\n\neg \"emp_id:int_id;emp_name:name;emp_ph:ph;emp_mgr:yn\"\n\nPlease note that there should not be any space in the attribute name\nIn case the csv file generated is incorrect,check your grain string and try again";
				JOptionPane.showMessageDialog(frame,helpMessage ,"Writing the Grain String (it's easy :) )", JOptionPane.INFORMATION_MESSAGE,ic);
			}
		});
		btnGetCsv.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent ae)
		{
			String grain=txtrSg.getText();
			if(grain.length()==0)
			{
				JOptionPane.showMessageDialog(frame,"No Grain String Entered !","Are You Testing Me?",JOptionPane.INFORMATION_MESSAGE,ic );
			}
			else
			{
				int typeOfFile=comboBox.getSelectedIndex();
			fc.showSaveDialog(frame);
			File f=fc.getSelectedFile();
			int numRec=(Integer)spinner.getValue();
			new GrainStringParser(grain,numRec,typeOfFile,f);
			}
			}
		});
		
	}
}

