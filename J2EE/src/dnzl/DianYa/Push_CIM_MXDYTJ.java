package dnzl.DianYa;

import java.sql.SQLException;
import java.util.List;

import dnzl.Core.Push_CIM_SuperClass;
import dnzl.DataFactory.XmlFactory;

/*********************************************
 * 电网 电压统计值
 *
 ********************************************/
public class Push_CIM_MXDYTJ extends Push_CIM_SuperClass{
	
	
//////////////////////////////////////////////////////////////
//for all type
/////////////////////////////////////////////////////////////
//	@Override
//	public void initData() {
//		String str[] =xmlContents().split("==");
//		this.log.setF_count(str[0]);
//		this.setXmlContents(str[1]);
//		if(Integer.parseInt(str[0]) == 0){
//			this.IsNeed(false);
//		}
//		super.initData();
//	}

	
	public List<String> xmlContents() throws SQLException{
		return XmlFactory.GetXMLAll_DWDYTJ();
	}

	@Override
	public void initData() {
		List<String> list = null;
		try {
			list = xmlContents();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(list == null || list.size() == 0){
			this.IsLog(false);
			this.IsNeed(false);
		}else{
			this.setXmlContents(list);
		}
	}
	
//	public String xmlContents(){
//
//
//		String insertData=null;
//		try {
//			insertData = XmlFactory.GetXML_DWDYTJ();
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return insertData;
//	}

}
