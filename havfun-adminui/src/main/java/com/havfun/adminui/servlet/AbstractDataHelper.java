package com.havfun.adminui.servlet;


public interface AbstractDataHelper {

	public static final int SERVLET_TYPE_APPROVE = 0;
	public static final int SERVLET_TYPE_CREATE = 1;
	public static final int SERVLET_TYPE_ENQUIRE = 2;
	public static final int SERVLET_TYPE_RESUBMIT = 3;
	public static final int SERVLET_TYPE_UPDATE = 4;
	public static final int SERVLET_TYPE_SETTLING = 5;
	public static final int SERVLET_TYPE_ALLOCATION = 6;
	public static final int SERVLET_TYPE_CREATE_RESUBMIT = 7;
	public static final int SERVLET_TYPE_UPDATE_RESUBMIT = 8;
	public static final int SERVLET_TYPE_ALLOCATION_RESUBMIT = 9;
	
	public static final String BUTTON_LIST = "buttonList";
	public static final String NAVIGATOR = "navigator";	
	public static final String PAGE_MODE = "pageMode";
	public static final String ACTION = "action";	
	public static final String CANCEL_ACTION = "cancelAction";	
	public static final String REJECT_ACTION = "rejectAction";
	public static final String UPDATE_ACTION = "updateAction";
	public static final String CHECK_BOX_ON = "on";	
	public static final String PRIMARY_ACTION = "primaryAction";
	public static final String SECONDARY_ACTION = "secondaryAction";
	
	public static final String BACK_URL	= "backUrl";
	public static final String SEARCH_APPROVAL = "SearchApproval";
	
	public static final String ORIGINAL_APPROVAL_ID = "originalApprovalId";
	
	
	public enum DataStatus {
		CURRENT("C"),
		PENDING("P"),
		;
		
		private String value;
		
		private DataStatus(String value) {
			this.value = value;
		}
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
	}
/*
	public enum ButtonType {
		CREATE("btn_create", "common_create", "btn_common_small", ApprovalAction.NONE.getValue()),
		UPDATE("btn_update", "common_update", "btn_common_small", ApprovalAction.NONE.getValue()),
		CANCEL("btn_cancel", "common_cancel", "btn_remove_small", ApprovalAction.CANCEL.getValue()),
		RESUBMIT("btn_resubmit", "common_resubmit", "btn_common_small", ApprovalAction.RESUBMIT.getValue()),
		APPROVE("btn_approve", "approvalAction.A", "btn_common btn_approval_action", ApprovalAction.APPROVE.getValue()),
		REJECT("btn_reject", "approvalAction.J", "btn_common_sell btn_approval_action", ApprovalAction.REJECT.getValue()),
		ASKFORRESUBMIT("btn_ask_for_resubmit", "approvalAction.S", "btn_common btn_approval_action", ApprovalAction.ASK_FOR_RESUBMIT.getValue()),
		REJECT_NORMAL("btn_reject_normal", "common_reject", "btn_common_sell_small", ApprovalAction.NONE.getValue()),
		ALLOCATE("btn_allocate", "common_allocate", "btn_common_small", ApprovalAction.NONE.getValue()),
		REPLACE("btn_replace", "common_update", "btn_common_small", ApprovalAction.NONE.getValue()),
		BOOKCLOSE("btn_bookClose", "common_bookClose", "btn_common_small", ApprovalAction.NONE.getValue()),
		POST("btn_post", "common_post", "btn_common_small", ApprovalAction.NONE.getValue()),
		DELETE("btn_delete", "common_remove", "btn_common_small", ApprovalAction.NONE.getValue()),
		CONFIRM("btn_confirm", "common_confirm", "btn_common_small", ApprovalAction.NONE.getValue()),
		RETURN("btn_return", "common_return", "btn_common_sell_small", ApprovalAction.NONE.getValue()),
		REACTIVEATE("btn_reactivate", "common_reactivate", "btn_common_small", ApprovalAction.NONE.getValue()),
		CREATE_ANOTHER("btn_create_another", "common_create_another", "btn_common_small_long", ApprovalAction.NONE.getValue()),
		APPROVE_ALL("btn_approve_all", "common_approve_all", "btn_common", ApprovalAction.APPROVE.getValue()),
		;
		
		private String id;
		private String key;
		private String style;
		private String approvalAction;
		
		private ButtonType(String id, String key, String style, String approvalAction) {
			this.id = id;
			this.key = key;
			this.style = style;
			this.approvalAction = approvalAction;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}

		public String getStyle() {
			return style;
		}

		public void setStyle(String style) {
			this.style = style;
		}

		public String getApprovalAction() {
			return approvalAction;
		}

		public void setApprovalAction(String approvalAction) {
			this.approvalAction = approvalAction;
		}
	}

	public class Button {
		
		private ButtonType buttonType;
		private String id;
		private String key;
		private String style;
		private String approvalAction;
		private String requestAction;
		private String result;
		private String label;
		
		public Button(ButtonType buttonType) {
			super();
			this.buttonType = buttonType;
			this.id = buttonType.id;
			this.key = buttonType.key;
			this.style = buttonType.style;
			this.approvalAction = buttonType.approvalAction;
		}
		public Button(ButtonType buttonType, String requestAction, String result) {
			super();
			this.buttonType = buttonType;
			this.id = buttonType.id;
			this.key = buttonType.key;
			this.style = buttonType.style;
			this.approvalAction = buttonType.approvalAction;
			this.requestAction = requestAction;
			this.result = result;
		}
		public Button(ButtonType buttonType, String requestAction, String result, String label) {
			super();
			this.buttonType = buttonType;
			this.id = buttonType.id;
			this.key = buttonType.key;
			this.style = buttonType.style;
			this.approvalAction = buttonType.approvalAction;
			this.requestAction = requestAction;
			this.result = result;
			this.label = label;
		}
		public ButtonType getButtonType() {
			return buttonType;
		}
		public void setButtonType(ButtonType buttonType) {
			this.buttonType = buttonType;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getKey() {
			return key;
		}
		public void setKey(String key) {
			this.key = key;
		}
		public String getStyle() {
			return style;
		}
		public void setStyle(String style) {
			this.style = style;
		}
		public String getApprovalAction() {
			return approvalAction;
		}
		public void setApprovalAction(String approvalAction) {
			this.approvalAction = approvalAction;
		}
		public String getRequestAction() {
			return requestAction;
		}
		public void setRequestAction(String requestAction) {
			this.requestAction = requestAction;
		}
		public String getResult() {
			return result;
		}
		public void setResult(String result) {
			this.result = result;
		}
		public String getLabel() {
			return label;
		}
		public void setLabel(String label) {
			this.label = label;
		}
	}
		*/

}
