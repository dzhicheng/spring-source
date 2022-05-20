package com.dongzhic.event.java;

import java.util.EventObject;

/**
 * Java中提供了基本的事件处理基类：
 *  EventObject：所有事件状态对象都将从其派生的根类；
 *  EventListener：所有事件侦听器接口必须扩展的标记接口；
 *
 * 开关门事件
 * @Author dongzhic
 * @Date 2022/5/19 00:03
 */
public class DoorEvent extends EventObject {

    /**
     * 门的状态：0：关，1：开
     */
    private Integer doorStatus;

    /**
     * Constructs a prototypical Event.
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public DoorEvent(Object source) {
        super(source);
    }

    public DoorEvent(Object source, Integer doorStatus) {
        super(source);
        this.doorStatus = doorStatus;
    }

    public Integer getDoorStatus() {
        return doorStatus;
    }

    public void setDoorStatus(Integer doorStatus) {
        this.doorStatus = doorStatus;
    }
}
