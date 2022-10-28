package egovframework.ippado.sys.user.service.impl;

import java.util.List;

import egovframework.ippado.sys.user.service.UserAuthor;
import egovframework.ippado.sys.user.service.UserAuthorService;
import egovframework.ippado.sys.user.service.UserAuthorVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

/**
 * 권한그룹에 관한 ServiceImpl 클래스를 정의한다.
 * @author 공통서비스 개발팀 이문준
 * @since 2009.06.01
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 *   2009.03.11  이문준          최초 생성
 *   2011.08.31  JJY            경량환경 템플릿 커스터마이징버전 생성 
 *
 * </pre>
 */

@Service("userAuthorService")
public class UserAuthorServiceImpl  extends EgovAbstractServiceImpl implements UserAuthorService {
	
	@Resource(name="userAuthorDAO")
    private UserAuthorDAO userAuthorDAO;

	/**
	 * 그룹별 할당된 권한 목록 조회
	 * @param userAuthorVO UserAuthorVO
	 * @return List<UserAuthorVO>
	 * @exception Exception
	 */
	public List<UserAuthorVO> selectAuthorGroupList(UserAuthorVO userAuthorVO) throws Exception{
		return userAuthorDAO.selectAuthorGroupList(userAuthorVO);
	}
	
	/**
	 * 그룹에 권한정보를 할당하여 데이터베이스에 등록
	 * @param userAuthor UserAuthor
	 * @exception Exception
	 */
	public void insertAuthorGroup(UserAuthor userAuthor) throws Exception{
		userAuthorDAO.insertAuthorGroup(userAuthor);
	}
	
	/**
	 * 화면에 조회된 그룹권한정보를 수정하여 항목의 정합성을 체크하고 수정된 데이터를 데이터베이스에 반영
	 * @param userAuthor UserAuthor
	 * @exception Exception
	 */
	public void updateAuthorGroup(UserAuthor userAuthor) throws Exception{
		userAuthorDAO.updateAuthorGroup(userAuthor);
	}

	/**
	 * 그룹별 할당된 시스템 메뉴 접근권한을 삭제
	 * @param userAuthor UserAuthor
	 * @exception Exception
	 */
	public void deleteAuthorGroup(UserAuthor userAuthor) throws Exception {
		userAuthorDAO.deleteAuthorGroup(userAuthor);
	}
	
    /**
	 * 목록조회 카운트를 반환한다
	 * @param userAuthorVO UserAuthorVO
	 * @return int
	 * @exception Exception
	 */
	public int selectAuthorGroupListTotCnt(UserAuthorVO userAuthorVO) throws Exception {
		return userAuthorDAO.selectAuthorGroupListTotCnt(userAuthorVO);
    }
	
}