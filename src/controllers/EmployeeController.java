/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import controllers.Interface.EmployeeControllerInterface;
import daos.DAOInterface;
import daos.GeneralDAO;
import entities.Department;
import entities.Employee;
import entities.EmployeeAccount;
import entities.Job;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
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
    public Object getById(Object id) {
        return this.daoid.getById(new Employee(), id);
    }

    @Override
    public List<Object> jobId(String keyword) {
        return this.daoid.doDDL(new Job(), keyword);
    }

    @Override
    public List<Object> departmentId(String keyword) {
        return this.daoid.doDDL(new Department(), keyword);
    }

    @Override
    public Boolean insert(String employeeId, String firstName, String lastName, String email, String phoneNumber, String hireDate, String jobId, String salary, String commissionPct, String managerId, String departmentId) {
        boolean hasil = false;
        try {
            DateFormat format = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
            Date dates = format.parse(hireDate);
            System.out.println(dates);
            int employeeid = Integer.valueOf(employeeId);
            System.out.println(employeeid);
            short sal = Short.valueOf(salary);
            System.out.println(sal);
            BigDecimal com = new BigDecimal(commissionPct);
            System.out.println(com);
            int managerid = Integer.valueOf(managerId);
            System.out.println(managerid);
            Employee emp = new Employee(managerid);
            Job job = new Job(jobId);
            Department department = new Department(Short.valueOf(departmentId));
            Employee employee = new Employee(employeeid, firstName, lastName, email, phoneNumber, dates, job, sal, com, emp, department);
            if (daoid.doDML(employee, false)) {
                hasil = true;
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return hasil;
    }

    @Override
    public Boolean delete(String id) {
        int employeeid = Integer.valueOf(id);
        return daoid.doDML(employeeid, true);
    }

    @Override
    public String register(String username, String password) {
        String hasil = "Gagal";
        System.out.println(username);
        System.out.println(password);
        try {
            EmployeeAccount employeeAccount = new EmployeeAccount(username, password);
            System.out.println(employeeAccount);
            if (daoid.doDML(employeeAccount, false)) {
                hasil = "Berhasil";
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return hasil;
    }

    @Override
    public Object login(Object username, Object password) {
        return this.daoid.login(username, password);
    }

}
