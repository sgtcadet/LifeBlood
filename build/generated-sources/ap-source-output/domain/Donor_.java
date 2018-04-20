package domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Donor.class)
public abstract class Donor_ extends domain.Person_ {

	public static volatile SingularAttribute<Donor, PersonAddress> address;
	public static volatile SingularAttribute<Donor, Phone> phone;
	public static volatile SingularAttribute<Donor, String> bloodType;

}

