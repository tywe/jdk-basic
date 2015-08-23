package org.teng.practice.pattern.responsibility;

/**
 * description:
 *
 * @author baichuan
 * @date 8/23/15.
 */
public class ConcreteHandlerB extends Handler {
    public ConcreteHandlerB() {
    }

    public ConcreteHandlerB(Handler handler) {
        System.out.println("handlerB初始化...");
        setSuccessor(handler);
    }

    @Override
    public void handlerRequest(int request) {
        if (request >= 10 && request < 20) {
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
