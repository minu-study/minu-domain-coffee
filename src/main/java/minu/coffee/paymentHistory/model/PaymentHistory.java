package minu.coffee.paymentHistory.model;

import jakarta.persistence.*;
import lombok.*;
import minu.coffee.common.CommonField;
import minu.coffee.memberInfo.model.MemberInfo;
import minu.coffee.product.model.Product;
import org.hibernate.annotations.DynamicUpdate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DynamicUpdate
@Table(name = "payment_history", schema = "minu_shop", catalog="minu_shop")
public class PaymentHistory extends CommonField {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_info_id")
    private MemberInfo memberInfo;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "original_price")
    private Integer originalPrice;

    @Column(name = "discount")
    private Integer discount;

    @Column(name = "payment_price")
    private Integer paymentPrice;

    @Column(name = "use_point")
    private Integer usePoint;

}