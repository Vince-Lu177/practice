package Practice_0524_Library.Action;

import Practice_0524_Library.Book.BookList;

public class ExitAction implements IAction{
    @Override
    public void work(BookList bookList) {
        System.out.println("goodbye");
        System.exit(0);
    }
}
