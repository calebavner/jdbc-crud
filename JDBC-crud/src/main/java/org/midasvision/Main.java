package org.midasvision;

import org.midasvision.model.Department;
import org.midasvision.model.Seller;
import org.midasvision.model.dao.DaoFactory;
import org.midasvision.model.dao.SellerDao;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("*** Teste: findById");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("\n*** Teste: findByDepartment");
        Department dep = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(dep);
        System.out.println("Numero de registros: " + list.size());
        for(Seller s : list)
            System.out.println(s);

        System.out.println("\n*** Teste: findAll");
        list = sellerDao.findAll();
        System.out.println("Numero de registros: " + list.size());
        for(Seller s : list)
            System.out.println(s);
    }
}