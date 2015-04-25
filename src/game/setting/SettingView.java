package game.setting;

import game.Game;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SettingView extends JFrame implements Observer {

	public static final String BUTTONCLOSE_NAME = "Close";
	public static final String BUTTONRESET_NAME = "Reset";
	
	private JButton buttonClose, buttonReset;
	
	public SettingView() {
		super();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setPreferredSize(new Dimension(DimensionConstants.FRAME_WIDTH_MEDIUM, DimensionConstants.FRAME_HEIGHT_MEDIUM));
		
		setTitle(Game.NAME);
		
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		getContentPane().add(panel, BorderLayout.SOUTH);
		
		java.awt.Dimension dimen = new java.awt.Dimension(DimensionConstants.BUTTON_WIDTH, DimensionConstants.BUTTON_HEIGHT);
		
		this.buttonClose = new JButton(BUTTONCLOSE_NAME);
		this.buttonClose.setPreferredSize(dimen);
		panel.add(this.buttonClose);
		
		this.buttonReset = new JButton(BUTTONRESET_NAME);
		this.buttonReset.setPreferredSize(dimen);
		panel.add(this.buttonReset);
	}
	
	@Override
	public void update(Observable observable, Object arg) {
		final Setting setting = (Setting) observable;
		
		SettingViewListener listener = new SettingViewListener(setting, this);
		if(this.buttonClose.getActionListeners().length == 0) {
			this.buttonClose.addActionListener(listener);
		}
		
		if(this.buttonReset.getActionListeners().length == 0) {
			this.buttonReset.addActionListener(listener);
		}
	}
}
