package fun.mingshan.markdown4j.extension.enums;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @author hanjuntao
 * @date 2022/1/24
 */
public class Test {
    public static void main(String[] args) throws ClassNotFoundException, MalformedURLException {
       // PackageScanner packageScanner = new PackageScanner("E:\\D\\develop\\code\\data-hdy\\data-domain\\data-domain-wms\\target\\classes\\",
      //          "com.service.data.domain.wms.enu");

//        PackageScanner packageScanner1 = new PackageScanner("E:\\D\\develop\\MY\\CODE\\markdown4j\\src\\main\\java\\",
//                "fun.mingshan.markdown4j");

     //   System.out.println(packageScanner.getClasses());

//        MyClassLoader classLoader = new MyClassLoader("E:\\D\\develop\\code\\data-hdy\\data-domain\\data-domain-wms\\target\\classes\\com\\service\\data\\domain\\wms\\enu\\AbnormalStateEnum.class");
//        Class<?> aClass = classLoader.findClass("AbnormalStateEnum");

        File file = new File("E:\\D\\develop\\code\\data-hdy\\data-domain\\data-domain-wms\\target\\classes\\com\\service\\data\\domain\\wms\\enu\\AbnormalStateEnum.class");
        URL url = file.toURI().toURL();
        ClassLoader loader = new URLClassLoader(new URL[] { url });
        Class tidyClazz = loader.loadClass("com.service.data.domain.wms.enu.AbnormalStateEnum");

    }
}
