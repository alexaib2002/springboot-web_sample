package org.alexaib.springlearn.springweblearn;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({
        @PropertySource("classpath:strings.properties")
})
public class StringsPropertiesConfig {

}
