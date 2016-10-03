package com.sasd13.goinfromania.controller.result;

import com.sasd13.goinfromania.bean.Game;
import com.sasd13.goinfromania.controller.IAction;
import com.sasd13.goinfromania.controller.IDialog;
import com.sasd13.goinfromania.controller.IFrame;
import com.sasd13.goinfromania.engine.GameHandler;

public class GameResultActionFinish implements IAction {

	private IDialog dialog;
	private Game game;

	public GameResultActionFinish(IDialog dialog, Game game) {
		this.dialog = dialog;
		this.game = game;
	}

	@Override
	public void execute(IFrame frame) {
		GameHandler.finishGame(game);
		dialog.dispose();
		frame.displayHome();
	}
}
