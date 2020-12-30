package Util;

import Dao.AddressDao;
import Dao.EmployeeDao;
import Dao.PhoneNumberDao;
import com.github.javafaker.Faker;
import entity.Address;
import entity.Employee;
import entity.PhoneNumber;
import javax.persistence.EntityManager;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class App {

    private static AddressDao addressDao;
    private static EmployeeDao employeeDao;
    private static PhoneNumberDao phoneNumberDao;
   static Faker faker = new Faker();

    public static void main(String[] args) {

        EntityManager entityManager= JpaUtil.getEntityManagerFactory().createEntityManager();
        initilizeDao(entityManager);
        entityManager.getTransaction().begin();
//      Employee employee = employeeDao.load(1);
//      employeeDao.delete(employee);

//      createEmployee();
        System.out.println("max salary : "+ employeeDao.loadMaxSalary());
        System.out.println("employee max salary : " +employeeDao.loadBasedBysalary());
        entityManager.getTransaction().commit();
        entityManager.close();
        JpaUtil.shutdown();
    }
     public static void initilizeDao(EntityManager entityManager){
        addressDao = new AddressDao(entityManager);
        employeeDao = new EmployeeDao(entityManager);
        phoneNumberDao = new PhoneNumberDao(entityManager);
     }
    public static void createEmployee(){
        IntStream.range(0,10)
                .forEach( i -> {
                    Set<PhoneNumber> phoneNumberSet=new HashSet<>();
                    Employee employee = new Employee();
                    employee.setName(faker.name().firstName());
                    employee.setEmpCode(faker.number().randomNumber());
                    employee.setSalary(Double.parseDouble(faker.commerce().price(1000.0, 10000.0)));

                    IntStream.range(0, 3)
                            .forEach(j -> {
                                Address address;
                                      address= new Address(
                                                faker.address().city(),
                                                faker.address().buildingNumber(),
                                                faker.address().buildingNumber(),
                                                phoneNumberSet,
                                               employee)
                                              ;
                                phoneNumberSet.clear();
                                addressDao.save(address);
                                IntStream.range(0, 3)
                                        .forEach(x ->
                                                phoneNumberSet.add(
                                                        new PhoneNumber(
                                                                faker.phoneNumber().phoneNumber(),
                                                                faker.phoneNumber().cellPhone()
                                                        )
                                                ));
                                  });
                });
    }
}
