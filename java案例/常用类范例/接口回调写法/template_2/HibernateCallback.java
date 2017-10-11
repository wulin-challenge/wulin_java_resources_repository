package cn.template_2;

import org.hibernate.Session;

public interface HibernateCallback {

	Object doInSession(Session session);
}
