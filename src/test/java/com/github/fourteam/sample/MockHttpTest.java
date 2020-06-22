package com.github.fourteam.sample;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import javax.servlet.ServletException;
import java.io.IOException;

public class MockHttpTest {

    @Test
    public void doGet() throws ServletException, IOException {
        // given
        SampleServlet sampleServlet = new SampleServlet();
        MockHttpServletRequest req = new MockHttpServletRequest();
        req.addParameter("name", "bbubbush");
        MockHttpServletResponse res = new MockHttpServletResponse();

        // when
        sampleServlet.doGet(req, res);

        // then
        Assert.assertTrue(true);
    }

    @Test
    public void doPost() throws ServletException, IOException {
        // given
        SampleServlet sampleServlet = new SampleServlet();
        MockHttpServletRequest req = new MockHttpServletRequest();
        MockHttpServletResponse res = new MockHttpServletResponse();

        // when
        sampleServlet.doPost(req, res);

        // then
        Assert.assertTrue(true);
    }

    @Test
    public void service() throws ServletException, IOException {
        // given
        SampleServlet sampleServlet = new SampleServlet();
        MockHttpServletRequest req = new MockHttpServletRequest();
        MockHttpServletResponse res = new MockHttpServletResponse();

        // when
        sampleServlet.service(req, res);

        // then
        Assert.assertTrue(true);
    }
}

