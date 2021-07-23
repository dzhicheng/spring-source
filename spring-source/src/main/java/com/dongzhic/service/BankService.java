package com.dongzhic.service;

import java.util.List;

/**
 * @Author dongzhic
 * @Date 7/14/21 3:26 PM
 */
public interface BankService {

    String queryBank (String bankId, int id, List list);

    void queryArea (String areaId);
    Object returnValue (String id);
    void throwMethod (String id);
}
