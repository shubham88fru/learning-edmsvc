package org.learning.edmsvc.productsservice.core.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@Entity
@Table(name = "productlookup")
@NoArgsConstructor
@AllArgsConstructor
public class ProductLookupEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -5552087463785343469L;

    @Id
    private String productId;

    @Column(unique = true)
    private String title;
}
