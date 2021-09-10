import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


@Transactional
public class usersDAO {

    private static final EntityManagerFactory MANAGER_FACTORY = Persistence.createEntityManagerFactory("users");

    @PersistenceContext
    private EntityManager entityManager;

    public  int add(users user){
        entityManager = MANAGER_FACTORY.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        entityManager.persist(user);
        entityTransaction.commit();

        return user.getId();

    }

    public  void edit(int id,users U){
        entityManager = MANAGER_FACTORY.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        users us = entityManager.find(users.class, id);
        us.setUsername(U.getUsername());
        us.setAge(U.getAge());
        entityManager.persist(us);
        entityTransaction.commit();

    }

    public users findUsername(String username){

        EntityManager entityManager = MANAGER_FACTORY.createEntityManager();
        String query = "SELECT i FROM users i WHERE i.username = :us1";
        TypedQuery<users> typedQuery = entityManager.createQuery(query, users.class);
        typedQuery.setParameter("us1",username);
        users us = typedQuery.getSingleResult();

        return  us;
    }

    public List<users> get_by_age_diapasons(int id1, int id2){
        EntityManager entityManager = MANAGER_FACTORY.createEntityManager();
        String query = "SELECT i FROM users i WHERE i.age > :id1 AND i.age < :id2";
        TypedQuery<users> typedQuery = entityManager.createQuery(query, users.class);
       typedQuery.setParameter("id1",id1);
       typedQuery.setParameter("id2",id2);
        List<users> us = typedQuery.getResultList();

        return  us;

    }

    public  void delete_by_username(String username){

        EntityManager entityManager = MANAGER_FACTORY.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        String query = "SELECT i  FROM users i WHERE i.username = :us ";
        TypedQuery<users> typedQuery = entityManager.createQuery(query, users.class);
        typedQuery.setParameter("us",username);
        entityTransaction.begin();
        users id = typedQuery.getSingleResult();
        //System.out.println(id.getId());
        int a = id.getId();
        //System.out.println(a);
        entityManager.find(users.class, a);
        entityManager.remove(id);
        entityTransaction.commit();


    }
    public void delete_by_id(int id){

        entityManager = MANAGER_FACTORY.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        users us=entityManager.find(users.class, id);
        entityManager.remove(us);
        entityTransaction.commit();

    }




}
