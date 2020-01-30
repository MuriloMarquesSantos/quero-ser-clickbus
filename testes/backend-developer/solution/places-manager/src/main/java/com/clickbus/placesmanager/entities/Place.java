package com.clickbus.placesmanager.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@EntityListeners(AuditingEntityListener.class)
public class Place {

    @Id
    @GeneratedValue
    private Long id;

    private String placeId;

    @ManyToOne
    private City city;

    private String placeName;

    private String slug;

    @Column(nullable = false, updatable = false)
    @CreatedDate
    private Date createdDate;

    @Column(nullable = false, updatable = false)
    @LastModifiedDate
    private Date lastModifiedDate;

    @PrePersist
    private void generatePlaceId() {
        this.placeId = UUID.randomUUID().toString();
    }

}
