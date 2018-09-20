package com.dbapp.attackWay;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: jackson.tang
 * @version: 1.0
 * @Date: Created in 2018/3/21 14:25
 * @Modified:
 */
public class AttackParser {
    /**
     * 解析树形数据 
     * @param topId
     * @param entityList
     * @return
     * @author jianda
     * @date 2017年5月29日
     */

    public static  List<Attack> getTreeList(String topId, List<Attack> entityList) {
        List<Attack> resultList=new ArrayList<>();
        //获取顶层元素集合
        String parentId;
        Set<String> intent = new HashSet<>();
        Set<String> strategy = new HashSet<>();
        Set<String> method = new HashSet<>();
        for (Attack entity : entityList) {
            parentId = entity.getParentName();
            if(entity.getId() ==1 ){
                if(parentId == null && !intent.contains(entity.getName())){
                    resultList.add(entity);
                    intent.add(entity.getName());
                }
            }else if(entity.getId() ==2 ){
                if(parentId == null && !strategy.contains(entity.getName())){
                    resultList.add(entity);
                    strategy.add(entity.getName());
                }
            }else if(entity.getId() ==3 ){
                if(parentId == null && !method.contains(entity.getName())){
                    resultList.add(entity);
                    method.add(entity.getName());
                }
            }

        }
        entityList.removeAll(resultList);

        //获取每个顶层元素的子数据集合  
        for (Attack entity : resultList) {
            entity.setChildList(getSubList(entity.getName(),entityList));
        }

        return resultList;
    }

    /**
     * 获取子数据集合 
     * @param id
     * @param entityList
     * @return
     * @author jianda
     * @date 2017年5月29日
     */
    private  static  List<Attack> getSubList(String id, List<Attack> entityList) {
        List<Attack> childList=new ArrayList<>();
        List<Attack> vaildList=new ArrayList<>();
        String parentId;
        List<Attack> usedList=new ArrayList<>();
        //子集的直接子对象
        Set<String> childStrategy = new HashSet<>();
        Set<String> childMethod = new HashSet<>();
        for (Attack entity : entityList) {
            parentId=entity.getParentName();
                if(entity.getId() == 2 && !childStrategy.contains(entity.getName())){
                    if(id.equals(parentId)){
                        usedList.add(entity);
                        childList.add(entity);
                        childStrategy.add(entity.getName());
                    }
                }else if(entity.getId() == 3 && !childMethod.contains(entity.getName())){
                    if(id.equals(parentId)){
                        childList.add(entity);
                        childMethod.add(entity.getName());
                    }
                }
        }
        entityList.removeAll(usedList);

        //子集的间接子对象
        for (Attack entity : childList) {
            entity.setChildList(getSubSubList(entity.getName(), entityList));
        }

        //递归退出条件  
        if(childList.size()==0){
            return null;
        }
        for(Attack entity : childList){
            if(entity.getId() == 2){
                vaildList.add(entity);
            }
        }

        return vaildList;
    }


    private  static  List<Attack> getSubSubList(String id, List<Attack> entityList) {
        List<Attack> childList=new ArrayList<>();
        String parentId;
        //子集的直接子对象
        Set<String> childMethod = new HashSet<>();
        for (Attack entity : entityList) {
            parentId=entity.getParentName();
            if(entity.getId() == 3 && !childMethod.contains(entity.getName())){
                if(id.equals(parentId)){
                    childList.add(entity);
                    childMethod.add(entity.getName());
                }
            }
        }
        //递归退出条件
        if(childList.size()==0){
            return null;
        }
        return childList;
    }
} 