package egovframework.ippado.sys.menu.web;

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

import egovframework.com.cmm.ComDefaultVO;
import egovframework.com.cmm.LoginVO;
import egovframework.ippado.base.IppadoBaseController;
import egovframework.ippado.sys.menu.service.ProgrmManageDtlVO;
import egovframework.ippado.sys.menu.service.ProgrmManageService;
import egovframework.ippado.sys.menu.service.ProgrmManageVO;
import egovframework.rte.fdl.security.userdetails.util.EgovUserDetailsHelper;

/**
 * 프로그램목록 관리및 변경을 처리하는 비즈니스 구현 클래스
 * 
 * @author 개발환경 개발팀 이용
 * @since 2009.06.01
 * @version 1.0
 * @see
 *
 *      <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 *   2009.03.20  이  용          최초 생성
 *   2011.08.31  JJY            경량환경 템플릿 커스터마이징버전 생성
 *
 *      </pre>
 */

@Controller
public class ProgrmManageController extends IppadoBaseController {

	/** Validator */
	@Autowired
	private DefaultBeanValidator beanValidator;

	/** ProgrmManageService */
	@Resource(name = "progrmManageService")
	private ProgrmManageService progrmManageService;

	/**
	 * 프로그램목록을 상세화면 호출 및 상세조회한다.
	 * 
	 * @param tmp_progrmNm String
	 * @return 출력페이지정보 "sys/menu/ProgramListDetailSelectUpdt"
	 * @exception Exception
	 */
	@RequestMapping(value = "/sys/menu/ProgramListDetailSelect.do")
	public String selectProgrm(@RequestParam("tmp_progrmNm") String tmp_progrmNm,
			@ModelAttribute("searchVO") ComDefaultVO searchVO, ModelMap model) throws Exception {
		// 미인증 사용자에 대한 보안처리
		if (!EgovUserDetailsHelper.isAuthenticated())
			return goLogin(model);

		searchVO.setSearchKeyword(tmp_progrmNm);
		ProgrmManageVO progrmManageVO = progrmManageService.selectProgrm(searchVO);
		model.addAttribute("progrmManageVO", progrmManageVO);
		return "sys/menu/ProgramListDetailSelectUpdt";
	}

	/**
	 * 프로그램목록 리스트조회한다.
	 * 
	 * @param searchVO ComDefaultVO
	 * @return 출력페이지정보 "sys/menu/ProgramListManage"
	 * @exception Exception
	 */
	@RequestMapping(value = "/sys/menu/ProgramListManageSelect.do")
	public String selectProgrmList(@ModelAttribute("searchVO") ComDefaultVO searchVO, ModelMap model) throws Exception {
		// 미인증 사용자에 대한 보안처리
		if (!EgovUserDetailsHelper.isAuthenticated())
			return goLogin(model);

		setPageInfo(searchVO, model, progrmManageService.selectProgrmListTotCnt(searchVO));

		model.addAttribute("list_progrmmanage", progrmManageService.selectProgrmList(searchVO));
		model.addAttribute("searchVO", searchVO);

		return "sys/menu/ProgramListManage";

	}

	/**
	 * 프로그램목록 멀티 삭제한다.
	 * 
	 * @param checkedProgrmFileNmForDel String
	 * @return 출력페이지정보 "forward:/sys/menu/ProgramListManageSelect.do"
	 * @exception Exception
	 */
	@RequestMapping("/sys/menu/ProgrmManageListDelete.do")
	public String deleteProgrmManageList(@RequestParam("checkedProgrmFileNmForDel") String checkedProgrmFileNmForDel,
			@ModelAttribute("progrmManageVO") ProgrmManageVO progrmManageVO, ModelMap model) throws Exception {
		String sLocationUrl = null;
		String resultMsg = "";
		// 미인증 사용자에 대한 보안처리
		if (!EgovUserDetailsHelper.isAuthenticated())
			return goLogin(model);

		String[] delProgrmFileNm = checkedProgrmFileNmForDel.split(",");
		if (delProgrmFileNm == null || (delProgrmFileNm.length == 0)) {
			resultMsg = egovMessageSource.getMessage("fail.common.delete");
			sLocationUrl = "forward:/sys/menu/ProgramListManageSelect.do";
		} else {
			progrmManageService.deleteProgrmManageList(checkedProgrmFileNmForDel);
			resultMsg = egovMessageSource.getMessage("success.common.delete");
			sLocationUrl = "forward:/sys/menu/ProgramListManageSelect.do";
		}
		model.addAttribute("resultMsg", resultMsg);
		// status.setComplete();
		return sLocationUrl;
	}

