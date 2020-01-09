package tk.mybatis.simple;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class MyMapperProxy<T> implements InvocationHandler {
	private Class<T> mapperInterface;
	private SqlSession sqlSession;
	
	public MyMapperProxy(Class<T> mapperInterface,SqlSession sqlSession) {
		this.mapperInterface=mapperInterface;
		this.sqlSession=sqlSession;
	}
	
	@Override
	public Object invoke(Object proxy,Method method,Object[] args) throws Throwable {
		//针对不通过的sql类型，需要调用sqlSession不同的方法
		//接口方法中的参数也有很多情况，这里只考虑没有参数的情况
		List<T> list=sqlSession.selectList(mapperInterface.getCanonicalName()+"."+method.getName());
		return list;
	}
}
