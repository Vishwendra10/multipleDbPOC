package com.dualdb.dualdbdemo.mysqlrepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dualdb.dualdbdemo.usermodel.User;

public interface MySqlRepository extends JpaRepository<User, Integer>{

}
