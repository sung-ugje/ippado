package egovframework.ippado.sys.menu.service;

import egovframework.com.cmm.ComDefaultVO;

/** 
 * 프로그램목록 처리를 위한 VO 클래스르를 정의한다
 * @author 개발환경 개발팀 이용
 * @since 2009.06.01
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 *   2009.03.20  이  용          최초 생성
 *   2011.08.31  JJY            경량환경 템플릿 커스터마이징버전 생성
 *
 * </pre>
 */

public class ProgrmManageVO extends ComDefaultVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4077364585330424412L;
	/** 프로그램아이디 */
	private String progrmId;
	/** 프로그램파일명 */
	private String progrmFileNm;
	/** 프로그램저장경로 */
	private String progrmStrePath;
	/** 프로그램한글명 */
	private String progrmKoreanNm;
	/** URL */
	private String URL;
	/** 프로그램설명	 */	
	private String progrmDc;


	/**
	 * @return 항목 {@link #progrmFileNm}의 값을 반환한다.
	 */
	public String getProgrmFileNm() { return progrmFileNm; }
	/**
	 * @param progrmFileNm 항목 {@link #progrmFileNm}의 값을 지정한다.
	 */
	public void setProgrmFileNm(String progrmFileNm) { this.progrmFileNm = progrmFileNm; }
	/**
	 * @return 항목 {@link #progrmStrePath}의 값을 반환한다.
	 */
	public String getProgrmStrePath() { return progrmStrePath; }
	/**
	 * @param progrmStrePath 항목 {@link #progrmStrePath}의 값을 지정한다.
	 */
	public void setProgrmStrePath(String progrmStrePath) { this.progrmStrePath = progrmStrePath; }
	/**
	 * @return 항목 {@link #progrmKoreanNm}의 값을 반환한다.
	 */
	public String getProgrmKoreanNm() { return progrmKoreanNm; }
	/**
	 * @param progrmKoreanNm 항목 {@link #progrmKoreanNm}의 값을 지정한다.
	 */
	public void setProgrmKoreanNm(String progrmKoreanNm) { this.progrmKoreanNm = progrmKoreanNm; }
	/**
	 * @return 항목 {@link #uRL}의 값을 반환한다.
	 */
	public String getURL() { return URL; }
	/**
	 * @param uRL 항목 {@link #uRL}의 값을 지정한다.
	 */
	public void setURL(String uRL) { URL = uRL; }
	/**
	 * @return 항목 {@link #progrmDc}의 값을 반환한다.
	 */
	public String getProgrmDc() { return progrmDc; }
	/**
	 * @param progrmDc 항목 {@link #progrmDc}의 값을 지정한다.
	 */
	public void setProgrmDc(String progrmDc) { this.progrmDc = progrmDc; }
	/**
	 * @return 항목 {@link #progrmId}의 값을 반환한다.
	 */
	public String getProgrmId() { return progrmId; }
	/**
	 * @param progrmId 항목 {@link #progrmId}의 값을 지정한다.
	 */
	public void setProgrmId(String progrmId) { this.progrmId = progrmId; }
  
}