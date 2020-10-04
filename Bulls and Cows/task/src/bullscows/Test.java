package bullscows;

public class Test {
    public static void main(String[] args) {
        System.out.println(Math.ceil(1.45) > Math.floor(1.55));
        System.out.println(Math.abs(-1) != Math.abs(1));
        System.out.println(Math.PI > 3.14 && Math.PI < 3.15);
        System.out.println(Math.max(1, Math.min(2, 3)) == 3);
    }
}
