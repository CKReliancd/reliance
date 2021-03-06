package com.atguigu.service.test;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.atguigu.pojo.Book;
import com.atguigu.service.BookService_stu;

@ContextConfiguration(locations = "classpath:springmvc_stu.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class BookServiceTest_stu {

	@Autowired
	private BookService_stu bookService;

	@Test
	public void testSaveBook() {
		bookService.saveBook(new Book(null, "xxx", "asfd", new BigDecimal(199),
				1234, 1234));
	}

	@Test
	public void testDeleteBookById() {
		bookService.deleteBookById(23);
	}

	@Test
	public void testUpdateBook() {
		bookService.updateBook(new Book(22, "我被修改了！！哈哈", "asfd",
				new BigDecimal(199), 1234, 1234));
	}

	@Test
	public void testQueryBookById() {
		System.out.println(bookService.queryBookById(1));
	}

	@Test
	public void testQueryList() {
		System.out.println(bookService.queryList().size());
	}





















}
