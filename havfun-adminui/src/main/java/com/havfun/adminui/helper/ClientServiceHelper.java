package com.havfun.adminui.helper;

import com.havfun.service.HavfunService;

public class ClientServiceHelper {
	private static ClientServiceHelper SINGLETON; 

	private HavfunService clientService;

	public static ClientServiceHelper getInstance()
	{
		return SINGLETON;
	}
	
	public static void setSingleton(ClientServiceHelper clientServiceHelper)
	{
		SINGLETON = clientServiceHelper;
		try
		{
			//clientServiceHelper.getClientService().startClient();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public ClientServiceHelper()
	{		
	}

	public HavfunService getClientService() {
		return clientService;
	}

	public void setClientService(HavfunService bosClientService) {
		this.clientService = bosClientService;
	}
}
