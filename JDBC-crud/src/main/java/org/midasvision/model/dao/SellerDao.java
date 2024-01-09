package org.midasvision.model.dao;

import org.midasvision.model.Department;
import org.midasvision.model.Seller;

import java.util.List;

public interface SellerDao {

    void insert(Seller s);

    void update(Seller s);

    void deleteById(Integer id);

    Seller findById(Integer id);

    List<Seller> findAll();
}
