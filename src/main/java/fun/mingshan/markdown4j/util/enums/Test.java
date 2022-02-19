package fun.mingshan.markdown4j.util.enums;

/**
 * @author hanjuntao
 * @date 2022/1/24
 */
public class Test {
    public static void main(String[] args) throws ClassNotFoundException {
        PackageScanner packageScanner = new PackageScanner("fun.mingshan.markdown4j.util");
        System.out.println(packageScanner.getClasses());
    }
}
