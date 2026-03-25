package ca.bytetube.ood._16_alexa;

public interface Command {
    boolean validate();

    void execute();
}
