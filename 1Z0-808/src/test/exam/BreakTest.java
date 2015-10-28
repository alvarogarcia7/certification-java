package test.exam;

public class BreakTest {

  @Test public void test_1() {
      System.out.println("0");
      PARENT_LOOP:   if (true){
          System.out.println("1");
          INNER_LOOP:if(true) {
              System.out.println("2");
              break PARENT_LOOP;
          }
          System.out.println("3");
      }
      System.out.println("4");
  }
}
