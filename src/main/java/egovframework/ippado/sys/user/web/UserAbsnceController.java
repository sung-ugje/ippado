/**
 * 개요
 * - 사용자부재에 대한 controller 클래스를 정의한다.
 *
 * 상세내용
 * - 사용자부재에 대한 등록, 수정, 삭제, 조회, 반영확인 기능을 제공한다.
 * - 사용자부재의 조회기능은 목록조회, 상세조회로 구분된다.
 * @author 이문준
 * @version 1.0
 * @created 03-8-2009 오후 2:09:35
 *  <pre>
 * &lt;&lt; 개정이력(Modification Information) &gt;&gt;
 *
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 *   2009.8.03  이문준          최초 생성
 *   2011.8.26	정진오			IncludedInfo annotation 추가
 *
 * </pre>
 */

package egovframework.ippado.sys.user.web;

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
import egovframework.ippado.sys.user.service.UserAbsnce;
import egovframework.ippado.sys.user.service.UserAbsnceService;
import egovframework.ippado.sys.user.service.UserAbsnceVO;
import egovframework.ippado.utl.fcc.service.EgovStringUtil;
import egovframework.rte.fdl.security.userdetails.util.EgovUserDetailsHelper;

@Controller
public class UserAbsnceController extends IppadoBaseController{

	@Resource(name = "egovUserAbsnceService")
	private UserAbsnceService egovUserAbsnceService;

	@Autowired
	private DefaultBeanValidator beanValidator;

	/**
	 * 사용자부재 목록화면 이동
	 * 
	 * @return String
	 * @exception Exception
	 */
	@RequestMapping("/sys/user/UserAbsnceListView.do")
	public String selectUserAbsnceListView() throws Exception {

		return "sys/user/UserAbsnceList";
	}

	/**
	 * 사용자부재정보를 관리하기 위해 등록된 사용자부재 목록을 조회한다.
	 * 
	 * @param userAbsnceVO - 사용자부재 VO
	 * @return String - 리턴 Url
	 */
	@RequestMapping("/sys/user/UserAbsnceList.do")
	public String selectUserAbsnceList(@RequestParam("selAbsnceAt") String selAbsnceAt,
			@ModelAttribute("userAbsnceVO") UserAbsnceVO userAbsnceVO, ModelMap model) throws Exception {
		// 미인증 사용자에 대한 보안처리
    	if(!EgovUserDetailsHelper.isAuthenticated()) return goLogin(model); 

		setPageInfo(userAbsnceVO, model,egovUserAbsnceService.selectUserAbsnceListTotCnt(userAbsnceVO));
		
		userAbsnceVO.setSelAbsnceAt(selAbsnceAt);
		userAbsnceVO.setUserAbsnceList(egovUserAbsnceService.selectUserAbsnceList(userAbsnceVO));

		model.addAttribute("userAbsnceList", userAbsnceVO.getUserAbsnceList());

		model.addAttribute("message", egovMessageSource.getMessage("success.common.select"));

		return "sys/user/UserAbsnceList";
	}

	/**
	 * 등록된 사용자부재 상세정보를 조회한다.
	 * 
	 * @param userAbsnceVO - 사용자부재 VO
	 * @return String - 리턴 Url
	 */
	@RequestMapping("/sys/user/UserAbsnceUpdate.do")
	public String selectUserAbsnce(@RequestParam("userId") String userId,
			@ModelAttribute("userAbsnceVO") UserAbsnceVO userAbsnceVO, ModelMap model) throws Exception {

		// 미인증 사용자에 대한 보안처리
    	if(!EgovUserDetailsHelper.isAuthenticated()) return goLogin(model); 

		userAbsnceVO.setUserId(userId);
		model.addAttribute("userAbsnce", egovUserAbsnceService.selectUserAbsnce(userAbsnceVO));
		model.addAttribute("message", egovMessageSource.getMessage("success.common.select"));

		UserAbsnceVO vo = (UserAbsnceVO) model.get("userAbsnce");

		if (vo.getRegYn().equals("N"))
			return "sys/user/UserAbsnceRegist";
		else
			return "sys/user/UserAbsnceUpdt";
	}

	/**
	 * 사용자부재정보를 신규로 등록한다.
	 * 
	 * @param userAbsnce - 사용자부재 model
	 * @return String - 리턴 Url
	 */
	@RequestMapping("/sys/user/UserAbsnceAdd.do")
	public String insertUserAbsnceView(@RequestParam("userId") String userId, @ModelAttribute("userAbsnceVO") UserAbsnceVO userAbsnceVO, ModelMap model) throws Exception {
		
		// 미인증 사용자에 대한 보안처리
    	if(!EgovUserDetailsHelper.isAuthenticated()) return goLogin(model); 

    	
		userAbsnceVO.setUserId(userId);
		model.addAttribute("userAbsnce", egovUserAbsnceService.selectUserAbsnce(userAbsnceVO));
		model.addAttribute("message", egovMessageSource.getMessage("success.common.select"));

		return "forward:/sys/user/UserAbsnceList.do";

	}

