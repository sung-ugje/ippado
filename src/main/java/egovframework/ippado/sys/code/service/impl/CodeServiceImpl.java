package egovframework.ippado.sys.code.service.impl;

import java.util.List;

import egovframework.ippado.sys.code.service.Code;
import egovframework.ippado.sys.code.service.CodeVO;
import egovframework.ippado.sys.code.service.CodeService;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;



/**
 *
 * 공통코드에 대한 서비스 구현클래스를 정의한다
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
@Service("CodeService")
public class CodeServiceImpl extends EgovAbstractServiceImpl implements CodeService {

    @Resource(name="CodeDAO")
    private CodeDAO codeDAO;

	/**
	 * 공통코드를 삭제한다.
	 */
	@Override
	public void deleteCmmnCode(Code cmmnCode) throws Exception {
		codeDAO.deleteCmmnCode(cmmnCode);
	}

	/**
	 * 공통코드를 등록한다.
	 */
	@Override
	public void insertCmmnCode(Code cmmnCode) throws Exception {
    	codeDAO.insertCmmnCode(cmmnCode);
	}

	/**
	 * 공통코드 상세항목을 조회한다.
	 */
	@Override
	public Code selectCmmnCodeDetail(Code cmmnCode) throws Exception {
    	Code ret = codeDAO.selectCmmnCodeDetail(cmmnCode);
    	return ret;
	}

	/**
	 * 공통코드 목록을 조회한다.
	 */
	@Override
	public List<?> selectCmmnCodeList(CodeVO searchVO) throws Exception {
        return codeDAO.selectCmmnCodeList(searchVO);
	}

	/**
	 * 공통코드 총 갯수를 조회한다.
	 */
	@Override
	public int selectCmmnCodeListTotCnt(CodeVO searchVO) throws Exception {
        return codeDAO.selectCmmnCodeListTotCnt(searchVO);
	}

	/**
	 * 공통코드를 수정한다.
	 */
	@Override
	public void updateCmmnCode(Code cmmnCode) throws Exception {
		codeDAO.updateCmmnCode(cmmnCode);
	}

}
