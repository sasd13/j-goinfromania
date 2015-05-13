package view;

import game.util.ImageLoader;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.GameController;

public class HomeView extends JPanel implements ActionListener {

	private JButton buttonPlay, buttonContinue;
	
	public HomeView() {
		super();
		
		setLayout(null);
		
		JPanel panelButton = new JPanel(new BorderLayout());
		panelButton.setOpaque(false);
		panelButton.setBounds(320, 480, 150, 90);
		add(panelButton);
		
		Dimension dimension = new Dimension(150, 40);
		
		this.buttonPlay = new JButton("PLAY");
		this.buttonPlay.setPreferredSize(dimension);
		this.buttonPlay.addActionListener(this);
		panelButton.add(this.buttonPlay, BorderLayout.NORTH);
		
		this.buttonContinue = new JButton("CONTINUE");
		this.buttonContinue.setPreferredSize(dimension);
		this.buttonContinue.addActionListener(this);
		panelButton.add(this.buttonContinue, BorderLayout.SOUTH);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		BufferedImage image = ImageLoader.loadFromPath("home.png");
		
		g.drawImage(image, 0, 0, this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		
		if (button == this.buttonPlay) {
			GameController.getInstance().newRound();
		} else if (button == this.buttonContinue) {
			GameController.getInstance().displayListRounds();
		}
	}
}
