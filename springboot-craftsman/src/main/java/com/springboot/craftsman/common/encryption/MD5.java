package com.springboot.craftsman.common.encryption;


import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by zheng on 2018/6/25.
 */
public class MD5 {
    public MD5() {
    }

    public static String md5(String str) {
        try {
            MessageDigest e = MessageDigest.getInstance("MD5");
            e.update(str.getBytes());
            byte[] b = e.digest();
            StringBuffer buf = new StringBuffer("");

            for(int offset = 0; offset < b.length; ++offset) {
                int i = b[offset];
                if(i < 0) {
                    i += 256;
                }
                if(i < 16) {
                    buf.append("0");

                }
                buf.append(Integer.toHexString(i));
            }
            str = buf.toString();
            return str;
        } catch (Exception var6) {
            throw new RuntimeException(var6);
        }
    }

    public static void main(String[] args) {
        //System.out.println(md5("123456"));
        List<Integer>  list  = new ArrayList<>(16);
        for(int i=1;i<=5;i++){
            list.add(i);
        }
        ListIterator<Integer> list2 = list.listIterator();

//        for(Integer ele : list){
//            if(ele == 3)
//                list.remove(ele);
//        }

        while (list2.hasNext()){
            if (list2.next()==3){
                list2.remove();
            }
        }
    }
}
