package cn.com.demo.ssm.anno.spring.anno.config;

import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

public class MyComponentFilter implements TypeFilter {
    @Override
    // 当前正在扫描的class的所有元数据
    // 扫描的所有类的元数据
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        String clsName = metadataReader.getClassMetadata().getClassName();
        return clsName.endsWith("DAOImpl");
    }
}
