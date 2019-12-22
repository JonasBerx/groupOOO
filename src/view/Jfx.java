package view;
	
import javafx.scene.control.Alert;
import model.DomainFacade;
import view.jfx.Helpers;
import view.jfx.cashier.Stage;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;

public class Jfx extends javafx.application.Application implements ViewStrategy {
	@Override
	public void start(javafx.stage.Stage primaryStage)  {
		try {
			startUnchecked();
		} catch (Exception e) {
			e.printStackTrace();
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			Helpers.alert(
					Alert.AlertType.ERROR,
					"Error starting ShopApp",
					"A unknown fatal error occurred while starting ShopApp. \n" +
							"Full stack-trace was printed to console. Exiting...",
					e.toString()
			);
		}
	}

	public void startUnchecked() throws IOException {
		DomainFacade domainFacade = new DomainFacade();
		Stage cashierStage = new Stage(domainFacade);
		new controller.cashier.Stage(domainFacade, cashierStage);
		view.jfx.client.Stage clientStage = new view.jfx.client.Stage();
		new controller.client.Stage(domainFacade, clientStage);
	}

	public void main(String[] args) {
		launch(args);
	}
}
