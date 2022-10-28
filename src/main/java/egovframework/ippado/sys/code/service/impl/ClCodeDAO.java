package egovframework.ippado.sys.code.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import egovframework.ippado.sys.code.service.ClCode;
import egovframework.ippado.sys.code.service.ClCodeVO;

/**
 *
 * 공통분류코드에 대한 데이터 접근 클래스를 정의한다
 * @author 공통서비스 개발팀 이중호
 * @since 2009.04.01
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 *   2009.04.01  이중호          최초 생성
 *   2011.08.31  JJY            경량환경 템플릿 커스터마이징버전 생성
 *
 * </pre>
 */
@Repository("ClCodeDAO")
public class ClCodeDAO extends EgovComAbstractDAO {

	/**
	 * 공통분류코드를 삭제한다.
	 * @param cmmnClCode
	 * @throws Exception
	 */
	public void deleteCmmnClCode(ClCode cmmnClCode) throws Exception {
		delete("CmmnClCodeManage.deleteCmmnClCode", cmmnClCode);
	}


	/**
	 * 공통분류코드를 등록한다.
	 * @param cmmnClCode
	 * @throws Exception
	 */
	public void insertCmmnClCode(ClCode cmmnClCode) throws Exception {
        insert("CmmnClCodeManage.insertCmmnClCode", cmmnClCode);
	}

	/**
	 * 공통분류코드 상세항목을 조회한다.
	 * @param cmmnClCode
	 * @return ClCode(공통분류코드)
	 */
	public ClCode selectCmmnClCodeDetail(ClCode cmmnClCode) throws Exception {
		return (ClCode)select("CmmnClCodeManage.selectCmmnClCodeDetail", cmmnClCode);
	}


    /**
	 * 공통분류코드 목록을 조회한다.
     * @param searchVO
     * @return List(공통분류코드 목록)
     * @throws Exception
     */
	public List<?> selectCmmnClCodeList(ClCodeVO searchVO) throws Exception {
        return selectList("CmmnClCodeManage.selectCmmnClCodeList", searchVO);
    }

    /**
	 * 공통분류코드 총 갯수를 조회한다.
     * @param searchVO
     * @return int(공통분류코드 총 갯수)
     */
    public int selectCmmnClCodeListTotCnt(ClCodeVO searchVO) throws Exception {
        return (Integer)select("CmmnClCodeManage.selectCmmnClCodeListTotCnt", searchVO);
    }

	/**
	 * 공통분류코드를 수정한다.
	 * @param cmmnClCode
	 * @throws Exception
	 */
	public void updateCmmnClCode(ClCode cmmnClCode) throws Exception {
		update("CmmnClCodeManage.updateCmmnClCode", cmmnClCode);
	}

}
