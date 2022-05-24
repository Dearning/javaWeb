package cn.edu.zucc.cs31901079.dao;

import cn.edu.zucc.cs31901079.bean.Book;

import java.util.List;

public interface BookDao {
    public int addBook(Book book);
    public int deleteBookById(Integer id);
    public int updateBook(Book book);
    public Book queryBookById(Integer id);
    public List<Book> queryBooks();
}
