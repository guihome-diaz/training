package eu.daxiongmao.springtraining.di.repositories;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Integration tests for #{@link FakeDatasource}
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FakeDatasourceIT {

    @Autowired
    private ApplicationContext appContext;

    @Autowired
    private FakeDatasource fakeDatasource;


    @Test
    public void testFakeDatasourceBean_manualLoad() {
        final FakeDatasource fakeDatasourceBean = (FakeDatasource) appContext.getBean(FakeDatasource.class);
        Assert.assertNotNull(fakeDatasourceBean);
        Assert.assertFalse(fakeDatasourceBean.toString().isEmpty());
        Assert.assertEquals(fakeDatasource, fakeDatasourceBean);
        Assert.assertEquals(fakeDatasource.toString(), fakeDatasourceBean.toString());
        Assert.assertEquals(fakeDatasource.getDbUrl(), fakeDatasourceBean.getDbUrl());
        Assert.assertEquals(fakeDatasource.getDbUsername(), fakeDatasourceBean.getDbUsername());
    }

    @Test
    public void testFakeDatasourceBean_annotationLoad() {
        Assert.assertNotNull(fakeDatasource);
        Assert.assertFalse(fakeDatasource.toString().isEmpty());
        Assert.assertFalse(fakeDatasource.getDbUrl().isEmpty());
        Assert.assertFalse(fakeDatasource.getDbUsername().isEmpty());
    }

}
