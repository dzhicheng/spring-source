package com.dongzhic.event.java;

/**
 * @Author dongzhic
 * @Date 2022/5/19 00:09
 */
public class OpenDoorListener implements DoorListener{

    @Override
    public void doorEvent(DoorEvent doorEvent) {
        Integer doorStatus = doorEvent.getDoorStatus();
        if (doorStatus == 1) {
            System.out.println("the door is open");
        }
    }
}
