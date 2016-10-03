package com.sasd13.goinfromania.controller.menu.file;

import com.sasd13.goinfromania.bean.EnumState;
import com.sasd13.goinfromania.bean.Game;
import com.sasd13.goinfromania.controller.IAction;
import com.sasd13.goinfromania.controller.IFrame;
import com.sasd13.goinfromania.dao.GameDAO;
import com.sasd13.goinfromania.engine.GameHandler;

public class MenuFileActionOpen implements IAction {

	private Game game;

	public void setGame(Game game) {
		this.game = game;
	}

	@Override
	public void execute(IFrame frame) {
		if (game != null && game.getState().getOrder() < EnumState.DESTROYED.getOrder()) {
			GameHandler.finishGame(game, frame);
		}

		if (game == null || game.getState() == EnumState.DESTROYED) {
			frame.displayGames(GameDAO.loadAll());
		}
	}
}
