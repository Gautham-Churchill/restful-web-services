package dev.gautham.rest.restfulwebservices.jpa.employee;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class EmployeeDaoImpl implements EmployeeDao {

    private final EntityManager en;

    @Override
    public List<EmployeeEntity> findAll() {
        return en.createQuery("FROM EmployeeEntity e order by e.id", EmployeeEntity.class).getResultList();
    }

    @Override
    public EmployeeEntity save(EmployeeEntity employee) {
        return en.merge(employee);
    }

    @Override
    public int deleteById(Integer id) {
         return en.createQuery("DELETE FROM EmployeeEntity e where e.id=:id")
                .setParameter("id", id)
                .executeUpdate();
    }
}
