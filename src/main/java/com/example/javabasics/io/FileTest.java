package com.example.javabasics.io;

import java.io.File;
import java.io.IOException;

/**
 * @author LiJingZhi
 * @since 2023-03-08 18:16
 */
public class FileTest {
    public static void main(String[] args) throws IOException {
//        File file = new File("D:\\Test.txt");
//        File file = new File("Test.txt");
        File file = new File("D:\\");
//        System.out.println(file.createNewFile());
//        System.out.println(file.getAbsoluteFile());
//        System.out.println(file.getPath());
//        System.out.println(file.getName());
//        System.out.println(file.length());
//        String[] list = file.list();
//        File[] files = file.listFiles();
//        System.out.println(list);
//        for (String S:list
//             ) {
//            System.out.println(S);
//        }
//        System.out.println(files);
//        for (File f:files
//             ) {
//            System.out.println(f.getName());
//        }
        RecursionFiles(file);
    }

    public static void RecursionFiles(File file){
        if (!file.isDirectory() || "System Volume Information".equals(file.getName())){
            return;
        }
        File[] files = file.listFiles();
        for (File f:files) {
            if (f.isDirectory()){
                System.out.println(f.getAbsoluteFile());
                RecursionFiles(f);
            }else {
                System.out.println(f.getAbsoluteFile());
            }
        }

    }

}
