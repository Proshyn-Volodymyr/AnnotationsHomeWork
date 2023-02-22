package task1;

public class TestAnnWithParams {
    @MethodArgsProvider
    public void test(int a, int b){
        System.out.println("The first passed parameter: " + a);
        System.out.println("The second passed parameter: " + b);
    }
    @MethodArgsProvider
    public void test1(int a, int b){
        System.out.println(a);
        System.out.println(b);
    }
    public void test2(int a, int b){
        System.out.println(a);
        System.out.println(b);
    }
}
