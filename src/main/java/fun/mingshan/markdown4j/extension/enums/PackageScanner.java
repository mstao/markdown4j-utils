package fun.mingshan.markdown4j.extension.enums;

import fun.mingshan.markdown4j.util.StringUtils;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * https://www.cnblogs.com/lingdurebing/p/ldrb-java.html
 *
 * @author hanjuntao
 * @date 2022/1/24
 */
public class PackageScanner {
    private final List<Class<?>> classes;

    // 基础路径com.service.data.domain.wms.enu
    private final String basePath;
    // 基础包名
    private String basePackage;

    /**
     * 扫描指定目录的文件
     *
     * @param bathPath    基础目录
     * @param basePackage 基础包名
     * @throws ClassNotFoundException
     */
    public PackageScanner(String bathPath, String basePackage) throws ClassNotFoundException, MalformedURLException {
        this.basePackage = basePackage;
        this.basePath = bathPath;

        String filePath = bathPath;
        if (!StringUtils.isEmpty(basePackage)) {
            filePath += basePackage.replace('.', '\\');
        }
        classes = new ArrayList<>();
        fileScanner2(new File(filePath));
    }

    private void fileScanner2(File file) throws ClassNotFoundException, MalformedURLException {
        if (file.isFile() && file.getName().lastIndexOf(".class") == file.getName().length() - 6) {//5是".java"的长度
            String filePath = file.getAbsolutePath();
            // 如何获取一个类的全限定名：
            // 文件全限定名 = 文件绝对路径 -  basePath
            String qualifiedName = filePath.substring(basePath.length(), filePath.length() - 6).replace('\\', '.');
            System.out.println(qualifiedName);
            URL url = file.toURI().toURL();

            ClassLoader loader = new URLClassLoader(new URL[] { url });
            Class<?> aClass = loader.loadClass(qualifiedName);
            classes.add(aClass);
        } else if (file.isDirectory()) {
            for (File f : Objects.requireNonNull(file.listFiles())) {
                fileScanner2(f);
            }
        }
    }

    /*
     * 得到加载到的类对象的List,返回的是ArrayList
     */
    public List<Class<?>> getClasses() {
        return this.classes;
    }
}
