import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Black_ghost
 * @title: CollectionTest
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-22 10:28:38
 * @Description
 **/
@Slf4j
public class CollectionTest {
    private int age;
    private int student;
    public static void main(String[] args) {
        CollectionTest collectionTest=new CollectionTest();
        collectionTest.age =10;
        System.out.println("start!!!");
        ArrayList<String> list=new ArrayList<>();
        list.add("string");

    }


    /**
         * @description 简单测试 ：用于验证ArrayList是否重写了equals方法
         * @author fairy_qin
         * @datetime 2023/9/21 9:42
     */
    @Test
    public void test01(){
         List<Integer> list1 = Arrays.asList(1, 2,3);
         ArrayList<Integer> list1_backup = new ArrayList<>(list1);
        Collections.sort(list1);
        boolean isTrue = list1_backup.equals(list1);
        System.out.println(isTrue);
    }
}
