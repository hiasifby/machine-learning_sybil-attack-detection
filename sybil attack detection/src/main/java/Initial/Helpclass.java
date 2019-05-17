package Initial;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.infinispan.commons.marshall.MarshallableTypeHints;

public class Helpclass {

	public void Parseline(String filepath, String type) throws IOException {

		File ccfile = new File(filepath);
		FileInputStream fis = new FileInputStream(ccfile);
		// Construct BufferedReader from InputStreamReader
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		String line = "";
		int i = 0;
		while ((line = br.readLine()) != null) {
			i++;
			line = line.trim();
			if (line.length() != 0) {
				line = line.substring(0, line.length() - 1);
				String[] parseline = line.split(";");

				Data data = new Data();

				data.setSourceNode(Integer.parseInt(parseline[0]));
				data.setDestinationNode(Integer.parseInt(parseline[1]));
				data.setIntId(Integer.parseInt(parseline[2]));
				data.setMalicious(Integer.parseInt(parseline[3]));
				data.setHofNodes(parseline[4]);
				data.setType(type);

				String[] hof = parseline[4].split(",");
				data.setHofCount(hof.length + 1);

				session.save(data);

				if (i % 50 == 0) { // 20, same as the JDBC batch size
					// flush a batch of inserts and release memory:
					session.flush();
					session.clear();

				}
			}

		}
		br.close();
		session.flush();
		session.clear();
		session.getTransaction().commit();
		session.close();

		// System.out.println(line);

	}

	@SuppressWarnings("unchecked")
	public void Calxyhof() {

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		for (int j = 1; j <= 6; j++) {
			String type = "M" + j;
			System.out.println(type);

			for (int i = 1; i <= 30; i++) {

				Query<Data> query = session.createQuery(
						"FROM Data WHERE type like :ty and sourceNode=:sn or hofNodes like :snc or hofnodes like :snf");
				query.setParameter("sn", i);
				query.setParameter("snc", "%," + i + ",%");
				query.setParameter("snf", "%," + i);
				query.setParameter("ty", type + "%");
				List<Data> data = query.getResultList();
				// System.out.println(data.size());
				for (Data adata : data) {

					XYhof xyhof = new XYhof(i, adata.getHofCount(), adata.getHofCount() - 1, adata.getType());
					session.save(xyhof);

					if (i % 50 == 0) { // 20, same as the JDBC batch size
						// flush a batch of inserts and release memory:
						session.flush();
						session.clear();
					}

				}
			}
		}

		session.flush();
		session.clear();
		session.getTransaction().commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	public void Calavg() {

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		for (int j = 1; j <= 6; j++) {
			String type = "M" + j;
			String t = "";
			for (int i = 1; i <= 30; i++) {
				Query<XYhof> query = session.createQuery("FROM XYhof WHERE type like :ty and node=:sn");
				query.setParameter("sn", i);
				query.setParameter("ty", type+"%");
				List<XYhof> xyhof = query.getResultList();
				if (xyhof.size() != 0) {
					int x = 0, y = 0;
					float xavg = 0, yavg = 0;
					for (XYhof axyhof : xyhof) {
						x = x + axyhof.getXvalue();
						y = y + axyhof.getYvalue();
						t = axyhof.getType();
					}
					xavg = (float) x / xyhof.size();
					yavg = (float) y / xyhof.size();
					
					XYavg xyavg = new XYavg(i, xavg, yavg,t);
					session.save(xyavg);
					if (i % 50 == 0) { // 20, same as the JDBC batch size
						// flush a batch of inserts and release memory:
						session.flush();
						session.clear();
					}
				}
			}
			System.out.println(t);
		}

		session.flush();
		session.clear();
		session.getTransaction().commit();
		session.close();

	}

	@SuppressWarnings("unchecked")
	public void Caldistance() {

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		for (int z = 1; z <= 6; z++) {
			String type = "M" + z;
			String t = "";
			
			Query<XYavg> query = session.createQuery("FROM XYavg where type like :ty");
			query.setParameter("ty", type + "%");
			List<XYavg> xyavg = query.getResultList();

			float x1 = 0, x2 = 0, y1 = 0, y2 = 0;
			float distance = 0;
			for (int i = 0; i < xyavg.size(); i++) {

				XYavg axyavg = xyavg.get(i);
				x1 = axyavg.getXavg();
				y1 = axyavg.getYavg();
				t = axyavg.getType();
				for (int j = i + 1; j < xyavg.size(); j++) {

					XYavg bxyavg = xyavg.get(j);
					x2 = bxyavg.getXavg();
					y2 = bxyavg.getYavg();

					distance = (float) Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
					Volume volume = new Volume(axyavg.getNode() + "," + bxyavg.getNode(), distance, t);
					session.save(volume);

				}
				if (i % 50 == 0) { // 50, same as the JDBC batch size
					// flush a batch of inserts and release memory:
					session.flush();
					session.clear();
				}
			}			
		}	
		session.flush();
		session.clear();
		session.getTransaction().commit();
		session.close();
	}
}
