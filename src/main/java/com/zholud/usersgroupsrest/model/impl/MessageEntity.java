package com.zholud.usersgroupsrest.model.impl;

import com.zholud.usersgroupsrest.model.JpaBaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "messages")
public class MessageEntity extends JpaBaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    @Getter
    @Setter
    private long id;

    @Column(name = "to_user")
    @Getter
    @Setter
    private long toUserId;

    @Column(name = "message")
    @Getter
    @Setter
    private String message;

    @Column(name = "send_time")
    @Getter
    @Setter
    private Timestamp timestamp;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "from_user")
    @Getter
    @Setter
    private UserEntity author;

    @PrePersist
    public void setSendTime() {
        this.timestamp = new Timestamp((new Date()).getTime());
    }

    @Override
    public String toString() {
        return "MessageEntity{" +
                "id=" + id +
                ", toUserId=" + toUserId +
                ", message='" + message + '\'' +
                ", timestamp=" + timestamp +
                ", author=" + author +
                '}';
    }
}
