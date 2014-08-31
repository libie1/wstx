package info.fzhen.wstx.transaction;

import info.fzhen.wstx.WstxRtException;
import info.fzhen.wstx.at.coordinator.AtProtocol;
import info.fzhen.wstx.config.ATPartEprConfig;
import info.fzhen.wstx.coordinator.PrivateIdType;
import info.fzhen.wstx.at.participant.ATInitiator;
import info.fzhen.wstx.util.CommonUtils;
import info.fzhen.wstx.util.EprUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.cxf.ws.addressing.EndpointReferenceType;
import org.oasis_open.docs.ws_tx.wscoor._2006._06.RegisterResponseType;
import org.oasis_open.docs.ws_tx.wscoor._2006._06.RegisterType;
import org.oasis_open.docs.ws_tx.wscoor._2006._06.RegistrationPortType;

import java.util.HashMap;
import java.util.Map;

/**
 * Global protocol service manager of the site. It also holds global context.
 * Used by initiator of Completion protocol participant side.
 * 
 * @author fangzhen
 * 
 */
public class WsatInitiatorManager {
	private static final Log __LOG = LogFactory.getLog(Process.class);
	
	private static WsatInitiatorManager instance;
	private ATPartEprConfig eprConfiguration;
	
	/**Participants magagered by this manager (on this site) */
	Map<String, ATInitiator> initiators = new HashMap<String, ATInitiator>();

	public static WsatInitiatorManager getInstance() {
		if (instance == null){
			if (__LOG.isErrorEnabled()){
				__LOG.error("Atomatic Transaction Manager(WsatTxManager) hasn't been initialized");
			}
			throw new WstxRtException("Atomatic Transaction Manager(WsatTxManager) hasn't been initialized");
		}
		return instance;
	}

	public static void setInstance(WsatInitiatorManager instance) {
		WsatInitiatorManager.instance = instance;
	}

	public void registerInitiator(WsatTransaction transaction) {
		ATInitiator initiator = new ATInitiator();
		initiator.setTransaction(transaction);
		transaction.setInitiator(initiator);

		String id = CommonUtils.genPrivateId();
		initiators.put(id, initiator);

		//completion protocol participant
		PrivateIdType pit = new PrivateIdType(id);
		String addr = eprConfiguration.getInitiatorAddress();
		EndpointReferenceType initiatorEprCXF = EprUtils.createCxfEprInstance(addr, pit);
		RegisterType reg = new RegisterType();
		reg.setParticipantProtocolService(initiatorEprCXF);
		reg.setProtocolIdentifier(AtProtocol.COMPLETION.getText());

        EndpointReferenceType regSerCXF = transaction.getCoordinationContext()
				.getRegistrationService();
		RegistrationPortType client = EprUtils.createWsaddrClientProxy(RegistrationPortType.class, regSerCXF);
		RegisterResponseType response = client.registerOperation(reg);
		
		EndpointReferenceType coorInitiatorEpr = response.getCoordinatorProtocolService();
		transaction.setCoorInitiatorEpr(coorInitiatorEpr);
	}

	public void setEprConfiguration(ATPartEprConfig eprConfig) {
		this.eprConfiguration = eprConfig;
	}

    public ATInitiator getInitiator(String id){
		return initiators.get(id);
	}

	public void forgetInitiator(String txId) {
		initiators.remove(txId);
	}
}