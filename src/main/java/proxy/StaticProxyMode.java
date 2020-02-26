package proxy;

/**
 * @author suzl demo of static proxy mode
 */
public class StaticProxyMode {
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

class StaticProxy implements StaticProxyMode.Rent {
    /**
     * rent house
     */
    public void rentHouse() {
        System.out.println("Rent house from proxy");
    }

    /**
     * do other stuff besides rent
     */
    public void doSthElse() {
        System.out.println("Rent from proxy");
    }
}

/**
 * LandLord only want to rent house
 */
class LandLord implements StaticProxyMode.Rent {
    /**
     * rent house
     */
    public void rentHouse() {
        System.out.println("Rent house form land lord");
    }
}