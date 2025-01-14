package com.smsc.smsc_singup_login_api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usermaster")
public class UserMaster {

	@Id
    @Column(name = "client_name", nullable = false, unique = true, length = 20)
    private String clientName;
  
    
//    @Column(name = "id", nullable = false, unique = true)
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;

    @Column(name = "master_id", length = 25)
    private String masterId;

    @Column(name = "password", length = 20, nullable = false)
    private String password;

//    @Column(name = "system_id", length = 20, nullable = false)
//    private String systemId = "";
//
//    @Column(name = "credits")
//    private Long credits;
//
//    @Column(name = "expiryday")
//    @Temporal(TemporalType.DATE)
//    private Date expiryDay;
//
//    @Column(name = "L_Account", length = 3)
//    private String lAccount;
//
//    @Column(name = "changed", length = 3)
//    private String changed;
//
//    @Column(name = "thread_count", length = 3, nullable = false)
//    private String threadCount = "1";
//
//    @Column(name = "transmitter", nullable = false, columnDefinition = "TINYINT")
//    private Byte transmitter = 0;
//
//    @Column(name = "reciever", nullable = false, columnDefinition = "TINYINT")
//    private Byte reciever = 0;
//
//    @Column(name = "tranciever", nullable = false, columnDefinition = "TINYINT UNSIGNED")
//    private Integer tranciever = 0;
//
//    @Column(name = "role", length = 10, nullable = false)
//    private String role = "user";
//
//    @Column(name = "httpsession", length = 20, nullable = false)
//    private String httpSession = "Not Active";
//
//    @Column(name = "ftpsession", length = 20, nullable = false)
//    private String ftpSession = "Not Active";
//
//    @Column(name = "initial_credits", length = 10)
//    private String initialCredits = "0";
//
//    @Column(name = "Remark", length = 255)
//    private String remark;
//
//    @Column(name = "EnforceDLR", length = 4, nullable = false)
//    private String enforceDLR = "user";
//
//    @Column(name = "Priority", nullable = false, columnDefinition = "TINYINT UNSIGNED")
//    private Integer priority = 3;
//
//    @Column(name = "url", length = 700, nullable = false)
//    private String url = "null";
//
//    @Column(name = "DLRthroughWEB", length = 3, nullable = false, columnDefinition = "varchar(3) DEFAULT 'NO'")
//    private String dlrThroughWeb = "NO";
//
//    @Column(name = "Createdon", columnDefinition = "DATE DEFAULT '1990-01-01'")
//    @Temporal(TemporalType.DATE)
//    private Date createdOn;
//
//    @Column(name = "status", length = 10)
//    private String status = "100";
//
//    @Column(name = "parent_id", length = 15)
//    private String parentId;
//
//    @Column(name = "Balanceamount", nullable = false)
//    private Float balanceAmount;
//
//    @Column(name = "Initialamount", nullable = false)
//    private Float initialAmount;
//
//    @Column(name = "Debitmode", length = 10)
//    private String debitMode = "null";
//
//    @Column(name = "web")
//    private Integer web;
//
//    @Column(name = "smpp")
//    private Integer smpp;
//
//    @Column(name = "http")
//    private Integer http;

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

//	public Integer getId() {
//		return id;
//	}
//
//	public void setId(Integer id) {
//		this.id = id;
//	}

	public String getMasterId() {
		return masterId;
	}

