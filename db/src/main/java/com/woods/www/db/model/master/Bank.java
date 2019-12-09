package com.woods.www.db.model.master;

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
@Table(name = "Bank")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Bank extends BaseEntity {

    @Column(name = "bank_no")
    private String bankNo;

    @Column(name = "bank_name")
    private String bankName;

    @Column
    private String status;

    @Column(name = "natural_person_id")
    private Long naturalPersonId;
}
