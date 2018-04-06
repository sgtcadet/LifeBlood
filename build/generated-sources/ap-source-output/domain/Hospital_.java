package domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Hospital.class)
public abstract class Hospital_ {

	public static volatile SingularAttribute<Hospital, String> phone;
	public static volatile SingularAttribute<Hospital, String> hospitalId;
	public static volatile SingularAttribute<Hospital, String> name;
	public static volatile SingularAttribute<Hospital, HospitalAddress> hospitalAddress;

}

