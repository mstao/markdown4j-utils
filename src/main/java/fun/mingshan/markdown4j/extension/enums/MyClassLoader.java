package fun.mingshan.markdown4j.extension.enums;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * https://www.cnblogs.com/anai/p/4269858.html
 *
 * @author hanjuntao
 * @date 2022/2/19
 */
public class MyClassLoader extends ClassLoader {
    //类路径
    private String classPath;

    MyClassLoader(String classPath) {
        this.classPath = classPath;
    }

    /**
     * 如果父的类加载器中都找不到name指定的类，
     * 就会调用这个方法去从磁盘上加载一个类
     *
     * @param name 类的全限定包名 不带后缀  例如com.test.Notice  而不要写成com.test.Notice.java
     * @return
     * @throws java.io.IOException
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] classBytes;
        Class<?> clazz = null;
        try {
            //加载类的字节码
            classBytes = loadClassBytes(this.classPath);
            //将字节码交给JVM
            clazz = defineClass(name, classBytes, 0, classBytes.length);
            if (clazz == null) {
                throw new ClassNotFoundException(name);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return clazz;
    }

    /**
     * 加载类的字节码
     */
    private byte[] loadClassBytes(String filePath) throws IOException {
        return Files.readAllBytes(Paths.get(filePath));
    }

}
