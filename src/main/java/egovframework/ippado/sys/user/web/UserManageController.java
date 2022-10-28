package egovframework.ippado.sys.user.web;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springmodules.validation.commons.DefaultBeanValidator;

import egovframework.ippado.base.IppadoBaseController;
import egovframework.ippado.sys.user.service.UserDefaultVO;
import egovframework.ippado.sys.user.service.UserManageService;
import egovframework.ippado.sys.user.service.UserManageVO;
import egovframework.ippado.utl.sim.service.EgovFileScrty;
import egovframework.rte.fdl.security.userdetails.util.EgovUserDetailsHelper;

/**
 * 사용자관련 요청을  비지니스 클래스로 전달하고 처리된결과를 해당 웹 화면으로 전달하는  Controller를 정의한다
 * @author 공통서비스 개발팀 조재영
 * @since 2009.04.10
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 *   2009.04.10  조재영          최초 생성
 *   2011.08.31  JJY            경량환경 템플릿 커스터마이징버전 생성
 *
 * </pre>
 */
@Controller
public class UserManageController extends IppadoBaseController {

	/** userManageService */
	@Resource(name = "userManageService")
	private UserManageService userManageService;



	/** DefaultBeanValidator beanValidator */
	@Autowired
	private DefaultBeanValidator beanValidator;

	/**
	 * 사용자목록을 조회한다. (pageing)
	 * @param userSearchVO 검색조건정보
	 * @param model 화면모델
	 * @return sys/user/UserManage
	 * @throws Exception
	 */
	@RequestMapping(value = "/sys/user/UserManage.do")
	public String selectUserList(@ModelAttribute("userSearchVO") UserDefaultVO userSearchVO, ModelMap model) throws Exception {

		// 미인증 사용자에 대한 보안처리
    	if(!EgovUserDetailsHelper.isAuthenticated()) return goLogin(model); 

    	setPageInfo(userSearchVO, model, userManageService.selectUserListTotCnt(userSearchVO));
    	model.addAttribute("resultList", userManageService.selectUserList(userSearchVO));

		//사용자상태코드를 코드정보로부터 조회
		setCodeDetail(model, "emplyrSttusCode_result","COM013");

		return "sys/user/UserManage";
	}

	/**
	 * 사용자등록화면으로 이동한다.
	 * 
	 * @param userSearchVO 검색조건정보
	 * @param userManageVO 사용자초기화정보
	 * @param model 화면모델
	 * @return sys/user/UserInsert
	 * @throws Exception
	 */
	@RequestMapping("/sys/user/UserInsertView.do")
	public String insertUserView(@ModelAttribute("userSearchVO") UserDefaultVO userSearchVO, @ModelAttribute("userManageVO") UserManageVO userManageVO, Model model)
			throws Exception {

		// 미인증 사용자에 대한 보안처리
		if(!EgovUserDetailsHelper.isAuthenticated()) return goLogin(model); 
		
		//사용자상태코드를 코드정보로부터 조회
		setCodeDetail(model, "emplyrSttusCode_result","COM013");

		return "sys/user/UserInsert";
	}


	/**
	 * 사용자등록처리후 목록화면으로 이동한다.
	 * @param userManageVO 사용자등록정보
	 * @param bindingResult 입력값검증용 bindingResult
	 * @param model 화면모델
	 * @return forward:/sys/user/UserManage.do
	 * @throws Exception
	 */
	@RequestMapping("/sys/user/UserInsert.do")
	public String insertUser(@ModelAttribute("userManageVO") UserManageVO userManageVO, BindingResult bindingResult, Model model) throws Exception {

		// 미인증 사용자에 대한 보안처리
		if(!EgovUserDetailsHelper.isAuthenticated()) return goLogin(model); 

		beanValidator.validate(userManageVO, bindingResult);
		if (bindingResult.hasErrors()) {


			//성별구분코드를 코드정보로부터 조회
			setCodeDetail(model, "sexdstnCode_result","COM014");
			
			//사용자상태코드를 코드정보로부터 조회
			setCodeDetail(model, "emplyrSttusCode_result","COM013");

			//소속기관코드를 코드정보로부터 조회 - COM025
			setCodeDetail(model, "insttCode_result","COM025");

			return "sys/user/UserInsert";
		} else {
			userManageService.insertUser(userManageVO);
			//Exception 없이 진행시 등록성공메시지
			model.addAttribute("resultMsg", "success.common.insert");
		}
		return "forward:/sys/user/UserManage.do";
	}

