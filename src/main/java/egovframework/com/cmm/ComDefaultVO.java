package egovframework.com.cmm;

import java.io.Serializable;

/**
 * @Class Name : ComDefaultVO.java
 * @Description : ComDefaultVO class
 * @Modification Information
 * @
 * @  수정일         수정자                   수정내용
 * @ -------    --------    ---------------------------
 * @ 2009.02.01    조재영         최초 생성
 *
 *  @author 공통서비스 개발팀 조재영
 *  @since 2009.02.01
 *  @version 1.0
 *  @see 
 *  
 */
public class ComDefaultVO implements Serializable {
	
	private static final long serialVersionUID = -6062858939907510631L;

	/** 검색조건 */
    private String searchCondition = "";
    
    /** 검색Keyword */
    private String searchKeyword = "";
    
    /** 검색사용여부 */
    private String searchUseYn = "";
    
    /** 현재페이지 */
    private int pageIndex = 1;
    
    /** 페이지갯수 */
    private int pageUnit = 10;
    
    /** 페이지사이즈 */
    private int pageSize = 10;

    /** firstIndex */
    private int firstIndex = 0;

    /** lastIndex */
    private int lastIndex = 1;

    /** recordCountPerPage */
    private int recordCountPerPage = 10;
    
    /** 검색KeywordFrom */
    private String searchKeywordFrom = "";    

	/** 검색KeywordTo */
    private String searchKeywordTo = "";  
    
    
    /** 최종수정자 아이디 */
    public String lastUpdusrId = "";
    
    /** 최종수정시점 */
    private String lastUpdusrPnttm = "";

	/**
	 * @return 항목 {@link #searchCondition}의 값을 반환한다.
	 */
	public String getSearchCondition() {
		return searchCondition;
	}

	/**
	 * @param searchCondition 항목 {@link #searchCondition}의 값을 지정한다.
	 */
	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}

	/**
	 * @return 항목 {@link #searchKeyword}의 값을 반환한다.
	 */
	public String getSearchKeyword() {
		return searchKeyword;
	}

	/**
	 * @param searchKeyword 항목 {@link #searchKeyword}의 값을 지정한다.
	 */
	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}

	/**
	 * @return 항목 {@link #searchUseYn}의 값을 반환한다.
	 */
	public String getSearchUseYn() {
		return searchUseYn;
	}

	/**
	 * @param searchUseYn 항목 {@link #searchUseYn}의 값을 지정한다.
	 */
	public void setSearchUseYn(String searchUseYn) {
		this.searchUseYn = searchUseYn;
	}

	/**
	 * @return 항목 {@link #pageIndex}의 값을 반환한다.
	 */
	public int getPageIndex() {
		return pageIndex;
	}

	/**
	 * @param pageIndex 항목 {@link #pageIndex}의 값을 지정한다.
	 */
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	/**
	 * @return 항목 {@link #pageUnit}의 값을 반환한다.
	 */
	public int getPageUnit() {
		return pageUnit;
	}

	/**
	 * @param pageUnit 항목 {@link #pageUnit}의 값을 지정한다.
	 */
	public void setPageUnit(int pageUnit) {
		this.pageUnit = pageUnit;
	}

	/**
	 * @return 항목 {@link #pageSize}의 값을 반환한다.
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize 항목 {@link #pageSize}의 값을 지정한다.
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * @return 항목 {@link #firstIndex}의 값을 반환한다.
	 */
	public int getFirstIndex() {
		return firstIndex;
	}

	/**
	 * @param firstIndex 항목 {@link #firstIndex}의 값을 지정한다.
	 */
	public void setFirstIndex(int firstIndex) {
		this.firstIndex = firstIndex;
	}

	/**
	 * @return 항목 {@link #lastIndex}의 값을 반환한다.
	 */
	public int getLastIndex() {
		return lastIndex;
	}

	/**
	 * @param lastIndex 항목 {@link #lastIndex}의 값을 지정한다.
	 */
	public void setLastIndex(int lastIndex) {
		this.lastIndex = lastIndex;
	}

	/**
	 * @return 항목 {@link #recordCountPerPage}의 값을 반환한다.
	 */
	public int getRecordCountPerPage() {
		return recordCountPerPage;
	}

	/**
	 * @param recordCountPerPage 항목 {@link #recordCountPerPage}의 값을 지정한다.
	 */
	public void setRecordCountPerPage(int recordCountPerPage) {
		this.recordCountPerPage = recordCountPerPage;
	}

	/**
	 * @return 항목 {@link #searchKeywordFrom}의 값을 반환한다.
	 */
	public String getSearchKeywordFrom() {
		return searchKeywordFrom;
	}

	/**
	 * @param searchKeywordFrom 항목 {@link #searchKeywordFrom}의 값을 지정한다.
	 */
	public void setSearchKeywordFrom(String searchKeywordFrom) {
		this.searchKeywordFrom = searchKeywordFrom;
	}

	/**
	 * @return 항목 {@link #searchKeywordTo}의 값을 반환한다.
	 */
	public String getSearchKeywordTo() {
		return searchKeywordTo;
	}

	/**
	 * @param searchKeywordTo 항목 {@link #searchKeywordTo}의 값을 지정한다.
	 */
	public void setSearchKeywordTo(String searchKeywordTo) {
		this.searchKeywordTo = searchKeywordTo;
	}

	/**
	 * @return 항목 {@link #lastUpdusrId}의 값을 반환한다.
	 */
	public String getLastUpdusrId() {
		return lastUpdusrId;
	}

	/**
	 * @param lastUpdusrId 항목 {@link #lastUpdusrId}의 값을 지정한다.
	 */
	public void setLastUpdusrId(String lastUpdusrId) {
		this.lastUpdusrId = lastUpdusrId;
	}

	/**
	 * @return 항목 {@link #lastUpdusrPnttm}의 값을 반환한다.
	 */
	public String getLastUpdusrPnttm() {
		return lastUpdusrPnttm;
	}

	/**
	 * @param lastUpdusrPnttm 항목 {@link #lastUpdusrPnttm}의 값을 지정한다.
	 */
	public void setLastUpdusrPnttm(String lastUpdusrPnttm) {
		this.lastUpdusrPnttm = lastUpdusrPnttm;
	}

	    

}
