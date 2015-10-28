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
  
  @Test public void break_2() {
        System.out.println("0");
        PARENT_LOOP:   if (true){
            System.out.println("1");
            INNER_LOOP:if(true) {
                for(int i=0;i<5;i++) {
                    System.out.println("2");
                    break INNER_LOOP;
                }
                System.out.println("2B");
                break PARENT_LOOP;
            }
            System.out.println("3");
        }
        System.out.println("4");
    }
}
