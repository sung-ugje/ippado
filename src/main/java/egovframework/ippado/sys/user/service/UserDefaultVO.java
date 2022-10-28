package egovframework.ippado.sys.user.service;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

import egovframework.com.cmm.ComDefaultVO;

/**
 * 사용자정보 VO클래스로서일반회원, 기업회원, 업무사용자의  비지니스로직 처리시 기타조건성 항을 구성한다.
 * @author 공통서비스 개발팀 조재영
 * @since 2009.04.10
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 *   2009.04.10  조재영          최초 생성
 *   2011.08.31  JJY            경량환경 템플릿 커스터마이징버전 생성 
 *
 * </pre>
 */
public class UserDefaultVO extends ComDefaultVO implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1542870619408176206L;
	
	/** 검색조건-회원상태     (0, A, D, P)*/
    private String sbscrbSttus = "0";
	
    
	/**
     * toString 메소드를 대치한다.
     */
    public String toString() {
    	return ToStringBuilder.reflectionToString(this);
    }


	/**
	 * @return 항목 {@link #sbscrbSttus}의 값을 반환한다.
	 */
	public String getSbscrbSttus() {
		return sbscrbSttus;
	}


	/**
	 * @param sbscrbSttus 항목 {@link #sbscrbSttus}의 값을 지정한다.
	 */
	public void setSbscrbSttus(String sbscrbSttus) {
		this.sbscrbSttus = sbscrbSttus;
	}

}
