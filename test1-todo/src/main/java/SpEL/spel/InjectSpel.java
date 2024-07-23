package SpEL.spel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("injectSpel")
public class InjectSpel {
    @Value("#{injectConfig.name}")
    private String name;
    @Value("#{injectConfig.age + 10}")
    private String age;
    @Value("#{injectConfig.programmer == true ? 'Yes' : 'No'}")
    private String programmer;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setProgrammer(String programmer) {
        this.programmer = programmer;
    }

    @Override
    public String toString() {
        return "InjectSpel{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", programmer='" + programmer + '\'' +
                '}';
    }
}
