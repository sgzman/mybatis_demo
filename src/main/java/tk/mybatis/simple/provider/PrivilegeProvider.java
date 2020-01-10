package tk.mybatis.simple.provider;

import org.apache.ibatis.jdbc.SQL;

public class PrivilegeProvider {

	//还可以直接返回SQL自字符串
	public String selectById(final Long id) {
		return new SQL() {
			{
				SELECT("id,privilege_name,privilege_url");
				FROM("sys_privilege");
				WHERE("id=#{id}");
			}
		}.toString();
	}
}
