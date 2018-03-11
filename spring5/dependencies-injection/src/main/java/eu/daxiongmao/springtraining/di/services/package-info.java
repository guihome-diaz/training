/**
 * <h1>Multiple implementation of the same interface</h1>
 * <p>
 * This package contains several implementation of the same interface.<br>
 * <ul>
 * <li><strong>Standard implementation</strong>: 3 beans are implementing the interface [EN, FR, ZH].
 * It is up to the consumer (@service, @controller) to select which bean to use with @Qualifier</li>
 * <li><strong>Primary bean</strong>: one of the implementation will be the default (PRIMARY) bean.
 * It means that if the consumer (@service, @controller) do not use @Qualifer, then Spring framework will
 * inject the bean that has the @Primary annotation [ZH]</li>
 * <li><strong>Spring profiles</strong>: Some beans are only available for particular profiles (sv, de).
 * You have to enable the corresponding profile(s). 2 way to enable profile(s):
 * <ul>
 * <li>in the <code>application.properties</code> file and use <code>spring.profile.active=sv</code></li>
 * <li>Use @ActiveProfile (mostly for unit tests)</li>
 * </ul>
 * </li>
 * </ul>
 * </p>
 */
package eu.daxiongmao.springtraining.di.services;
