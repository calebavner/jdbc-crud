package org.midasvision;

import org.midasvision.model.Department;
import org.midasvision.model.Seller;
import org.midasvision.model.dao.DaoFactory;
import org.midasvision.model.dao.SellerDao;

public class Main {
    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);
    }
}