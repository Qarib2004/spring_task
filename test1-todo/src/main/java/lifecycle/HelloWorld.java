package lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class HelloWorld implements InitializingBean, DisposableBean {
    @Override
    public void destroy() throws Exception {
        System.out.println(
                "Container has been closed "
                        + "and I'm the destroy() method");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(
                "Bean HelloWorld has been "
                        + "instantiated and I'm the "
                        + "init() method");
    }
}
