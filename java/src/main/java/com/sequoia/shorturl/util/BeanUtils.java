package com.sequoia.shorturl.util;

import org.springframework.cglib.beans.BeanCopier;

/**
 * @Description:
 * @Author: jzq
 * @Create: 2022/2/12
 */
public class BeanUtils {

    public static void beanCopy(Object src, Object target){
        BeanCopier copier = BeanCopier.create(src.getClass(), target.getClass(), false);
        copier.copy(src, target, null);
    }

}
