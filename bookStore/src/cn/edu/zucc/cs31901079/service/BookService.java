package cn.edu.zucc.cs31901079.service;

import cn.edu.zucc.cs31901079.bean.Book;

import java.util.List;

public interface BookService {
    public void addBook(Book book);
    public void deleteBookById(Integer id);

    public void updateBook(Book book);
    public Book queryBookById(Integer id);
    public List<Book> queryBooks();
}
