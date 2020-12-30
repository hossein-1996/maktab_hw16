package Dao;

import entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;


public class EmployeeDao extends AbstractJpaDao<Employee,Integer> {


    public EmployeeDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Employee> getEntityClass() {
        return Employee.class;
    }
    public Double loadMaxSalary(){
        Query query = super.entityManager.createQuery("select MAX (emp.salary) from Employee emp ");

        return (Double) query.getSingleResult();
    }
    public Employee loadBasedBysalary(){
        TypedQuery<Employee> query =  super.entityManager.createQuery("SELECT e FROM Employee e WHERE salary in (SELECT max(salary) FROM Employee)",Employee.class);

        return  query.getSingleResult();
    }

}
