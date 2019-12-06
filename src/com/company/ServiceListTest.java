package com.company;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ServiceListTest {

    @Test
    public void testGetServiceName() {
        ServiceList serviceList = new ServiceList();
        String testing = serviceList.getServiceName("123456");
        if(testing.length() > 20) {
            fail("Service name to long. ");
        }
        assertEquals("Service_Option_A", testing);
    }
    @Test
    public void testGetServiceNameFail() {
        ServiceList serviceList = new ServiceList();
        String testing = serviceList.getServiceName("123456");
        if(testing.length() > 20) {
            fail("Service name to long. ");
        }
        assertNotEquals("Service_Option_C", testing);
    }

    @Test
    public void testGetServicePrice() {
        ServiceList serviceList = new ServiceList();
        String testing = serviceList.getServicePrice("123456");
        if(testing.length() > 6) {
            fail("Service price to long. ");
        }
        assertEquals("999.99", testing);
    }
    @Test
    public void testGetServicePriceFail() {
        ServiceList serviceList = new ServiceList();
        String testing = serviceList.getServicePrice("123456");
        if(testing.length() > 6) {
            fail("Service price to long. ");
        }
        assertNotEquals("999.66", testing);
    }

}
