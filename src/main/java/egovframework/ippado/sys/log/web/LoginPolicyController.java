package egovframework.ippado.sys.log.web;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springmodules.validation.commons.DefaultBeanValidator;

import egovframework.com.cmm.LoginVO;
import egovframework.ippado.base.IppadoBaseController;
import egovframework.ippado.sys.log.service.LoginPolicy;
import egovframework.ippado.sys.log.service.LoginPolicyService;
import egovframework.ippado.sys.log.service.LoginPolicyVO;
import egovframework.rte.fdl.security.userdetails.util.EgovUserDetailsHelper;

/**
 * 로그인정책에 대한 controller 클래스를 정의한다. 로그인정책에 대한 등록, 수정, 삭제, 조회, 반영확인 기능을 제공한다.
 * 로그인정책의 조회기능은 목록조회, 상세조회로 구분된다.
 * 
 * @author 공통서비스개발팀 lee.m.j
 * @since 2009.08.03
 * @version 1.0
 * @see
 *
 *      <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 *   2009.08.03  lee.m.j        최초 생성
 *   2011.08.31  JJY            경량환경 템플릿 커스터마이징버전 생성
 *
 *      </pre>
 */
@Controller
public class LoginPolicyController extends IppadoBaseController {

	@Resource(name = "loginPolicyService")
	LoginPolicyService loginPolicyService;

	@Autowired
	private DefaultBeanValidator beanValidator;

	/**
	 * 로그인정책 목록 조회화면으로 이동한다.
	 * 
	 * @return String - 리턴 Url
	 */
	@RequestMapping("/sys/log/LoginPolicyListView.do")
	public String selectLoginPolicyListView() throws Exception {
		// 미인증 사용자에 대한 보안처리
		if (!EgovUserDetailsHelper.isAuthenticated()) return goLogin();

		return "/sys/log/LoginPolicyList";
	}

	/**
	 * 로그인정책 목록을 조회한다.
	 * 
	 * @param loginPolicyVO - 로그인정책 VO
	 * @return String - 리턴 Url
	 */
	@RequestMapping("/sys/log/LoginPolicyList.do")
	public String selectLoginPolicyList(@ModelAttribute("loginPolicyVO") LoginPolicyVO loginPolicyVO, ModelMap model)
			throws Exception {
		// 미인증 사용자에 대한 보안처리
		if (!EgovUserDetailsHelper.isAuthenticated()) return goLogin(model);

		loginPolicyVO.setLoginPolicyList(loginPolicyService.selectLoginPolicyList(loginPolicyVO));
		model.addAttribute("loginPolicyList", loginPolicyVO.getLoginPolicyList());

		setPageInfo(loginPolicyVO, model, loginPolicyService.selectLoginPolicyListTotCnt(loginPolicyVO));

		model.addAttribute("message", egovMessageSource.getMessage("success.common.select"));

		return "/sys/log/LoginPolicyList";
	}

	/**
	 * 로그인정책 목록의 상세정보를 조회한다.
	 * 
	 * @param loginPolicyVO - 로그인정책 VO
	 * @return String - 리턴 Url
	 */
	@RequestMapping("/sys/log/getLoginPolicy.do")
	public String selectLoginPolicy(@RequestParam("emplyrId") String emplyrId,
			@ModelAttribute("loginPolicyVO") LoginPolicyVO loginPolicyVO, ModelMap model) throws Exception {
		// 미인증 사용자에 대한 보안처리
		if (!EgovUserDetailsHelper.isAuthenticated()) return goLogin(model);

		loginPolicyVO.setEmplyrId(emplyrId);

		model.addAttribute("loginPolicy", loginPolicyService.selectLoginPolicy(loginPolicyVO));
		model.addAttribute("message", egovMessageSource.getMessage("success.common.select"));

		LoginPolicyVO vo = (LoginPolicyVO) model.get("loginPolicy");

		if (vo.getRegYn().equals("N")) return "/sys/log/LoginPolicyRegist";
		else return "/sys/log/LoginPolicyUpdt";
	}

