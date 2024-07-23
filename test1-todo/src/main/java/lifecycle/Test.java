package lifecycle;

import com.geeksforgeeks.org.Company;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Test {
    public static void main(String[] args) {
        Resource resource = new ClassPathResource("annotation/applicationContext.xml");
        BeanFactory bn = new XmlBeanFactory(resource);
        Company c = (Company)bn.getBean("company");
        c.display();
    }
}
