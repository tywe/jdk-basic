package org.teng.practice.pattern.responsibility;

/**
 * description:
 *
 * @author baichuan
 * @date 8/23/15.
 */
public class ConcreteHandlerA extends Handler {
    public ConcreteHandlerA() {
    }

    public ConcreteHandlerA(Handler handler) {
        System.out.println("handlerA初始化...");
        setSuccessor(handler);
    }

    @Override
    public void handlerRequest(int request) {
        if (request >= 0 && request < 10) {
            String handlerMessageFormat = "%s:处理请求%s";
            System.out.println(String.format(handlerMessageFormat, this.getClass().getName(), request));
        } else {
            if (successor != null) {
                successor.handlerRequest(request);
            } else {
                System.out.println("请求无法处理：" + request);
            }
        }
    }
}
