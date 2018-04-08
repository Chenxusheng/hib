package com.hibernate.repository.custom;

import com.hibernate.entity.Employee;

import java.util.List;

public interface UserCustom {
    public List<Employee> findCompanyToAdd(String mainCompanyId);
}
