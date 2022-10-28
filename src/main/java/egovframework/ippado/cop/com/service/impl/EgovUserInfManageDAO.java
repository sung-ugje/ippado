package egovframework.ippado.cop.com.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import egovframework.ippado.cop.com.service.UserInfVO;

/**
 * 협업 활용 사용자 정보 조회를 위한 데이터 접근 클래스
 * 
 * @author 공통서비스개발팀 이삼섭
 * @since 2009.04.06
 * @version 1.0
 * @see
 *
 *      <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 *   2009.04.06  이삼섭          최초 생성
 *   2011.08.31  JJY            경량환경 템플릿 커스터마이징버전 생성
 *
 *      </pre>
 */
@Repository("EgovUserInfManageDAO")
public class EgovUserInfManageDAO extends EgovComAbstractDAO {

	/**
	 * 사용자 정보에 대한 목록을 조회한다.
	 *
	 * @param userVO
	 * @return
	 * @throws Exception
	 */
	public List<UserInfVO> selectUserList(UserInfVO userVO) throws Exception {
		return selectList("EgovUserInfManage.selectUserList", userVO);
	}

	/**
	 * 사용자 정보에 대한 목록 전체 건수를 조회한다.
	 *
	 * @param userVO
	 * @return
	 * @throws Exception
	 */
	public int selectUserListCnt(UserInfVO userVO) throws Exception {
		return (Integer) select("EgovUserInfManage.selectUserListCnt", userVO);
	}

	/**
	 * 커뮤니티 사용자 목록을 조회한다.
	 *
	 * @param userVO
	 * @return
	 * @throws Exception
	 */
	public List<UserInfVO> selectCmmntyUserList(UserInfVO userVO) throws Exception {
		return selectList("EgovUserInfManage.selectCmmntyUserList", userVO);
	}

	/**
	 * 커뮤니티 사용자 목록에 대한 전체 건수를 조회한다.
	 *
	 * @param userVO
	 * @return
	 * @throws Exception
	 */
	public int selectCmmntyUserListCnt(UserInfVO userVO) throws Exception {
		return (Integer) select("EgovUserInfManage.selectCmmntyUserListCnt", userVO);
	}

	/**
	 * 커뮤니티 관리자 목록을 조회한다.
	 *
	 * @param userVO
	 * @return
	 * @throws Exception
	 */
	public List<UserInfVO> selectCmmntyMngrList(UserInfVO userVO) throws Exception {
		return selectList("EgovUserInfManage.selectCmmntyMngrList", userVO);
	}

	/**
	 * 커뮤니티 관리자 목록에 대한 전체 건수를 조회한다.
	 *
	 * @param userVO
	 * @return
	 * @throws Exception
	 */
	public int selectCmmntyMngrListCnt(UserInfVO userVO) throws Exception {
		return (Integer) select("EgovUserInfManage.selectCmmntyMngrListCnt", userVO);
	}

	/**
	 * 동호회 사용자 목록을 조회한다.
	 *
	 * @param userVO
	 * @return
	 * @throws Exception
	 */
	public List<UserInfVO> selectClubUserList(UserInfVO userVO) throws Exception {
		return selectList("EgovUserInfManage.selectClubUserList", userVO);
	}

	/**
	 * 동호회 사용자 목록에 대한 전체 건수를 조회한다.
	 *
	 * @param userVO
	 * @return
	 * @throws Exception
	 */
	public int selectClubUserListCnt(UserInfVO userVO) throws Exception {
		return (Integer) select("EgovUserInfManage.selectClubUserListCnt", userVO);
	}

	/**
	 * 동호회 운영자 목록을 조회한다.
	 *
	 * @param userVO
	 * @return
	 * @throws Exception
	 */
	public List<UserInfVO> selectClubOprtrList(UserInfVO userVO) throws Exception {
		return selectList("EgovUserInfManage.selectClubOprtrList", userVO);
	}

	/**
	 * 동호회 운영자 목록에 대한 전체 건수를 조회한다.
	 *
	 * @param userVO
	 * @return
	 * @throws Exception
	 */
	public int selectClubOprtrListCnt(UserInfVO userVO) throws Exception {
		return (Integer) select("EgovUserInfManage.selectClubOprtrListCnt", userVO);
	}

	/**
	 * 동호회에 대한 모든 사용자 목록을 조회한다.
	 *
	 * @param userVO
	 * @return
	 * @throws Exception
	 */
	public List<UserInfVO> selectAllClubUser(UserInfVO userVO) throws Exception {
		return selectList("EgovUserInfManage.selectAllClubUser", userVO);
	}

	/**
	 * 커뮤니티에 대한 모든 사용자 목록을 조회한다.
	 *
	 * @param userVO
	 * @return
	 * @throws Exception
	 */
	public List<UserInfVO> selectAllCmmntyUser(UserInfVO userVO) throws Exception {
		return selectList("EgovUserInfManage.selectAllCmmntyUser", userVO);
	}
}