	/**
	 * 사용자부재정보를 신규로 등록한다.
	 * 
	 * @param userAbsnce - 사용자부재 model
	 * @return String - 리턴 Url
	 */
	@RequestMapping("/sys/user/addUserAbsnce.do")
	public String insertUserAbsnce(@ModelAttribute("userAbsnce") UserAbsnce userAbsnce, @ModelAttribute("userAbsnceVO") UserAbsnceVO userAbsnceVO, BindingResult bindingResult, ModelMap model)
			throws Exception {
		// 미인증 사용자에 대한 보안처리
    	if(!EgovUserDetailsHelper.isAuthenticated()) return goLogin(model); 


		beanValidator.validate(userAbsnce, bindingResult); // validation 수행

		if (bindingResult.hasErrors()) {
			model.addAttribute("userAbsnceVO", userAbsnceVO);
			return "egovframework/com/uss/ion/msi/EgovMainImageRegist";
		} else {
			LoginVO user = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
			userAbsnce.setLastUpdusrId(user == null ? "" : EgovStringUtil.isNullToString(user.getId()));

			model.addAttribute("userAbsnce", egovUserAbsnceService.insertUserAbsnce(userAbsnce, userAbsnceVO));
			model.addAttribute("message", egovMessageSource.getMessage("success.common.insert"));

			return "forward:/sys/user/UserAbsnceList.do";
		}
	}

	/**
	 * 기 등록된 사용자부재정보를 수정한다.
	 * 
	 * @param userAbsnce - 사용자부재 model
	 * @return String - 리턴 Url
	 */
	@RequestMapping("/sys/user/updtUserAbsnce.do")
	public String updateUserAbsnce(@ModelAttribute("userAbsnce") UserAbsnce userAbsnce, BindingResult bindingResult,
			ModelMap model) throws Exception {
		// 미인증 사용자에 대한 보안처리
    	if(!EgovUserDetailsHelper.isAuthenticated()) return goLogin(model); 

		if (bindingResult.hasErrors()) {
			model.addAttribute("userAbsnceVO", userAbsnce);
			return "egovframework/com/sys/user/EgovUserAbsnceUpdt";
		} else {

			LoginVO user = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
			userAbsnce.setLastUpdusrId(user == null ? "" : EgovStringUtil.isNullToString(user.getId()));

			egovUserAbsnceService.updateUserAbsnce(userAbsnce);
			return "forward:/sys/user/UserAbsnceList.do";
		}
	}

	/**
	 * 기 등록된 사용자부재정보를 삭제한다.
	 * 
	 * @param userAbsnce - 사용자부재 model
	 * @return String - 리턴 Url
	 */
	@RequestMapping("/sys/user/removeUserAbsnce.do")
	public String deleteUserAbsnce(@ModelAttribute("userAbsnce") UserAbsnce userAbsnce, ModelMap model)
			throws Exception {
		// 미인증 사용자에 대한 보안처리
    	if(!EgovUserDetailsHelper.isAuthenticated()) return goLogin(model); 

		egovUserAbsnceService.deleteUserAbsnce(userAbsnce);
		model.addAttribute("message", egovMessageSource.getMessage("success.common.delete"));
		return "forward:/sys/user/UserAbsnceList.do";
	}

	/**
	 * 기 등록된 사용자부재정보를 삭제한다.
	 * 
	 * @param userAbsnce - 사용자부재 model
	 * @return String - 리턴 Url
	 */
	@RequestMapping("/sys/user/removeUserAbsnceList.do")
	public String deleteUserAbsnceList(@RequestParam("userIds") String userIds,
			@ModelAttribute("userAbsnce") UserAbsnce userAbsnce, ModelMap model) throws Exception {

		String[] strUserIds = userIds.split(";");

		for (int i = 0; i < strUserIds.length; i++) {
			userAbsnce.setUserId(strUserIds[i]);
			egovUserAbsnceService.deleteUserAbsnce(userAbsnce);
		}

		model.addAttribute("message", egovMessageSource.getMessage("success.common.delete"));
		return "forward:/sys/user/UserAbsnceList.do";
	}

	/**
	 * MyPage에 사용자부재정보를 제공하기 위해 목록을 조회한다.
	 * 
	 * @param userAbsnceVO - 사용자부재 VO
	 * @return String - 리턴 Url
	 */
	@RequestMapping("/sys/user/UserAbsnceMainList.do")
	public String selectUserAbsnceMainList(@ModelAttribute("userAbsnceVO") UserAbsnceVO userAbsnceVO, ModelMap model)
			throws Exception {

		userAbsnceVO.setSelAbsnceAt("A");
		userAbsnceVO.setUserAbsnceList(egovUserAbsnceService.selectUserAbsnceList(userAbsnceVO));

		model.addAttribute("userAbsnceList", userAbsnceVO.getUserAbsnceList());

		return "sys/user/UserAbsnceMainList";
	}
}
