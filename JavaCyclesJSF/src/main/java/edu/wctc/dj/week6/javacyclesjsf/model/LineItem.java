package edu.wctc.dj.week6.javacyclesjsf.model;

public class LineItem {

    private Product product;
    private int qty;

    public LineItem(Product product, int qty) {
        this.product = product;
        this.qty = qty;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

}
