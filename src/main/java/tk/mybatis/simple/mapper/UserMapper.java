package tk.mybatis.simple.mapper;

import java.util.List;

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
}
