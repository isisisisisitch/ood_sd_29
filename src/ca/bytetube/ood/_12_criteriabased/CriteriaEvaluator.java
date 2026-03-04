package ca.bytetube.ood._12_criteriabased;

import java.util.Map;

public class CriteriaEvaluator {
    public static boolean isMatch(Criteria criteria, Map<String, Object> input) {
        return criteria.isMatch(input);
    }
}
