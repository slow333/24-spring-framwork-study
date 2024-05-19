
## EJB(Enterprise JavaBeans)
- EJB는 에프리케이션 작성을 쉽게 해준다
- 그러나 개발도 힘들고, 배포도 힘들고...
   - 그래서 J2EE 등장
-----
- J2EE , expert one-on-one, 로드 존슨
    - spring을 소개한다.
    - EJB가 했던 일들을 더욱 간단한 Java Bean이 처리할 수 있게된다.
-----
# Bean 이란 ?
- Java에서 인스턴스 생성
```
 Book book = new Book();
```
- Bean은 컨테이너가 관리하는 객체
    - 객체의 생명주기를 컨테이너가 관리
    - 객체를 싱글톤으로 만들것인지, 프로토타입으로 만들 것인지
---
Bean은 컨테이너에서 관리하게 해주는 것
# 스프링의 핵심 기능 1
- 관점지향 컨테이너
    - 빈을 생성, 관리해주는 것.
    - 관점지향(AOP, aspect-oriented programming)
---
# java
 - 변수: field 라고 함
 - method: Property라고 함

# ApplicationContext
- ApplicationContext는 다양한 인터페이스를 상속받고 있다.
- 스프링 컨테이너의 핵심 인터페이스
```
org.springframework.context;
Interface ApplicationContext;
```
- 그중에서도 BeanFactory도 ApplicationContext는 상속받는다.
```
org.springframework.beans.facotry 
Inteface BeanFatory
```
---
# ApplicationContext를 구현하고 있는 대표적인 클래스
- CLASSPATH에서 XML 설정파일을 읽어들여 동작한다.
```
org.springframework.context.support
Class ClassPathXmlApplicationContext
```
---
## 스프링 프레임워크의 핵심 모듈
- Core Container 부분이 핵심
- Gradle에서 아래의 라이브러리를 추가한다.

  implementation group: 'org.springframework', name: 'spring-context', version: '6.1.7'
![img_6.png](img_6.png)
- 이 안에서 aop, beans,context, core, expression에 대해 의존성을 갖음
---
# Spring ApplicationContext 사용
```Java
public class SpringApplicationContextEx {
  public static void main(String[] args) {
    // 인스턴스를 인터페이스 타입으로 참조 할 수 있다.
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    Book book2 =(Book)context.getBean("book1");

    book2.setPrice(2000);
    book2.setTitle("moving body");

    System.out.println(book2.getPrice());
    System.out.println(book2.getTitle());

    Book book3 =(Book)context.getBean("book1");
    System.out.println(book3.getTitle());
  }
}
```
---
# MyDao와 MyService의 클래스 다이어그램
- 연관관계
  - MyService가 MyDao를 가진다.
![img_5.png](img_5.png)
---
# MyService & MyDao
- 프로그래머가 직접 인스턴스를 생성하고 주입
- setter 주입
```
MyService myService = new MyService();
MyDao myDao = new MyDao();
myService.setMyDao(myDao);
```
- 생성자에 주입
```
 MyService myService = new MyService(new MyDao());
```
---
# 스프링 설정으로 주입
```
 MyService myService = new MyService();
 MyDao myDao = new MyDao();
 myService.setMyDao(myDao);
```
resources/applicationContext.xml

```
   <bean id="myService" class="spfw.spring02.component.MyService">
<!--        set myDao-->
       <property name="myDao" ref="myDao"></property>
                  -- setMyDao 와 같음 --
   </bean>
   <bean id="myDao" class="spfw.spring02.component.MyDao"/>
```
---