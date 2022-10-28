package egovframework.ippado.sys.log.service;

import java.util.Map;

/**
 * 시스템 로그 생성을 위한 ASPECT 클래스
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
public interface LoginLogService {

	/**
	 * 접속로그를 기록한다.
	 *
	 * @param LoginLogVO
	 */
	public void logInsertLoginLog(LoginLogVO loinLog) throws Exception;

	/**
	 * 접속로그를 조회한다.
	 *
	 * @param loginLog
	 * @return loginLog
	 * @throws Exception
	 */
	public LoginLogVO selectLoginLog(LoginLogVO loginLog) throws Exception;

	/**
	 * 접속로그 목록을 조회한다.
	 *
	 * @param LoginLogVO
	 */
	public Map<?, ?> selectLoginLogInf(LoginLogVO loinLog) throws Exception;

}
