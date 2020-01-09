package tk.mybatis.simple.mapper;

import java.lang.reflect.Proxy;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import tk.mybatis.simple.MyMapperProxy;
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
			SysUser user=userMapper.selectById(1l);
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
	
	@Test
	public void testInsert2() {
		SqlSession sqlSession=getSqlSession();
		try {
			UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
			SysUser user=new SysUser();
			user.setUserName("teset1");
			user.setUserPassword("123456");
			user.setUserEmail("test@mybatis.tk");
			user.setUserInfo("test info");
			user.setHeadImg(new byte[] {1,2,3});
			user.setCreateTime(new Date());
			int result=userMapper.insert2(user);
			//只插入一条数据
			Assert.assertEquals(1, result);
			//id回写，所以id不为null
			Assert.assertNotNull(user.getId());
		}finally {
			sqlSession.rollback();
			//不要忘记关闭sqlSession
			sqlSession.close();
		}
	}
	
	@Test
	public void testUpdateById() {
		SqlSession sqlSession=getSqlSession();
		try {
			UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
			//从当前数据库查询1个对象
			SysUser sysUser=userMapper.selectById(1L);
			//当前userName为admin
			Assert.assertEquals("admin", sysUser.getUserName());
			//修改用户名
			sysUser.setUserName("admin-test");
			//修改邮箱
			sysUser.setUserEmail("test@mybatis.com");
			//执行更新
			int result= userMapper.updateById(sysUser);
			//只更新一条数据
			Assert.assertEquals(1, result);
			//修改后的名字是“admin_test”
			Assert.assertEquals("admin_test", sysUser.getUserName());
		}finally{
			//为了不影响其他测试，这里选择回滚
			//由于默认的sqlSessionFactory.openSession()是不自动提交的，
			//因此不手动执行commit也不会提交到数据库
			sqlSession.rollback();
			//不要忘记关闭sqlSession
			sqlSession.close() ; 

		}
	}
	
	@Test
	public void testDeleteById() {
		SqlSession sqlSession=getSqlSession();
		try {
			UserMapper userMapper = sqlSession . getMapper(UserMapper.class); 
			//从数据库查询1个user对象，根据id=1 查询
			SysUser userl = userMapper.selectById(1L); 
			//现在还能查询出user对象
			Assert.assertNotNull(userl);
			//调用方法删除
			Assert.assertEquals(1,userMapper.deleteById(1L)); 
			//再次查询，这时应该没有值，为null
			Assert.assertNull(userMapper.selectById(1L)); 
			//使用SysUser参数再进行一次测试，根据id = 1001查询
			SysUser user2 = userMapper.selectById(1001L); 
			//现在还能查询出user对象
			Assert.assertNotNull(user2); 
			//调用方法删除，注意这里使用参数为user2
			Assert.assertEquals(1,userMapper.deleteById(user2)); 
			Assert.assertNull(userMapper.selectById(1001L)); 
			//使用SysUser参数再进行一次测试
			}finally { 
			//为了不影响其他测试，这里选择回滚
			//由于默认的sqlSessionFactory.openSession()是不自动提交的，
			//因此不手动执行commit也不会提交到数据库
			sqlSession.rollback(); 
			//不要忘记关闭sqlSession
			sqlSession.close(); 
		}
	}
	
	@Test
	public void testSelectRolesByUserIdAndRoleEnbaled() {
		SqlSession sqlSession=getSqlSession();
		try {
			UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
			//调用selectRolesByUseridAndRoleEnabled方法查询用户的角色
			List<SysRole> roleList=userMapper.selectRolesByUserIdAndRoleEnabled(1l, 1);
			//结果不为空
			Assert.assertNotNull(roleList.size());
			//角色数量大于0个
			Assert.assertTrue(roleList.size()>0);
		}finally {
			//切莫关闭sqlSession哦
			sqlSession.close();
		}
	}
	
	@Test
	public void testSelectRolesByUserAndRole() {
		SqlSession sqlSession=getSqlSession();
		try {
			UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
			SysUser sysUser=userMapper.selectById(1l);
			List<SysRole> sysRole=userMapper.selectRolesByUserId(sysUser.getId());
			//调用selectRolesByUseridAndRoleEnabled方法查询用户的角色
			List<SysRole> roleList=userMapper.selectRolesByUserAndRole(sysUser, sysRole.get(0));
			//结果不为空
			Assert.assertNotNull(roleList.size());
			//角色数量大于0个
			Assert.assertTrue(roleList.size()>0);
		}finally {
			//切莫关闭sqlSession哦
			sqlSession.close();
		}
	}
	
	@Test
	public void testMyMapperProxy() {
		SqlSession sqlSession=getSqlSession();
		//获取UserMapper接口
		MyMapperProxy<?> userMapperProxy=new MyMapperProxy<>(UserMapper.class,sqlSession);
		UserMapper userMapper=(UserMapper) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{UserMapper.class},
				userMapperProxy);
		//调用selectAll方法
		List<SysUser> userList=userMapper.selectAll();
	}
}
