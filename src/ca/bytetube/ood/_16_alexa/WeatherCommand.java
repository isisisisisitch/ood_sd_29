package ca.bytetube.ood._16_alexa;

public class WeatherCommand implements Command {
    String location;

    public WeatherCommand(String location) {
        this.location = location;
    }

    @Override
    public boolean validate() {

        return location != null && !location.trim().isEmpty();
    }

    @Override
    public void execute() {
        //call APIs
        System.out.println("current weather in " + location + " : 19 C,Cloud");

    }
}
