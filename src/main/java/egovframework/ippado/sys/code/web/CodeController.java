package egovframework.ippado.sys.code.web;

import java.util.Map;

import egovframework.com.cmm.LoginVO;
import egovframework.ippado.sys.code.service.ClCodeVO;
import egovframework.ippado.sys.code.service.Code;
import egovframework.ippado.sys.code.service.CodeVO;
import egovframework.ippado.base.IppadoBaseController;
import egovframework.ippado.sys.code.service.ClCodeService;
import egovframework.ippado.sys.code.service.CodeService;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.fdl.security.userdetails.util.EgovUserDetailsHelper;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springmodules.validation.commons.DefaultBeanValidator;

/**
 *
 * 공통코드에 관한 요청을 받아 서비스 클래스로 요청을 전달하고 서비스클래스에서 처리한 결과를 웹 화면으로 전달을 위한 Controller를
 * 정의한다
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
public class CodeController extends IppadoBaseController {

	@Resource(name = "CodeService")
	private CodeService codeService;

	@Resource(name = "ClCodeService")
	private ClCodeService clCodeService;

	@Autowired
	private DefaultBeanValidator beanValidator;

	/**
	 * 공통코드를 삭제한다.
	 * 
	 * @param loginVO
	 * @param cmmnCode
	 * @param model
	 * @return "forward:/sys/code/CodeList.do"
	 * @throws Exception
	 */
	@RequestMapping(value = "/sys/code/CodeRemove.do")
	public String deleteCmmnCode(@ModelAttribute("loginVO") LoginVO loginVO, Code cmmnCode, ModelMap model)
			throws Exception {
		// 미인증 사용자에 대한 보안처리
		if (!EgovUserDetailsHelper.isAuthenticated()) return goLogin(model);
		codeService.deleteCmmnCode(cmmnCode);
		return "forward:/sys/code/CodeList.do";
	}

	/**
	 * 공통코드를 등록한다.
	 * 
	 * @param loginVO
	 * @param cmmnCode
	 * @param bindingResult
	 * @param model
	 * @return "/sys/code/CodeRegist"
	 * @throws Exception
	 */
	@RequestMapping(value = "/sys/code/CodeRegist.do")
	public String insertCmmnCode(@ModelAttribute("loginVO") LoginVO loginVO, @ModelAttribute("cmmnCode") Code cmmnCode,
			BindingResult bindingResult, ModelMap model) throws Exception {
		// 미인증 사용자에 대한 보안처리
		if (!EgovUserDetailsHelper.isAuthenticated()) return goLogin(model);

		if (cmmnCode.getClCode() == null || cmmnCode.getClCode().equals("")) {
			ClCodeVO searchVO;
			searchVO = new ClCodeVO();
			searchVO.setRecordCountPerPage(999999);
			searchVO.setFirstIndex(0);
			searchVO.setSearchCondition("CodeList");
			model.addAttribute("cmmnClCode", clCodeService.selectCmmnClCodeList(searchVO));

			return "/sys/code/CodeRegist";
		}

		beanValidator.validate(cmmnCode, bindingResult);
		if (bindingResult.hasErrors()) {
			ClCodeVO searchVO;
			searchVO = new ClCodeVO();
			searchVO.setRecordCountPerPage(999999);
			searchVO.setFirstIndex(0);
			searchVO.setSearchCondition("CodeList");
			model.addAttribute("cmmnClCode", clCodeService.selectCmmnClCodeList(searchVO));

			return "/sys/code/CodeRegist";
		}

		cmmnCode.setFrstRegisterId(loginVO.getUniqId());
		codeService.insertCmmnCode(cmmnCode);
		return "forward:/sys/code/CodeList.do";
	}

	/**
	 * 공통코드 상세항목을 조회한다.
	 * 
	 * @param loginVO
	 * @param cmmnCode
	 * @param model
	 * @return "sys/code/CodeDetail"
	 * @throws Exception
	 */
	@RequestMapping(value = "/sys/code/CodeDetail.do")
	public String selectCmmnCodeDetail(@ModelAttribute("loginVO") LoginVO loginVO, Code cmmnCode, ModelMap model)
			throws Exception {
		// 미인증 사용자에 대한 보안처리
		if (!EgovUserDetailsHelper.isAuthenticated()) return goLogin(model);
		Code vo = codeService.selectCmmnCodeDetail(cmmnCode);
		model.addAttribute("result", vo);

		return "sys/code/CodeDetail";
	}

	/**
	 * 공통코드 목록을 조회한다.
	 * 
	 * @param loginVO
	 * @param searchVO
	 * @param model
	 * @return "/sys/code/CodeList"
	 * @throws Exception
	 */
	@RequestMapping(value = "/sys/code/CodeList.do")
	public String selectCmmnCodeList(@ModelAttribute("loginVO") LoginVO loginVO,
			@ModelAttribute("searchVO") CodeVO searchVO, ModelMap model) throws Exception {
		// 미인증 사용자에 대한 보안처리
		if (!EgovUserDetailsHelper.isAuthenticated()) return goLogin(model);
		setPageInfo(searchVO, model, codeService.selectCmmnCodeListTotCnt(searchVO));

		model.addAttribute("resultList", codeService.selectCmmnCodeList(searchVO));

		return "/sys/code/CodeList";
	}

	/**
	 * 공통코드를 수정한다.
	 * 
	 * @param loginVO
	 * @param cmmnCode
	 * @param bindingResult
	 * @param commandMap
	 * @param model
	 * @return "/sys/code/CodeModify"
	 * @throws Exception
	 */
	@RequestMapping(value = "/sys/code/CodeModify.do")
	public String updateCmmnCode(@ModelAttribute("loginVO") LoginVO loginVO, @ModelAttribute("cmmnCode") Code cmmnCode,
			BindingResult bindingResult, @RequestParam Map<String, Object> commandMap, ModelMap model)
			throws Exception {
		// 미인증 사용자에 대한 보안처리
		if (!EgovUserDetailsHelper.isAuthenticated())
			return goLogin(model);
		
		String sCmd = commandMap.get("cmd") == null ? "" : (String) commandMap.get("cmd");
		if (sCmd.equals("")) {
			Code vo = codeService.selectCmmnCodeDetail(cmmnCode);
			model.addAttribute("cmmnCode", vo);

			return "/sys/code/CodeModify";
		} else if (sCmd.equals("Modify")) {
			beanValidator.validate(cmmnCode, bindingResult);
			if (bindingResult.hasErrors()) {
				Code vo = codeService.selectCmmnCodeDetail(cmmnCode);
				model.addAttribute("cmmnCode", vo);

				return "/sys/code/CodeModify";
			}

			cmmnCode.setLastUpdusrId(loginVO.getUniqId());
			codeService.updateCmmnCode(cmmnCode);
			return "forward:/sys/code/CodeList.do";
		} else {
			return "forward:/sys/code/CodeList.do";
		}
	}

}