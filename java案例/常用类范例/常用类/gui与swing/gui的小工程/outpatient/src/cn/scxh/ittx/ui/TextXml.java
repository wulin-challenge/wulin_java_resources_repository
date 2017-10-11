package cn.scxh.ittx.ui;

import java.io.FileOutputStream;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import cn.scxh.ittx.domain.Patient;
import cn.scxh.ittx.exception.QueryObjectException;
import cn.scxh.ittx.service.impl.PatientServiceImpl;
import cn.scxh.ittx.service.intf.PatientService;

public class TextXml {
	public void createPatientXml() {
		PatientService ps = new PatientServiceImpl();
		List<Patient> patientList = null;
		try {
			patientList = ps.differenceConditionQueryPatients(null);
			Document document=DocumentHelper.createDocument();
			Element r=document.addElement("patients");
			for (Patient p : patientList) {
				Element root=r.addElement("patient");
				Element id=root.addElement("id");
				id.addText(p.getId());
				Element name=root.addElement("name");
				name.addText(p.getName());
				Element sax=root.addElement("sax");
				sax.addText(p.getSex());
				Element age=root.addElement("age");
				age.addText(p.getAge()+"");
				Element married=root.addElement("married");
				married.addText(p.getMarried());
				Element job=root.addElement("job");
				job.addText(p.getJob());
				Element blood=root.addElement("blood");
				blood.addText(p.getBlood());
			}
			
			OutputFormat format=OutputFormat.createPrettyPrint();
			try {
				XMLWriter writer= new XMLWriter(new FileOutputStream("patient.xml"),format);
				writer.write(document);
				writer.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (QueryObjectException e) {
			e.printStackTrace();
		}
		
		
	}
	public static void main(String[] args) {
		new TextXml().createPatientXml();
	}
	

}
