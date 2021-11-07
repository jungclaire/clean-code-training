package com.cleancode.houseutils.policy;

import com.cleancode.houseutils.exception.ErrorCode;
import com.cleancode.houseutils.exception.HouseUtilsException;

import java.util.List;

/**
 * @author claire
 */

public interface BrokeragePolicy {

    List<BrokerageRule> getRules();

    default Long calculate(Long price) {
        BrokerageRule brokerageRule = getRules().stream()
                .filter(rule -> price < rule.getLessThan())
                .findFirst().orElseThrow(() -> new HouseUtilsException(ErrorCode.INTERNAL_ERROR));
        return brokerageRule.calcMaxBrokerage(price);
    }
}
