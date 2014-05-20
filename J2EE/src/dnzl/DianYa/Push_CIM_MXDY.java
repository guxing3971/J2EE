package dnzl.DianYa;

import java.sql.SQLException;
import java.util.List;

import dnzl.Core.Push_CIM_SuperClass;
import dnzl.DataFactory.XmlFactory;


public class Push_CIM_MXDY extends Push_CIM_SuperClass{
	public List<String> xmlContents() throws SQLException{
		return XmlFactory.GetXMLAll_DWDY();
	}

	@Override
	public void initData() {
		List<String> list = null;
		try {
			list = xmlContents();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(list == null  || list.size() == 0){
			this.IsLog(false);
			this.IsNeed(false);
		}else{
			this.setXmlContents(list);
		}
	}
}
