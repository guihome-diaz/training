package eu.daxiongmao.springtraining.di;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * Created by jt on 6/5/17.
 */
@Component
public class CustomBeanPostProcessor implements BeanPostProcessor {

    /**
     * Intialization process (<strong>pre-initialization</strong>)<br>
     * This method is called for EACH bean of the Spring context during application startup
     * and it offer you the opportunity to perform post process "BEFORE intialization" actions
     *
     * @param bean     spring bean (this comes from the Spring context)
     * @param beanName spring bean's name (if you want to filter on bean's name)
     * @return the updated bean / or replacement
     * @throws BeansException something went wrong
     * @inheritDoc
     */
    @Override
    public Object postProcessBeforeInitialization(final Object bean, final String beanName) throws BeansException {

        if (bean instanceof LifeCycleDemoBean) {
            ((LifeCycleDemoBean) bean).beforeInit();
        }

        return bean;
    }

    /**
     * Intialization process (<strong>post-initialization</strong>)<br>
     * This method is called for EACH bean of the Spring context during application startup
     * and it offer you the opportunity to perform post process "AFTER intialization" actions
     *
     * @param bean     spring bean (this comes from the Spring context)
     * @param beanName spring bean's name (if you want to filter on bean's name)
     * @return the updated bean / or replacement
     * @throws BeansException something went wrong
     * @inheritDoc
     */
    @Override
    public Object postProcessAfterInitialization(final Object bean, final String beanName) throws BeansException {
        if (bean instanceof LifeCycleDemoBean) {
            ((LifeCycleDemoBean) bean).afterInit();
        }

        return bean;
    }
}
