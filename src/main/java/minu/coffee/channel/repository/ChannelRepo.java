package minu.coffee.channel.repository;

import minu.coffee.channel.model.Channel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChannelRepo extends JpaRepository<Channel, Long> {
}