package egovframework.ippado.sys.author.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.com.cmm.ComDefaultVO;
import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import egovframework.ippado.sys.author.service.AuthorMenuVO;

/**
 * 권한별메뉴, 사이트맵 생성에 대한 DAO 클래스를 정의한다. *
 * @author 공통컴포넌트 개발팀 서준식
 * @since 2011.06.30
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 *   2011.06.30  서 준 식   최초 생성(MenuManageDAO 클래스로 부터 분리
 *   					   메소드들을 MenuManageDAO 클래스에서 분리해옮)
 *   2011.08.31  JJY       경량환경 템플릿 커스터마이징버전 생성
 * </pre>
 */

@Repository("menuCreateManageDAO")
public class AuthorMenuManageDAO extends EgovComAbstractDAO{



	/**
	 * ID 존재여부를 조회
	 * @param vo MenuManageVO
	 * @return int
	 * @exception Exception
	 */
	public int selectUsrByPk(ComDefaultVO vo) throws Exception{
		return (Integer)select("menuManage.selectUsrByPk", vo);
	}

	/**
	 * ID에 대한 권한코드를 조회
	 * @param vo AuthorMenuVO
	 * @return int
	 * @exception Exception
	 */
	public AuthorMenuVO selectAuthorByUsr(ComDefaultVO vo) throws Exception{
		return (AuthorMenuVO)select("menuManage.selectAuthorByUsr", vo);
	}

	/**
	 * 권한별메뉴관리 내역을 조회
	 * @param vo ComDefaultVO
	 * @return List
	 * @exception Exception
	 */
	public List<?> selectAuthorMenuManagList(ComDefaultVO vo) throws Exception{
		return selectList("menuManage.selectAuthorMenuManageList_D", vo);
	}

	/**
	 * 권한별메뉴관리 총건수를 조회한다.
	 * @param vo ComDefaultVO
	 * @return int
	 * @exception Exception
	 */
    public int selectAuthorMenuManagTotCnt(ComDefaultVO vo) {
        return (Integer)select("menuManage.selectAuthorMenuManageTotCnt_S", vo);
    }

    /*********** 메뉴 생성 관리 ***************/
	/**
	 * 권한별메뉴 내역을 조회
	 * @param vo AuthorMenuVO
	 * @return List
	 * @exception Exception
	 */
	public List<?> selectAuthorMenuList(AuthorMenuVO vo) throws Exception{
		return selectList("menuManage.selectAuthorMenuList_D", vo);
	}

	/**
	 * 권한별메뉴내역 등록
	 * @param vo AuthorMenuVO
	 * @exception Exception
	 */
	public void insertAuthorMenu(AuthorMenuVO vo){
		insert("menuManage.insertAuthorMenu_S", vo);
	}


	/**
	 * 권한별메뉴내역 존재여부 조회한다.
	 * @param vo AuthorMenuVO
	 * @return int
	 * @exception Exception
	 */
    public int selectAuthorMenuCnt(AuthorMenuVO vo) {
        return (Integer)select("menuManage.selectAuthorMenuCnt_S", vo);
    }


	/**
	 * 권한별메뉴내역 수정
	 * @param vo AuthorMenuVO
	 * @exception Exception
	 */
	public void updateAuthorMenu(AuthorMenuVO vo){
		update("menuManage.updateAuthorMenu_S", vo);
	}

	/**
	 * 권한별메뉴내역 삭제
	 * @param vo AuthorMenuVO
	 * @exception Exception
	 */
	public void deleteAuthorMenu(AuthorMenuVO vo){
		delete("menuManage.deleteAuthorMenu_S", vo);
	}


}
