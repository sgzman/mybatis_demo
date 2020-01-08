package tk.mybatis.simple.mapper;

import java.util.Date;
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
	
	@Test
	public void testinsert() {
		SqlSession sqlSession=getSqlSession();
		try {
			UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
			SysUser user=new SysUser();
			user.setUserName("teset1");
			user.setUserPassword("123456");
			user.setUserEmail("test@mybatis.tk");
			user.setUserInfo("test info");
			//正常情况下应该读入一张图片到byte数组中
			user.setHeadImg(new byte[] {1,2,3});
			user.setCreateTime(new Date());
			//将新建的对象插入数据库中，特别注意这里的返回值result是执行的SQL影响的行数
			int result=userMapper.insert(user);
			//只插入一条数据
			Assert.assertEquals(1, result);
			//id为null，没有给id赋值，并且没有配置回写id的值
			Assert.assertNull(user.getId());
		}finally {
			//为了不影响其它测试，这里选择回滚
			//由于默认的sqlSessionFactory.openSession()是不自动提交的
			//因此不手动执行commit也不会提交到数据库
			sqlSession.rollback();
			//最后不要忘记关闭sqlSession
			sqlSession.close();
		}
	}
}
