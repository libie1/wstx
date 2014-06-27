package info.fzhen.wstx.transaction;

/**
 * stateless
 * 
 * @author fangzhen
 * 
 */
public class TransactionFactory {
	private TransactionFactory() {

	}

	private static TransactionFactory instance;

	public WsatTransaction createWsatTransaction(TransactionConfig config) {
		WsatTransaction transaction;
		transaction = new WsatTransaction();
		transaction.setConfig(config);
		return transaction;
	}

	public static TransactionFactory getInstance() {
		//TODO synchronize
		if (instance == null) {
			instance = new TransactionFactory();
		}
		return instance;
	}

	public static void setInstance(TransactionFactory instance) {
		TransactionFactory.instance = instance;
	}

}