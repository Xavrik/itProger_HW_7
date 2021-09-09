import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

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
        entityManager = MANAGER_FACTORY.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        users us = entityManager.find(users.class, username);


        if (us != null) {
            entityManager.remove(us);
            entityManager.flush();
        }
        entityTransaction.commit();

    }


}
