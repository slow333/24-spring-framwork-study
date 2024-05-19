package spfw.spring02.component;

public class MyService extends MyDao {

  private MyDao myDao;

  // setter 메소드 또느 myDao 프로퍼티
  public void setMyDao(MyDao myDao) {
    this.myDao = myDao;
  }

  public void service() {
    System.out.println("MyService.service()");
    myDao.get();
  }
}
