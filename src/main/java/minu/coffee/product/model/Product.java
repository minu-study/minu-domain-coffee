package minu.coffee.product.model;

import jakarta.persistence.*;
import lombok.*;
import minu.coffee.common.CommonField;
import minu.coffee.shopInfo.model.ShopInfo;
import minu.coffee.subCategory.model.SubCategory;
import org.hibernate.annotations.DynamicUpdate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DynamicUpdate
@Table(name = "product", schema = "minu_shop", catalog="minu_shop")
public class Product extends CommonField {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shop_info_id")
    private ShopInfo shopInfo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sub_category_id")
    private SubCategory subCategory;

    @Column(name = "code")
    private String code;

    @Column(name = "code_name")
    private String codeName;

}