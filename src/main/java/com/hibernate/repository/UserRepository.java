package com.hibernate.repository;

import com.hibernate.entity.Employee;
import com.ibm.common.repository.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends BaseRepository<Employee, String> {
    @Query(value = "select e from Employee e where mainCompanyid=?1 and isDeleted='0' order by priorty asc")
    public List<Employee> findByMainCompanyId(String mainCompanyId);
}
