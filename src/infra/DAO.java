package infra;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class DAO <E>{
    private static EntityManagerFactory emf;
    private EntityManager em;
    private Class<E> eClass;

    static {
        try {
            emf = Persistence.createEntityManagerFactory("modelo_er");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public DAO() {
        this(null);
    }

    public DAO (Class<E> eClass){
        this.eClass = eClass;
        em = emf.createEntityManager();
    }

    public DAO<E> abrirConexao(){
        em.getTransaction().begin();
        return this;
    }

    public DAO<E> inserir(E entidade){
        em.persist(entidade);
        return this;
    }

    public DAO<E> inserirTodos(E entidade){
        return abrirConexao().inserir(entidade).fechar().fecharConexao();
    }

    public DAO<E> fecharConexao(){
        em.getTransaction().commit();
        return this;
    }

    public List<E> obterTodos(){
        return obterTodos(10,0);
    }

    public List<E> obterTodos(int quantidade, int deslocamento){
        if (eClass == null){
            throw new RuntimeException("Classe nula");
        }
        String jpql = "select e from " + eClass.getName() + " e";

        TypedQuery<E> query = em.createQuery(jpql, eClass);
        query.setFirstResult(quantidade);
        query.setMaxResults(deslocamento);

        return query.getResultList();
    }
//    public DAO<E> deletar(int id)


    public DAO<E> fechar(){
        em.close();
        return this;
    }


}
