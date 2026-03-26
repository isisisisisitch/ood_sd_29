package ca.bytetube.ood._17_amazongo;

import java.util.HashMap;
import java.util.Map;

public class TrackingRegister {
    Map<String, Session> sessions = new HashMap<>();

    public Session start(Customer customer) {
        Session s = new Session("S-" + System.nanoTime(), customer);
        sessions.put(s.getId(), s);
        return s;
    }

    public void pickup(String sessionId, Product product, int qty) {
        Session session = sessions.get(sessionId);
        if (session != null) session.getBasket().add(product, qty);
    }


    public void putBack(String sessionId, Product product, int qty) {
        Session session = sessions.get(sessionId);
        if (session != null) session.getBasket().add(product, -qty);
    }

}