	/**
	 * 프로그램목록을 등록화면으로 이동 및 등록 한다.
	 * 
	 * @param progrmManageVO ProgrmManageVO
	 * @param commandMap     Map
	 * @return 출력페이지정보 등록화면 호출시 "sys/menu/ProgramListRegist", 출력페이지정보 등록처리시
	 *         "forward:/sys/menu/ProgramListManageSelect.do"
	 * @exception Exception
	 */
	@RequestMapping(value = "/sys/menu/ProgramListRegist.do")
	public String insertProgrmList(@RequestParam Map<String, Object> commandMap,
			@ModelAttribute("progrmManageVO") ProgrmManageVO progrmManageVO, BindingResult bindingResult,
			ModelMap model) throws Exception {
		String resultMsg = "";
		String sLocationUrl = null;
		// 미인증 사용자에 대한 보안처리
		if (!EgovUserDetailsHelper.isAuthenticated())
			return goLogin(model);

		String sCmd = commandMap.get("cmd") == null ? "" : (String) commandMap.get("cmd");
		if (sCmd.equals("insert")) {
			beanValidator.validate(progrmManageVO, bindingResult);
			if (bindingResult.hasErrors()) {
				sLocationUrl = "sys/menu/ProgramListRegist";
				return sLocationUrl;
			}
			if (progrmManageVO.getProgrmDc() == null || progrmManageVO.getProgrmDc().equals("")) {
				progrmManageVO.setProgrmDc(" ");
			}
			progrmManageService.insertProgrm(progrmManageVO);
			resultMsg = egovMessageSource.getMessage("success.common.insert");
			sLocationUrl = "forward:/sys/menu/ProgramListManageSelect.do";
		} else {
			sLocationUrl = "sys/menu/ProgramListRegist";
		}
		model.addAttribute("resultMsg", resultMsg);
		return sLocationUrl;
	}

	/**
	 * 프로그램목록을 수정 한다.
	 * 
	 * @param progrmManageVO ProgrmManageVO
	 * @return 출력페이지정보 "forward:/sys/menu/ProgramListManageSelect.do"
	 * @exception Exception
	 */
	/* 프로그램목록수정 */
	@RequestMapping(value = "/sys/menu/ProgramListDetailSelectUpdt.do")
	public String updateProgrmList(@ModelAttribute("progrmManageVO") ProgrmManageVO progrmManageVO,
			BindingResult bindingResult, ModelMap model) throws Exception {
		String resultMsg = "";
		String sLocationUrl = null;
		// 미인증 사용자에 대한 보안처리
		if (!EgovUserDetailsHelper.isAuthenticated())
			return goLogin(model);

		beanValidator.validate(progrmManageVO, bindingResult);
		if (bindingResult.hasErrors()) {
			sLocationUrl = "forward:/sys/menu/ProgramListDetailSelect.do";
			return sLocationUrl;
		}
		if (progrmManageVO.getProgrmDc() == null || progrmManageVO.getProgrmDc().equals("")) {
			progrmManageVO.setProgrmDc(" ");
		}
		progrmManageService.updateProgrm(progrmManageVO);
		resultMsg = egovMessageSource.getMessage("success.common.update");
		sLocationUrl = "forward:/sys/menu/ProgramListManageSelect.do";
		model.addAttribute("resultMsg", resultMsg);
		return sLocationUrl;
	}

	/**
	 * 프로그램목록을 삭제 한다.
	 * 
	 * @param progrmManageVO ProgrmManageVO
	 * @return 출력페이지정보 "forward:/sys/menu/ProgramListManageSelect.do"
	 * @exception Exception
	 */
	@RequestMapping(value = "/sys/menu/ProgramListManageDelete.do")
	public String deleteProgrmList(@ModelAttribute("progrmManageVO") ProgrmManageVO progrmManageVO, ModelMap model)
			throws Exception {
		String resultMsg = "";
		// 미인증 사용자에 대한 보안처리
		if (!EgovUserDetailsHelper.isAuthenticated())
			return goLogin(model);

		progrmManageService.deleteProgrm(progrmManageVO);
		resultMsg = egovMessageSource.getMessage("success.common.delete");
		model.addAttribute("resultMsg", resultMsg);
		return "forward:/sys/menu/ProgramListManageSelect.do";
	}

