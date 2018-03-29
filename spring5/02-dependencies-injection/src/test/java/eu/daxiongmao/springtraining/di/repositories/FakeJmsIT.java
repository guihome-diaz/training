package eu.daxiongmao.springtraining.di.repositories;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Integration tests for #{@link FakeJms}
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FakeJmsIT {

    @Autowired
    private ApplicationContext appContext;

    @Autowired
    private FakeJms fakeJms;


    @Test
    public void testFakeJmsBean_manualLoad() {
        final FakeJms fakeJmsBean = (FakeJms) appContext.getBean(FakeJms.class);
        Assert.assertNotNull(fakeJmsBean);
        Assert.assertFalse(fakeJmsBean.toString().isEmpty());
        Assert.assertEquals(fakeJms, fakeJmsBean);
        Assert.assertEquals(fakeJms.toString(), fakeJmsBean.toString());
        Assert.assertEquals(fakeJms.getDbUrl(), fakeJmsBean.getDbUrl());
        Assert.assertEquals(fakeJms.getDbUsername(), fakeJmsBean.getDbUsername());
    }

    @Test
    public void testFakeJmsBean_annotationLoad() {
        Assert.assertNotNull(fakeJms);
        Assert.assertFalse(fakeJms.toString().isEmpty());
        Assert.assertFalse(fakeJms.getDbUrl().isEmpty());
        Assert.assertFalse(fakeJms.getDbUsername().isEmpty());
    }
}
