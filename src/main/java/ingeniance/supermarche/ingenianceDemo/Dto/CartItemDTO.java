package ingeniance.supermarche.ingenianceDemo.Dto;

public class CartItemDTO {

    private Long idCartItem;
    private Long productId;
    private String productName;
    private Integer quantity;

    public Long getIdCartItem() {
        return idCartItem;
    }

    public void setIdCartItem(Long idCartItem) {
        this.idCartItem = idCartItem;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
