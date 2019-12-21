package model.article;

/**
 * @Author Jonas Berx
 * @Version 1.1
 * changed Dieters author sign to correct javadoc
 */

/**@Author Dieter Draelants
 * Article class
 */

public class Article implements Comparable<Article> {
    private final int articleCode;
    private int quantity;
    private String articleName, group;
    private double price;

    public Article(int articleCode, String name, String group, double price, int quantity) {
        checkArticleCode(articleCode);
        this.articleCode = articleCode;
        setName(name);
        setGroup(group);
        setPrice(price);
        setQuantity(quantity);
    }

    public int getArticleCode() {
        return articleCode;
    }

    public void checkArticleCode(int articleCode) {
        if (articleCode <= 0) {
            throw new IllegalArgumentException("Article code cannot be zero or less");
        }
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("You can't add 0 or less articles");
        }
        this.quantity = quantity;
    }

    public String getName() {
        return articleName;
    }

    public void setName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("You should give your product a name");
        }
        this.articleName = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        String pattern = "^gr[1-9][0-9]*$";
        if (group.trim().isEmpty()) {
            throw new IllegalArgumentException("Your product should be in a group");
        }
        if (!group.matches(pattern)) {
            throw new IllegalArgumentException("Your group notation doesn't match the required notation \n it should be like this: ^gr[1-9][0-9]*$");
        }
        this.group = group;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Je prijs kan niet negatief zijn");
        }
        this.price = price;
    }

    //Pretty To String
    public String toString() {
        String out = "";
        out += "\nCode: " + getArticleCode() + "\nName: " + getName() + "\nGroup: " + getGroup() + "\nPrice: " + getPrice() + "\nStock: " + getQuantity() + "\n-------------------";
        return out;
    }

    //To string for csv file
    public String saveToString() {
        String out = "";
        out += getArticleCode() + "," + getName() + "," + getGroup() + "," + getPrice() + "," + getQuantity() + "\n";
        return out;
    }

    //    CompareTo for sorting the Observable list
    @Override
    public int compareTo(Article toCompare) {
        if (toCompare == null)
            throw new IllegalArgumentException("<toCompare> cannot be null");

        return this.getName().compareTo(toCompare.getName());
    }
}
