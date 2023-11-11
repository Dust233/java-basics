package com.example.javabasics.stream;

import com.example.mybatis.model.User;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author LiJingZhi
 * @since 2023-03-03 11:40
 */
public class JavaStream {
    public static void main(String[] args) {
//        streamTest();
//        parallelStreamTest();

//        testGetTargetUsers();
//        String s = "1-2--3";
//        String[] split = s.split("-", -1);
//        System.out.println(split[split.length - 1]);
//        JavaStream javaStream = new JavaStream();
//        for (int i = 0; i < 2; i++) {
//            test(i);
//        }

//        List<String> strings = new ArrayList<>();
//        strings.add("1");
//        strings.add("2");
//        strings.add("3");
//        Iterator<String> iterator = strings.iterator();
//        while (iterator.hasNext()){
//            String next = iterator.next();
//            if (next.equals("2")){
//                iterator.remove();
//            }
//        }

    }

    public static List<Integer> test(int i){
        List<Integer> integers = new ArrayList<>();
        List<Integer> integers1 = new ArrayList<>();
        integers1.add(i);
        integers.addAll(integers1);
        return integers;
    }

    /**
     *
     * 开始管道
     * 	stream()	创建出一个新的stream串行流对象
     * 	parallelStream()	创建出一个可并行执行的stream流对象
     * 	Stream.of()	通过给定的一系列元素创建一个新的Stream串行流对象
     * 中间管道
     * 	filter()	按照条件过滤符合要求的元素， 返回新的stream流
     * 	map()	将已有元素转换为另一个对象类型，一对一逻辑，返回新的stream流
     * 	flatMap()	将已有元素转换为另一个对象类型，一对多逻辑，即原来一个元素对象可能会转换为1个或者多个新类型的元素，返回新的stream流
     * 	limit()	仅保留集合前面指定个数的元素，返回新的stream流
     * 	skip()	跳过集合前面指定个数的元素，返回新的stream流
     * 	concat()	将两个流的数据合并起来为1个新的流，返回新的stream流
     * 	distinct()	对Stream中所有元素进行去重，返回新的stream流
     * 	sorted()	对stream中所有的元素按照指定规则进行排序，返回新的stream流
     * 	peek()	对stream流中的每个元素进行逐个遍历处理，返回处理后的stream流
     * 终止管道
     * 	count()	返回stream处理后最终的元素个数
     * 	max()	返回stream处理后的元素最大值
     * 	min()	返回stream处理后的元素最小值
     * 	findFirst()	找到第一个符合条件的元素时则终止流处理
     * 	findAny()	找到任何一个符合条件的元素时则退出流处理，这个对于串行流时与findFirst相同，对于并行流时比较高效，任何分片中找到都会终止后续计算逻辑
     * 	anyMatch()	返回一个boolean值，类似于isContains(),用于判断是否有符合条件的元素
     * 	allMatch()	返回一个boolean值，用于判断是否所有元素都符合条件
     * 	noneMatch()	返回一个boolean值， 用于判断是否所有元素都不符合条件
     * 	collect()	将流转换为指定的类型，通过Collectors进行指定
     * 	toArray()	将流转换为数组
     * 	iterator()	将流转换为Iterator对象
     * 	foreach()	无返回值，对元素进行逐个遍历，然后执行给定的处理逻辑
     *
     */
    public static void streamTest(){
        List<String> strs = Arrays.asList("张三 张三丰", "李四 李四光", "王五 王老五");
        List<User> users = Arrays.asList(new User(1,"一"));
        System.out.println("\n****************filter******************");
        strs.stream().filter(st -> !st.equals("张三 张三丰")).forEach(s -> System.out.println(s));
        System.out.println("\n****************map******************");
        List<Object> collect = strs.stream().map(sa -> {
            User user = new User();
            user.setName(sa);
            return user;
        }).collect(Collectors.toList());
        System.out.println(collect);
        System.out.println("\n****************flatMap*******************");
        List<String> collect1 = strs.stream().flatMap(sf -> Arrays.stream(sf.split(" "))).collect(Collectors.toList());
        System.out.println(collect1);
        System.out.println("\n****************limit*******************");
        strs.stream().limit(2).forEach(s -> System.out.println(s));
        System.out.println("\n****************skip*******************");
        strs.stream().skip(1).forEach(s -> System.out.println(s));
        System.out.println("\n****************concat*******************");
        Stream<Integer> s1 = Stream.of(1, 2, 3);
        Stream<Integer> s2 = Stream.of(4, 5, 6);
        List<Integer> collect2 = Stream.concat(s1, s2).collect(Collectors.toList());
        System.out.println(collect2);
        System.out.println("\n****************distinct*******************");
        List<Integer> i1 = Arrays.asList(1,3,3,3,2,1,7,7);
        i1.stream().distinct().forEach(s -> System.out.print(s + "\t"));
        System.out.println("\n****************peek*******************");
        strs.stream().peek(ss -> System.out.println(ss)).collect(Collectors.toList());
        Integer integer = i1.stream().reduce((a, b) -> a * b).orElse(0);
        System.out.println(integer);

        System.out.println(0/1);
    }

    public static void testGetTargetUsers() {
        List<String> ids = Arrays.asList("205","10","308","49","627","193","111", "193");
        // 使用流操作
        List<User> results = ids.stream()
                .filter(s -> s.length() > 2)
                .distinct()
                .map(Integer::valueOf)
                .sorted(Comparator.comparingInt(o -> o))
                .limit(3)
                .map(id -> new User(id))
                .collect(Collectors.toList());
        System.out.println(results);
    }

    public static void parallelStreamTest(){
        System.out.println(false);
    }
}
