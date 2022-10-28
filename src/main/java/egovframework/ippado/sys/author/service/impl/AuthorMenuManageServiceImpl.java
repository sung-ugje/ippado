package egovframework.ippado.sys.author.service.impl;

import java.util.List;

import egovframework.com.cmm.ComDefaultVO;
import egovframework.ippado.sys.author.service.AuthorMenuManageService;
import egovframework.ippado.sys.author.service.AuthorMenuVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

/**
 * 메뉴목록, 사이트맵 생성을 처리하는 비즈니스 구현 클래스를 정의한다.
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
 *   2011.07.01  서준식          EgovMenuManageServiceImpl에서 메뉴 생성 관련 부분 분리
 *   2011.08.31  JJY            경량환경 템플릿 커스터마이징버전 생성
 *
 * </pre>
 */
@Service("meunCreateManageService")
public class AuthorMenuManageServiceImpl extends EgovAbstractServiceImpl implements AuthorMenuManageService {

	@Resource(name = "menuCreateManageDAO")
	private AuthorMenuManageDAO menuCreateManageDAO;

	/**
	 * ID 존재여부를 조회
	 * @param vo ComDefaultVO
	 * @return int
	 * @exception Exception
	 */
	@Override
	public int selectUsrByPk(ComDefaultVO vo) throws Exception {
		return menuCreateManageDAO.selectUsrByPk(vo);
	}

	/**
	 * 권한별메뉴 내역을 조회
	 * @param  vo AuthorMenuVO
	 * @return List
	 * @exception Exception
	 */
	@Override
	public List<?> selectAuthorMenuList(AuthorMenuVO vo) throws Exception {
		return menuCreateManageDAO.selectAuthorMenuList(vo);
	}

	/**
	 * 화면에 조회된 메뉴정보로 권한별메뉴내역 데이터베이스에서 입력
	 * @param checkedAuthorForInsert  String
	 * @param checkedMenuNoForInsert String
	 * @exception Exception
	 */
	@Override
	public void insertAuthorMenuList(String checkedAuthorForInsert, String checkedMenuNoForInsert) throws Exception {
		AuthorMenuVO menuCreatVO = null;
		int AuthorCnt = 0;
		String[] insertMenuNo = checkedMenuNoForInsert.split(",");

		String insertAuthor = checkedAuthorForInsert;
		menuCreatVO = new AuthorMenuVO();
		menuCreatVO.setAuthorCode(insertAuthor);
		AuthorCnt = menuCreateManageDAO.selectAuthorMenuCnt(menuCreatVO);

		// 이전에 존재하는 권한코드에 대한 메뉴설정내역 삭제
		if (AuthorCnt > 0) {
			menuCreateManageDAO.deleteAuthorMenu(menuCreatVO);
		}
		for (int i = 0; i < insertMenuNo.length; i++) {
			menuCreatVO.setAuthorCode(insertAuthor);
			menuCreatVO.setMenuNo(Integer.parseInt(insertMenuNo[i]));
			menuCreateManageDAO.insertAuthorMenu(menuCreatVO);
		}
	}

	/**
	 * 권한별메뉴관리 목록을 조회
	 * @param vo ComDefaultVO
	 * @return List
	 * @exception Exception
	 */
	@Override
	public List<?> selectAuthorMenuManagList(ComDefaultVO vo) throws Exception {
		return menuCreateManageDAO.selectAuthorMenuManagList(vo);
	}

	/**
	 * ID에 대한 권한코드를 조회
	 * @param vo ComDefaultVO
	 * @return AuthorMenuVO
	 * @exception Exception
	 */
	@Override
	public AuthorMenuVO selectAuthorByUsr(ComDefaultVO vo) throws Exception {
		return menuCreateManageDAO.selectAuthorByUsr(vo);
	}

	/**
	 * 권한별메뉴관리 총건수를 조회한다.
	 * @param vo ComDefaultVO
	 * @return int
	 * @exception Exception
	 */
	@Override
	public int selectAuthorMenuManagTotCnt(ComDefaultVO vo) throws Exception {
		return menuCreateManageDAO.selectAuthorMenuManagTotCnt(vo);
	}

}
