package com.sequoia.shorturl;

import com.jsoniter.JsonIterator;
import com.sequoia.shorturl.domain.OrderDetail;
import org.junit.Test;
import org.springframework.util.Assert;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Description: JDK8 stream()
 * @Author: usr1999
 * @Create: 2021/9/22
 */
public class StreamTest {

    @Test
    public void test() {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");

        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());

        System.out.println(filtered);

        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        // 获取对应的平方数
        List<Integer> squaresList = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
        System.out.println(squaresList);

        Random random = new Random();
        //random.ints().limit(10).forEach(System.out::println);

        /*List<String>*/
        strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        // 获取空字符串的数量
        long count = strings.stream().filter(string -> string.isEmpty()).count();
        System.out.println(count);

        int[] array={1,3,5,6,8};
        IntStream stream = Arrays.stream(array);



    }

    @Test
    public void test2() {
        String orderDetails = "[{\"amount\":24.63,\"quantity\":1,\"exCode\":\"YUNDA\",\"reachables\":[ture],\"skuUuid\":\"4a31128617bbb059732eYbHq8hu\",\"goodsId\":42,\"freight\":5,\"shopId\":\"338711476\",\"itemIds\":[\"1631760371622\"]},{\"amount\":26,\"quantity\":1,\"exCode\":\"YUNDA\",\"reachables\":[ture],\"skuUuid\":\"34455\",\"goodsId\":43,\"freight\":15,\"shopId\":\"33871234\",\"itemIds\":[\"16317603234\"]}]";

        List<String> itemIdList = new ArrayList();
        Map<String, OrderDetail> detailMap = new HashMap();

        OrderDetail[] orderDetailList = JsonIterator.deserialize(orderDetails.replace("\n", ""), OrderDetail[].class);
        String[] orderUuids = new String[orderDetailList.length];
        for (int i = orderDetailList.length - 1; i >= 0; i--) {
            OrderDetail orderDetail = orderDetailList[i];
            String orderUuid = orderDetail.getOrderId();
            orderUuids[i] = orderUuid;

            Boolean[] reachables = orderDetail.getReachables();
            String[] itemIds = orderDetail.getItemIds();
            for (int j=0;j<itemIds.length;j++) {
                if(reachables[j]) {
                    itemIdList.add(itemIds[j]);
                }
            }
            detailMap.put(orderUuid, orderDetail);
        }

        System.out.println(itemIdList);
        System.out.println(detailMap);

        Stream stream = Arrays.stream(orderDetailList);


    }


    @Test
    public void test3() {
        Assert.hasLength("a", "aaa");

        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6);

        Stream<Integer> stream2 = Stream.iterate(0, (x) -> x + 3).limit(4);
        stream2.forEach(System.out::println);

        Stream<Double> stream3 = Stream.generate(Math::random).limit(3);
        stream3.forEach(System.out::println);

    }


}
