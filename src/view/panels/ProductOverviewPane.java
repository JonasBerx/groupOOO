package view.panels;

import database.ArticleDbInMemory;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import model.Article;
import sun.util.locale.provider.JRELocaleProviderAdapter;

import java.io.FileNotFoundException;


public class ProductOverviewPane extends GridPane {
	//private TableView<Product> table;


	public ProductOverviewPane() throws FileNotFoundException {
		this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);
        
		this.add(new Label("Products:"), 0, 0, 1, 1);
		this.add(new Label("Code"), 0, 1, 1, 1);
		this.add(new Label("Omschrijving"), 1, 1, 1, 1);
		this.add(new Label("Groep"), 2, 1, 1, 1);
		this.add(new Label("Prijs"), 3, 1, 1, 1);

		/*
		@Author Dieter Draelants
		Uitlezen van hashmap naar de artikelen pagina

		!Moet nog geoptimaliseert worden!
		 */

		ArticleDbInMemory db = new ArticleDbInMemory();
		db.read("C:\\Users\\diete\\Documents\\2TI.Sem1\\OOO\\Groepwerk\\groupOOO\\src\\bestanden\\articles.csv");
		int i = 0;
		for (Article a : db.returnDb().values()) {
			this.add(new Label(String.valueOf(a.getArticleCode())), 0, i + 2, 1, 1);
			this.add(new Label(a.getArticleName()), 1, i + 2, 1, 1);
			this.add(new Label(a.getGroup()), 2, i + 2, 1, 1);
			this.add(new Label(String.valueOf(a.getPrice())), 3, i + 2, 1, 1);
			i++;
		}


	}
	
	

}
