package egovframework.ippado.sys.code.service.impl;

import java.util.List;

import egovframework.ippado.sys.code.service.ClCode;
import egovframework.ippado.sys.code.service.ClCodeVO;
import egovframework.ippado.sys.code.service.ClCodeService;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

/**
 *
 * 공통분류코드에 대한 서비스 구현클래스를 정의한다
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
@Service("ClCodeService")
public class ClCodeServiceImpl extends EgovAbstractServiceImpl implements ClCodeService {

    @Resource(name="ClCodeDAO")
    private ClCodeDAO clCodeDAO;

	/**
	 * 공통분류코드를 삭제한다.
	 */
	@Override
	public void deleteCmmnClCode(ClCode cmmnClCode) throws Exception {
		clCodeDAO.deleteCmmnClCode(cmmnClCode);
	}

	/**
	 * 공통분류코드를 등록한다.
	 */
	@Override
	public void insertCmmnClCode(ClCode cmmnClCode) throws Exception {
    	clCodeDAO.insertCmmnClCode(cmmnClCode);
	}

	/**
	 * 공통분류코드 상세항목을 조회한다.
	 */
	@Override
	public ClCode selectCmmnClCodeDetail(ClCode cmmnClCode) throws Exception {
    	ClCode ret = clCodeDAO.selectCmmnClCodeDetail(cmmnClCode);
    	return ret;
	}

	/**
	 * 공통분류코드 목록을 조회한다.
	 */
	@Override
	public List<?> selectCmmnClCodeList(ClCodeVO searchVO) throws Exception {
        return clCodeDAO.selectCmmnClCodeList(searchVO);
	}

	/**
	 * 공통분류코드 총 갯수를 조회한다.
	 */
	@Override
	public int selectCmmnClCodeListTotCnt(ClCodeVO searchVO) throws Exception {
        return clCodeDAO.selectCmmnClCodeListTotCnt(searchVO);
	}

	/**
	 * 공통분류코드를 수정한다.
	 */
	@Override
	public void updateCmmnClCode(ClCode cmmnClCode) throws Exception {
		clCodeDAO.updateCmmnClCode(cmmnClCode);
	}

}