	/**
	 * 프로그램변경요청목록 조회한다.
	 * 
	 * @param searchVO ComDefaultVO
	 * @return 출력페이지정보 "sys/menu/ProgramChangeRequst"
	 * @exception Exception
	 */
	@RequestMapping(value = "/sys/menu/ProgramChangeRequstSelect.do")
	public String selectProgrmChangeRequstList(@ModelAttribute("searchVO") ComDefaultVO searchVO, ModelMap model)
			throws Exception {
		// 미인증 사용자에 대한 보안처리
		if (!EgovUserDetailsHelper.isAuthenticated())
			return goLogin(model);

		setPageInfo(searchVO, model, progrmManageService.selectProgrmChangeRequstListTotCnt(searchVO));

		model.addAttribute("list_changerequst", progrmManageService.selectProgrmChangeRequstList(searchVO));

		return "sys/menu/ProgramChangeRequst";
	}

	/**
	 * 프로그램변경요청목록을 상세조회한다.
	 * 
	 * @param progrmManageDtlVO ProgrmManageDtlVO
	 * @return 출력페이지정보 "sys/menu/ProgramChangRequstDetailSelectUpdt"
	 * @exception Exception
	 */
	@RequestMapping(value = "/sys/menu/ProgramChangRequstDetailSelect.do")
	public String selectProgrmChangeRequst(@ModelAttribute("progrmManageDtlVO") ProgrmManageDtlVO progrmManageDtlVO,
			ModelMap model) throws Exception {
		// 미인증 사용자에 대한 보안처리
		if (!EgovUserDetailsHelper.isAuthenticated())
			return goLogin(model);

		if (progrmManageDtlVO.getProgrmFileNm() == null || progrmManageDtlVO.getProgrmFileNm().equals("")) {
			String _FileNm = progrmManageDtlVO.getTmp_progrmNm();
			progrmManageDtlVO.setProgrmFileNm(_FileNm);
			int _tmp_no = progrmManageDtlVO.getTmp_rqesterNo();
			progrmManageDtlVO.setRqesterNo(_tmp_no);
		}
		ProgrmManageDtlVO resultVO = progrmManageService.selectProgrmChangeRequst(progrmManageDtlVO);
		model.addAttribute("progrmManageDtlVO", resultVO);
		return "sys/menu/ProgramChangRequstDetailSelectUpdt";
	}

	/**
	 * 프로그램변경요청 화면을 호출및 프로그램변경요청을 등록한다.
	 * 
	 * @param progrmManageDtlVO ProgrmManageDtlVO
	 * @param commandMap        Map
	 * @return 출력페이지정보 등록화면 호출시 "sys/menu/ProgramChangRequstStre", 출력페이지정보 등록처리시
	 *         "forward:/sys/menu/ProgramChangeRequstSelect.do"
	 * @exception Exception
	 */
	/* 프로그램변경요청등록 */
	@RequestMapping(value = "/sys/menu/ProgramChangRequstStre.do")
	public String insertProgrmChangeRequst(@RequestParam Map<String, Object> commandMap,
			@ModelAttribute("progrmManageDtlVO") ProgrmManageDtlVO progrmManageDtlVO, BindingResult bindingResult,
			ModelMap model) throws Exception {
		String resultMsg = "";
		// 미인증 사용자에 대한 보안처리
		if (!EgovUserDetailsHelper.isAuthenticated())
			return goLogin(model);

		// 로그인 객체 선언
		LoginVO user = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
		String sLocationUrl = null;
		String sCmd = commandMap.get("cmd") == null ? "" : (String) commandMap.get("cmd");
		if (sCmd.equals("insert")) {
			// beanValidator 처리
			beanValidator.validate(progrmManageDtlVO, bindingResult);
			if (bindingResult.hasErrors()) {
				sLocationUrl = "sys/menu/ProgramChangRequstStre";
				return sLocationUrl;
			}
			if (progrmManageDtlVO.getChangerqesterCn() == null || progrmManageDtlVO.getChangerqesterCn().equals("")) {
				progrmManageDtlVO.setChangerqesterCn("");
			}
			if (progrmManageDtlVO.getRqesterProcessCn() == null || progrmManageDtlVO.getRqesterProcessCn().equals("")) {
				progrmManageDtlVO.setRqesterProcessCn("");
			}
			progrmManageService.insertProgrmChangeRequst(progrmManageDtlVO);
			resultMsg = egovMessageSource.getMessage("success.common.insert");
			sLocationUrl = "forward:/sys/menu/ProgramChangeRequstSelect.do";
		} else {
			/* MAX요청번호 조회 */
			ProgrmManageDtlVO tmp_vo = progrmManageService.selectProgrmChangeRequstNo(progrmManageDtlVO);
			int _tmp_no = tmp_vo.getRqesterNo();
			progrmManageDtlVO.setRqesterNo(_tmp_no);
			progrmManageDtlVO.setRqesterPersonId(user.getId());
			sLocationUrl = "sys/menu/ProgramChangRequstStre";
		}
		model.addAttribute("resultMsg", resultMsg);
		return sLocationUrl;
	}

