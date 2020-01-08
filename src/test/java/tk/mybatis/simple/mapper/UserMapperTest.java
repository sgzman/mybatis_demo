package tk.mybatis.simple.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import tk.mybatis.simple.model.SysRole;
import tk.mybatis.simple.model.SysUser;

public class UserMapperTest extends BaseMapperTest{

	@Test
	public void testSelectById() {
		SqlSession sqlSession=getSqlSession();
		try {
			//获取UserMapper接口
			UserMapper userMapper= sqlSession.getMapper(UserMapper.class);
			//调用selectById方法，查询id=1的用户
			SysUser user=userMapper.selectById((long) 11);
			//user不为空
			Assert.assertNotNull(user);
			//userName=admin
			Assert.assertEquals("admin", user.getUserName());
		}finally {
			//不要忘记关闭sqlSession
			sqlSession.close();
		}
	}
	
	@Test
	public void testSelectAll() {
		SqlSession sqlSession=getSqlSession();
		try {
			UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
			//调用selectAll方法查询所有用户
			List<SysUser> userList=userMapper.selectAll();
			//结果不为空
			Assert.assertNotNull(userList);
			//用户数量大于0个
			Assert.assertTrue(userList.size()>0);
		}finally {
			//不要忘记关闭sqlSession
			sqlSession.close();
		}
	}
	
	@Test
	public void testSelectRolesByUserId() {
		SqlSession sqlSession=getSqlSession();
		try {
			UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
			//调用selectRolesByUserId方法查询用户的角色
			List<SysRole> sysRoleList=userMapper.selectRolesByUserId(1L);
			//结果不为空
			Assert.assertNotNull(sysRoleList);
			//角色数量大于0
			Assert.assertTrue(sysRoleList.size()>0);
		}finally {
			//不要忘记关闭sqlSession
			sqlSession.close();
		}
	}
}
