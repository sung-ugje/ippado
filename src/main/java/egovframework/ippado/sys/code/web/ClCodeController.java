package egovframework.ippado.sys.code.web;

import java.util.Map;

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
import egovframework.ippado.sys.code.service.ClCode;
import egovframework.ippado.sys.code.service.ClCodeService;
import egovframework.ippado.sys.code.service.ClCodeVO;
import egovframework.rte.fdl.security.userdetails.util.EgovUserDetailsHelper;

/**
 *
 * 공통분류코드에 관한 요청을 받아 서비스 클래스로 요청을 전달하고 서비스클래스에서 처리한 결과를 웹 화면으로 전달을 위한
 * Controller를 정의한다
 * 
 * @author 공통서비스 개발팀 이중호
 * @since 2009.04.01
 * @version 1.0
 * @see
 *
 *      <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 *   2009.04.01  이중호          최초 생성
 *   2011.08.31  JJY            경량환경 템플릿 커스터마이징버전 생성
 *
 *      </pre>
 */
@Controller
public class ClCodeController extends IppadoBaseController {
	@Resource(name = "ClCodeService")
	private ClCodeService clCodeService;

	@Autowired
	private DefaultBeanValidator beanValidator;

	/**
	 * 공통분류코드를 삭제한다.
	 * 
	 * @param loginVO
	 * @param cmmnClCode
	 * @param model
	 * @return "forward:/sys/code/ClCodeList.do"
	 * @throws Exception
	 */
	@RequestMapping(value = "/sys/code/ClCodeRemove.do")
	public String deleteCmmnClCode(@ModelAttribute("loginVO") LoginVO loginVO, ClCode cmmnClCode, ModelMap model)
			throws Exception {
		// 미인증 사용자에 대한 보안처리
		if (!EgovUserDetailsHelper.isAuthenticated())
			return goLogin(model);

		clCodeService.deleteCmmnClCode(cmmnClCode);
		return "forward:/sys/code/ClCodeList.do";
	}

	/**
	 * 공통분류코드를 등록한다.
	 * 
	 * @param loginVO
	 * @param cmmnClCode
	 * @param bindingResult
	 * @return "/sys/code/ClCodeRegist"
	 * @throws Exception
	 */
	@RequestMapping(value = "/sys/code/ClCodeRegist.do")
	public String insertCmmnClCode(@ModelAttribute("loginVO") LoginVO loginVO,
			@ModelAttribute("cmmnClCode") ClCode cmmnClCode, BindingResult bindingResult) throws Exception {
		// 미인증 사용자에 대한 보안처리
		if (!EgovUserDetailsHelper.isAuthenticated())
			return goLogin();

		if (cmmnClCode.getClCode() == null || cmmnClCode.getClCode().equals("")) {
			return "/sys/code/ClCodeRegist";
		}

		beanValidator.validate(cmmnClCode, bindingResult);
		if (bindingResult.hasErrors()) {
			return "/sys/code/ClCodeRegist";
		}

		cmmnClCode.setFrstRegisterId(loginVO.getUniqId());
		clCodeService.insertCmmnClCode(cmmnClCode);
		return "forward:/sys/code/ClCodeList.do";
	}

	/**
	 * 공통분류코드 상세항목을 조회한다.
	 * 
	 * @param loginVO
	 * @param cmmnClCode
	 * @param model
	 * @return "sys/code/ClCodeDetail"
	 * @throws Exception
	 */
	@RequestMapping(value = "/sys/code/ClCodeDetail.do")
	public String selectCmmnClCodeDetail(@ModelAttribute("loginVO") LoginVO loginVO, ClCode cmmnClCode, ModelMap model)
			throws Exception {
		// 미인증 사용자에 대한 보안처리
		if (!EgovUserDetailsHelper.isAuthenticated())
			return goLogin(model);

		ClCode vo = clCodeService.selectCmmnClCodeDetail(cmmnClCode);
		model.addAttribute("result", vo);

		return "sys/code/ClCodeDetail";
	}

	/**
	 * 공통분류코드 목록을 조회한다.
	 * 
	 * @param loginVO
	 * @param searchVO
	 * @param model
	 * @return "/sys/code/ClCodeList"
	 * @throws Exception
	 */
	@RequestMapping(value = "/sys/code/ClCodeList.do")
	public String selectCmmnClCodeList(@ModelAttribute("loginVO") LoginVO loginVO,
			@ModelAttribute("searchVO") ClCodeVO searchVO, ModelMap model) throws Exception {

		// 미인증 사용자에 대한 보안처리
		if (!EgovUserDetailsHelper.isAuthenticated())
			return goLogin(model);

		model.addAttribute("resultList", clCodeService.selectCmmnClCodeList(searchVO));

		setPageInfo(searchVO, model, clCodeService.selectCmmnClCodeListTotCnt(searchVO));

		return "/sys/code/ClCodeList";
	}

	/**
	 * 공통분류코드를 수정한다.
	 * 
	 * @param loginVO
	 * @param cmmnClCode
	 * @param bindingResult
	 * @param commandMap
	 * @param model
	 * @return "/sys/code/ClCodeModify"
	 * @throws Exception
	 */
	@RequestMapping(value = "/sys/code/ClCodeModify.do")
	public String updateCmmnClCode(@ModelAttribute("loginVO") LoginVO loginVO,
			@ModelAttribute("administCode") ClCode cmmnClCode, BindingResult bindingResult,
			@RequestParam Map<String, Object> commandMap, ModelMap model) throws Exception {

		// 미인증 사용자에 대한 보안처리
		if (!EgovUserDetailsHelper.isAuthenticated())
			return goLogin(model);

		String sCmd = commandMap.get("cmd") == null ? "" : (String) commandMap.get("cmd");
		if (sCmd.equals("")) {
			ClCode vo = clCodeService.selectCmmnClCodeDetail(cmmnClCode);
			model.addAttribute("cmmnClCode", vo);

			return "/sys/code/ClCodeModify";
		} else if (sCmd.equals("Modify")) {
			beanValidator.validate(cmmnClCode, bindingResult);
			if (bindingResult.hasErrors()) {
				ClCode vo = clCodeService.selectCmmnClCodeDetail(cmmnClCode);
				model.addAttribute("cmmnClCode", vo);

				return "/sys/code/ClCodeModify";
			}
			cmmnClCode.setLastUpdusrId(loginVO.getUniqId());
			clCodeService.updateCmmnClCode(cmmnClCode);
			return "forward:/sys/code/ClCodeList.do";
		} else {
			return "forward:/sys/code/ClCodeList.do";
		}
	}

}