	/**
	 * 프로그램변경 요청을 수정 한다.
	 * 
	 * @param progrmManageDtlVO ProgrmManageDtlVO
	 * @return 출력페이지정보 "forward:/sys/menu/ProgramChangeRequstSelect.do"
	 * @exception Exception
	 */
	@RequestMapping(value = "/sys/menu/ProgramChangRequstDetailSelectUpdt.do")
	public String updateProgrmChangeRequst(@ModelAttribute("progrmManageDtlVO") ProgrmManageDtlVO progrmManageDtlVO,
			BindingResult bindingResult, ModelMap model) throws Exception {
		String sLocationUrl = null;
		String resultMsg = "";
		// 미인증 사용자에 대한 보안처리
		if (!EgovUserDetailsHelper.isAuthenticated())
			return goLogin(model);

		// 로그인 객체 선언
		LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
		// beanValidator 처리
		beanValidator.validate(progrmManageDtlVO, bindingResult);
		if (bindingResult.hasErrors()) {
			sLocationUrl = "forward:/sys/menu/ProgramChangRequstDetailSelect.do";
			return sLocationUrl;
		}

		if (progrmManageDtlVO.getRqesterPersonId().equals(loginVO.getId())) {
			if (progrmManageDtlVO.getChangerqesterCn() == null || progrmManageDtlVO.getChangerqesterCn().equals("")) {
				progrmManageDtlVO.setChangerqesterCn(" ");
			}
			if (progrmManageDtlVO.getRqesterProcessCn() == null || progrmManageDtlVO.getRqesterProcessCn().equals("")) {
				progrmManageDtlVO.setRqesterProcessCn(" ");
			}
			progrmManageService.updateProgrmChangeRequst(progrmManageDtlVO);
			resultMsg = egovMessageSource.getMessage("success.common.update");
			sLocationUrl = "forward:/sys/menu/ProgramChangeRequstSelect.do";
		} else {
			resultMsg = "수정이 실패하였습니다. 변경요청 수정은 변경요청자만 수정가능합니다.";
			progrmManageDtlVO.setTmp_progrmNm(progrmManageDtlVO.getProgrmFileNm());
			progrmManageDtlVO.setTmp_rqesterNo(progrmManageDtlVO.getRqesterNo());
			sLocationUrl = "forward:/sys/menu/ProgramChangRequstDetailSelect.do";
		}
		model.addAttribute("resultMsg", resultMsg);
		return sLocationUrl;
	}

	/**
	 * 프로그램변경 요청을 삭제 한다.
	 * 
	 * @param progrmManageDtlVO ProgrmManageDtlVO
	 * @return 출력페이지정보 "forward:/sys/menu/ProgramChangeRequstSelect.do"
	 * @exception Exception
	 */
	@RequestMapping(value = "/sys/menu/ProgramChangRequstDelete.do")
	public String deleteProgrmChangeRequst(@ModelAttribute("progrmManageDtlVO") ProgrmManageDtlVO progrmManageDtlVO,
			ModelMap model) throws Exception {
		String sLocationUrl = null;

		// 미인증 사용자에 대한 보안처리
		if (!EgovUserDetailsHelper.isAuthenticated())
			return goLogin(model);

		// 로그인 객체 선언
		LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
		if (progrmManageDtlVO.getRqesterPersonId().equals(loginVO.getId())) {
			// progrmManageDtlVO.setRqesterPersonId(user.getId());
			model.addAttribute("resultMsg", egovMessageSource.getMessage("success.common.delete"));
			progrmManageService.deleteProgrmChangeRequst(progrmManageDtlVO);
			sLocationUrl = "forward:/sys/menu/ProgramChangeRequstSelect.do";
		} else {
			model.addAttribute("resultMsg", "삭제에 실패하였습니다. 변경요청자만 삭제가능합니다.");
			sLocationUrl = "forward:/sys/menu/ProgramChangRequstDetailSelect.do";
		}
		return sLocationUrl;
	}

