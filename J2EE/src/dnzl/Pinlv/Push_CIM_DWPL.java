package dnzl.Pinlv;

import java.sql.SQLException;
import java.util.List;

import dnzl.Core.Push_CIM_SuperClass;
import dnzl.DataFactory.XmlFactory;


public class Push_CIM_DWPL extends Push_CIM_SuperClass{
	public List<String> xmlContents() throws SQLException{
		return XmlFactory.GetXMLAll_DWPL();
	}

	@Override
	public void initData() {
		List<String> list = null;
		try {
			list = xmlContents();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(list == null ||list.size() == 0){
			this.IsLog(false);
			this.IsNeed(false);
		}else{
			this.setXmlContents(list);
		}
	}
	
//	@Override
//	public void initData() {
//		String str[] =insertData().split("==");
//		this.log.setF_count(str[0]);
//		this.setXmlContents(str[1]);
//		if(Integer.parseInt(str[0]) == 0){
//			this.IsNeed(false);
//		}
//		
//	}
//	public String  insertData() {
//		String insertData=null;
//		try {
//			insertData = XmlFactory.GetXML_DWPL();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return insertData;
//	}

	
}
