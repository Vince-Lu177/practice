package Practice_0524_Library.Action;

import Practice_0524_Library.Book.Book;
import Practice_0524_Library.Book.BookList;

import java.util.Scanner;

public class ReturnAction implements IAction{

    @Override
    public void work(BookList bookList) {
        System.out.println("执行还书操作");
        System.out.println("请输入您要还的书籍");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        for (int i = 0; i < bookList.getSize(); i++) {
            Book book = bookList.getBook(i);
            if(book.getName().equals(name)){
                if(book.isBorrowed()){
                    book.setBorrowed(false);
                    System.out.println("还书成功");
                    return;
                }
            }
        }
        System.out.println("还书失败");
    }
}
