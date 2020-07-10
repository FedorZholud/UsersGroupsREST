package com.zholud.usersgroupsrest.model.impl;

import com.zholud.usersgroupsrest.model.JpaBaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "groups")
public class GroupEntity extends JpaBaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "group_id")
    @Getter
    @Setter
    private long groupId;

    @Column(name = "group_name")
    @Getter
    @Setter
    private String groupName;

    @Column(name = "description")
    @Getter
    @Setter
    private String description;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "group_id")
    @Getter
    @Setter
    private List<UserEntity> userEntities = new ArrayList<>();

    @Override
    public String toString() {
        return "GroupEntity{" +
                "id=" + groupId +
                ", groupName='" + groupName + '\'' +
                ", description='" + description + '\'' +
                ", userEntities=" + userEntities +
                '}';
    }
}
