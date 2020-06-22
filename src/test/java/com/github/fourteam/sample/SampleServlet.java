package com.github.fourteam.sample;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class SampleServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug(this.getClass().toString() + ".service()... Run");
        super.service(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug(this.getClass().toString() + ".doGet()... Run");
        if ( StringUtils.isEmpty(req.getPart("name"))) {
            log.debug("Hello " + req.getParameter("name"));
        }
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug(this.getClass().toString() + ".doPost()... Run");
        super.doPost(req, resp);
    }

}
