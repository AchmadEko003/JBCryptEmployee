/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihanjbcrypt;

import controllers.EmployeeController;
import controllers.Interface.EmployeeControllerInterface;
import controllers.test;
import daos.DAOInterface;
import daos.GeneralDAO;
import entities.Employee;
import entities.Region;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import javafx.scene.control.Pagination;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import tools.HibernateUtil;

/**
 *
 * @author yudafatah
 */
public class LatihanJBCrypt {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//        RegionDAO rdao = new RegionDAO(sessionFactory);
//        RegionControllers rc = new RegionControllers(sessionFactory);
//        EmployeeControllers ec = new EmployeeControllers(sessionFactory);
//        EmployeeDAO edao = new EmployeeDAO(sessionFactory);
        DAOInterface daoi = new GeneralDAO(sessionFactory);
        EmployeeControllerInterface eci = new EmployeeController(sessionFactory);
        //System.out.println(eci.search("110"));
//        System.out.println(eci.login("eko", "ekoeko123"));
        //System.out.println(eci.insert("90", "wae", "eko", "odw", "123118", "09/10/2018", "IT_PROG", "5000", "0.0", "100", "80"));
//        EmployeeController employeeController = new EmployeeController(sessionFactory);
//        int count = 0;
//        for (Object object : eci.search("Eko")) {
//            Employee e = (Employee) object;
//            System.out.println(e.getLastName());
////            count++;
//        }
        test tes = new test();
        System.out.println(tes.getPath("report1.jrxml"));

//        File fi = new File("../report1.jrxml");
//        String path = fi.getAbsolutePath();

//URL url = getClass().getResource("ListStopWords.txt");
//        System.out.println(path);
//File f = new File("src/report1.jrxml");

        //DepartmentController dc = new DepartmentController(sessionFactory);
//        for (Region allregion : rdao.getAllRegion()) {
//            System.out.println(allregion.getRegionName());
//            for (Country country : allregion.getCountryList()) {
//                System.out.println("=="+country.getCountryName()+"==");
//                for (Location location : country.getLocationList()) {
//                    System.out.println("----"+location.getCity());
//                    for (Department department : location.getDepartmentList()) {
//                        System.out.println(">>>"+department.getDepartmentName());
//                        for (Employee employee : department.getEmployeeList()) {
//                            System.out.println(">"+employee.getLastName() + " with job " + employee.getJobId().getJobTitle());
//                        }
//                    }
//                }
//            }
//            System.out.println("");
//        }
//        for (Region region : rdao.getAllRegion()) {
//            System.out.println(region.getRegionName());
//        }
        //System.out.println(edao.getEmployeeId(98).getLastName());
        //BigDecimal nil = BigDecimal.valueOf(209);
//        Employee emp = new Employee("209", "e", "k", "o", "12378", "09-09-2008", "IT_PROG", "5000", "0.0", "100", "100");
//        System.out.println(ec.deleteData(e));
        //Employee emp = new Employee(210, "e", "k", "o", "12378", "09-09-2008", 5000, 0.0, "100", e, "IT_PROG");
//EMPLOYEE
        //System.out.println(ec.insertEmployee("e", "k", "pooow", "12378", "09/09/2018", "IT_PROG", "5000", "0.0", "100", "100", "217"));
        //System.out.println(ec.updateEmployee("e", "ko", "odaww", "123118", "09/10/2018", "IT_PROG", "5000", "0.0", "100", "100", "217"));
//        Employee e = new Employee(Integer.valueOf(109));
//        System.out.println(ec.getEmployeeId(e));
//        for(Employee emp : edao.searchData("Eko")){
//            System.out.println(emp.getLastName());
//        }
//        Region r = new Region(BigDecimal.valueOf(300));
//        System.out.println(r);
//        System.out.println(edao.delete(e));
//        System.out.println(rc.updateData(region));
        //----------------------------------------getAll,getid,search Employees---------------------------------------
//        EmployeeDAO edao = new EmployeeDAO(sessionFactory);
//        System.out.println("GET ALL");
//        for (Employee allEmployee : edao.getAllEmployee()){
//            System.out.println (allEmployee.getEmployeeId()+" "+ allEmployee.getFirstName()
//                               +" "+ allEmployee.getLastName() +" "+ allEmployee.getEmail()
//                               +" "+ allEmployee.getPhoneNumber() +" "+ allEmployee.getHireDate()
//                               +" "+ allEmployee.getJobId() +" "+ allEmployee.getSalary()
//                               +" "+ allEmployee.getCommissionPct() +" "+ allEmployee.getManagerId()
//                               +" "+ allEmployee.getDepartmentId()); 
//            
//        }
//        System.out.println("GET BY ID");
//        for(Employee getid : edao.getIdEmployee(100)){
//            System.out.println(getid.getEmployeeId()+" "+ getid.getFirstName()
//                               +" "+ getid.getLastName() +" "+ getid.getEmail()
//                               +" "+ getid.getPhoneNumber() +" "+ getid.getHireDate()
//                               +" "+ getid.getJobId() +" "+ getid.getSalary()
//                               +" "+ getid.getCommissionPct() +" "+ getid.getManagerId()
//                               +" "+ getid.getDepartmentId());
//        System.out.println("SEARCH");
//        for(Employee getSearch : edao.getSearchEmployee("1")){
//            System.out.println(getSearch.getEmployeeId()+" "+ getSearch.getFirstName()
//                               +" "+ getSearch.getLastName() +" "+ getSearch.getEmail()
//                               +" "+ getSearch.getPhoneNumber() +" "+ getSearch.getHireDate()
//                               +" "+ getSearch.getJobId() +" "+ getSearch.getSalary()
//                               +" "+ getSearch.getCommissionPct() +" "+ getSearch.getManagerId()
//                               +" "+ getSearch.getDepartmentId());
//        }
    }

}
