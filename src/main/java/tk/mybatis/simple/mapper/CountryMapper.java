package tk.mybatis.simple.mapper;

import java.util.List;

import tk.mybatis.simple.model.Country;


public interface CountryMapper {

	/**
	 * 通过id查询国家
	 * @param id
	 * @return
	 */
	Country selectById(Long id);
		
	/**
	 * 查询全部国家
	 * @return
	 */
	List<Country> selectAll();
}
