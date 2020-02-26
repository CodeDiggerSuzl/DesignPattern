package proxy;

/**
 * @author suzl demo of static proxy mode
 */
public class ProxyMode {
    /**
     * common behaviour
     */
    interface Rent {
        /**
         * rent house
         */
        void rentHouse();
    }
}

class Proxy implements ProxyMode.Rent {
    /**
     * rent house
     */
    public void rentHouse() {
        System.out.println("Rent house from proxy");
    }
}

/**
 * LandLord only want to rent house
 */
class LandLord implements ProxyMode.Rent {
    /**
     * rent house
     */
    public void rentHouse() {
        System.out.println("Rent house form land lord");
    }
}