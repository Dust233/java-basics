package com.example.javabasics.io;

import java.io.*;

/**
 * @author LiJingZhi
 * @since 2023-03-08 11:18
 */
public class ByteStream {
    private static final int BYTENUM = 1024;
    public static void main(String[] args) throws IOException {
        //文件IO流
        fileIOStreamTest();
        //数组IO流（内存流）
        byteArrayIOStreamTest();
        //管道
        pipedStreamTest();
        //基本数据读写
//        basicDataIOStreamTest();
        //打印流
        PrintWriterTest();
        //对象IO流（序列化和反序列化）
        ObjectIOStreamTest();
        //字符字节流转换
        IOStreamTransitionTest();
        //复制图片
        copyImg();
        //缓冲流
        BufferedTest();
    }




    public static void fileIOStreamTest() throws IOException {
        FileOutputStream fos = new FileOutputStream("D:\\fileTest.txt",true);
        fos.write("文件IO流测试".getBytes());
        FileInputStream fis = new FileInputStream("D:\\fileTest.txt");
        byte[] bytes = new byte[BYTENUM];
        int a;
        while ((a = fis.read(bytes)) != -1) {
            String s = new String(bytes, 0, a);
            System.out.println(s);
        }
        fos.close();
        fis.close();
    }

    public static void byteArrayIOStreamTest() throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] Obytes = "数组IO流测试".getBytes();
        baos.write(Obytes,0,Obytes.length);

        InputStream ips = new BufferedInputStream(new ByteArrayInputStream(baos.toByteArray()));
        byte[] Ibytes = new byte[BYTENUM];
        int s;
        while ((s = ips.read(Ibytes)) != -1) {
            System.out.println(new String(Ibytes, 0, s));
        }
        baos.close();
        ips.close();
    }

    public static void pipedStreamTest() throws IOException {
        PipedOutputStream pos = new PipedOutputStream();
        PipedInputStream pis = new PipedInputStream(pos);
        new Thread(() ->{
            byte[] by = "管道测试".getBytes();
            try {
                pos.write(by, 0, by.length);
                pos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            byte[] by = new byte[BYTENUM];
            int s;
            try {
                while ((s = pis.read(by)) != -1){
                    String s1 = new String(by, 0, s);
                    System.out.println(s1);
                }
                pis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private static void basicDataIOStreamTest() throws IOException {
        DataOutputStream das = new DataOutputStream(new FileOutputStream("D:\\fileTest.txt"));
        das.writeByte(10);
        das.writeShort(100);
        das.writeInt(1000);
        das.writeLong(10000L);
        das.writeFloat(12.34F);
        das.writeDouble(12.56);
        das.writeBoolean(true);
        das.writeChar('A');

        DataInputStream dis = new DataInputStream(new FileInputStream("D:\\fileTest.txt")) ;
        byte b = dis.readByte() ;
        short s = dis.readShort() ;
        int i = dis.readInt();
        long l = dis.readLong() ;
        float f = dis.readFloat() ;
        double d = dis.readDouble() ;
        boolean bb = dis.readBoolean() ;
        char ch = dis.readChar() ;
    }

    private static void PrintWriterTest() {
        StringWriter sw =  new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        pw.println("打印流测试");
        System.out.println(sw);
    }

    private static void ObjectIOStreamTest() throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeUTF("对象IO流测试");
        //水龙头没有关，系统认为还没有结束，datas就没有数据会导致报错
        baos.close();
        oos.close();

        ObjectInputStream input = new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()));
        String s = input.readUTF();
        input.close();
        System.out.println(s);

    }

    private static void IOStreamTransitionTest() throws IOException {
        Writer osw = new OutputStreamWriter(new ByteArrayOutputStream());
        osw.write("字节流转字符流测试");
        osw.close();
        InputStreamReader isr = new InputStreamReader(new ByteArrayInputStream(osw.toString().getBytes()));
        char[] chars = new char[BYTENUM];
        int s;
        while ((s = isr.read(chars)) != -1) {
            System.out.println(new String(chars, 0, s));
        }
        isr.close();

    }

    private static void copyImg() throws IOException {
        FileInputStream fis = new FileInputStream("C:\\Users\\LJZ\\Pictures\\wallhaven-y83zox_3840x2560.png");
        FileOutputStream fos = new FileOutputStream("test_copy.png");
        byte[] imgs = new byte[BYTENUM];
        int s;
        while ((s = fis.read(imgs)) != -1){
            fos.write(imgs, 0 , s);
        }
        fis.close();
        fos.close();
    }

    public static void BufferedTest() throws IOException {
        long start = System.currentTimeMillis();
        FileInputStream fis = new FileInputStream("D:\\aa\\odin_images_V13.0.4.1.15.DEV_20220308.0000.00_12.0_cn_713cd3335d.tar");
        FileOutputStream fos = new FileOutputStream("D:\\aa\\fileTest\\copy.tar");
        int s;
        byte[] bytes = new byte[1024 * 8];
//        while ((s = fis.read(bytes)) != -1){
//            fos.write(s);
//        }
//        long end = System.currentTimeMillis();

        BufferedInputStream bis = new BufferedInputStream(fis);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        while ((s = bis.read(bytes)) != -1){
            bos.write(bytes, 0, s);
        }
        long end = System.currentTimeMillis();
        System.out.println("用了" + (end - start) + "ms");
        bos.close();
        bis.close();
        fos.close();
        fis.close();

    }

}
