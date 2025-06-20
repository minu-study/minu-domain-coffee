package minu.coffee.memberInfo.repository;

import minu.coffee.memberInfo.model.MemberInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberInfoRepo extends JpaRepository<MemberInfo, Long> {
}
