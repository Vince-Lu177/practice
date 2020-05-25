package Practice_0524_Library.Action;

import Practice_0524_Library.Book.Book;
import Practice_0524_Library.Book.BookList;

import java.util.Scanner;

public class BorrowAction implements IAction{
    @Override
    public void work(BookList bookList) {
        System.out.println("执行借书操作");
        System.out.println("请输入您要借的书籍: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        for (int i = 0; i < bookList.getSize(); i++) {
            Book book = bookList.getBook(i);
            if (book.getName().equals(name)) {
                if (book.isBorrowed()) {
                    continue;
                } else {
                    book.setBorrowed(true);
                    System.out.println("借书成功");
                    return;
                }
            }
        }
        System.out.println("结束失败! 没有匹配到书籍");
    }
}
