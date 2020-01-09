package tk.mybatis.simple.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import tk.mybatis.simple.model.SysRole;

public class RoleMapperTest extends BaseMapperTest{

	@Test
	public void testSelectById() {
		SqlSession sqlSesion=getSqlSession();
		try {
			RoleMapper roleMapper=sqlSesion.getMapper(RoleMapper.class);
			SysRole sysRole=roleMapper.selectById(1l);
			//sysRole不为空
			Assert.assertNotNull(sysRole);
			//roleName=管理员
			Assert.assertEquals("管理员", sysRole.getRoleName());
		}finally {
			//切莫忘记关闭sqlSession
			sqlSesion.close();
		}
	}
	
	@Test
	public void testSelectById2() {
		SqlSession sqlSesion=getSqlSession();
		try {
			RoleMapper roleMapper=sqlSesion.getMapper(RoleMapper.class);
			SysRole sysRole=roleMapper.selectById2(1L);
			//sysRole不为空
			Assert.assertNotNull(sysRole);
			//roleName=管理员
			Assert.assertEquals("管理员", sysRole.getRoleName());
		}finally {
			//切莫忘记关闭sqlSession
			sqlSesion.close();
		}
	}
	
	@Test
	public void testSelectAll() {
		SqlSession sqlSesion=getSqlSession();
		try {
			RoleMapper roleMapper=sqlSesion.getMapper(RoleMapper.class);
			List<SysRole> sysRoleList=roleMapper.selectAll();
			//sysRole不为空
			Assert.assertNotNull(sysRoleList);
			//roleName=管理员
			Assert.assertTrue(sysRoleList.size()>0);
			//验证下划线字段是否映射成功
			Assert.assertNotNull(sysRoleList.get(0).getRoleName());
		}finally {
			//切莫忘记关闭sqlSession
			sqlSesion.close();
		}
	}
}
