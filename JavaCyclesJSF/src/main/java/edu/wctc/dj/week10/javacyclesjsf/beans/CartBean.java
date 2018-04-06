package edu.wctc.dj.week10.javacyclesjsf.beans;

import edu.wctc.dj.week10.javacyclesjsf.model.Product;
import edu.wctc.dj.week10.javacyclesjsf.model.ShoppingCart;
import edu.wctc.dj.week10.javacyclesjsf.service.ShoppingCartService;
import java.io.Serializable;
import java.util.List;
import javax.faces.context.FacesContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("cartBean")
@Scope("session")
public class CartBean implements Serializable {

    private final String sessionId;
    private final ShoppingCart cart;
    private final ShoppingCartService cartService = new ShoppingCartService();
    private List<Product> productList;

    public CartBean() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        sessionId = facesContext.getExternalContext().getSessionId(true);

        cart = cartService.getContents(sessionId);
    }

    public int getItemsInCart() {
        return cart.getItemsInCart();
    }

    public String getContents() {
        productList = cart.getContents();
        //productList = (List<Product>) cartService.getContents(sessionId);
        return "shoppingCart";
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public void addToCart(Product prod) {
        cart.add(prod);
        cartService.update(sessionId, cart);
    }

}
