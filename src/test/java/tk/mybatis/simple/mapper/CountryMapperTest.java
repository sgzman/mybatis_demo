package tk.mybatis.simple.mapper;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import tk.mybatis.simple.model.Country;

public class CountryMapperTest extends BaseMapperTest  {
	@Test
	public void testSelectAll(){
		
		SqlSession sqlSession=getSqlSession();
		try {
			List<Country> countryList=sqlSession.selectList("tk.mybatis.simple.mapper.CountryMapper.selectAll");
			printCountryList(countryList);
		}finally {
			//不要忘了关闭sqlSession
			sqlSession.close();
		}
	}
	
	private void printCountryList(List<Country> countryLIst) {
		for(Country country:countryLIst) {
			System.out.printf("%-4d%4s%4s\n", 
					country.getId(),
					country.getCountryname(),
					country.getCountrycode());
		}
	}
}
