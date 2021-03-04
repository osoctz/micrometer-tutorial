package cn.metaq.micrometertutorial.hook;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@RestController
@Log4j2
public class AlertController {

    @Autowired
    private HttpServletRequest request;

    @PostMapping("alert")
    public String receive_alert(){

        Enumeration<String> parameters= request.getParameterNames();

        while(parameters.hasMoreElements()){

            String parameterName=parameters.nextElement();

            log.info("参数{} = {}",parameterName,request.getParameter(parameterName));
        }
        log.info("收到告警。。。");
        return "alert";
    }
}