	/**
	 * 로그인정책 정보 등록화면으로 이동한다.
	 * 
	 * @param loginPolicy - 로그인정책 model
	 * @return String - 리턴 Url
	 */
	@RequestMapping("/sys/log/addLoginPolicyView.do")
	public String insertLoginPolicyView(@RequestParam("emplyrId") String emplyrId,
			@ModelAttribute("loginPolicyVO") LoginPolicyVO loginPolicyVO, ModelMap model) throws Exception {

		// 미인증 사용자에 대한 보안처리
		if (!EgovUserDetailsHelper.isAuthenticated()) return goLogin(model);

		loginPolicyVO.setEmplyrId(emplyrId);

		model.addAttribute("loginPolicy", loginPolicyService.selectLoginPolicy(loginPolicyVO));
		model.addAttribute("message", egovMessageSource.getMessage("success.common.select"));

		return "/sys/log/LoginPolicyRegist";
	}

	/**
	 * 로그인정책 정보를 신규로 등록한다.
	 * 
	 * @param loginPolicy - 로그인정책 model
	 * @return String - 리턴 Url
	 */
	@RequestMapping("/sys/log/addLoginPolicy.do")
	public String insertLoginPolicy(@ModelAttribute("loginPolicy") LoginPolicy loginPolicy, BindingResult bindingResult,
			ModelMap model) throws Exception {
		// 미인증 사용자에 대한 보안처리
		if (!EgovUserDetailsHelper.isAuthenticated()) return goLogin(model);

		beanValidator.validate(loginPolicy, bindingResult); // validation 수행

		if (bindingResult.hasErrors()) {
			model.addAttribute("loginPolicyVO", loginPolicy);
			return "/sys/log/LoginPolicyRegist";
		} else {

			LoginVO user = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
			loginPolicy.setUserId(user.getId());

			loginPolicyService.insertLoginPolicy(loginPolicy);
			model.addAttribute("message", egovMessageSource.getMessage("success.common.update"));

			return "forward:/sys/log/getLoginPolicy.do";
		}
	}

	/**
	 * 기 등록된 로그인정책 정보를 수정한다.
	 * 
	 * @param loginPolicy - 로그인정책 model
	 * @return String - 리턴 Url
	 */
	@RequestMapping("/sys/log/updtLoginPolicy.do")
	public String updateLoginPolicy(@ModelAttribute("loginPolicy") LoginPolicy loginPolicy, BindingResult bindingResult,
			ModelMap model) throws Exception {
		// 미인증 사용자에 대한 보안처리
		if (!EgovUserDetailsHelper.isAuthenticated()) return goLogin(model);

		beanValidator.validate(loginPolicy, bindingResult); // validation 수행

		if (bindingResult.hasErrors()) {
			model.addAttribute("loginPolicyVO", loginPolicy);
			return "/sys/log/LoginPolicyUpdt";
		} else {
			LoginVO user = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
			loginPolicy.setUserId(user.getId());

			loginPolicyService.updateLoginPolicy(loginPolicy);
			model.addAttribute("message", egovMessageSource.getMessage("success.common.update"));

			return "forward:/sys/log/LoginPolicyList.do";
		}
	}

	/**
	 * 기 등록된 로그인정책 정보를 삭제한다.
	 * 
	 * @param loginPolicy - 로그인정책 model
	 * @return String - 리턴 Url
	 */
	@RequestMapping("/sys/log/removeLoginPolicy.do")
	public String deleteLoginPolicy(@ModelAttribute("loginPolicy") LoginPolicy loginPolicy, ModelMap model)
			throws Exception {
		// 미인증 사용자에 대한 보안처리
		if (!EgovUserDetailsHelper.isAuthenticated()) return goLogin(model);

		loginPolicyService.deleteLoginPolicy(loginPolicy);

		model.addAttribute("message", egovMessageSource.getMessage("success.common.delete"));
		return "forward:/sys/log/LoginPolicyList.do";
	}

}
