package inflearn.practice.config;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.MultiValueMap;

import java.util.Arrays;

public class MyConfigurationPropertiesImportSelector implements DeferredImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        MultiValueMap<String, Object> attrs = importingClassMetadata.getAllAnnotationAttributes(EnableMyConfigurationProperties.class.getName());

        if (attrs == null || attrs.get("value") == null) {
            return new String[0]; // 값이 없을 경우 빈 배열 반환
        }

        Object value = attrs.getFirst("value");

        if (value instanceof Class<?>[]) {
            Class<?>[] propertyClasses = (Class<?>[]) value;
            return Arrays.stream(propertyClasses)
                    .map(Class::getName)
                    .toArray(String[]::new);
        } else if (value instanceof Class<?>) {
            return new String[]{((Class<?>) value).getName()};
        }

        return new String[0];
    }
}