	/**
	 * 사용자정보 수정을 위해 사용자정보를 상세조회한다.
	 * @param uniqId 상세조회대상 사용자아이디
	 * @param userSearchVO 검색조건
	 * @param model 화면모델
	 * @return sys/user/UserSelectUpdt
	 * @throws Exception
	 */
	@RequestMapping("/sys/user/UserSelectUpdtView.do")
	public String updateUserView(@RequestParam("selectedId") String uniqId, @ModelAttribute("searchVO") UserDefaultVO userSearchVO, Model model) throws Exception {

		// 미인증 사용자에 대한 보안처리
		if(!EgovUserDetailsHelper.isAuthenticated()) return goLogin(model); 

		//패스워드힌트목록을 코드정보로부터 조회
		setCodeDetail(model, "passwordHint_result","COM022");

		//성별구분코드를 코드정보로부터 조회
		setCodeDetail(model, "sexdstnCode_result","COM014");
		
		//사용자상태코드를 코드정보로부터 조회
		setCodeDetail(model, "emplyrSttusCode_result","COM013");

		//소속기관코드를 코드정보로부터 조회 - COM025
		setCodeDetail(model, "insttCode_result","COM025");

		UserManageVO userManageVO = new UserManageVO();
		userManageVO = userManageService.selectUser(uniqId);
		model.addAttribute("userSearchVO", userSearchVO);
		model.addAttribute("userManageVO", userManageVO);

		return "sys/user/UserSelectUpdt";
	}

	/**
	 * 사용자정보 수정후 목록조회 화면으로 이동한다.
	 * @param userManageVO 사용자수정정보
	 * @param bindingResult 입력값검증용 bindingResult
	 * @param model 화면모델
	 * @return forward:/sys/user/UserManage.do
	 * @throws Exception
	 */
	@RequestMapping("/sys/user/UserSelectUpdt.do")
	public String updateUser(@ModelAttribute("userManageVO") UserManageVO userManageVO, BindingResult bindingResult, Model model) throws Exception {

		// 미인증 사용자에 대한 보안처리
		if(!EgovUserDetailsHelper.isAuthenticated()) return goLogin(model); 

		beanValidator.validate(userManageVO, bindingResult);
		if (bindingResult.hasErrors()) {
			//패스워드힌트목록을 코드정보로부터 조회
			setCodeDetail(model, "passwordHint_result","COM022");

			//성별구분코드를 코드정보로부터 조회
			setCodeDetail(model, "sexdstnCode_result","COM014");
			
			//사용자상태코드를 코드정보로부터 조회
			setCodeDetail(model, "emplyrSttusCode_result","COM013");

			//소속기관코드를 코드정보로부터 조회 - COM025
			setCodeDetail(model, "insttCode_result","COM025");

			return "sys/user/UserSelectUpdt";
		} else {
			//업무사용자 수정시 히스토리 정보를 등록한다.
			userManageService.insertUserHistory(userManageVO);
			userManageService.updateUser(userManageVO);
			//Exception 없이 진행시 수정성공메시지
			model.addAttribute("resultMsg", "success.common.update");
			return "forward:/sys/user/UserManage.do";
		}
	}

	/**
	 * 사용자정보삭제후 목록조회 화면으로 이동한다.
	 * @param checkedIdForDel 삭제대상아이디 정보
	 * @param userSearchVO 검색조건
	 * @param model 화면모델
	 * @return forward:/sys/user/UserManage.do
	 * @throws Exception
	 */
	@RequestMapping("/sys/user/UserDelete.do")
	public String deleteUser(@RequestParam("checkedIdForDel") String checkedIdForDel, @ModelAttribute("searchVO") UserDefaultVO userSearchVO, Model model) throws Exception {

		// 미인증 사용자에 대한 보안처리
		if(!EgovUserDetailsHelper.isAuthenticated()) return goLogin(model); 

		userManageService.deleteUser(checkedIdForDel);
		//Exception 없이 진행시 등록성공메시지
		model.addAttribute("resultMsg", "success.common.delete");
		return "forward:/sys/user/UserManage.do";
	}

	/**
	 * 입력한 사용자아이디의 중복확인화면 이동
	 * @param model 화면모델
	 * @return sys/user/IdDplctCnfirm
	 * @throws Exception
	 */
	@RequestMapping(value = "/sys/user/IdDplctCnfirmView.do")
	public String checkIdDplct(ModelMap model) throws Exception {

		// 미인증 사용자에 대한 보안처리
		if(!EgovUserDetailsHelper.isAuthenticated()) return goLogin(model); 

		model.addAttribute("checkId", "");
		model.addAttribute("usedCnt", "-1");
		return "sys/user/IdDplctCnfirm";
	}

