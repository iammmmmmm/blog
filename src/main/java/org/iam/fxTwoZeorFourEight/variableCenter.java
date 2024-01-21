package org.iam.fxTwoZeorFourEight;

import java.util.HashMap;

/**
 * 可变中心 作为变量中心，用于在不同类之间传递变量
 *
 * @author Iammm
 * @ClassName variableCenter
 * @Time 2024/1/21 11:11
 * @date 2024/01/21
 */
public class variableCenter {
    /**
     * VAR列表
     */
    private static HashMap<String,Object> varList;
    static {
        variableCenter.varList = new HashMap<>();
    }

    /**
     * 放
     *
     * @param key   钥匙
     * @param value 值
     */
    public static void put(String key,Object value){
        System.out.println("put key:"+key+" value:"+value);
        varList.put(key,value);
    }

    /**
     * 获取
     *
     * @param key 钥匙
     * @return {@link Object}
     */
    public static Object get(String key){
        if(!varList.containsKey(key)){
            throw new IllegalArgumentException("key:"+key+" not exist");
        }
        var a =varList.get(key);
        System.out.println("get value:"+a+" by key:"+key);
        return a;
    }
}
