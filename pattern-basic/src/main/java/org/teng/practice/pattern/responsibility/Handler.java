package org.teng.practice.pattern.responsibility;

/**
 * description:
 *
 * @author baichuan
 * @date 8/23/15.
 */
public abstract class Handler {
    protected Handler successor;

    public Handler() {
        System.out.println("handler初始化...");
    }

    public Handler getSuccessor() {
        return successor;
    }

    public void setSuccessor(Handler handler) {
        if (handler == null) {
            System.out.println("最后一级职责");
        } else {
            System.out.println(this.getClass().getSimpleName() + "设置上一级职责：" + handler.getClass().getSimpleName());
        }

        this.successor = successor;
    }

    public abstract void handlerRequest(int request);
}