	/**
	 * 입력한 사용자아이디의 중복여부를 체크하여 사용가능여부를 확인
	 * @param commandMap 파라메터전달용 commandMap
	 * @param model 화면모델
	 * @return sys/user/IdDplctCnfirm
	 * @throws Exception
	 */
	@RequestMapping(value = "/sys/user/IdDplctCnfirm.do")
	public String checkIdDplct(@RequestParam Map<String, Object> commandMap, ModelMap model) throws Exception {

		// 미인증 사용자에 대한 보안처리
		if(!EgovUserDetailsHelper.isAuthenticated()) return goLogin(model); 

		String checkId = (String) commandMap.get("checkId");
		checkId = new String(checkId.getBytes("ISO-8859-1"), "UTF-8");

		if (checkId == null || checkId.equals(""))
			return "forward:/uss/umt/EgovIdDplctCnfirmView.do";

		int usedCnt = userManageService.checkIdDplct(checkId);
		model.addAttribute("usedCnt", usedCnt);
		model.addAttribute("checkId", checkId);

		return "sys/user/IdDplctCnfirm";
	}

	/**
	 * 업무사용자 암호 수정처리 후 화면 이동
	 * @param model 화면모델
	 * @param commandMap 파라메터전달용 commandMap
	 * @param userSearchVO 검색조 건
	 * @param userManageVO 사용자수정정보(비밀번호)
	 * @return sys/user/UserPasswordUpdt
	 * @throws Exception
	 */
	@RequestMapping(value = "/sys/user/UserPasswordUpdt.do")
	public String updatePassword(ModelMap model, @RequestParam Map<String, Object> commandMap, @ModelAttribute("searchVO") UserDefaultVO userSearchVO,
			@ModelAttribute("userManageVO") UserManageVO userManageVO) throws Exception {

		// 미인증 사용자에 대한 보안처리
		if(!EgovUserDetailsHelper.isAuthenticated()) return goLogin(model); 

		String oldPassword = (String) commandMap.get("oldPassword");
		String newPassword = (String) commandMap.get("newPassword");
		String newPassword2 = (String) commandMap.get("newPassword2");
		String uniqId = (String) commandMap.get("uniqId");

		boolean isCorrectPassword = false;
		UserManageVO resultVO = new UserManageVO();
		userManageVO.setPassword(newPassword);
		userManageVO.setOldPassword(oldPassword);
		userManageVO.setUniqId(uniqId);

		String resultMsg = "";
		resultVO = userManageService.selectPassword(userManageVO);
		//패스워드 암호화
		String encryptPass = EgovFileScrty.encryptPassword(oldPassword, userManageVO.getEmplyrId());
		if (encryptPass.equals(resultVO.getPassword())) {
			if (newPassword.equals(newPassword2)) {
				isCorrectPassword = true;
			} else {
				isCorrectPassword = false;
				resultMsg = "fail.user.passwordUpdate2";
			}
		} else {
			isCorrectPassword = false;
			resultMsg = "fail.user.passwordUpdate1";
		}

		if (isCorrectPassword) {
			userManageVO.setPassword(EgovFileScrty.encryptPassword(newPassword, userManageVO.getEmplyrId()));
			userManageService.updatePassword(userManageVO);
			model.addAttribute("userManageVO", userManageVO);
			resultMsg = "success.common.update";
		} else {
			model.addAttribute("userManageVO", userManageVO);
		}
		model.addAttribute("userSearchVO", userSearchVO);
		model.addAttribute("resultMsg", resultMsg);

		return "sys/user/UserPasswordUpdt";
	}

	/**
	 * 업무사용자 암호 수정  화면 이동
	 * @param model 화면모델
	 * @param commandMap 파라메터전달용 commandMap
	 * @param userSearchVO 검색조건
	 * @param userManageVO 사용자수정정보(비밀번호)
	 * @return sys/user/UserPasswordUpdt
	 * @throws Exception
	 */
	@RequestMapping(value = "/sys/user/UserPasswordUpdtView.do")
	public String updatePasswordView(ModelMap model, @RequestParam Map<String, Object> commandMap, @ModelAttribute("searchVO") UserDefaultVO userSearchVO,
			@ModelAttribute("userManageVO") UserManageVO userManageVO) throws Exception {

		// 미인증 사용자에 대한 보안처리
		if(!EgovUserDetailsHelper.isAuthenticated()) return goLogin(model); 

		String userTyForPassword = (String) commandMap.get("userTyForPassword");
		userManageVO.setUserTy(userTyForPassword);

		model.addAttribute("userManageVO", userManageVO);
		model.addAttribute("userSearchVO", userSearchVO);
		return "sys/user/UserPasswordUpdt";
	}

}
