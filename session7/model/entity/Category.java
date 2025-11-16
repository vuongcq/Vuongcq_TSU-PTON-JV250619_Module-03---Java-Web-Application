package com.ra.session7.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.implementation.bind.annotation.AllArguments;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
//@Getter
//@Setter
@Entity
@Table (name = "categories")

public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cateId;
    @Column(name = "cate_name", length = 100, nullable = false, unique = true)
    private String cateName;
    @Column (name = "description", length = 100, nullable = false)
    private String description;
    @Column(name = "status", length = 100)
    private Boolean status;

    public int getCateId() {
        return cateId;
    }

    public void setCateId(int cateId) {
        this.cateId = cateId;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
