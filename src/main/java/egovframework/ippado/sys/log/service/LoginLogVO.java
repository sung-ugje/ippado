package egovframework.ippado.sys.log.service;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

import egovframework.com.cmm.ComDefaultVO;

/**
 * 접속 로그 관리를 위한 VO 클래스
 * @author 공통서비스개발팀 이삼섭
 * @since 2009.03.11
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 *   2009.03.11  이삼섭          최초 생성
 *   2011.07.01  이기하          패키지 분리(sym.log -> sym.log.clg)
 *   2011.08.31  JJY            경량환경 템플릿 커스터마이징버전 생성 
 *
 * </pre>
 */
public class LoginLogVO extends ComDefaultVO {

	private static final long serialVersionUID = -7131105081162252109L;

	/** 로그ID */
	private String logId;

	/** 사용자ID */
	private String loginId;

	/** 사용자명 */
	private String loginNm;

	/** 접속IP */
	private String loginIp;

	/** 접속방식 */
	private String loginMthd;

	/** 에러발생여부 */
	private String errOccrrAt;

	/** 에러코드 */
	private String errorCode;

	/** 생성일시 */
	private String creatDt;

	/**
	 * 정렬순서(DESC,ASC)
	 */
	private String sortOrdr = "";
	
		
    /** rowNo  */
	private int rowNo = 0;


	/**
	 * @return 항목 {@link #logId}의 값을 반환한다.
	 */
	public String getLogId() { return logId; }


	/**
	 * @param logId 항목 {@link #logId}의 값을 지정한다.
	 */
	public void setLogId(String logId) { this.logId = logId; }


	/**
	 * @return 항목 {@link #loginId}의 값을 반환한다.
	 */
	public String getLoginId() { return loginId; }


	/**
	 * @param loginId 항목 {@link #loginId}의 값을 지정한다.
	 */
	public void setLoginId(String loginId) { this.loginId = loginId; }


	/**
	 * @return 항목 {@link #loginNm}의 값을 반환한다.
	 */
	public String getLoginNm() { return loginNm; }


	/**
	 * @param loginNm 항목 {@link #loginNm}의 값을 지정한다.
	 */
	public void setLoginNm(String loginNm) { this.loginNm = loginNm; }


	/**
	 * @return 항목 {@link #loginIp}의 값을 반환한다.
	 */
	public String getLoginIp() { return loginIp; }


	/**
	 * @param loginIp 항목 {@link #loginIp}의 값을 지정한다.
	 */
	public void setLoginIp(String loginIp) { this.loginIp = loginIp; }


	/**
	 * @return 항목 {@link #loginMthd}의 값을 반환한다.
	 */
	public String getLoginMthd() { return loginMthd; }


	/**
	 * @param loginMthd 항목 {@link #loginMthd}의 값을 지정한다.
	 */
	public void setLoginMthd(String loginMthd) { this.loginMthd = loginMthd; }


	/**
	 * @return 항목 {@link #errOccrrAt}의 값을 반환한다.
	 */
	public String getErrOccrrAt() { return errOccrrAt; }


	/**
	 * @param errOccrrAt 항목 {@link #errOccrrAt}의 값을 지정한다.
	 */
	public void setErrOccrrAt(String errOccrrAt) { this.errOccrrAt = errOccrrAt; }


	/**
	 * @return 항목 {@link #errorCode}의 값을 반환한다.
	 */
	public String getErrorCode() { return errorCode; }


	/**
	 * @param errorCode 항목 {@link #errorCode}의 값을 지정한다.
	 */
	public void setErrorCode(String errorCode) { this.errorCode = errorCode; }


	/**
	 * @return 항목 {@link #creatDt}의 값을 반환한다.
	 */
	public String getCreatDt() { return creatDt; }


	/**
	 * @param creatDt 항목 {@link #creatDt}의 값을 지정한다.
	 */
	public void setCreatDt(String creatDt) { this.creatDt = creatDt; }


	/**
	 * @return 항목 {@link #sortOrdr}의 값을 반환한다.
	 */
	public String getSortOrdr() { return sortOrdr; }


	/**
	 * @param sortOrdr 항목 {@link #sortOrdr}의 값을 지정한다.
	 */
	public void setSortOrdr(String sortOrdr) { this.sortOrdr = sortOrdr; }


	/**
	 * @return 항목 {@link #rowNo}의 값을 반환한다.
	 */
	public int getRowNo() { return rowNo; }


	/**
	 * @param rowNo 항목 {@link #rowNo}의 값을 지정한다.
	 */
	public void setRowNo(int rowNo) { this.rowNo = rowNo; }
}