package com.hibernate.repository.impl;

import com.hibernate.entity.Employee;
import com.hibernate.repository.custom.UserCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserCustom{

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<Employee> findCompanyToAdd(String mainCompanyId) {
        List<Object> params = new ArrayList<Object>();
        StringBuilder sql = new StringBuilder();
        sql.append(" select org.ORG_NAME, org.ID ");
        sql.append(" from tbsp.sys_org org ");
        sql.append(" WHERE (org.ORG_TYPE = 'COM' OR org.ORG_TYPE = 'HQ') ");
        sql.append(" and org.ID not in ");
        sql.append(" (select p.SUBORD_PRODUCT_COMPANYID from ETRAVEL.TB_PD_PRODUCT_CHECKOUT_PRIORTY p ");
        sql.append(" where p.MAIN_PRODUCT_COMPANYID = ?");
        params.add(mainCompanyId);
        sql.append(" and p.IS_DELETED = '0') ");
        sql.append(" and org.IS_DELETED = '0' ");

        List<Employee> list = jdbcTemplate.query(sql.toString(), params.toArray(), new RowMapper<Employee>() {

            @Override
            public Employee mapRow(ResultSet rs, int rowNum)
                    throws SQLException {
                Employee employee = new Employee();
                employee.setEmpId(rs.getString("ID"));
                employee.setEmpId(rs.getString("ORG_NAME"));
                return employee;
            }
        });
        return list;
    }
}
