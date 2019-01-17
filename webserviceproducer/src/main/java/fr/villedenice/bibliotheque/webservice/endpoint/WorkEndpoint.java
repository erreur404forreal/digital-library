package fr.villedenice.bibliotheque.webservice.endpoint;

import org.cereme.business.services.contracts.WorkService;
import org.cereme.ws.GetWorkByAuthorRequest;
import org.cereme.ws.GetWorkByAuthorResponse;
import org.cereme.ws.WorkInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Endpoint
public class WorkEndpoint {
	private static final String NAMESPACE_URI = "http://www.elibrary.fr/work-ws";
	@Autowired
	private WorkService workService;



	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getWorkByAuthorRequest")
	@ResponsePayload
	public GetWorkByAuthorResponse getWorkByAuthor(@RequestPayload GetWorkByAuthorRequest request) {
		GetWorkByAuthorResponse response = new GetWorkByAuthorResponse();
		List<WorkInfo> workInfoListByAuthor = new ArrayList<>();

//		List<Work> workList = workService.findWorksByAuthorContain(request.getAuthor());
//		for (int i = 0; i < workList.size(); i++) {
//			WorkInfo ob = new WorkInfo();
//			BeanUtils.copyProperties(workList.get(i), ob);
//			workInfoListByAuthor.add(ob);
//		}
//		response.getWorkInfo().addAll(workInfoListByAuthor);

		return response;
	}

//	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getWorkByTitleRequest")
//	@ResponsePayload
//	public GetWorkByTitleResponse getWorkByTitle(@RequestPayload GetWorkByTitleRequest request) {
//		GetWorkByTitleResponse response = new GetWorkByTitleResponse();
//		List<WorkInfo> workInfoListByTitle = new ArrayList<>();
//		List<Work> workList = workService.findByTitle(request.getTitle());
//		for (int i = 0; i < workList.size(); i++) {
//			WorkInfo ob = new WorkInfo();
//			BeanUtils.copyProperties(workList.get(i), ob);
//			workInfoListByTitle.add(ob);
//		}
//		response.getWorkInfo().addAll(workInfoListByTitle);
//
//		return response;
//	}

//	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getWorkByDateRequest")
//	@ResponsePayload
//	public GetWorkByDateResponse getWorkByDate(@RequestPayload GetWorkByDateRequest request) {
//		GetWorkByDateResponse response = new GetWorkByDateResponse();
//		List<WorkInfo> workInfoListByDate = new ArrayList<>();
//		List<Work> workList = workService.findByYearPublication(request.getDate());
//		for (int i = 0; i < workList.size(); i++) {
//			WorkInfo ob = new WorkInfo();
//			BeanUtils.copyProperties(workList.get(i), ob);
//			workInfoListByDate.add(ob);
//		}
//		response.getWorkInfo().addAll(workInfoListByDate);
//
//		return response;
//	}
//
//	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllWorkRequest")
//	@ResponsePayload
//	public GetAllWorkResponse getAllWork() {
//		GetAllWorkResponse response = new GetAllWorkResponse();
//		List<WorkInfo> workInfoList = new ArrayList<>();
//		List<Work> workList = workService.getAllWork();
//		for (int i = 0; i < workList.size(); i++) {
//			WorkInfo ob = new WorkInfo();
//			BeanUtils.copyProperties(workList.get(i), ob);
//			workInfoList.add(ob);
//		}
//		response.getWorkInfo().addAll(workInfoList);
//		return response;
//	}

    @PostConstruct
    public void init() {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

}
