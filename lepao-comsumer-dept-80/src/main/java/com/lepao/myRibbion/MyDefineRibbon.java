package com.lepao.myRibbion;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

//自定义负载均衡的规则
public class MyDefineRibbon extends AbstractLoadBalancerRule{
	
	private Integer total = 0;
	private Integer currentIndex = 0;
	
	@Override
	public Server choose(Object key) {
		// TODO Auto-generated method stub
		 return choose(getLoadBalancer(), key);
	}

	private Server choose(ILoadBalancer lb, Object key) {
		if (lb == null) {
            return null;
        }
        Server server = null;

        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }
            List<Server> upList = lb.getReachableServers();
            List<Server> allList = lb.getAllServers();

            int serverCount = allList.size();
            if (serverCount == 0) {
                /*
                 * No servers. End regardless of pass, because subsequent passes
                 * only get more restrictive.
                 */
                return null;
            }
            synchronized(total)
            {
            	if(total<5)
            	{
            		server=upList.get(currentIndex);
            		total++;
            	}else{
            		total=0;
            		currentIndex++;
            		if(currentIndex%upList.size()==0)
            		{
            			currentIndex=0;
            		}
            	}
            }
            
            

            if (server == null) {
                /*
                 * The only time this should happen is if the server list were
                 * somehow trimmed. This is a transient condition. Retry after
                 * yielding.
                 */
                Thread.yield();
                continue;
            }

            if (server.isAlive()) {
                return (server);
            }

            // Shouldn't actually happen.. but must be transient or a bug.
            server = null;
            Thread.yield();
        }

        return server;
	}

	@Override
	public void initWithNiwsConfig(IClientConfig arg0) {
		// TODO Auto-generated method stub
		
	}

}
