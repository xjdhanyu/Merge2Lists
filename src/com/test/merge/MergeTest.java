package com.test.merge;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class MergeTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Integer> list1 = new ArrayList<Integer>();
		List<Integer> list2 = new ArrayList<Integer>();
		for (int i = 0; i < 100000; i++) {
			if (i == 4999) {
				list1.add(1459);
				list2.add(list1.get(i));
			} else {
				list1.add(new Random().nextInt());
				list2.add(new Random().nextInt());
			}
		}
		long l1 = new Date().getTime();
		Set<Integer> set1 = new HashSet<Integer>(list1);
		set1.addAll(list2);
		long l2 = new Date().getTime();
		System.out.println("使用set集合过滤重复元素所用时间：[" + (l2 - l1) + "]ms");
		System.out.println("去重合并后的集合元素总数：" + set1.size());
		System.out.println("------------------------");
		long l3 = new Date().getTime();
		try {
			list1.removeAll(list2);
			list1.addAll(list2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		long l4 = new Date().getTime();
		System.out.println("使用List集合过滤重复元素所用时间：[" + (l4 - l3) + "]ms");
		System.out.println("去重合并后的集合元素总数：" + list1.size());

	}

}
