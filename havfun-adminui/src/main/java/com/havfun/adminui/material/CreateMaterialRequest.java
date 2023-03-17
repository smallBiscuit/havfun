package com.havfun.adminui.material;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;
import com.havfun.adminui.data.BaseUser;
import com.havfun.adminui.helper.ClientServiceHelper;
import com.havfun.adminui.helper.LocalizationHelper;
import com.havfun.adminui.servlet.AbstractServlet;
import com.havfun.service.entity.constant.MaterialStatus;
import com.havfun.service.message.admin.material.AdminCreateMaterialRequest;
import com.havfun.service.message.admin.material.AdminCreateMaterialResponse;
import com.havfun.service.message.constant.ErrorCode;
import com.havfun.service.message.data.MaterialMessage;
import com.havfun.service.utils.LabelUtil;

/**
 * Servlet implementation class CreateMaterialRequest
 */
@WebServlet("/" + MaterialHelper.CREATE_MATERIAL_REQUEST)
public class CreateMaterialRequest extends AbstractServlet {

	private static final Logger LOGGER = LogManager.getLogger(CreateMaterialRequest.class.getName());

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateMaterialRequest() {
		super();
	}

	@Override
	protected void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MaterialMessage materialMessage = materialHelper.getMaterialMessage(request);
		materialMessage.setActive( true );

		AdminCreateMaterialRequest createRequest = new AdminCreateMaterialRequest();

		BaseUser baseUser = (BaseUser) request.getAttribute(LOGON_USER);
		createRequest.setLoginUserId(baseUser.getId());
		createRequest.setToken(baseUser.getToken());
		createRequest.setMaterialMessage(materialMessage);

		LOGGER.info("CreateMaterialRequest process createRequest " + createRequest);
		AdminCreateMaterialResponse createResponse = ClientServiceHelper.getInstance().getClientService().invoke(createRequest);
		LOGGER.info("CreateMaterialRequest process createResponse " + createResponse);
		int result = -1;

		Map<String, Object> resultMap = new HashMap<String, Object>();
		String lang = (String) request.getAttribute("SelectedLang");
		ResourceBundle labels = LocalizationHelper.getResourceBundle("Result", lang);

		if (createResponse != null) {

			String redirectUrl = "#";
			String resultMessage = "";
			int resultCode = createResponse.getResult();

			if (createResponse.getResult() == ErrorCode.NO_ERROR) {

				resultMessage = LabelUtil.getDisplayValueFromResourceBundle(labels, "common_success");
				redirectUrl = "EnquireMaterial?materialId=" + createResponse.getMaterialId();

			} else {

				resultMessage = LabelUtil.getDisplayValueFromResourceBundle(labels,
						"error_result." + createResponse.getResult());
				redirectUrl = "#";
			}

			resultMap.put("resultCode", resultCode);
			resultMap.put("resultMessage", resultMessage);
			resultMap.put("redirectUrl", redirectUrl);

		} else {

			resultMap.put("resultCode", ErrorCode.INTERNAL_ERROR);
			resultMap.put("resultMessage",
					LabelUtil.getDisplayValueFromResourceBundle(labels, "error_result." + ErrorCode.INTERNAL_ERROR));

		}

		response.setCharacterEncoding("UTF-8");
		String resultJSON = new Gson().toJson(resultMap);
		response.getWriter().write(resultJSON);

	}
}
