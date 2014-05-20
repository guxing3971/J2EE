package dnzl.TaiZhang;

import java.sql.SQLException;
import java.util.List;

import dnzl.Core.Push_CIM_SuperClass;
import dnzl.DataFactory.XmlFactory;

/*************************************************
 * 架空线路设备清单 
 *
 *************************************************/
public class Push_CIM_JKXLSB extends Push_CIM_SuperClass{
	public List<String> xmlContents() throws SQLException{
		return XmlFactory.GetXMLAll_JKXLSB();
	}

	@Override
	public void initData() {
		List<String> list = null;
		try {
			list = xmlContents();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(list.size() == 0){
			this.IsLog(false);
		}else{
			this.setXmlContents(list);
		}
	}
}
