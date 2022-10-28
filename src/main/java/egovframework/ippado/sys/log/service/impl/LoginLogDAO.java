package egovframework.ippado.sys.log.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import egovframework.ippado.sys.log.service.LoginLogVO;

/**
 * 시스템 로그 관리를 위한 데이터 접근 클래스
 * @author 공통서비스개발팀 이삼섭
 * @since 2009.03.11
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 *   2009.03.11  이삼섭          최초 생성
 *   2011.07.01  이기하          패키지 분리(sym.log -> sym.log.clg)
 *   2011.08.31  JJY            경량환경 템플릿 커스터마이징버전 생성
 *
 * </pre>
 */
@Repository("loginLogDAO")
public class LoginLogDAO extends EgovComAbstractDAO {

	/**
	 * 접속로그를 기록한다.
	 *
	 * @param LoginLogVO
	 * @return
	 * @throws Exception
	 */
	public void logInsertLoginLog(LoginLogVO loginLog) throws Exception{
		insert("LoginLogVO.logInsertLoginLog", loginLog);
	}

	/**
	 * 접속로그를 조회한다.
	 *
	 * @param loginLog
	 * @return loginLog
	 * @throws Exception
	 */
	public LoginLogVO selectLoginLog(LoginLogVO loginLog) throws Exception{

		return (LoginLogVO) select("LoginLogVO.selectLoginLog", loginLog);
	}

	/**
	 * 접속로그를 목록을 조회한다.
	 *
	 * @param loginLog
	 * @return
	 * @throws Exception
	 */
	public List<?> selectLoginLogInf(LoginLogVO loginLog) throws Exception{
		return selectList("LoginLogVO.selectLoginLogInf", loginLog);
	}

	/**
	 * 접속로그 목록의 숫자를 조회한다.
	 * @param loginLog
	 * @return
	 * @throws Exception
	 */
	public int selectLoginLogInfCnt(LoginLogVO loginLog) throws Exception{

		return (Integer)select("LoginLogVO.selectLoginLogInfCnt", loginLog);
	}

}
