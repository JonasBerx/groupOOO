package newDatabase;

import model.Article;

import java.util.ArrayList;

public interface LoadSaveStrategy {

    ArrayList<Article> load();

    void save(ArrayList<Article> articles);
}