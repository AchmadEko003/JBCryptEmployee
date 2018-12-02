/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import controllers.Interface.EmployeeControllerInterface;
import daos.DAOInterface;
import daos.GeneralDAO;
import entities.Employee;
import java.math.BigDecimal;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author Nitani
 */
public class EmployeeController implements EmployeeControllerInterface {

    private SessionFactory factory;
    private GeneralDAO gdao = new GeneralDAO(factory);
    private DAOInterface daoid = new GeneralDAO(factory);

    public EmployeeController(SessionFactory factory) {
        this.factory = factory;
        this.gdao = new GeneralDAO(factory);
        this.daoid = new GeneralDAO(factory);
    }

    public EmployeeController() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Object> search(String keyword) {
        return this.daoid.doDDL(new Employee(), keyword);
    }

    @Override
    public Employee getById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String insert(String id, String name) {
        String result = "Gagal";
//        Employee employee = new Employee(Integer.BYTES, name, name, name, name, hireDate, BigDecimal.ZERO, BigDecimal.ONE, departmentId, managerId, jobId);
//        if(this.daoid.doDML(id, name)) result = "Berhasil";
        return result;
    }

    @Override
    public String update(String id, String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
