package egovframework.ippado.sys.log.service.impl;

import java.util.List;

import egovframework.ippado.sys.log.service.ConectStatsService;
import egovframework.ippado.sys.log.service.StatsVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

/**
 * 접속 통계 검색 비즈니스 구현 클래스
 * @author 공통서비스 개발팀 박지욱
 * @since 2009.03.12
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일      수정자          수정내용
 *  -------    --------    ---------------------------
 *  2009.03.19  박지욱          최초 생성
 *  2011.06.30  이기하          패키지 분리(sts -> sts.cst)
 *  2011.08.31  JJY            경량환경 템플릿 커스터마이징버전 생성
 *
 *  </pre>
 */
@Service("ConectStatsService")
public class ConectStatsServiceImpl extends EgovAbstractServiceImpl implements
	ConectStatsService {

    @Resource(name="conectStatsDAO")
    private ConectStatsDAO conectStatsDAO;

    /**
	 * 접속 통계를 조회한다
	 * @param vo StatsVO
	 * @return List
	 * @exception Exception
	 */
	@Override
	public List<?> selectConectStats(StatsVO vo) throws Exception {
        return conectStatsDAO.ConectStats(vo);
	}
}
