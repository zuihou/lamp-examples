package top.tangyh.lamp.example.config;

import top.tangyh.basic.boot.config.BaseConfig;
import top.tangyh.basic.log.event.SysLogListener;
import top.tangyh.lamp.oauth.api.LogApi;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zuihou
 * @date 2017-12-15 14:42
 */
@Configuration
public class ExampleWebConfiguration extends BaseConfig {

    @Bean
    @ConditionalOnExpression("${lamp.log.enabled:true} && 'DB'.equals('${lamp.log.type:LOGGER}')")
    public SysLogListener sysLogListener(LogApi logApi) {
        return new SysLogListener(logApi::save);
    }
}
