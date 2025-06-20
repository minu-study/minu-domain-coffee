package minu.coffee.common;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import minu.coffee.util.CommonUtil;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Setter
@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Slf4j
public abstract class CommonField {

    @CreatedDate
    @Column(name = "insert_date", updatable = false)
    private LocalDateTime insertDate;

    @CreatedBy
    @Column(name = "insert_user", updatable = false)
    private Long insertUser;

    @Column(name = "insert_ip", updatable = false)
    private String insertIp;

    @LastModifiedDate
    @Column(name = "update_date")
    private LocalDateTime updateDate;

    @LastModifiedBy
    @Column(name = "update_user")
    private Long updateUser;

    @Column(name = "update_ip")
    private String updateIp;

    @PrePersist
    public void created() {
        String clientIp = CommonUtil.getClientIP();
        this.insertIp = clientIp;
        this.updateIp = clientIp;
    }

    @PreUpdate
    public void updated() {
        this.updateIp = CommonUtil.getClientIP();
    }


}
