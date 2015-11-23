package hu.neuron.java.web.beans;

import java.io.ByteArrayInputStream;

import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import hu.neuron.java.service.UserServiceLocal;
import hu.neuron.java.service.vo.UserVO;

@ManagedBean(name = "userImages")
@ApplicationScoped
public class UserImages {

	@EJB
	private UserServiceLocal userService;

	public StreamedContent getImage() throws Exception {
		FacesContext context = FacesContext.getCurrentInstance();

		if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
			// So, we're rendering the HTML. Return a stub StreamedContent so
			// that it will generate right URL.
			return new DefaultStreamedContent();
		} else {
			// So, browser is requesting the image. Return a real
			// StreamedContent with the image bytes.
			String studentId = context.getExternalContext().getRequestParameterMap().get("userId");
			UserVO userVO = getUserService().findById((Long.valueOf(studentId)));
			return new DefaultStreamedContent(new ByteArrayInputStream(userVO.getImage()));
		}
	}

	public UserServiceLocal getUserService() {
		return userService;
	}

	public void setUserService(UserServiceLocal userService) {
		this.userService = userService;
	}

}