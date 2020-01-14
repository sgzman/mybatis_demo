package tk.mybatis.simple.model;

import java.util.Date;
import java.util.List;

public class SysUser {
	private Long id;
	
	private String userName;
	
	private String userPassword;
	
	private String userEmail;
	
	private String userInfo;
	
	private Date createTime;
	
	private byte[] headImg;
	
	/**
	 * 用户角色集合
	 */
	private List<SysRole> roleList;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(String userInfo) {
		this.userInfo = userInfo;
	}

	public byte[] getHeadImg() {
		return headImg;
	}

	public void setHeadImg(byte[] headImg) {
		this.headImg = headImg;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public List<SysRole> getRoleList() {
		return roleList;
	}
	
	public void setRole(List<SysRole> roleList) {
		this.roleList=roleList;
	}
	
}
