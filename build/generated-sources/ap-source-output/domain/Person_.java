package domain;

import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Person.class)
public abstract class Person_ {

	public static volatile SingularAttribute<Person, String> trn;
	public static volatile SingularAttribute<Person, String> firstname;
	public static volatile SingularAttribute<Person, PersonAddress> address;
	public static volatile SingularAttribute<Person, String> gender;
	public static volatile SingularAttribute<Person, Phone> phone;
	public static volatile SingularAttribute<Person, Date> dob;
	public static volatile SingularAttribute<Person, String> email;
	public static volatile SingularAttribute<Person, String> lastname;

}

