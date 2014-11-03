package info.fzhen.wstx.at.twopc;


import info.fzhen.wstx.WstxRtException;
import info.fzhen.wstx.at.AtAbstractCoorManager;
import info.fzhen.wstx.at.AtomicTxCoordinator;
import info.fzhen.wstx.util.CommonUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.oasis_open.docs.ws_tx.wscoor._2006._06.RegisterResponseType;
import org.oasis_open.docs.ws_tx.wscoor._2006._06.RegisterType;

public class At2pcCoorManager extends AtAbstractCoorManager<At2pcCoor> {
	private static final Log __LOG = LogFactory.getLog(At2pcCoorManager.class);

	private static At2pcCoorManager instance;

	public static At2pcCoorManager getInstance() {
		if (instance == null) {
			String msg = "2PC protocol service coordinator manager: " + At2pcCoorManager.class.getSimpleName() +
						"hasn't been initialized. It should be initiated " +
						"by Spring as singleton. Please check your conf file.";
			if (__LOG.isErrorEnabled()) {
				__LOG.error(msg);
			}
			throw new WstxRtException(msg);
		}
		return instance;
	}

	public static void setInstance(At2pcCoorManager instance) {
		At2pcCoorManager.instance = instance;
	}

	/**
	 * register durable 2PC protocol
	 */
	public RegisterResponseType registerD2pcParticipant(AtomicTxCoordinator activity, RegisterType regPara) {
		return register2pcParticipant(activity, regPara, false);
	}

	/**
	 * register durable 2PC protocol
	 */
	public RegisterResponseType registerV2pcParticipant(AtomicTxCoordinator activity, RegisterType regPara) {
		return register2pcParticipant(activity, regPara, true);
	}

	/**
	 * Register 2PC participant
	 *
	 * @param activity the activity that involved
	 * @param regPara  register parameter
	 * @param v        true if is volatile 2PC
	 * @return
	 */
	public RegisterResponseType register2pcParticipant(AtomicTxCoordinator activity, RegisterType regPara, boolean v) {
		At2pcCoor at2pcCoor = new At2pcCoor();
		at2pcCoor.setActivity(activity);
		if (v) {
			at2pcCoor.setVolatile(true);
			activity.addV2pcCoor(at2pcCoor);
		} else {
			at2pcCoor.setVolatile(false);
			activity.addD2pcCoor(at2pcCoor);
		}
		at2pcCoor.setState(At2pcCoor.State.Active);
		at2pcCoor.setParticipantEpr(regPara.getParticipantProtocolService());

		String privateId = CommonUtils.genPrivateId();
		managedCoordinators.put(privateId, at2pcCoor);

		RegisterResponseType response = constructRegisterResponse(privateId);
		return response;
	}
}