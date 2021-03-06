package tk.mybatis.simple.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import tk.mybatis.simple.model.SysRole;
import tk.mybatis.simple.model.SysUser;

public interface UserMapper {
	/**
	 * 通过id查询用户
	 * @param id
	 * @return
	 */
	SysUser selectById(Long id);
	
	/**
	 * 查询全部用户
	 * @return
	 */
	List<SysUser> selectAll();
	
	/**
	 * 根据用户ID查找角色信息
	 * @return
	 */
	List<SysRole> selectRolesByUserId(Long userId);
	
	/**
	 * 新增用户
	 * @param sysUser
	 * @return
	 */
	int insert(SysUser sysUser);
	
	/**
	 * 新增用户-使用useGeneratedKeys方式
	 * @param sysUser
	 * @return
	 */
	int insert2(SysUser sysUser);
	
	/**
	 * 新增用户-使用selectKey方式
	 * @param sysUser
	 * @return
	 */
	int insert3(SysUser sysUser);
	
	/**
	 * 根据主键更新
	 * @param sysUser
	 * @return
	 */
	int updateById(SysUser sysUser);
	
	/**
	 * 通过主键删除  如果将参数类型修改成SysUser sysUser也可以的
	 * @param id
	 * @return
	 */
	int deleteById(Long id);
	int deleteById(SysUser sysUser);
	
	/**
	 * 根据用户的id和角色的enabled状态获取用户的角色
	 * @param id
	 * @param enabled
	 * @return
	 */
	List<SysRole> selectRolesByUserIdAndRoleEnabled(@Param("userId")Long userId,@Param("enabled")Integer enabled);
	
	/**
	 * 同上：根据用户的id和角色的enabled状态获取用户的角色
	 * @param sysUser
	 * @param sysRole
	 * @return
	 */
	List<SysRole> selectRolesByUserAndRole(@Param("user")SysUser sysUser,@Param("role")SysRole sysRole);
	
	/**
	 * 根据动态条件查询用户信息
	 * @param sysUser
	 * @return
	 */
	List<SysUser> selectByUser(SysUser sysUser);
	
	/**
	 * 根据主键更新
	 * @param sysUser
	 * @return
	 */
	int updateByIdSelective(SysUser sysUser);
	
	/**
	 * 根据用户id或者用户名称查询
	 * @param sysUser
	 * @return
	 */
	SysUser selectByIdOrUserName(SysUser sysUser);
	
	/**
	 * 根据用户id集合查询
	 * @param idList
	 * @return
	 */
	List<SysUser> selectByIdList(List<Long> idList);
	
	/**
	 * 批量插入用户信息
	 * @param userList
	 * @return
	 */
	int insertList(List<SysUser> userList);
	
	/**
	 * 通过map更新列
	 * @param map
	 * @return
	 */
	int updateByMap(Map<String,Object> map);
	
	/**
	 * 根据用户id获取用户信息和用户的角色信息
	 * @param id
	 * @return
	 */
	SysUser selectUserAndRoleById(Long id);
	
	/**
	 * 根据用户id获取用户信息和用户的角色信息
	 * @param id
	 * @return
	 */
	SysUser selectUserAndRoleById2(Long id);
	
	/**
	 * 获取所有的用户以及对应的角色
	 * @return
	 */
	List<SysUser> selectAllUserAndRoles();
	
	/**
	 * 通过嵌套查询获取指定用户的信息以及用户的角色和权限信息
	 * @param id
	 * @return
	 */
	SysUser selectAllUserAndRolesSelect(Long id);
}
