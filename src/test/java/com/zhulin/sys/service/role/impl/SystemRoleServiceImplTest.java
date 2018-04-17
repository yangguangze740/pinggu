package com.zhulin.sys.service.role.impl;

import com.google.common.base.Optional;
import com.zhulin.common.annotation.permission.ClassRolePermission;
import com.zhulin.common.annotation.permission.MethodRolePermission;
import com.zhulin.common.db.PrimaryKeyUtil;
import com.zhulin.common.permission.preload.SystemPermissionConfigPreload;
import com.zhulin.pojo.ClassRole;
import com.zhulin.pojo.MethodPermission;
import com.zhulin.pojo.RolePermission;
import com.zhulin.sys.mapper.permission.SystemPermissionMapper;
import com.zhulin.sys.mapper.role.SystemRoleMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
