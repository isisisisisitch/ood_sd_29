package ca.bytetube.ood._12_criteriabased;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Main {
    public static void main(String[] args) {
        ComparisonCriteria ageComparisonCriteria = CriteriaFactory.createComparisonCriteria("age", 30, ">");
        ComparisonCriteria nameComparisonCriteria = CriteriaFactory.createComparisonCriteria("name", "Alice", "==");
        List<Criteria> criteriaList = Arrays.asList(ageComparisonCriteria, nameComparisonCriteria);
        Map<String, Object> input = new HashMap<>();
        input.put("age", 35);
        input.put("name", "Dal");

        LogicalCriteria logicalCriteria = CriteriaFactory.createLogicalCriteria("not", criteriaList);
        System.out.println(CriteriaEvaluator.isMatch(logicalCriteria, input));

    }
}
