package eu.daxiongmao.springtraining.di.services;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * Implementation of a particular service for the CHINESE language.
 * <h3>Technical note 1: @Primary</h3>
 * <p>
 * This is the <strong>PRIMARY bean</strong>: it is the default bean for that interface.<br>
 * In case of multiple instances of the same interface and no <code>@Qualifier</code> spring will use
 * the <code>@Primary</code> instance.
 * You can only put 1 @primary bean for 1 interface - except if every @Primary is bind to a different @Profile.
 * </p>
 * <h3>Technical note 2: @Profile("default")</h3>
 * <p>
 * You can use @Profile("default") to include the bean in the context that is loaded when no profile is specify by the user.
 * In other words: default profile is only active when other profiles are NOT active
 * </p>
 */
@Profile("default")
@Service("greetingServiceZh")
@Primary
public class GreetingServiceZhImpl implements GreetingService {

    public static final String WELCOME_ZH = "你好！ 欢迎参加培训";

    @Override
    public String sayHello() {
        return WELCOME_ZH;
    }
}
