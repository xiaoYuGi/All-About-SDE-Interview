package org.gnuhpc.interview.designpattern.chainofresponsibility.concretehandler;

import org.gnuhpc.interview.designpattern.chainofresponsibility.handler.Handler;
import org.gnuhpc.interview.designpattern.chainofresponsibility.pojo.Request;
import org.gnuhpc.interview.designpattern.chainofresponsibility.pojo.RequestType;

public class Director extends Handler {

    @Override
    public void handleRequest(Request request) {
        if (request.getRequestType() == RequestType.CONFERENCE) {
            System.out.println("Directors can approve conferences");
        } else {
            successor.handleRequest(request);
        }
    }
}
