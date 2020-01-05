package com.atguigu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.dao.BookDao_stu;
import com.atguigu.pojo.Book;

@Service
public class BookService_stu {

	@Autowired
	private BookDao_stu bookDao;

	public void saveBook(Book book) {
		bookDao.saveBook(book);
	}

	public void deleteBookById(Integer id) {
		bookDao.deleteBookById(id);
	}

	public void updateBook(Book book) {
		bookDao.updateBook(book);
	}

	public Book queryBookById(Integer id) {
		return bookDao.queryBookById(id);
	}

	public List<Book> queryList() {
		return bookDao.queryList();
	}

}

