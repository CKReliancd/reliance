package com.atguigu.controller;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.atguigu.bean.Book;

/**
 * ModelAttributes；
 * 书城修改图书为例；
 * 前端页面：<form>图书信息</form>
 * Controller程序：public String addBook(Book book)；
 * Dao程序：bookDao.update(book);
 * 
 * 
 * 如果那些不改，不携带这个字段；
 * 三个字段；price，sales，stock；
 * 其他没有带的字段；
 * Book book;book没带的字段封装为null；
 * 
 * 
 * 全字段修改
 * String sql="update bs_book set title=?,author=?,price=?,"
 * + "sales=?,stock=?,img_path=? where id=?";
 * 
 * return update(sql, book.getTitle(),book.getAuthor(),book.getPrice(),
 * book.getSales(),book.getStock(),book.getImgPath(),book.getId());
 * 
 * 
 * 问题：
 * 1、没携带的字段，封装为null，直接进行数据库保存，会将原有的字段覆盖为null；
 * 解决：
 * 1）、页面提交数据
 * 2）、String updateBook(Book book)；自动封装页面数据到book对象
 * 3）、不能直接将book对象传给dao，因为没有带的字段是null
 * 4）、传给dao之前，查询这本图书的原来信息
 * 5）、把页面带来的信息，重新封装进原来的图书信息中，没带的字段不封装；
 * 6）、把查出来并封装设置好的对象传给dao；
 * 
 * 根本的解决方案；
 * public String updateBook(Book book)
 * 1、创建一个book对象 new Book();
 * 2、把book中每个属性的值从请求参数中获取出来并设置上；
 * 
 * 变成这样？
 * 1、从数据库中获取到这个book对象；（3个属性值）
 * 2、把book中每个属性的值从请求参数中获取出来并设置上（请求参数带了2个）；
 * 
 * @author lfy
 *
 */
@Controller
public class ModelAttributesTest {
	
	
	/**@ModelAttribute("book")
	 * 标注在参数位置，可以取出之前保存在map中的值，给map中放值是在方法提前运行的时候放的
	 * 
	 * 一个放，一个取对于方法参数是自定义类型的javaBean，pojo有用
	 * 
	 * 1、
	 * @param book
	 * @return
	 */
	@RequestMapping("/updateBook")
	public String updateBook(@ModelAttribute("haha")Book book){
		
		System.out.println("保存了图书："+book);
		return "WEB-INF/success";
	}
	
	/**
	 * @Target({ElementType.PARAMETER, ElementType.METHOD})
	 * 
	 * 1、METHOD：标注在方法位置；
	 * 		标注了ModelAttribute的方法会提前于所有目标方法运行之前运行；
	 * 2、方法提前运行，给map中保存好数据库中查出的图书记录
	 * 3、在目标方法上使用@ModelAttribute("key")取出刚才map中保存的值；
	 * 
	 * 
	 * 原理：
	 * 确定book的值的时候，@ModelAttribute("book")可以从之前给map中保存的数据中
	 * 拿到旧的book对象进行封装；
	 * 
	 * 
	 * 方法位置：
	 * 1、@ModelAttribute能让方法提前
	 * 2、把方法的返回值自动的放在map中，map的key默认就是返回值类型首字母小写book
	 * 3、改变map中默认的key
	 */
	@ModelAttribute("haha")
	public Book getBook(){
		Book book = new Book();
		book.setAuthor("lfy");
		book.setBookName("java入门到xxx");
		book.setId(1);
		book.setPrice(98.98);
		book.setSales(100);
		book.setStock(9999);
		//map.put("booka", book);
		System.out.println("数据库中的书："+book);
		return book;
	}

}
