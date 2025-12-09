import com.ayoub.framework.validation.OrderService;
import com.ayoub.framework.validation.PaymentProcess;
import com.ayoub.framework.validation.PaypalService;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {

            PaymentProcess paymentProcessor =  new PaypalService();

            OrderService orderService = new OrderService(paymentProcessor);
            orderService.checkout();
    }
}