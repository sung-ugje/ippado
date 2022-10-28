package egovframework.ippado.sys.author.web;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springmodules.validation.commons.DefaultBeanValidator;

import egovframework.ippado.base.IppadoBaseController;
import egovframework.ippado.sys.author.service.AuthorManage;
import egovframework.ippado.sys.author.service.AuthorManageService;
import egovframework.ippado.sys.author.service.AuthorManageVO;
import egovframework.rte.fdl.security.userdetails.util.EgovUserDetailsHelper;

/**
 * 권한관리에 관한 controller 클래스를 정의한다.
 * 
 * @author 공통서비스 개발팀 이문준
 * @since 2009.06.01
 * @version 1.0
 * @see
 *
 *      <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 *   2009.03.11  이문준          최초 생성
 *   2011.08.31  JJY            경량환경 템플릿 커스터마이징버전 생성
 *
 *      </pre>
 */

@Controller
public class AuthorManageController extends IppadoBaseController {

	@Resource(name = "authorManageService")
	private AuthorManageService authorManageService;

	@Autowired
	private DefaultBeanValidator beanValidator;

	/**
	 * 권한 목록화면 이동
	 * 
	 * @return String
	 * @exception Exception
	 */
	@RequestMapping("/sys/author/AuthorListView.do")
	public String selectAuthorListView() throws Exception {
		return "/sys/author/AuthorManage";
	}

	/**
	 * 권한 목록을 조회한다
	 * 
	 * @param authorManageVO AuthorManageVO
	 * @return String
	 * @exception Exception
	 */
	@RequestMapping(value = "/sys/author/AuthorList.do")
	public String selectAuthorList(@ModelAttribute("authorManageVO") AuthorManageVO authorManageVO, ModelMap model)
			throws Exception {

		// 미인증 사용자에 대한 보안처리
		if (!EgovUserDetailsHelper.isAuthenticated())
			return goLogin(model);

		setPageInfo(authorManageVO, model, authorManageService.selectAuthorListTotCnt(authorManageVO));

		authorManageVO.setAuthorManageList(authorManageService.selectAuthorList(authorManageVO));
		model.addAttribute("authorList", authorManageVO.getAuthorManageList());

		model.addAttribute("message", egovMessageSource.getMessage("success.common.select"));

		return "/sys/author/AuthorManage";
	}

	/**
	 * 권한 세부정보를 조회한다.
	 * 
	 * @param authorCode     String
	 * @param authorManageVO AuthorManageVO
	 * @return String
	 * @exception Exception
	 */
	@RequestMapping(value = "/sys/author/Author.do")
	public String selectAuthor(@RequestParam("authorCode") String authorCode,
			@ModelAttribute("authorManageVO") AuthorManageVO authorManageVO, ModelMap model) throws Exception {

		// 미인증 사용자에 대한 보안처리
		if (!EgovUserDetailsHelper.isAuthenticated())
			return goLogin(model);

		authorManageVO.setAuthorCode(authorCode);

		model.addAttribute("authorManage", authorManageService.selectAuthor(authorManageVO));
		model.addAttribute("message", egovMessageSource.getMessage("success.common.select"));
		return "/sys/author/AuthorUpdate";
	}

	/**
	 * 권한 등록화면 이동
	 * 
	 * @return String
	 * @exception Exception
	 */
	@RequestMapping("/sys/author/AuthorInsertView.do")
	public String insertAuthorView() throws Exception {

		return "/sys/author/AuthorInsert";
	}

	/**
	 * 권한 세부정보를 등록한다.
	 * 
	 * @param authorManage  AuthorManage
	 * @param bindingResult BindingResult
	 * @return String
	 * @exception Exception
	 */
	@RequestMapping(value = "/sys/author/AuthorInsert.do")
	public String insertAuthor(@ModelAttribute("authorManage") AuthorManage authorManage, BindingResult bindingResult,
			SessionStatus status, ModelMap model) throws Exception {

		// 미인증 사용자에 대한 보안처리
		if (!EgovUserDetailsHelper.isAuthenticated())
			return goLogin(model);

		beanValidator.validate(authorManage, bindingResult); // validation 수행

		if (bindingResult.hasErrors()) {
			return "/sys/author/AuthorInsert";
		} else {
			authorManageService.insertAuthor(authorManage);
			status.setComplete();
			model.addAttribute("message", egovMessageSource.getMessage("success.common.insert"));
			return "forward:/sys/author/Author.do";
		}
	}

	/**
	 * 권한 세부정보를 수정한다.
	 * 
	 * @param authorManage  AuthorManage
	 * @param bindingResult BindingResult
	 * @return String
	 * @exception Exception
	 */
	@RequestMapping(value = "/sys/author/AuthorUpdate.do")
	public String updateAuthor(@ModelAttribute("authorManage") AuthorManage authorManage, BindingResult bindingResult,
			SessionStatus status, Model model) throws Exception {

		// 미인증 사용자에 대한 보안처리
		if (!EgovUserDetailsHelper.isAuthenticated())
			return goLogin(model);

		beanValidator.validate(authorManage, bindingResult); // validation 수행

		if (bindingResult.hasErrors()) {
			return "/sys/author/AuthorUpdate";
		} else {
			authorManageService.updateAuthor(authorManage);
			status.setComplete();
			model.addAttribute("message", egovMessageSource.getMessage("success.common.update"));
			return "forward:/sys/author/Author.do";
		}
	}

	/**
	 * 권한 세부정보를 삭제한다.
	 * 
	 * @param authorManage AuthorManage
	 * @return String
	 * @exception Exception
	 */
	@RequestMapping(value = "/sys/author/AuthorDelete.do")
	public String deleteAuthor(@ModelAttribute("authorManage") AuthorManage authorManage, SessionStatus status,
			Model model) throws Exception {

		// 미인증 사용자에 대한 보안처리
		if (!EgovUserDetailsHelper.isAuthenticated())
			return goLogin(model);

		authorManageService.deleteAuthor(authorManage);
		status.setComplete();
		model.addAttribute("message", egovMessageSource.getMessage("success.common.delete"));
		return "forward:/sys/author/AuthorList.do";
	}

	/**
	 * 권한목록을 삭제한다.
	 * 
	 * @param authorCodes  String
	 * @param authorManage AuthorManage
	 * @return String
	 * @exception Exception
	 */
	@RequestMapping(value = "/sys/author/AuthorListDelete.do")
	public String deleteAuthorList(@RequestParam("authorCodes") String authorCodes,
			@ModelAttribute("authorManage") AuthorManage authorManage, SessionStatus status, Model model)
			throws Exception {

		// 미인증 사용자에 대한 보안처리
		if (!EgovUserDetailsHelper.isAuthenticated())
			return goLogin(model);

		String[] strAuthorCodes = authorCodes.split(";");
		for (int i = 0; i < strAuthorCodes.length; i++) {
			authorManage.setAuthorCode(strAuthorCodes[i]);
			authorManageService.deleteAuthor(authorManage);
		}
		status.setComplete();
		model.addAttribute("message", egovMessageSource.getMessage("success.common.delete"));
		return "forward:/sys/author/AuthorList.do";
	}

	/**
	 * 권한제한 화면 이동
	 * 
	 * @return String
	 * @exception Exception
	 */
	@RequestMapping("/sys/accessDenied.do")
	public String accessDenied() throws Exception {

		return "sys/accessDenied";
	}
}
