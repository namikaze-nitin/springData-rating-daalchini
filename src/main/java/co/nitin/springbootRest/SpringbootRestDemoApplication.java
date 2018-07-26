package co.nitin.springbootRest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@EnableAutoConfiguration
@SpringBootApplication(scanBasePackages="co")
public class SpringbootRestDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRestDemoApplication.class, args);
	}
	
//	@Bean
//	@SuppressWarnings("deprecation")
//	public HibernateJpaSessionFactoryBean sessionFactory(EntityManagerFactory emf) {
//	    HibernateJpaSessionFactoryBean fact = new HibernateJpaSessionFactoryBean();
//	    fact.setEntityManagerFactory(emf);
//	    return fact;
//	}
}
