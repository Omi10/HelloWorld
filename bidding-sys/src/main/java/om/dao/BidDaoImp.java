package om.dao;

import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.JDBCConnectionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import om.entities.Bid;
import om.entities.User;
import om.entities.Bid;

@Repository
@Transactional
public class BidDaoImp implements BidDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void save(Bid Bid) {
		getSession().save(Bid);
	}

	@Override
	public Bid getBid(int bidId) {
		return getSession().get(Bid.class, bidId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Bid> getBids() throws JDBCConnectionException {
		return getSession().createQuery("from Bid").list();
	}

	@Override
	public void update(Bid bid) {
		getSession().update(bid);
	}

	@Override
	public void delete(Bid bid) {
		getSession().delete(bid);
	}

}