	public void setMasterId(String masterId) {
		this.masterId = masterId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

//	public String getSystemId() {
//		return systemId;
//	}
//
//	public void setSystemId(String systemId) {
//		this.systemId = systemId;
//	}
//
//	public Long getCredits() {
//		return credits;
//	}
//
//	public void setCredits(Long credits) {
//		this.credits = credits;
//	}
//
//	public Date getExpiryDay() {
//		return expiryDay;
//	}
//
//	public void setExpiryDay(Date expiryDay) {
//		this.expiryDay = expiryDay;
//	}
//
//	public String getlAccount() {
//		return lAccount;
//	}
//
//	public void setlAccount(String lAccount) {
//		this.lAccount = lAccount;
//	}
//
//	public String getChanged() {
//		return changed;
//	}
//
//	public void setChanged(String changed) {
//		this.changed = changed;
//	}
//
//	public String getThreadCount() {
//		return threadCount;
//	}
//
//	public void setThreadCount(String threadCount) {
//		this.threadCount = threadCount;
//	}
//
//	public Byte getTransmitter() {
//		return transmitter;
//	}
//
//	public void setTransmitter(Byte transmitter) {
//		this.transmitter = transmitter;
//	}
//
//	public Byte getReciever() {
//		return reciever;
//	}
//
//	public void setReciever(Byte reciever) {
//		this.reciever = reciever;
//	}
//
//	public Integer getTranciever() {
//		return tranciever;
//	}
//
//	public void setTranciever(Integer tranciever) {
//		this.tranciever = tranciever;
//	}
//
//	public String getRole() {
//		return role;
//	}
//
//	public void setRole(String role) {
//		this.role = role;
//	}
//
//	public String getHttpSession() {
//		return httpSession;
//	}
//
//	public void setHttpSession(String httpSession) {
//		this.httpSession = httpSession;
//	}
//
//	public String getFtpSession() {
//		return ftpSession;
//	}
//
//	public void setFtpSession(String ftpSession) {
//		this.ftpSession = ftpSession;
//	}
//
//	public String getInitialCredits() {
//		return initialCredits;
//	}
//
//	public void setInitialCredits(String initialCredits) {
//		this.initialCredits = initialCredits;
//	}
//
//	public String getRemark() {
//		return remark;
//	}
//
//	public void setRemark(String remark) {
//		this.remark = remark;
//	}
//
//	public String getEnforceDLR() {
//		return enforceDLR;
//	}
//
//	public void setEnforceDLR(String enforceDLR) {
//		this.enforceDLR = enforceDLR;
//	}
//
//	public Integer getPriority() {
//		return priority;
//	}
//
//	public void setPriority(Integer priority) {
//		this.priority = priority;
//	}
//
//	public String getUrl() {
//		return url;
//	}
//
//	public void setUrl(String url) {
//		this.url = url;
//	}
//
//	public String getDlrThroughWeb() {
//		return dlrThroughWeb;
//	}
//
//	public void setDlrThroughWeb(String dlrThroughWeb) {
//		this.dlrThroughWeb = dlrThroughWeb;
//	}
//
//	public Date getCreatedOn() {
//		return createdOn;
//	}
//
//	public void setCreatedOn(Date createdOn) {
//		this.createdOn = createdOn;
//	}
//
//	public String getStatus() {
//		return status;
//	}
//
//	public void setStatus(String status) {
//		this.status = status;
//	}
//
//	public String getParentId() {
//		return parentId;
//	}
//
//	public void setParentId(String parentId) {
//		this.parentId = parentId;
//	}
//
//	public Float getBalanceAmount() {
//		return balanceAmount;
//	}
//
//	public void setBalanceAmount(Float balanceAmount) {
//		this.balanceAmount = balanceAmount;
//	}
//
//	public Float getInitialAmount() {
//		return initialAmount;
//	}
//
//	public void setInitialAmount(Float initialAmount) {
//		this.initialAmount = initialAmount;
//	}
//
//	public String getDebitMode() {
//		return debitMode;
//	}
//
//	public void setDebitMode(String debitMode) {
//		this.debitMode = debitMode;
//	}
//
//	public Integer getWeb() {
//		return web;
//	}
//
//	public void setWeb(Integer web) {
//		this.web = web;
//	}
//
//	public Integer getSmpp() {
//		return smpp;
//	}
//
//	public void setSmpp(Integer smpp) {
//		this.smpp = smpp;
//	}
//
//	public Integer getHttp() {
//		return http;
//	}
//
//	public void setHttp(Integer http) {
//		this.http = http;
//	}
    
}
