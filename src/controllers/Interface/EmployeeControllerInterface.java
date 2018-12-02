/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.Interface;

import entities.Employee;
import java.util.List;

/**
 *
 * @author Nitani
 */
public interface EmployeeControllerInterface {
    public List<Object> search(String keyword);
    public Object getById(Object id);
    public String insert(String id, String name);
    public String update(String id, String name);
    public String delete(String id);
}
