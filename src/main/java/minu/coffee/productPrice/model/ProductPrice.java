package minu.coffee.productPrice.model;

import jakarta.persistence.*;
import lombok.*;
import minu.coffee.common.CommonField;
import minu.coffee.product.model.Product;
import org.hibernate.annotations.DynamicUpdate;

import java.time.Instant;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DynamicUpdate
@Table(name = "product_price", schema = "minu_shop", catalog="minu_shop")
public class ProductPrice extends CommonField {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "price")
    private Integer price;

    @Column(name = "enable")
    private Boolean enable;

    @Column(name = "deleted")
    private Boolean deleted;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

}