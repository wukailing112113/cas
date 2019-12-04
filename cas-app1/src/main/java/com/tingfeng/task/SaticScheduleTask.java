package com.tingfeng.task;

import com.tingfeng.remote.FerignApp2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
public class SaticScheduleTask {

    @Autowired
    private FerignApp2 ferignApp2;


    /**
     * http://www.ibloger.net/article/3129.html
     * 这里通过ferign 的方式调用app2的服务，但是会要求登录认证，所以，cas也提供了解决方案，就是通过代理实现：
     * Cas Proxy可以让我们轻松的通过App1访问App2时通过Cas Server的认证，从而访问到App2。
     * 其主要原理是这样的，App1先通过Cas Server的认证，然后向Cas Server申请一个针对于App2的proxy ticket，
     * 之后在访问App2时把申请到的针对于App2的proxy ticket以参数ticket传递过去。
     * App2的AuthenticationFilter将拦截到该请求，发现该请求携带了ticket参数后将放行交由后续的Ticket Validation Filter处理。
     * Ticket Validation Filter将会传递该ticket到Cas Server进行认证，显然该ticket是由Cas Server针对于App2发行的，
     * App2在申请校验时是可以校验通过的，这样我们就可以正常的访问到App2了。
     */
    //3.添加定时任务
    @Scheduled(cron = "0/5 * * * * ?")
    //或直接指定时间间隔，例如：5秒
    //@Scheduled(fixedRate=5000)
    private void configureTasks() {
        String hello = ferignApp2.hello();
        System.out.println(hello);
        System.err.println("执行静态定时任务时间: " + LocalDateTime.now());
    }
}