	/**
	 * 프로그램변경 요청에 대한 처리 사항을 조회한다.
	 * 
	 * @param searchVO ComDefaultVO
	 * @return 출력페이지정보 "sys/menu/ProgramChangeRequstProcess"
	 * @exception Exception
	 */
	@RequestMapping(value = "/sys/menu/ProgramChangeRequstProcessListSelect.do")
	public String selectProgrmChangeRequstProcessList(@ModelAttribute("searchVO") ComDefaultVO searchVO, ModelMap model)
			throws Exception {
		// 미인증 사용자에 대한 보안처리
		if (!EgovUserDetailsHelper.isAuthenticated())
			return goLogin(model);

		setPageInfo(searchVO, model, progrmManageService.selectChangeRequstProcessListTotCnt(searchVO));

		model.addAttribute("list_changerequst", progrmManageService.selectChangeRequstProcessList(searchVO));

		return "sys/menu/ProgramChangeRequstProcess";
	}

	/**
	 * 프로그램변경 요청에 대한 처리 사항을 상세조회한다.
	 * 
	 * @param progrmManageDtlVO ProgrmManageDtlVO
	 * @return 출력페이지정보 "sys/menu/ProgramChangRequstProcessDetailSelectUpdt"
	 * @exception Exception
	 */
	@RequestMapping(value = "/sys/menu/ProgramChangRequstProcessDetailSelect.do")
	public String selectProgrmChangRequstProcess(
			@ModelAttribute("progrmManageDtlVO") ProgrmManageDtlVO progrmManageDtlVO, ModelMap model) throws Exception {
		// 미인증 사용자에 대한 보안처리
		if (!EgovUserDetailsHelper.isAuthenticated())
			return goLogin(model);

		if (progrmManageDtlVO.getProgrmFileNm() == null) {
			String _FileNm = progrmManageDtlVO.getTmp_progrmNm();
			progrmManageDtlVO.setProgrmFileNm(_FileNm);
			int _Tmp_no = progrmManageDtlVO.getTmp_rqesterNo();
			progrmManageDtlVO.setRqesterNo(_Tmp_no);
		}
		ProgrmManageDtlVO resultVO = progrmManageService.selectProgrmChangeRequst(progrmManageDtlVO);
		if (resultVO.getOpetrId() == null) {
			LoginVO user = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
			resultVO.setOpetrId(user.getId());
		}
		model.addAttribute("progrmManageDtlVO", resultVO);
		return "sys/menu/ProgramChangRequstProcessDetailSelectUpdt";
	}

	/**
	 * 프로그램변경요청처리 내용을 수정 한다.
	 * 
	 * @param progrmManageDtlVO ProgrmManageDtlVO
	 * @return 출력페이지정보 "forward:/sys/menu/ProgramChangeRequstProcessListSelect.do"
	 * @exception Exception
	 */
	@RequestMapping(value = "/sys/menu/ProgramChangRequstProcessDetailSelectUpdt.do")
	public String updateProgrmChangRequstProcess(
			@ModelAttribute("progrmManageDtlVO") ProgrmManageDtlVO progrmManageDtlVO, BindingResult bindingResult,
			ModelMap model) throws Exception {
		String sLocationUrl = null;
		// 미인증 사용자에 대한 보안처리
		if (!EgovUserDetailsHelper.isAuthenticated())
			return goLogin(model);

		beanValidator.validate(progrmManageDtlVO, bindingResult);
		if (bindingResult.hasErrors()) {
			sLocationUrl = "forward:/sys/menu/ProgramChangRequstProcessDetailSelect.do";
			return sLocationUrl;
		}

		LoginVO user = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
		if (progrmManageDtlVO.getOpetrId().equals(user.getId())) {
			if (progrmManageDtlVO.getChangerqesterCn() == null || progrmManageDtlVO.getChangerqesterCn().equals("")) {
				progrmManageDtlVO.setChangerqesterCn(" ");
			}
			if (progrmManageDtlVO.getRqesterProcessCn() == null || progrmManageDtlVO.getRqesterProcessCn().equals("")) {
				progrmManageDtlVO.setRqesterProcessCn(" ");
			}
			progrmManageService.updateProgrmChangeRequstProcess(progrmManageDtlVO);
			model.addAttribute("resultMsg", egovMessageSource.getMessage("success.common.update"));

			sLocationUrl = "forward:/sys/menu/ProgramChangeRequstProcessListSelect.do";
		} else {
			model.addAttribute("resultMsg", "수정이 실패하였습니다. 변경요청처리 수정은 변경처리해당 담당자만 처리가능합니다.");
			progrmManageDtlVO.setTmp_progrmNm(progrmManageDtlVO.getProgrmFileNm());
			progrmManageDtlVO.setTmp_rqesterNo(progrmManageDtlVO.getRqesterNo());
			sLocationUrl = "forward:/sys/menu/ProgramChangRequstProcessDetailSelect.do";
		}
		return sLocationUrl;
	}

