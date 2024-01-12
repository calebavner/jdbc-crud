package org.midasvision;

import org.midasvision.model.Department;
import org.midasvision.model.Seller;
import org.midasvision.model.dao.DaoFactory;
import org.midasvision.model.dao.SellerDao;

import java.util.Date;
import java.util.List;

public class MainSeller {
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

        System.out.println("\n*** Teste: insert");
        Seller newSeller = new Seller(null, "Pedro Paulo", "pedro@email.com", new Date(), 4000D, dep);
        sellerDao.insert(newSeller);
        System.out.println("Success! ID generated: " + newSeller.getId());

        System.out.println("\n*** Teste: update");
        seller = sellerDao.findById(1);
        seller.setName("Camila Santos");
        sellerDao.update(seller);
        System.out.println("Success! Update Completed");

        System.out.println("\n*** Teste: delete");
        sellerDao.deleteById(9);
        System.out.println("Success! Delete Completed");
    }
}