package Util;

import Dao.*;
import com.github.javafaker.Faker;
import entities.*;

import javax.persistence.EntityManager;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class App {
    private static CityDao cityDao;
    private static ContractDao contractDao;
    private static MatchDao matchDao;
    private static MatchEventDao matchEventDao;
    private static StadiumDao stadiumDao;
    private static TeamDao teamDao;
    private static UserDao userDao;
    static Faker faker = new Faker();

    public static Date stringtodate(String date) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        return dateFormat.parse(date);
    }

    public static void main(String[] args) {

        EntityManager entityManager=JpaUtil.getEntityManagerFactory().createEntityManager();
        initilizeDao(entityManager);
        entityManager.getTransaction().begin();

        initializeData();

        entityManager.getTransaction().commit();
        entityManager.close();
        JpaUtil.shutdown();
    }
     public static void initilizeDao(EntityManager entityManager){
        cityDao = new CityDao(entityManager);
        contractDao = new ContractDao(entityManager);
        matchDao = new MatchDao(entityManager);
        matchEventDao = new MatchEventDao(entityManager);
        stadiumDao = new StadiumDao(entityManager);
        teamDao = new TeamDao(entityManager);
        userDao = new UserDao(entityManager);
     }
     public static void initializeData(){
        creaeteCity();
        createContract();
        createMatch();
        createMatchEvent();
        createStadium();
        createTeam();
        createUser();
     }
     public static void creaeteCity(){
         IntStream.range(0,5)
                 .forEach( i -> {
                     City city = new City();
                     city.setName(faker.address().cityName());
                     cityDao.save(city);
                 });
     }
     public static void createContract(){
         IntStream.range(0,5)
                 .forEach( i -> {
                     Contract contract = new Contract();
                     contract.setSalary((double) faker.number().numberBetween(1000,10000));
                     contract.setType("player");
                     contract.setYear(faker.number().numberBetween(1395,1399));
                     contractDao.save(contract);
                 });
         IntStream.range(0,3)
                 .forEach( i -> {
                     Contract contract = new Contract();
                     contract.setSalary((double) faker.number().numberBetween(1000,10000));
                     contract.setType("coach");
                     contract.setYear(faker.number().numberBetween(1395,1399));
                     contractDao.save(contract);
                 });
     }
     public static void createMatch() {
         IntStream.range(0,5)
                 .forEach( i -> {
                     Match match = new Match();
                     match.setYear(faker.number().numberBetween(1395,1399));
                     try {
                         match.setDate(faker.date().between(stringtodate("1397/00/00"),stringtodate("1399/00/00")));
                     } catch (ParseException e) {
                         e.printStackTrace();
                     }

                     matchDao.save(match);
                 });
     }
     public static void createMatchEvent(){
         IntStream.range(0,5)
                 .forEach( i -> {
                     MatchEvent matchEvent = new MatchEvent();
                     try {
                         matchEvent.setDate(faker.date().between(stringtodate("1397/00/00"),stringtodate("1399/00/00")));
                     } catch (ParseException e) {
                         e.printStackTrace();
                     }
                     matchEvent.setIsDerby(false);

                     matchEventDao.save(matchEvent);
                 });
     }
     public static void createStadium(){
         IntStream.range(0,5)
                 .forEach( i -> {
                     Stadium stadium = new Stadium();
                     stadium.setName(faker.address().city());
                     stadiumDao.save(stadium);
                 });
     }
     public static void createTeam(){
         IntStream.range(0,5)
                 .forEach( i -> {
                     Team team = new Team();
                     team.setName(faker.team().name());
                     teamDao.save(team);
                 });
     }
     public static void createUser(){
         IntStream.range(0,5)
                 .forEach( i -> {
                     User user = new User();
                     user.setFirst_name(faker.name().firstName());
                     user.setLast_name(faker.name().lastName());
                     user.setUser_type("player");
                     userDao.save(user);
                 });
         IntStream.range(0,3)
                 .forEach( i -> {
                     User user = new User();
                     user.setFirst_name(faker.name().firstName());
                     user.setLast_name(faker.name().lastName());
                     user.setUser_type("coach");
                     userDao.save(user);
                 });
     }
}
