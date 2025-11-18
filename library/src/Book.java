public class Book {
    String title;
    String author;
    boolean isBorrowed;

    public Book() {
    }

    public Book(String title, String author, boolean isBorrowed) {
        this.title = title;
        this.author = author;
        this.isBorrowed = isBorrowed;
    }

    /**
     * 获取
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取
     * @return author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * 设置
     * @param author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * 获取
     * @return isBorrowed
     */
    public boolean isIsBorrowed() {
        return isBorrowed;
    }

    /**
     * 设置
     * @param isBorrowed
     */
    public void setIsBorrowed(boolean isBorrowed) {
        this.isBorrowed = isBorrowed;
    }

    public String toString() {
        return "Book{title = " + title + ", author = " + author + ", isBorrowed = " + isBorrowed + "}";
    }
}
