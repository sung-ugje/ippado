package egovframework.ippado.sys.log.web;

import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import egovframework.ippado.base.IppadoBaseController;
import egovframework.ippado.sys.log.service.LoginLogVO;
import egovframework.rte.fdl.security.userdetails.util.EgovUserDetailsHelper;
import egovframework.ippado.sys.log.service.LoginLogService;

/**
 * 접속로그정보를 관리하기 위한 컨트롤러 클래스
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
@Controller
public class LoginLogController extends IppadoBaseController {

	@Resource(name = "LoginLogService")
	private LoginLogService loginLogService;

	/**
	 * 로그인 로그 목록 조회
	 *
	 * @param loginLog
	 * @return sys/log/LoginLogList
	 * @throws Exception
	 */
	@RequestMapping(value = "/sys/log/LoginLogList.do")
	public String selectLoginLogInf(@ModelAttribute("searchVO") LoginLogVO loginLog, ModelMap model) throws Exception {

		// 미인증 사용자에 대한 보안처리
		if (!EgovUserDetailsHelper.isAuthenticated())
			return goLogin(model);
		
		loginLog.setSearchKeywordFrom(loginLog.getSearchKeywordFrom().replaceAll("-", ""));
		loginLog.setSearchKeywordTo(loginLog.getSearchKeywordTo().replaceAll("-", ""));

		HashMap<?, ?> _map = (HashMap<?, ?>) loginLogService.selectLoginLogInf(loginLog);
		int totCnt = Integer.parseInt((String) _map.get("resultCnt"));
		setPageInfo(loginLog, model, totCnt);
		model.addAttribute("resultList", _map.get("resultList"));
		model.addAttribute("resultCnt", _map.get("resultCnt"));
		
		return "sys/log/LoginLogList";
	}

	/**
	 * 로그인 로그 상세 조회
	 *
	 * @param loginLog
	 * @param model
	 * @return sys/log/LoginLogInqire
	 * @throws Exception
	 */
	@RequestMapping(value = "/sys/log/InqireLoginLog.do")
	public String selectLoginLog(@ModelAttribute("searchVO") LoginLogVO loginLog, @RequestParam("logId") String logId, ModelMap model) throws Exception {

		// 미인증 사용자에 대한 보안처리
		if (!EgovUserDetailsHelper.isAuthenticated())
			return goLogin(model);
		
		loginLog.setLogId(logId.trim());

		LoginLogVO vo = loginLogService.selectLoginLog(loginLog);
		model.addAttribute("result", vo);
		return "sys/log/LoginLogInqire";
	}

}
