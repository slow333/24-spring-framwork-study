package spfw.spring02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spfw.Book;
import spfw.spring02.component.MyDao;
import spfw.spring02.component.MyService;

public class SpringApplicationContextEx {
  public static void main(String[] args) {
    // 인스턴스를 인터페이스 타입으로 참조 할 수 있다.
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    MyService myService = context.getBean("myService", MyService.class);
    MyDao myDao = context.getBean("myDao", MyDao.class);

//    myService.setMyDao(myDao); // xml에서 설정할 수 있음
    myService.service();
  }
}
