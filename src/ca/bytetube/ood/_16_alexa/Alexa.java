package ca.bytetube.ood._16_alexa;

import java.util.HashMap;
import java.util.Map;

public class Alexa {
    Map<Rule, CommandFactory> commandFactories;
    ErrorHandler handler;

    public Alexa() {
        commandFactories = new HashMap<>();
        handler = new ErrorHandler();
        initializeCommands();
    }

    void addCommand(Rule rule, CommandFactory factory) {
        commandFactories.put(rule, factory);
    }

    //match weatherRule to weatherCommand
    private void initializeCommands() {
        addCommand(new WeatherRule(), input -> {
            WeatherRule rule = (WeatherRule) findMatchingRule(input);
            String location = rule.extractLocation(input);

            return new WeatherCommand(location);
        });
    }

    Rule findMatchingRule(String input) {
        for (Rule rule : commandFactories.keySet()) {
            if (rule.matches(input)) {
                return rule;
            }
        }
        return null;
    }

    public void processInput(String input) {
        Rule rule = findMatchingRule(input);

        //1.match not successfully
        if (rule == null) {
            System.out.println("Sorry, I dont understand your command");
            return;
        }

        try {
            //2.match successfully
            Command command = commandFactories.get(rule).createCommand(input);
            if (!command.validate()) {
                handleError(rule);
                return;
            }
            command.execute();

        } catch (Exception e) {
            handleError(rule);
        }

    }

    public void handleError(Rule rule) {
        handler.handleError(rule);
    }


}
