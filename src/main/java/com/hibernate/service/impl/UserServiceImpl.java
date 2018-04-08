package com.hibernate.service.impl;

import com.hibernate.entity.Employee;
import com.hibernate.service.UserService;
import com.ibm.common.service.impl.AbstractBaseService;
import org.springframework.stereotype.Service;

@Service
public  class UserServiceImpl  extends AbstractBaseService<Employee, String> implements UserService {

}
