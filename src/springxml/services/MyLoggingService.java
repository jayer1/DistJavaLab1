package springxml.services;

import springxml.iface.LoggingService;

public class MyLoggingService implements LoggingService {
    @Override
    public String getLog() {
        return "You have changed something!!";
    }
}
