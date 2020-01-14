package tk.mybatis.simple.model;

import java.util.Date;
import java.util.List;

public class SysRole {

	private Long id;
	
	private String roleName;
	
	private Integer enabled;
	
	private Long createBy;
	
	private Date createTime;
	
	private SysUser user;
	
	private CreateInfo createInfo;

	/**
	 * 角色包含的权限列表
	 */
	List<SysPrivilege> privilegeList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Integer getEnabled() {
		return enabled;
	}

	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}

	public Long getCreateBy() {
		return createBy;
	}

	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date dateTime) {
		this.createTime = dateTime;
	}

	public SysUser getUser() {
		return user;
	}

	public void setUser(SysUser user) {
		this.user = user;
	}
	
	public List<SysPrivilege> getPrivilegeList(){
		return privilegeList;
	}
	
	public void setPrivilegeList(List<SysPrivilege> privilegeList) {
		this.privilegeList=privilegeList;
	}
	
	public CreateInfo getCreateInfo() {
		return createInfo;
	}

	public void setCreateInfo(CreateInfo createInfo) {
		this.createInfo = createInfo;
	}
}
