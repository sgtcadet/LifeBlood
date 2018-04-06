package domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BloodBank.class)
public abstract class BloodBank_ {

	public static volatile SingularAttribute<BloodBank, String> number;
	public static volatile SingularAttribute<BloodBank, String> name;
	public static volatile SingularAttribute<BloodBank, BloodBankAddress> bloodBankAddress;
	public static volatile SingularAttribute<BloodBank, String> id;

}

