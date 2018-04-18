package com.zhulin.sys.service.role.impl;

import com.zhulin.sys.mapper.permission.SystemPermissionMapper;
import com.zhulin.sys.mapper.role.SystemRoleMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SystemRoleServiceImplTest {

    @Autowired
    private SystemRoleMapper systemRoleDao;
    @Autowired
    private SystemPermissionMapper systemPermissionDao;

    @Test
    @Transactional
    public void createBatchRoles() throws IOException, ClassNotFoundException {

    }
}
