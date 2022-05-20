package com.dongzhic.event.java;

import java.util.EventListener;

/**
 * Java中提供了基本的事件处理基类：
 *  EventObject：所有事件状态对象都将从其派生的根类；
 *  EventListener：所有事件侦听器接口必须扩展的标记接口；
 *  
 * 开关门监听器
 * @Author dongzhic
 * @Date 2022/5/19 00:06
 */
public interface DoorListener extends EventListener {
    /**
     * 开关门事件
     * @param doorEvent
     */
    void doorEvent (DoorEvent doorEvent);
}
