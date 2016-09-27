package com.sasd13.goinfromania.view.menu;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import com.sasd13.goinfromania.controller.menu.file.EnumMenuFileType;
import com.sasd13.goinfromania.controller.menu.file.MenuFileController;

public class MenuFile extends JMenu {

	public MenuFile() {
		super("Fichier");

		buildItems(new MenuFileController());
		setMnemonic(KeyEvent.VK_F);
	}

	private void buildItems(MenuFileController controller) {
		JMenuItem menuItemNew = new JMenuItem("Nouveau");
		menuItemNew.setActionCommand(EnumMenuFileType.NEW.getCode());
		menuItemNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		menuItemNew.addActionListener(controller);
		add(menuItemNew);

		JMenuItem menuItemOpen = new JMenuItem("Open");
		menuItemOpen.setActionCommand(EnumMenuFileType.OPEN.getCode());
		menuItemOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		menuItemOpen.addActionListener(controller);
		add(menuItemOpen);

		JMenuItem menuItemExit = new JMenuItem("Exit");
		menuItemExit.setActionCommand(EnumMenuFileType.EXIT.getCode());
		menuItemExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));
		menuItemExit.addActionListener(controller);
		add(menuItemExit);
	}
}
