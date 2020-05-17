package com.jie.anno.com.jie.anno.config;

import com.jie.anno.com.jie.anno.entity.Blue;
import com.jie.anno.com.jie.anno.entity.Yellow;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @version 1.0
 * @author: Jie Zhang
 * @date: 2020/5/17 16:42
 */
public class MyImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{Blue.class.getCanonicalName(), Yellow.class.getCanonicalName()};
    }
}