	/**
	 * 프로그램변경요청처리를 삭제 한다.
	 * 
	 * @param progrmManageDtlVO ProgrmManageDtlVO
	 * @return 출력페이지정보 "forward:/sys/menu/ProgramChangeRequstProcessListSelect.do"
	 * @exception Exception
	 */
	/* 프로그램변경요청처리 삭제 */
	@RequestMapping(value = "/sys/menu/ProgramChangRequstProcessDelete.do")
	public String deleteProgrmChangRequstProcess(
			@ModelAttribute("progrmManageDtlVO") ProgrmManageDtlVO progrmManageDtlVO, ModelMap model) throws Exception {
		// 미인증 사용자에 대한 보안처리
		if (!EgovUserDetailsHelper.isAuthenticated())
			return goLogin(model);

		progrmManageService.deleteProgrmChangeRequst(progrmManageDtlVO);

		return "forward:/sys/menu/ProgramChangeRequstProcessListSelect.do";
	}

	/**
	 * 프로그램변경이력리스트를 조회한다.
	 * 
	 * @param searchVO ComDefaultVO
	 * @return 출력페이지정보 "sys/menu/ProgramChgHst"
	 * @exception Exception
	 */
	@RequestMapping(value = "/sys/menu/ProgramChgHstListSelect.do")
	public String selectProgrmChgHstList(@ModelAttribute("searchVO") ComDefaultVO searchVO, ModelMap model)
			throws Exception {
		// 미인증 사용자에 대한 보안처리
		if (!EgovUserDetailsHelper.isAuthenticated())
			return goLogin(model);

		setPageInfo(searchVO, model, progrmManageService.selectProgrmChangeRequstListTotCnt(searchVO));
		model.addAttribute("list_changerequst", progrmManageService.selectProgrmChangeRequstList(searchVO));

		return "sys/menu/ProgramChgHst";
	}

	/* 프로그램변경이력상세조회 */
	/**
	 * 프로그램변경이력을 상세조회한다.
	 * 
	 * @param progrmManageDtlVO ProgrmManageDtlVO
	 * @return 출력페이지정보 "sys/menu/ProgramChgHstDetail"
	 * @exception Exception
	 */
	@RequestMapping(value = "/sys/menu/ProgramChgHstListDetailSelect.do")
	public String selectProgramChgHstListDetail(
			@ModelAttribute("progrmManageDtlVO") ProgrmManageDtlVO progrmManageDtlVO, ModelMap model) throws Exception {
		// 미인증 사용자에 대한 보안처리
		if (!EgovUserDetailsHelper.isAuthenticated())
			return goLogin(model);

		String _FileNm = progrmManageDtlVO.getTmp_progrmNm();
		progrmManageDtlVO.setProgrmFileNm(_FileNm);
		int _tmp_no = progrmManageDtlVO.getTmp_rqesterNo();
		progrmManageDtlVO.setRqesterNo(_tmp_no);

		ProgrmManageDtlVO resultVO = progrmManageService.selectProgrmChangeRequst(progrmManageDtlVO);
		model.addAttribute("resultVO", resultVO);
		return "sys/menu/ProgramChgHstDetail";
	}

	/**
	 * 프로그램파일명을 조회한다.
	 * 
	 * @param searchVO ComDefaultVO
	 * @return 출력페이지정보 "sys/menu/FileNmSearch"
	 * @exception Exception
	 */
	@RequestMapping(value = "/sys/menu/ProgramListSearch.do")
	public String selectProgrmListSearch(@ModelAttribute("searchVO") ComDefaultVO searchVO, ModelMap model)
			throws Exception {
		// 미인증 사용자에 대한 보안처리
		if (!EgovUserDetailsHelper.isAuthenticated())
			return goLogin(model);

		setPageInfo(searchVO, model, progrmManageService.selectProgrmListTotCnt(searchVO));

		model.addAttribute("list_progrmmanage", progrmManageService.selectProgrmList(searchVO));
		return "sys/menu/FileNmSearch";
	}

}