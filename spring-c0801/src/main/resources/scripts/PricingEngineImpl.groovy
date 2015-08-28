//import com.springinaction.pizza.Order;
//import com.springinaction.pizza.Pizza;
//import com.springinaction.pizza.PricingEngine
import com.springinaction.pizza.domain.Order
import com.springinaction.pizza.service.PricingEngine

class PricingEngineImpl implements PricingEngine, Serializable {
    public float calculateOrderTotal(Order order) {
        print "IN GROOVY";

        retun 99.99;
    }
}
