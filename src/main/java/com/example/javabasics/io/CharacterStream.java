package com.example.javabasics.io;

import java.io.*;

/**
 * @author LiJingZhi
 * @since 2023-03-08 11:18
 */
public class CharacterStream {
    public static void main(String[] args) throws IOException {
//        fileWriterTest();
//        fileReaderTest();
        BufferedTest();
    }

    public static void fileReaderTest() throws IOException {
        FileReader fr = new FileReader("D:\\fileTest.txt");
        int s;
        while((s = fr.read()) != -1){
            System.out.print((char) s);
        }
        fr.close();
    }

    public static void fileWriterTest() throws IOException {
        FileWriter fw = new FileWriter("D:\\fileTest.txt");
        fw.write("发件地of的简欧if大祭司哦哦对房间后");
        fw.close();

    }

    public static void BufferedTest() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("D:\\aa\\fileTest\\新建文本文档.txt"));
        String str;
        while ((str = br.readLine()) != null){
            System.out.println(str);
        }
        br.close();
    }

}
