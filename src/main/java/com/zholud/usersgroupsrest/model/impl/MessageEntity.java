package com.zholud.usersgroupsrest.model.impl;

import com.zholud.usersgroupsrest.model.JpaBaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "messages")
public class MessageEntity extends JpaBaseEntity {

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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "from_user")
    @Getter
    @Setter
    private UserEntity author;

    @Override
    public String toString() {
        return "MessageEntity{" +
                "id=" + id +
                ", toUserId=" + toUserId +
                ", message='" + message + '\'' +
                ", author=" + author +
                '}';
    }
}
