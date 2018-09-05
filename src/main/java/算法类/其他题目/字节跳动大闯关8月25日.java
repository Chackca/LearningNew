package 算法类.其他题目;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 字节跳动大闯关8月25日 {
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<ArrayList<Integer>> relations = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> innerList = new ArrayList<>();
            int next = sc.nextInt();
            while (next!=0){
                innerList.add(next);
                next = sc.nextInt();
            }
            relations.add(innerList);
        }

        int res = minGroups(relations);
    }


    private static int minGroups(ArrayList<ArrayList<Integer>> relations) {
        List findedGroupPersons = new ArrayList();

        List<ArrayList<Integer>> groups = new ArrayList<ArrayList<Integer>>();

        while (findedGroupPersons.size() < relations.size()) {
            //找到第一个还没有找到分组的同学
            int unGroupIndex = 1;
            for (; unGroupIndex < relations.size() + 1; unGroupIndex++) {
                if (findedGroupPersons.size() == 0 || !findedGroupPersons.contains(unGroupIndex)) {
                    break;
                }
            }
            //新建分组
            ArrayList<Integer> firstGroup = new ArrayList<Integer>();
            firstGroup.add(unGroupIndex); //把第一个人放到第一个组里
            sortedInsertGroup(unGroupIndex, firstGroup);
            sortedInsertGroup(unGroupIndex, findedGroupPersons);

            //把该人认识的人放进组里
            for (int i = 0; i < relations.get(unGroupIndex - 1).size(); i++) {
                int person = relations.get(unGroupIndex - 1).get(i);
                sortedInsertGroup(person, firstGroup);
                sortedInsertGroup(person, findedGroupPersons);

                //正向遍历，把所有在当前组的同学认识的人拉进来且去重
                for (int j = 0; j < relations.get(person - 1).size(); j++) {
                    int nextPerson = relations.get(person - 1).get(j);
                    if (!firstGroup.contains(nextPerson)) {
                        sortedInsertGroup(nextPerson, firstGroup);
                        sortedInsertGroup(nextPerson, findedGroupPersons);
                    }
                }

            }
            groups.add(firstGroup);

        }

        //小组间出现重复元素需要合并
        //暂时没有

        return groups.size();
    }


    //有序插入列表中
    private static void sortedInsertGroup(int value, List<Integer> findedGroupPersons) {
        int insertIndex = 0;
        for (insertIndex = 0; insertIndex < findedGroupPersons.size(); insertIndex++) {
            if (value < findedGroupPersons.get(insertIndex)) {
                findedGroupPersons.add(insertIndex, value);
                break;
            }
        }
        if (findedGroupPersons.size() == 0) {
            findedGroupPersons.add(0, value);
        } else if (insertIndex == findedGroupPersons.size()) {
            findedGroupPersons.add(value);
        }
    }*/

    private static int[] vis = new int[100001];
    private static ArrayList map = new ArrayList();
}

