package database;

import newDatabase.ArticleCSVLoadSave;
import newDatabase.ArticleTekstLoadSave;

public enum LoadSaveStrategyEnum {
    EXCEL(ExcelAdapter.class),
    TXT(ArticleTekstLoadSave.class),
    CSV( ArticleCSVLoadSave.class);


    private final Class aClass;
    LoadSaveStrategyEnum(Class aClass) {

        this.aClass = aClass;
    }

    // Kunnen enum als extension schrijven
    // path is dan = articles.ENUM
    // Props to Andreas

//    public String getThePath() {
//        return path;
//    }

    public Class getTheClass() {
        return this.aClass;
    }

}