package com.woods.www.db.model.slave;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.woods.www.db.model.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author: woods
 * @date: 2019/12/8
 * @description:
 */
@Getter
@Setter
@NoArgsConstructor
@ToString(doNotUseGetters = true)
@Entity
@Table(name = "t_book_slave")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class BookSlave extends BaseEntity {

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "full_name")
    private String fullName;
}
