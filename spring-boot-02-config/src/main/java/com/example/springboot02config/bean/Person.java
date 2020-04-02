package com.example.springboot02config.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 将配置文件中配置的每一个属性的值，映射到这个组件中
 * @ConfigurationProperties(prefix = "person") ：告诉Spring-Boot将本类中的所有属性和配置文件中相关的配置进行绑定
 * prefix = "person  配置文件中哪个下面的所有属性进行一一映射
 * 只有这个组件时容器中的组件，才能使用容器中的ConfigurationProperties功能
 */

//@ConfigurationProperties(prefix = "person")
@PropertySource(value = {"classpath:person.properties"})   //加载多个或者指定的配置文件
@Component
public class Person
{
  /*

    <bean class="Person">
            <property name="lasyname" value="自变量/${key}从环境变量、配置文件中取值/#{SPEL}"></property>
    </bean>*/
    @Value("${person.last-name}")
    private String lastname;
    @Value("#{11*2}")
    private Integer age;
    @Value("true")
    private boolean boss;
    private Date birth;

    private Map<String,Object> maps;
    private List<Object> lists;
    private Dog dog;


    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public boolean isBoss() {
        return boss;
    }

    public void setBoss(boolean boss) {
        this.boss = boss;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public List<Object> getLists() {
        return lists;
    }

    public void setLists(List<Object> lists) {
        this.lists = lists;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "Person{" +
                "lastname='" + lastname + '\'' +
                ", age=" + age +
                ", boss=" + boss +
                ", birth=" + birth +
                ", maps=" + maps +
                ", lists=" + lists +
                ", dog=" + dog +
                '}';
    }
}
