package view;


import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import model.Shop;
import view.panels.CashierProductOverviewPane;
import view.panels.CashierSalesPane;
import view.panels.CashierSettingsPane;

import java.io.FileNotFoundException;

class CashRegisterMainPane extends BorderPane {
    private CashierProductOverviewPane cashierProductOverviewPane;
    private CashierSettingsPane settingsPane;
    private CashierSalesPane salesPane;
    private Shop shop;
    CashRegisterMainPane() throws FileNotFoundException {
        shop = new Shop();
        cashierProductOverviewPane = new CashierProductOverviewPane(shop);
        salesPane = new CashierSalesPane(shop);
        settingsPane = new CashierSettingsPane(shop);

	    TabPane tabPane = new TabPane();
        Tab kassaTab = new Tab("Kassa", salesPane);
        Tab artikelTab = new Tab("Artikelen", cashierProductOverviewPane);
        Tab instellingTab = new Tab("Instellingen", settingsPane);
        Tab logTab = new Tab("Log");
        tabPane.getTabs().add(kassaTab);
        tabPane.getTabs().add(artikelTab);
        tabPane.getTabs().add(instellingTab);
        tabPane.getTabs().add(logTab);
	    this.setCenter(tabPane);
	}

    public Shop getShop() {
        return shop;
    }
}
